class WorldWarFactory implements SoldierFactory {
    @Override
    public Infantryman createInfantryman() { return new Infantryman(); }

    @Override
    public Horseman createHorseman() { return new Horseman(); }

    @Override
    public void registerEraEquipment() {
        SoldierProxy.registerEquipment("WorldWar", "Rifle", soldier -> new RifleDecorator(soldier));
        SoldierProxy.registerEquipment("WorldWar", "Steel Helmet", soldier -> new HelmetDecorator(soldier));
    }
}