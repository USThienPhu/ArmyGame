public class Game {
    public static void main(String[] args) {
        // Đăng ký trang bị vào Registry của Proxy
        SoldierProxy.registerEquipment("Kiếm", s -> new SwordDecorator(s));
        SoldierProxy.registerEquipment("Khiên", s -> new ShieldDecorator(s));

        // 1. Tạo các binh lính đơn lẻ (Leaf)
        Soldier p1 = new SoldierProxy(new Infantryman());
        Soldier p2 = new SoldierProxy(new Infantryman());
        Soldier h1 = new SoldierProxy(new Horseman());

        // 2. Tạo nhóm (Group) và thêm binh lính
        SoldierGroup squadAlpha = new SoldierGroup("Biệt kích Alpha");
        squadAlpha.addMember(p1);
        squadAlpha.addMember(p2);

        SoldierGroup grandArmy = new SoldierGroup("Đại Quân Đế Chế");
        grandArmy.addMember(squadAlpha); 
        grandArmy.addMember(h1);     

        System.out.println("=== HÀNH ĐỘNG CỦA ĐẠI QUÂN ===");
        
        grandArmy.equip("Kiếm");

        System.out.println("\nTổng sức mạnh tấn công: " + grandArmy.hit());

        System.out.println("\n--- Trận chiến phòng thủ ---");
        grandArmy.wardOff(60); 

    }
}