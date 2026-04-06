abstract class SoldierDecorator implements Soldier {
    protected Soldier decoratedSoldier;

    public SoldierDecorator(Soldier soldier) {
        this.decoratedSoldier = soldier;
    }

    public int hit() { return decoratedSoldier.hit(); }
    public boolean wardOff(int strength) { return decoratedSoldier.wardOff(strength); }
    
    @Override
    public void equip(String equipmentName) {
        decoratedSoldier.equip(equipmentName);
    }
    @Override
    public void accept(SoldierVisitor visitor) {
        decoratedSoldier.accept(visitor);
    }
    public Soldier getInnerSoldier() { return decoratedSoldier; }
}