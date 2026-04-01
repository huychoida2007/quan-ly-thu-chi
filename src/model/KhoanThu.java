package model;

public class KhoanThu extends GiaoDich {
    public KhoanThu(String maGiaoDich, String ngayThang, String noiDung, double soTien) {
        super(maGiaoDich, ngayThang, noiDung, soTien);
    }

    @Override
    public double tinhTienThucTe() {
        return this.getSoTien();
    }

    @Override
    public String layLoaiGiaoDich() {
        return "Khoan Thu";
    }
}