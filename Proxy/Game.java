public class Game {
    public static void main(String[] args) {
        // Khởi tạo lính thông qua Proxy
        Soldier mySoldier = new SoldierProxy(new Infantryman());

        System.out.println("--- Trang bị đồ lần 1 ---");
        mySoldier.addSword();
        mySoldier.addShield();

        System.out.println("\n--- Thử trang bị trùng lặp (Ràng buộc Proxy) ---");
        mySoldier.addShield(); 

        System.out.println("\n--- Attack (hit) ---");
        int totalHit = mySoldier.hit();
        System.out.println("\nTổng lực tấn công: " + totalHit);

        System.out.println("\n--- Defense (wardOff) ---");
        boolean isAlive = mySoldier.wardOff(12);
        System.out.println("\nCòn sống: " + isAlive);
    }
}