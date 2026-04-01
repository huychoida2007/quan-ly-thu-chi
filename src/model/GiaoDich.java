package model;

import java.io.Serializable;

public abstract class GiaoDich implements Serializable {
    private String maGiaoDich;
    private String ngayThang;
    private String noiDung;
    private double soTien;

    public GiaoDich(String maGiaoDich, String ngayThang, String noiDung, double soTien) {
        this.maGiaoDich = maGiaoDich;
        this.ngayThang = ngayThang;
        this.noiDung = noiDung;
        this.soTien = soTien;
    }

    public String getMaGiaoDich() { return maGiaoDich; }
    public void setMaGiaoDich(String maGiaoDich) { this.maGiaoDich = maGiaoDich; }

    public String getNgayThang() { return ngayThang; }
    public void setNgayThang(String ngayThang) { this.ngayThang = ngayThang; }

    public String getNoiDung() { return noiDung; }
    public void setNoiDung(String noiDung) { this.noiDung = noiDung; }

    public double getSoTien() { return soTien; }
    public void setSoTien(double soTien) { this.soTien = soTien; }

    public abstract double tinhTienThucTe();
    public abstract String layLoaiGiaoDich();
}