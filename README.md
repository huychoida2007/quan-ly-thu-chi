# Phần mềm Quản lý Thu Chi Cá Nhân
> **Bài tập lớn cuối kỳ môn Lập trình Java**

## 👥 Thông tin nhóm (Team Members)
| STT | Họ và Tên | Mã Sinh Viên | Vai trò / Nhiệm vụ | Link GitHub Cá Nhân |
|---|---|---|---|---|
| 1 | Lê Quốc Huy (Nhóm trưởng) | 3120225066 | Viết Code Controller, Model và xử lý File I/O | [GitHub](https://github.com/huychoida2007) |
| 2 | Trần Quốc Bảo | 3120225012 | Thiết kế giao diện (View) và Bắt lỗi Exception | [GitHub](link_cua_ban_2) |

## 📝 Giới thiệu dự án (Description)
Đây là phần mềm Quản lý Thu Chi Cá Nhân giúp người dùng dễ dàng ghi chép dòng tiền, phân loại các khoản thu/chi và theo dõi tổng số dư một cách trực quan thông qua giao diện Desktop. Đặc biệt, ứng dụng hỗ trợ vẽ biểu đồ thống kê hàng tháng giúp người dùng quản lý tài chính cá nhân hiệu quả hơn.

## ✨ Các chức năng chính (Features)
- [x] Quản lý thông tin (Thêm, Đọc, Cập nhật, Xóa dữ liệu - CRUD toàn diện).
- [x] Lưu trữ dữ liệu vĩnh viễn với File I/O nhị phân (`.dat`).
- [x] Giao diện người dùng (GUI) thân thiện, dễ thao tác bằng Java Swing (sử dụng linh hoạt các Layout và Component).
- [x] Bắt lỗi nhập liệu chặt chẽ (Exception Handling), tự định nghĩa Custom Exception (vd: `LoiSoTienKhongHopLe`) và hiện thông báo lỗi bằng `JOptionPane`.
- [x] Tự động tính toán tổng số dư hiện tại dựa trên các khoản thu/chi.
- [x] Vẽ biểu đồ thống kê chi tiêu hàng tháng (sử dụng thư viện JFreeChart).

## 💻 Công nghệ & Thư viện sử dụng (Technologies)
* **Ngôn ngữ:** Java (JDK 17+)
* **Giao diện:** Java Swing (Theme Nimbus)
* **Lưu trữ:** File Binary (`.dat`)
* **Kiến trúc:** Mô hình MVC (Model - View - Controller) áp dụng triệt để tính Đóng gói, Kế thừa và Đa hình.
* **Công cụ khác:** Git, GitHub, VS Code

## 📂 Cấu trúc thư mục (Project Structure)
Mã nguồn được tổ chức chặt chẽ theo mô hình **MVC (Model - View - Controller)** để dễ dàng quản lý và mở rộng:

```text
BAITAP.JAVA/
 ┣ 📦src/
 ┃ ┣ 📂controller/  # Chứa các lớp xử lý nghiệp vụ, tính toán logic và tương tác File
 ┃ ┃ ┗ DieuKhienGiaoDich.java
 ┃ ┣ 📂exception/   # Định nghĩa các lỗi tự chọn (Custom Exception)
 ┃ ┃ ┗ LoiSoTienKhongHopLe.java
 ┃ ┣ 📂main/        # File Entry-point để khởi động ứng dụng
 ┃ ┃ ┗ ChayChuongTrinh.java
 ┃ ┣ 📂model/       # Chứa các lớp thực thể (chỉ gồm Thuộc tính, Constructor, Getter/Setter)
 ┃ ┃ ┣ GiaoDich.java (Abstract)
 ┃ ┃ ┣ KhoanThu.java
 ┃ ┃ ┗ KhoanChi.java
 ┃ ┗ 📂view/        # Chứa các file giao diện cấu thành từ JFrame, JPanel
 ┃   ┗ GiaoDienChinh.java
 ┣ 📜.gitignore     # Chặn các file rác/IDE config không cần thiết khi push
 ┣ 📜README.md      # Tài liệu mô tả dự án và hướng dẫn cài đặt
 ┗ 📜dulieu_thuchi.dat # Tệp tin lưu trữ dữ liệu thực tế
```

## 🚀 Hướng dẫn cài đặt và chạy (Installation)
1. **Cài đặt môi trường:** Đảm bảo máy tính đã cài đặt JDK 17 trở lên và VS Code (hoặc IDE Java bất kỳ như IntelliJ/Eclipse).
2. **Clone repository này về máy:**
   ```bash
   git clone [https://github.com/huychoida2007/quan-ly-thu-chi.git](https://github.com/huychoida2007/quan-ly-thu-chi.git)
   ```
3. **Mở dự án:** Mở thư mục `BAITAP.JAVA` bằng IDE của bạn.
4. **Chạy ứng dụng:** Tìm đến file `src/main/ChayChuongTrinh.java`, nhấn chuột phải và chọn **Run Java** để bắt đầu.

## 📸 Ảnh chụp màn hình (Screenshots)

![Màn hình Giao diện chính]<img width="1207" height="689" alt="image" src="https://github.com/user-attachments/assets/1c795c04-da85-4ee0-8e5e-ec1e4e778904" />

![Màn hình Thêm Giao dịch]<img width="1209" height="694" alt="image" src="https://github.com/user-attachments/assets/18ec4bd9-4062-4ca5-8118-3fd36fcb4ee0" />

![Màn hình Biểu đồ Thống kê]<img width="1208" height="695" alt="image" src="https://github.com/user-attachments/assets/a1d28535-c206-4fd1-8a91-215769f313c5" />

