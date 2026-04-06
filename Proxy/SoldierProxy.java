import java.util.HashSet;
import java.util.Set;

public class SoldierProxy implements Soldier {
    private Soldier currentSoldier;
    private Set<Class<? extends SoldierDecorator>> equippedItems = new HashSet<>();

    public SoldierProxy(Soldier soldier) {
        this.currentSoldier = soldier;
    }

    @Override
    public void addShield() {
        if (equippedItems.contains(ShieldDecorator.class)) {
            System.out.println("Binh lính đã có Khiên, không thể trang bị thêm!");
            return;
        }
        
        this.currentSoldier = new ShieldDecorator(this.currentSoldier);
        equippedItems.add(ShieldDecorator.class);
        System.out.println(">>> Proxy: Đã trang bị Khiên thành công.");
    }

    @Override
    public void addSword() {
        if (equippedItems.contains(SwordDecorator.class)) {
            System.out.println("Binh lính đã có Kiếm, không thể trang bị thêm!");
            return;
        }

        this.currentSoldier = new SwordDecorator(this.currentSoldier);
        equippedItems.add(SwordDecorator.class);
        System.out.println(">>> Proxy: Đã trang bị Kiếm thành công.");
    }

    @Override
    public int hit() {
        return currentSoldier.hit();
    }

    @Override
    public boolean wardOff(int strength) {
        return currentSoldier.wardOff(strength);
    }
}
