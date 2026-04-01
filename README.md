# Phần mềm Quản lý Thu Chi Cá Nhân
> **Bài tập lớn cuối kỳ môn Lập trình Java**

## Thông tin nhóm thực hiện
| STT | Họ và Tên | Mã Sinh Viên | Vai trò / Nhiệm vụ |
|---|---|---|---|
| 1 | [Lê Quốc Huy] | [3120225066] | Viết Code Controller, Model và xử lý File I/O | [GitHub](https://github.com/huychoida2007) |

| 2 | [Điền tên bạn 2 vào đây] | [Điền MSV 2] | Thiết kế giao diện (View) và Bắt lỗi Exception |

## Giới thiệu dự án (Description)
Đây là phần mềm Quản lý Thu Chi Cá Nhân giúp người dùng dễ dàng ghi chép dòng tiền, phân loại các khoản thu/chi và theo dõi tổng số dư một cách trực quan thông qua giao diện Desktop.

## Các chức năng chính (Features)
- [x] Quản lý thông tin (Thêm, Cập nhật, Xóa dữ liệu).
- [x] Lưu trữ dữ liệu vĩnh viễn với File I/O nhị phân (.dat).
- [x] Giao diện người dùng (GUI) thân thiện, dễ thao tác bằng Java Swing.
- [x] Bắt lỗi nhập liệu chặt chẽ (Exception Handling, Custom Exception, Validate Ngày tháng & Mã giao dịch).
- [x] Tự động tính toán tổng số dư hiện tại dựa trên các khoản thu/chi.

## Công nghệ & Kiến trúc (Technologies)
* **Ngôn ngữ:** Java
* **Giao diện:** Java Swing (Theme Nimbus)
* **Lưu trữ:** File Binary (.dat)
* **Kiến trúc:** Mô hình MVC (Model - View - Controller)
* **Tính chất OOP:** Áp dụng Triệt để Tính Kế thừa, Tính Đa hình, Tính Trừu tượng và Đóng gói.

## 📂 Cấu trúc thư mục (Project Structure)
Mã nguồn được tổ chức theo mô hình MVC để dễ dàng quản lý và mở rộng:

```text
BAITAP.JAVA/
 ┣ src/
 ┃ ┣ controller/  # Điều hướng dữ liệu và xử lý File
 ┃ ┃ ┗ DieuKhienGiaoDich.java
 ┃ ┣ exception/   # Định nghĩa các lỗi tự chọn
 ┃ ┃ ┗ LoiSoTienKhongHopLe.java
 ┃ ┣ main/        # Điểm khởi đầu của chương trình
 ┃ ┃ ┗ ChayChuongTrinh.java
 ┃ ┣ model/       # Cấu trúc dữ liệu và đối tượng
 ┃ ┃ ┣ GiaoDich.java (Abstract)
 ┃ ┃ ┣ KhoanThu.java
 ┃ ┃ ┗ KhoanChi.java
 ┃ ┗ view/        # Giao diện người dùng Swing
 ┃   ┗ GiaoDienChinh.java
 ┣ .gitignore     # Chặn các file rác không cần thiết khi push
 ┣ README.md      # Tài liệu hướng dẫn dự án
 ┗ dulieu_thuchi.dat # Tệp tin lưu trữ dữ liệu thực tế

## 🚀 Hướng dẫn cài đặt và chạy (Installation)
1.Cài đặt môi trường: Đảm bảo máy tính đã cài đặt JDK 17 trở lên và VS Code (hoặc IDE Java bất kỳ).

2.Tải mã nguồn:   
Bash
git clone [https://github.com/huychoida2007/quan-ly-thu-chi.git](https://github.com/huychoida2007/quan-ly-thu-chi.git)

3.Mở dự án: Mở thư mục BAITAP.JAVA bằng VS Code.

4.Chạy ứng dụng: Tìm đến file src/main/ChayChuongTrinh.java, nhấn chuột phải và chọn Run Java.

