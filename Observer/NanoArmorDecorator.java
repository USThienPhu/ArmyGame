class NanoArmorDecorator extends SoldierDecorator {
    public NanoArmorDecorator(Soldier soldier) { super(soldier); }

    @Override
    public boolean wardOff(int strength) {
        // Công nghệ Nano: Hấp thụ 50% sát thương nhận vào
        int absorbed = strength / 2;
        int remainingDamage = strength - absorbed;
        
        System.out.print("[Lưới Nano hấp thụ 50%: -" + absorbed + " dmg] -> ");
        return decoratedSoldier.wardOff(remainingDamage);
    }
}