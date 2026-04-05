package controller;

import model.GiaoDich;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class DieuKhienGiaoDich {
    private List<GiaoDich> danhSachGiaoDich;
    private final String TEN_FILE = "dulieu_thuchi.dat";

    public DieuKhienGiaoDich() {
        danhSachGiaoDich = new ArrayList<>();
        docDuLieu();
    }

    public List<GiaoDich> layDanhSach() {
        return danhSachGiaoDich;
    }

    public void themGiaoDich(GiaoDich giaoDich) {
        danhSachGiaoDich.add(giaoDich);
        luuDuLieu();
    }

    public void suaGiaoDich(int viTri, GiaoDich giaoDich) {
        if (viTri >= 0 && viTri < danhSachGiaoDich.size()) {
            danhSachGiaoDich.set(viTri, giaoDich);
            luuDuLieu();
        }
    }

    public void xoaGiaoDich(int viTri) {
        if (viTri >= 0 && viTri < danhSachGiaoDich.size()) {
            danhSachGiaoDich.remove(viTri);
            luuDuLieu();
        }
    }

    // Phương thức tính tổng số dư dựa trên tính đa hình của OOP
    public double tinhTongSoDu() {
        double tong = 0;
        for (GiaoDich gd : danhSachGiaoDich) {
            tong += gd.tinhTienThucTe(); // Gọi hàm đa hình từ lớp con (KhoanThu / KhoanChi)
        }
        return tong;
    }

    // Kiểm tra mã giao dịch có bị trùng lặp trong hệ thống không
    public boolean kiemTraTrungMa(String ma, int viTriBoQua) {
        for (int i = 0; i < danhSachGiaoDich.size(); i++) {
            if (i != viTriBoQua && danhSachGiaoDich.get(i).getMaGiaoDich().equals(ma)) {
                return true;
            }
        }
        return false;
    }

    // Lưu trữ danh sách giao dịch xuống tệp nhị phân (Binary File I/O)
    private void luuDuLieu() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(TEN_FILE))) {
            oos.writeObject(danhSachGiaoDich);
        } catch (IOException e) {
            System.err.println("Lỗi ghi file: " + e.getMessage());
        }
    }

    // Đọc khôi phục dữ liệu từ tệp nhị phân khi ứng dụng khởi động
    @SuppressWarnings("unchecked")
    private void docDuLieu() {
        File file = new File(TEN_FILE);
        if (file.exists()) {
            try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
                danhSachGiaoDich = (List<GiaoDich>) ois.readObject();
            } catch (IOException | ClassNotFoundException e) {
                System.err.println("Lỗi đọc file: " + e.getMessage());
            }
        }
    }
}