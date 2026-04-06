class CountVisitor implements SoldierVisitor {
    private int infantryCount = 0;
    private int horsemanCount = 0;

    @Override
    public void visit(SoldierGroup group) {
        for (Soldier s : group.getMembers()) {
            s.accept(this);
        }
    }

    @Override
    public void visit(SoldierProxy proxy) {
        proxy.getInnerSoldier().accept(this);
    }

    @Override
    public void visit(Infantryman i) { infantryCount++; }

    @Override
    public void visit(Horseman h) { horsemanCount++; }

    public void printReport() {
        System.out.println("=== THỐNG KÊ QUÂN SỐ ===");
        System.out.println("Bộ binh: " + infantryCount);
        System.out.println("Kỵ binh: " + horsemanCount);
    }
}