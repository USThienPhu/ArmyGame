interface SoldierFactory {
    Infantryman createInfantryman();
    Horseman createHorseman();
    // Phương thức này giúp đăng ký các loại Decorator (trang bị) đặc trưng của thời đại vào Proxy
    void registerEraEquipment();
}