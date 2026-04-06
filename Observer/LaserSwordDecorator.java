class LaserSwordDecorator extends SoldierDecorator {
    private int battery = 100;

    public LaserSwordDecorator(Soldier soldier) { super(soldier); }

    @Override
    public int hit() {
        int baseHit = decoratedSoldier.hit();
        if (battery > 0) {
            int laserBonus = 40; // Sát thương cực mạnh
            System.out.print(" -> [LaserSword (+" + laserBonus + ") Energy: " + battery + "%]");
            battery -= 5;
            return baseHit + laserBonus;
        }
        System.out.print(" -> [LaserSword cạn năng lượng!]");
        return baseHit;
    }
}