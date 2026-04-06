class DisplayVisitor implements SoldierVisitor {
    private int indent = 0;

    private void printIndent() {
        for (int i = 0; i < indent; i++) System.out.print("  ");
    }

    @Override
    public void visit(SoldierGroup group) {
        printIndent();
        System.out.println("[Group] " + group.getName());
        indent++;
        for (Soldier s : group.getMembers()) {
            s.accept(this);
        }
        indent--;
    }

    @Override
    public void visit(SoldierProxy proxy) {
        // Proxy giữ danh sách trang bị, chúng ta in ở đây
        String items = String.join(", ", proxy.getEquippedItems());
        printIndent();
        System.out.print("|-- Trang bị: [" + (items.isEmpty() ? "Trống" : items) + "] -> ");
        
        // Tiếp tục duyệt vào lõi để biết là Bộ binh hay Kỵ binh
        proxy.getInnerSoldier().accept(this);
    }

    @Override
    public void visit(Infantryman i) {
        System.out.println("Loại: Bộ binh (HP: 50)");
    }

    @Override
    public void visit(Horseman h) {
        System.out.println("Loại: Kỵ binh (HP: 80)");
    }
}