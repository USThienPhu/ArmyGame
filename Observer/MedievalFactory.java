class MedievalFactory implements SoldierFactory {
    @Override
    public Infantryman createInfantryman() { return new Infantryman(); }

    @Override
    public Horseman createHorseman() { return new Horseman(); }

    @Override
    public void registerEraEquipment() {
        // Thêm "Medieval" làm tham số đầu tiên
        SoldierProxy.registerEquipment("Medieval", "Kiếm", soldier -> new SwordDecorator(soldier));
        SoldierProxy.registerEquipment("Medieval", "Giáp sắt", soldier -> new ArmorDecorator(soldier));
    }
}