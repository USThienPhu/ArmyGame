class Horseman implements Soldier {
    private int hp = 80;
    private int attack = 30;

    @Override
    public int hit() {
        System.out.print("Horseman attack: " + attack);
        return attack;
    }

    @Override
    public boolean wardOff(int strength) {
        this.hp -= strength;
        System.out.print("Horseman absorbs " + strength + " (HP left: " + hp + ") ");
        return hp > 0;
    }
}