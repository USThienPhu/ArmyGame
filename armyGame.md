# BÁO CÁO THIẾT KẾ: DECORATOR PATTERN

---

## 1. Sơ đồ lớp UML (Class Diagram)

> **Hướng dẫn:** Chèn đường dẫn ảnh sơ đồ StarUML của bạn vào dấu ngoặc đơn bên dưới.

![Sơ đồ lớp Decorator Pattern](assets/Decorator.png)

---

## 2. Phân tích tính phong phú của chức năng đối tượng

**Câu hỏi:** Theo Decorator Pattern, "chức năng của đối tượng trở nên phong phú hơn" – điều này có đúng trong trường hợp này không?

**Trả lời:** Đúng.

**Giải thích:**
* **Cơ chế hoạt động:** Thay vì dùng kế thừa (Inheritance) để tạo ra vô số lớp con cố định (ví dụ: SoldierWithSword, SoldierWithShield), mẫu thiết kế này sử dụng **Composition** (thành phần).
* **Phong phú về hành vi:** Khi một "Binh lính" được bao bọc (wrap) bởi một Decorator "Kiếm", đối tượng mới không chỉ giữ các hành vi cơ bản mà còn có thêm các thuộc tính hoặc phương thức của kiếm, ví dụ như tăng chỉ số attack hoặc thêm phương thức `slash()`.
* **Tính linh hoạt:** Bạn có thể thêm hoặc bớt các lớp chức năng này vào **thời điểm chạy (runtime)** mà không làm thay đổi cấu trúc của lớp gốc.
* **Trách nhiệm năng động:** Đối tượng được coi là "phong phú hơn" vì nó được tích hợp thêm các trách nhiệm mới một cách năng động.

---

## 3. Hạn chế về ràng buộc trang bị

**Câu hỏi:** Nếu có thêm ràng buộc: một binh lính không thể mang hai trang bị cùng loại – Decorator có phải là phương pháp thích hợp để đảm bảo ràng buộc này không?

**Trả lời:** Không phải là phương pháp thích hợp nhất.

**Lý do:**
* **Cấu trúc đệ quy (Recursive structure):** Decorator hoạt động theo kiểu "vỏ hành". Một lớp vỏ bên ngoài chỉ nhận diện đối tượng bên trong là một Component chung chung, nên khó biết được các lớp vỏ sâu hơn đã có loại trang bị đó hay chưa.
* **Vi phạm nguyên tắc "trong suốt" (Transparency):** Mục tiêu của Decorator là làm cho đối tượng được trang bị và đối tượng gốc trông giống hệt nhau về mặt giao diện. Việc bắt Decorator phải "kiểm tra ngược" vào bên trong sẽ làm tăng độ phức tạp và phá vỡ tính đóng gói.
* **Khó quản lý trạng thái:** Để kiểm tra loại trang bị, hệ thống phải duyệt qua toàn bộ chuỗi Decorator (traverse the chain), gây tốn kém hiệu năng và làm mã nguồn trở nên rắc rối.

---
