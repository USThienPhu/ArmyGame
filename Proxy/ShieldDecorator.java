class ShieldDecorator extends SoldierDecorator {
    public ShieldDecorator(Soldier soldier) { super(soldier); }

    @Override
    public int hit() {
        int baseHit = decoratedSoldier.hit();
        System.out.print(" -> Shield(+0)");
        return baseHit;
    }

    @Override
    public boolean wardOff(int strength) {
        int reducedStrength = Math.max(0, strength - 5);
        System.out.print("Shield(block 5) -> ");
        return decoratedSoldier.wardOff(reducedStrength);
    }
}