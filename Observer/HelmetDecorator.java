class HelmetDecorator extends SoldierDecorator {
    public HelmetDecorator(Soldier soldier) { super(soldier); }

    @Override
    public boolean wardOff(int strength) {
        // Mũ sắt giảm cố định 5 sát thương
        int reducedStrength = Math.max(0, strength - 5);
        System.out.print("[Helmet block 5 dmg] -> ");
        return decoratedSoldier.wardOff(reducedStrength);
    }
}