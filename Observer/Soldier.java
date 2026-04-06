interface Soldier {
    int hit();
    boolean wardOff(int strength);
    void equip(String equipmentName);
    
    void accept(SoldierVisitor visitor); 
}

