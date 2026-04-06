class ShieldDecorator extends SoldierDecorator {
    private int durability = 100;

    public ShieldDecorator(Soldier soldier) { super(soldier); }

    @Override
    public boolean wardOff(int strength) {
        int blockAmount = (5 * durability) / 100;
        int reducedStrength = Math.max(0, strength - blockAmount);
        System.out.print("Shield(block " + blockAmount + ", durability: " + durability + "%) -> ");
        durability = Math.max(0, durability - 15);
        return decoratedSoldier.wardOff(reducedStrength);
    }
}