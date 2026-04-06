interface Soldier {
    int hit();
    boolean wardOff(int strength);
    void equip(String equipmentName);
    
    // Cửa ngõ cho Visitor
    void accept(SoldierVisitor visitor); 
}

