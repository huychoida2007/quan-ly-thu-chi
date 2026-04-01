package model;

public class KhoanChi extends GiaoDich {
    public KhoanChi(String maGiaoDich, String ngayThang, String noiDung, double soTien) {
        super(maGiaoDich, ngayThang, noiDung, soTien);
    }

    @Override
    public double tinhTienThucTe() {
        return -this.getSoTien();
    }

    @Override
    public String layLoaiGiaoDich() {
        return "Khoan Chi";
    }
}