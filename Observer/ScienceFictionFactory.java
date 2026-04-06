class ScienceFictionFactory implements SoldierFactory {
    @Override
    public Infantryman createInfantryman() { return new Infantryman(); }

    @Override
    public Horseman createHorseman() { return new Horseman(); }

    @Override
    public void registerEraEquipment() {
        SoldierProxy.registerEquipment("ScienceFiction", "Laser Sword", soldier -> new LaserSwordDecorator(soldier));
        SoldierProxy.registerEquipment("ScienceFiction", "Nano Armor", soldier -> new NanoArmorDecorator(soldier));
    }
}