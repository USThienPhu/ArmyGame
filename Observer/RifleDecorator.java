class RifleDecorator extends SoldierDecorator {
    private int durability = 100;

    public RifleDecorator(Soldier soldier) { super(soldier); }

    @Override
    public int hit() {
        int baseHit = decoratedSoldier.hit();
        int bonus = Math.max(5, (20 * durability) / 100);
        System.out.print(" -> [Rifle(+" + bonus + ", đạn: " + durability + "%)]");
        durability = Math.max(0, durability - 20);
        return baseHit + bonus;
    }
}