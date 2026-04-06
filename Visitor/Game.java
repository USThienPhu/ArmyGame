public class Game {
    public static void main(String[] args) {
        // 1. Register equipment into the Proxy Registry
        SoldierProxy.registerEquipment("Sword", s -> new SwordDecorator(s));
        SoldierProxy.registerEquipment("Shield", s -> new ShieldDecorator(s));

        // 2. Create individual soldiers wrapped in Proxies
        Soldier p1 = new SoldierProxy(new Infantryman());
        Soldier p2 = new SoldierProxy(new Infantryman());
        Soldier h1 = new SoldierProxy(new Horseman());

        // 3. Organize into a small Squad (Composite)
        SoldierGroup squadAlpha = new SoldierGroup("Alpha Squad");
        squadAlpha.addMember(p1);
        squadAlpha.addMember(p2);

        // 4. Organize into a Grand Army (Nested Composite)
        SoldierGroup grandArmy = new SoldierGroup("Imperial Grand Army");
        grandArmy.addMember(squadAlpha); // Group inside Group
        grandArmy.addMember(h1);         // Solo unit inside Group

        System.out.println("=== STEP 1: BULK EQUIPMENT ===");
        // Bulk equip the entire army (Transparency: works for individuals and groups)
        grandArmy.equip("Sword");
        grandArmy.equip("Shield");

        System.out.println("\n=== STEP 2: COMBAT SIMULATION (ATTACK) ===");
        // Attack: Sum of all members' attack power
        int totalDamage = grandArmy.hit();
        System.out.println("\n[Final Report] Total Army Damage: " + totalDamage);

        System.out.println("\n=== STEP 3: COMBAT SIMULATION (DEFENSE) ===");
        // Defense: Damage is distributed equally across the hierarchy
        grandArmy.wardOff(60); 

        System.out.println("\n=== STEP 4: INSPECTION (VISITOR PATTERN) ===");
        // Use DisplayVisitor to show the hierarchy and equipment
        System.out.println("--- ARMY MANIFEST ---");
        DisplayVisitor display = new DisplayVisitor();
        grandArmy.accept(display);

        // Use CountVisitor to get statistics
        System.out.println("\n--- UNIT STATISTICS ---");
        CountVisitor counter = new CountVisitor();
        grandArmy.accept(counter);
        counter.printReport();
    }
}