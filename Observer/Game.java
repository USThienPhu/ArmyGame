public class Game {
    public static void main(String[] args) {
        SoldierProxy.registerEquipment("Sword", s -> new SwordDecorator(s));

        SoldierProxy.registerBattleObserver(DeathCountObserver.getInstance());
        SoldierProxy.registerBattleObserver(DeathNotifierObserver.getInstance());

        Soldier p1 = new SoldierProxy("Footman Aris", new Infantryman());
        
        System.out.println("=== BATTLE START ===");
        p1.wardOff(100); 
    }
}