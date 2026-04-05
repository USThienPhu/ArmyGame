public class Game {
    public static void main(String[] args) {

        Soldier mySoldier = new ShieldDecorator(new SwordDecorator(new Infantryman()));

        System.out.println("--- Attack (hit) ---");
        int totalHit = mySoldier.hit();
        System.out.println("\nTotal attack " + totalHit);

        System.out.println("\n--- Shield (wardOff) ---");
        boolean isAlive = mySoldier.wardOff(12);
        System.out.println("\nAlive: " + isAlive);
    }
}