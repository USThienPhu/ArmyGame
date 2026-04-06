class WorldWarFactory implements SoldierFactory {
    @Override
    public Infantryman createInfantryman() { return new Infantryman(); }

    @Override
    public Horseman createHorseman() { return new Horseman(); }

    @Override
    public void registerEraEquipment() {
        // Thêm "WorldWar" làm tham số đầu tiên
        SoldierProxy.registerEquipment("WorldWar", "Súng trường", soldier -> new RifleDecorator(soldier));
        SoldierProxy.registerEquipment("WorldWar", "Mũ sắt", soldier -> new HelmetDecorator(soldier));
    }
}