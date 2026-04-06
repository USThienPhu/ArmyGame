class SwordDecorator extends SoldierDecorator {
    public SwordDecorator(Soldier soldier) { super(soldier); }

    @Override
    public int hit() {
        int baseHit = decoratedSoldier.hit();
        System.out.print(" -> Sword(+7)");
        return baseHit + 7;
    }

    @Override
    public boolean wardOff(int strength) {
        System.out.print("Sword(no def) -> ");
        return decoratedSoldier.wardOff(strength);
    }
}