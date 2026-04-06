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
        String items = String.join(", ", proxy.getEquippedItems());
        printIndent();
        System.out.print("|-- Equipment: [" + (items.isEmpty() ? "Empty" : items) + "] -> ");
        
        proxy.getInnerSoldier().accept(this);
    }

    @Override
    public void visit(Infantryman i) {
        System.out.println("Type: Infantry (HP: 50)");
    }

    @Override
    public void visit(Horseman h) {
        System.out.println("Type: Cavalry (HP: 80)");
    }
}