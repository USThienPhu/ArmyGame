public class Game {
    public static void main(String[] args) {
        // 1. Setup Observers
        SoldierProxy.registerBattleObserver(new DeathCountObserver());
        SoldierProxy.registerBattleObserver(new DeathNotifierObserver());

        // 2. Initialize Units with Names
        Soldier p1 = new SoldierProxy("Footman Aris", new Infantryman()); // HP: 50
        Soldier h1 = new SoldierProxy("Knight Boros", new Horseman());    // HP: 80

        SoldierGroup squad = new SoldierGroup("Vanguard Squad");
        squad.addMember(p1);
        squad.addMember(h1);

        System.out.println("=== STARTING BATTLE ===");
        
        // 3. Simulate heavy damage to force a death
        // Damage 120 / 2 members = 60 each. 
        // Footman (50 HP) will die. Knight (80 HP) will survive with 20 HP.
        squad.wardOff(120); 

        System.out.println("\n=== BATTLE CONTINUES ===");
        // Next hit of 50 / 2 = 25 damage will kill the Knight.
        squad.wardOff(50);
    }
}