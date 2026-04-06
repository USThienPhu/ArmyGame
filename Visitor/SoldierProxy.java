// SoldierProxy.java
import java.util.*;
import java.util.function.Function;

public class SoldierProxy implements Soldier {
    private Soldier currentSoldier;
    private Set<String> equippedItems = new HashSet<>();
    
    // Registry: Bản đồ ánh xạ tên trang bị -> Logic tạo Decorator tương ứng
    private static final Map<String, Function<Soldier, Soldier>> registry = new HashMap<>();

    public static void registerEquipment(String name, Function<Soldier, Soldier> creator) {
        registry.put(name, creator);
    }

    public SoldierProxy(Soldier soldier) {
        this.currentSoldier = soldier;
    }

    @Override
    public void equip(String equipmentName) {
        // Kiểm tra ràng buộc: Không cho phép trang bị trùng
        if (equippedItems.contains(equipmentName)) {
            System.out.println(equipmentName + " đã tồn tại!");
            return;
        }

        Function<Soldier, Soldier> creator = registry.get(equipmentName);
        if (creator != null) {
            // Bọc đối tượng hiện tại bằng một Decorator mới
            this.currentSoldier = creator.apply(this.currentSoldier);
            equippedItems.add(equipmentName);
            System.out.println(">>> Hệ thống Proxy: Đã lắp đặt " + equipmentName);
        } else {
            System.out.println("Loại trang bị [" + equipmentName + "] chưa được đăng ký!");
        }
    }

    @Override public int hit() { return currentSoldier.hit(); }
    @Override public boolean wardOff(int str) { return currentSoldier.wardOff(str); }

    // Thêm phương thức truy xuất cho Proxy/Decorator để Visitor có thể duyệt sâu hơn
    // SoldierProxy.java (bổ sung)
    public Soldier getInnerSoldier() { return currentSoldier; }
    public Set<String> getEquippedItems() { return equippedItems; }

    @Override
    public void accept(SoldierVisitor visitor) {
        visitor.visit(this);
    }
}