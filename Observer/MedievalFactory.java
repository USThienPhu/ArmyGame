class MedievalFactory implements SoldierFactory {
    @Override
    public Infantryman createInfantryman() { return new Infantryman(); }

    @Override
    public Horseman createHorseman() { return new Horseman(); }

    @Override
    public void registerEraEquipment() {
        SoldierProxy.registerEquipment("Medieval", "Sword", soldier -> new SwordDecorator(soldier));
        SoldierProxy.registerEquipment("Medieval", "Iron Armor", soldier -> new ArmorDecorator(soldier));
    }
}