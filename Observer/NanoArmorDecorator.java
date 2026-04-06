class NanoArmorDecorator extends SoldierDecorator {
    public NanoArmorDecorator(Soldier soldier) { super(soldier); }

    @Override
    public boolean wardOff(int strength) {
        int absorbed = strength / 2;
        int remainingDamage = strength - absorbed;
        
        System.out.print("[Nano Armor absorb 50%: -" + absorbed + " dmg] -> ");
        return decoratedSoldier.wardOff(remainingDamage);
    }
}