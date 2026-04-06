class ScienceFictionFactory implements SoldierFactory {
    @Override
    public Infantryman createInfantryman() { return new Infantryman(); }

    @Override
    public Horseman createHorseman() { return new Horseman(); }

    @Override
    public void registerEraEquipment() {
        // Thêm "ScienceFiction" làm tham số đầu tiên
        SoldierProxy.registerEquipment("ScienceFiction", "Kiếm Laser", soldier -> new LaserSwordDecorator(soldier));
        SoldierProxy.registerEquipment("ScienceFiction", "Giáp Nano", soldier -> new NanoArmorDecorator(soldier));
    }
}