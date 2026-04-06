class SwordDecorator extends SoldierDecorator {
    private int durability = 100; // Độ bền ban đầu

    public SwordDecorator(Soldier soldier) { super(soldier); }

    @Override
    public int hit() {
        int baseHit = decoratedSoldier.hit();
        
        int bonus = Math.max(1, (7 * durability) / 100);
        System.out.print(" -> Sword(+" + bonus + ", durability: " + durability + "%)");
        durability = Math.max(0, durability - 10); 
        
        return baseHit + bonus;
    }
}