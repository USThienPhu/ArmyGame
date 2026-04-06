class ArmorDecorator extends SoldierDecorator {
    private int defensePower = 10;

    public ArmorDecorator(Soldier soldier) { super(soldier); }

    @Override
    public boolean wardOff(int strength) {
        int reducedStrength = Math.max(0, strength - defensePower);
        System.out.print("[Armor block " + defensePower + " dmg] -> ");
        return decoratedSoldier.wardOff(reducedStrength);
    }
}