public class Game {
    public static void main(String[] args) {
        MedievalFactory medFactory = new MedievalFactory();
        WorldWarFactory wwFactory = new WorldWarFactory();
        ScienceFictionFactory sfFactory = new ScienceFictionFactory();

        medFactory.registerEraEquipment();
        wwFactory.registerEraEquipment();
        sfFactory.registerEraEquipment();

        System.out.println("=== INITIALIZING MULTI-ERA ARMY ===\n");

        SoldierProxy knight = new SoldierProxy("Sir Arthur", "Medieval", medFactory.createHorseman());
        
        SoldierProxy marine = new SoldierProxy("Marine Sergeant", "WorldWar", wwFactory.createInfantryman());
        
        SoldierProxy cyborg = new SoldierProxy("Nano Warrior", "ScienceFiction", sfFactory.createInfantryman());


        System.out.println("--- TESTING INVALID ERA EQUIPMENT (Should Fail) ---");
        
        knight.equip("Rifle");
        
        marine.equip("Laser Sword");
        
        cyborg.equip("Iron Armor");


        System.out.println("\n--- TESTING VALID ERA EQUIPMENT (Should Succeed) ---");
        
        knight.equip("Sword");
        knight.equip("Iron Armor");

        marine.equip("Rifle");
        marine.equip("Steel Helmet");

        cyborg.equip("Laser Sword");
        cyborg.equip("Nano Armor");

        System.out.println("\n--- TESTING DUPLICATE EQUIPMENT (Should Fail) ---");
        knight.equip("Sword");
        marine.equip("Rifle");
        cyborg.equip("Laser Sword");


        System.out.println("\n--- FINAL ARMY INSPECTION ---");
        SoldierGroup alliance = new SoldierGroup("Timeless Alliance");
        alliance.addMember(knight);
        alliance.addMember(marine);
        alliance.addMember(cyborg);

        DisplayVisitor displayVisitor = new DisplayVisitor();
        alliance.accept(displayVisitor);

        System.out.println("\n--- COMBAT TEST ---");
        int totalDamage = alliance.hit();
        System.out.println("\n=> Total damage dealt by the alliance: " + totalDamage);

        System.out.println("\n--- ALLIANCE UNDER ATTACK ---");
        alliance.wardOff(120); 
    }
}