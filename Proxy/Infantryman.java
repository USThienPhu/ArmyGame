class Infantryman implements Soldier {
    private int hp = 50;
    private int attack = 25;

    @Override
    public int hit() {
        System.out.print("Infantryman:" + attack);
        return attack;
    }

    @Override
    public boolean wardOff(int strength) {
        this.hp -= strength;
        System.out.print("Infantryman absorbs " + strength + " (HP left: " + hp + ") ");
        return hp > 0;
    }

    public void addShield() { throw new UnsupportedOperationException(); }
    public void addSword() { throw new UnsupportedOperationException(); }

}