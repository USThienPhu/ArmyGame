abstract class SoldierDecorator implements Soldier {
    protected Soldier decoratedSoldier;

    public SoldierDecorator(Soldier soldier) {
        this.decoratedSoldier = soldier;
    }

    public int hit() { return decoratedSoldier.hit(); }
    public boolean wardOff(int strength) { return decoratedSoldier.wardOff(strength); }
    
    // Chuyển tiếp yêu cầu xuống đối tượng bên trong
    public void addShield() { decoratedSoldier.addShield(); }
    public void addSword() { decoratedSoldier.addSword(); }
}