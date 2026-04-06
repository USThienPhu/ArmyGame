import java.util.*;
import java.util.function.Function;

public class SoldierProxy implements Soldier {
    private Soldier currentSoldier;
    private Set<String> equippedItems = new HashSet<>();
    private String unitName;
    private String era; 
    
    private static BattleSubject battleSubject = new BattleSubject();

    public static void registerBattleObserver(DeathObserver o) {
        battleSubject.addObserver(o);
    }

    public String getUnitName() { return unitName; }
    public String getEra() { return era; }

    public SoldierProxy(String name, String era, Soldier soldier) {
        this.unitName = name;
        this.era = era;
        this.currentSoldier = soldier;
    }

    private static final Map<String, Map<String, Function<Soldier, Soldier>>> masterRegistry = new HashMap<>();
    public static void registerEquipment(String era, String name, Function<Soldier, Soldier> creator) {
        masterRegistry
            .computeIfAbsent(era, k -> new HashMap<>())
            .put(name, creator);
    }

    @Override
    public void equip(String equipmentName) {
        if (equippedItems.contains(equipmentName)) {
            System.out.println(">>> [Proxy] " + unitName + " already has " + equipmentName + "!");
            return;
        }

        Map<String, Function<Soldier, Soldier>> eraEquipments = masterRegistry.get(this.era);

        if (eraEquipments != null && eraEquipments.containsKey(equipmentName)) {
            Function<Soldier, Soldier> creator = eraEquipments.get(equipmentName);
            this.currentSoldier = creator.apply(this.currentSoldier);
            equippedItems.add(equipmentName);
            System.out.println(">>> [Proxy] Equipped " + equipmentName + " for " + unitName + " (Era: " + era + ")");
        } else {
            System.out.println("!!! ERROR: Equipment [" + equipmentName + "] does not exist or is not suitable for era " + era + "!");
        }
    }

    @Override 
    public int hit() { 
        return currentSoldier.hit(); 
    }

    @Override
    public boolean wardOff(int strength) {
        boolean isAlive = currentSoldier.wardOff(strength);
        if (!isAlive) {
            System.out.println("\n[System] Unit " + unitName + " is Killed in Action.");
            battleSubject.notifyObservers(unitName); 
        }
        return isAlive;
    }

    public Soldier getInnerSoldier() { return currentSoldier; }
    public Set<String> getEquippedItems() { return equippedItems; }

    @Override
    public void accept(SoldierVisitor visitor) {
        visitor.visit(this);
    }
}