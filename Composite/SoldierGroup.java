import java.util.ArrayList;
import java.util.List;

class SoldierGroup implements Soldier {
    private String name;
    private List<Soldier> members = new ArrayList<>();

    public SoldierGroup(String name) {
        this.name = name;
    }

    public void addMember(Soldier soldier) {
        members.add(soldier);
    }

    @Override
    public int hit() {
        int totalHit = 0;
        System.out.println("-> Nhóm [" + name + "] đang phối hợp tấn công:");
        for (Soldier member : members) {
            totalHit += member.hit(); // Đệ quy gọi hit() của từng thành viên
        }
        return totalHit;
    }

    @Override
    public boolean wardOff(int strength) {
        if (members.isEmpty()) return false;
        
        // Chia đều sát thương cho mỗi thành viên trong nhóm
        int damagePerMember = strength / members.size();
        System.out.println("-> Nhóm [" + name + "] chia đều " + strength + " sát thương cho " + members.size() + " thành viên.");
        
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
        System.out.println(">>> Đội quân [" + name + "]: Đồng loạt trang bị " + equipmentName);
        for (Soldier member : members) {
            member.equip(equipmentName); // Chuyển tiếp yêu cầu trang bị xuống dưới
        }
    }
}