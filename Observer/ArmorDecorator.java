class ArmorDecorator extends SoldierDecorator {
    private int defensePower = 10;

    public ArmorDecorator(Soldier soldier) { super(soldier); }

    @Override
    public boolean wardOff(int strength) {
        // Giảm sát thương cố định dựa trên chỉ số giáp
        int reducedStrength = Math.max(0, strength - defensePower);
        System.out.print("[Giáp sắt cản " + defensePower + " dmg] -> ");
        return decoratedSoldier.wardOff(reducedStrength);
    }
}