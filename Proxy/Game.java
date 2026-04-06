// Game.java
public class Game {
    public static void main(String[] args) {
        // 1. Đăng ký các loại trang bị vào hệ thống (Cấu hình một lần)
        SoldierProxy.registerEquipment("Kiếm", soldier -> new SwordDecorator(soldier));
        SoldierProxy.registerEquipment("Khiên", soldier -> new ShieldDecorator(soldier));

        // 2. Khởi tạo nhân vật
        Soldier mySoldier = new SoldierProxy(new Infantryman());

        System.out.println("--- Tiến hành trang bị ---");
        mySoldier.equip("Kiếm");
        mySoldier.equip("Khiên");
        mySoldier.equip("Kiếm"); // Thử trang bị trùng

        System.out.println("\n--- Kiểm tra chỉ số ---");
        int damage = mySoldier.hit();
        System.out.println("\nTổng sát thương: " + damage);

        System.out.println("\n--- Kiểm tra phòng thủ ---");
        // Sát thương 20 -> Armor giảm còn 10 -> Shield giảm còn 5 -> Infantryman nhận 5
        mySoldier.wardOff(20); 
    }
}