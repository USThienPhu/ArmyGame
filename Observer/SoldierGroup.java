import java.util.ArrayList;
import java.util.List;

class SoldierGroup implements Soldier {
    private String name;
    private List<Soldier> members = new ArrayList<>();
    public String getName() { return name; }
    public List<Soldier> getMembers() { return members; }
    public SoldierGroup(String name) {
        this.name = name;
    }

    public void addMember(Soldier soldier) {
        members.add(soldier);
    }

    @Override
    public int hit() {
        int totalHit = 0;
        System.out.println("-> Group [" + name + "] is attacking:");
        for (Soldier member : members) {
            totalHit += member.hit();
        }
        return totalHit;
    }

    @Override
    public boolean wardOff(int strength) {
        if (members.isEmpty()) return false;
        
        int damagePerMember = strength / members.size();
        System.out.println("-> Group [" + name + "] is dividing " + strength + " damage to " + members.size() + " members.");
        
        boolean anyAlive = false;
        for (Soldier member : members) {
            if (member.wardOff(damagePerMember)) {
                anyAlive = true;
            }
        }
        return anyAlive;
    }

    @Override
    public void equip(String equipmentName) {
        System.out.println(">>> Army [" + name + "]: Equipping " + equipmentName);
        for (Soldier member : members) {
            member.equip(equipmentName);
        }
    }
    @Override
    public void accept(SoldierVisitor visitor) {
        visitor.visit(this); 
    }
}