public class Game {
    public static void main(String[] args) {
        // --- BƯỚC 1: KHỞI TẠO CÁC FACTORY THỜI ĐẠI ---
        MedievalFactory medFactory = new MedievalFactory();
        WorldWarFactory wwFactory = new WorldWarFactory();
        ScienceFictionFactory sfFactory = new ScienceFictionFactory();

        // --- BƯỚC 2: ĐĂNG KÝ TRANG BỊ VÀO HỆ THỐNG ---
        // Việc này giúp Proxy biết thời đại nào có những món đồ gì
        medFactory.registerEraEquipment();
        wwFactory.registerEraEquipment();
        sfFactory.registerEraEquipment();

        System.out.println("=== KHỞI TẠO QUÂN ĐỘI ĐA THỜI ĐẠI ===\n");

        // --- BƯỚC 3: TẠO BINH LÍNH (Chưa có trang bị sẵn) ---
        // Knight thuộc thời Medieval
        SoldierProxy knight = new SoldierProxy("Hiệp sĩ Arthur", "Medieval", medFactory.createHorseman());
        
        // Marine thuộc thời WorldWar
        SoldierProxy marine = new SoldierProxy("Lính thủy đánh bộ", "WorldWar", wwFactory.createInfantryman());
        
        // Cyborg thuộc thời ScienceFiction
        SoldierProxy cyborg = new SoldierProxy("Chiến binh Nano", "ScienceFiction", sfFactory.createInfantryman());


        // --- BƯỚC 4: KIỂM TRA RÀNG BUỘC (TEST CONSTRAINT) ---
        System.out.println("--- THỬ NGHIỆM TRANG BỊ SAI THỜI ĐẠI (Sẽ thất bại) ---");
        
        // Hiệp sĩ trung cổ không thể dùng Súng trường của Thế chiến
        knight.equip("Súng trường"); 
        
        // Lính thế chiến không thể dùng Kiếm Laser của tương lai
        marine.equip("Kiếm Laser");
        
        // Chiến binh tương lai không dùng Giáp sắt thô sơ
        cyborg.equip("Giáp sắt");


        // --- BƯỚC 5: TRANG BỊ ĐÚNG THỜI ĐẠI (TEST VALID EQUIP) ---
        System.out.println("\n--- TRANG BỊ ĐÚNG THỜI ĐẠI (Sẽ thành công) ---");
        
        knight.equip("Kiếm");
        knight.equip("Giáp sắt");

        marine.equip("Súng trường");
        marine.equip("Mũ sắt");

        cyborg.equip("Kiếm Laser");
        cyborg.equip("Giáp Nano");


        // --- BƯỚC 6: HIỂN THỊ TRẠNG THÁI VÀ CHIẾN ĐẤU ---
        System.out.println("\n--- TỔNG KIỂM TRA QUÂN ĐỘI ---");
        SoldierGroup alliance = new SoldierGroup("Liên Minh Vượt Thời Gian");
        alliance.addMember(knight);
        alliance.addMember(marine);
        alliance.addMember(cyborg);

        // Sử dụng Visitor để in báo cáo
        DisplayVisitor displayVisitor = new DisplayVisitor();
        alliance.accept(displayVisitor);

        System.out.println("\n--- THỬ NGHIỆM CHIẾN ĐẤU ---");
        int totalDamage = alliance.hit();
        System.out.println("\n=> Tổng sát thương liên minh gây ra: " + totalDamage);

        System.out.println("\n--- LIÊN MINH BỊ TẤN CÔNG ---");
        alliance.wardOff(120); // Chia đều sát thương cho các thành viên
    }
}