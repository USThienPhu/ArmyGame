interface SoldierVisitor {
    void visit(Infantryman infantryman);
    void visit(Horseman horseman);
    void visit(SoldierGroup group);
    void visit(SoldierProxy proxy);
}