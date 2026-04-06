import java.util.*;
import java.util.function.Function;

public class SoldierProxy implements Soldier {
    private Soldier currentSoldier;
    private Set<String> equippedItems = new HashSet<>();
    private String unitName;
    private String era; // Định danh thời đại của binh lính (Medieval, WorldWar, SciFi,...)
    
    private static BattleSubject battleSubject = new BattleSubject();

    public static void registerBattleObserver(DeathObserver o) {
        battleSubject.addObserver(o);
    }

    public String getUnitName() { return unitName; }
    public String getEra() { return era; }

    /**
     * Constructor cập nhật để nhận thêm tham số era
     */
    public SoldierProxy(String name, String era, Soldier soldier) {
        this.unitName = name;
        this.era = era;
        this.currentSoldier = soldier; // Ban đầu là lính cơ bản, không bắt buộc trang bị sẵn
    }

    // Cấu trúc Registry mới: Phân loại trang bị theo Thời đại
    // Map<Tên_Thời_Đại, Map<Tên_Trang_Bị, Hàm_Tạo_Decorator>>
    private static final Map<String, Map<String, Function<Soldier, Soldier>>> masterRegistry = new HashMap<>();

    /**
     * Đăng ký trang bị kèm theo thời đại cụ thể
     */
    public static void registerEquipment(String era, String name, Function<Soldier, Soldier> creator) {
        masterRegistry
            .computeIfAbsent(era, k -> new HashMap<>())
            .put(name, creator);
    }

    @Override
    public void equip(String equipmentName) {
        // 1. Kiểm tra xem lính đã có trang bị này chưa
        if (equippedItems.contains(equipmentName)) {
            System.out.println(">>> [Proxy] " + unitName + " đã có " + equipmentName + " rồi!");
            return;
        }

        // 2. Lấy danh sách trang bị HỢP LỆ của thời đại mà lính này thuộc về
        Map<String, Function<Soldier, Soldier>> eraEquipments = masterRegistry.get(this.era);

        if (eraEquipments != null && eraEquipments.containsKey(equipmentName)) {
            // Nếu trang bị tồn tại trong thời đại này, tiến hành bọc Decorator
            Function<Soldier, Soldier> creator = eraEquipments.get(equipmentName);
            this.currentSoldier = creator.apply(this.currentSoldier);
            equippedItems.add(equipmentName);
            System.out.println(">>> [Proxy] Đã trang bị " + equipmentName + " cho " + unitName + " (Thời đại: " + era + ")");
        } else {
            // Ràng buộc: Ngăn chặn trang bị sai thời đại
            System.out.println("!!! LỖI: Trang bị [" + equipmentName + "] không tồn tại hoặc không phù hợp với thời đại " + era + "!");
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