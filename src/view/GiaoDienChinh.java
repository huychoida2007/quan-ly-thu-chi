package view;

import controller.DieuKhienGiaoDich;
import exception.LoiSoTienKhongHopLe;
import model.KhoanChi;
import model.KhoanThu;
import model.GiaoDich;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.MaskFormatter;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.ResolverStyle;

public class GiaoDienChinh extends JFrame {
    private DieuKhienGiaoDich dieuKhien;
    
    private JTextField txtMa, txtNoiDung, txtSoTien;
    private JFormattedTextField txtNgay;
    private JComboBox<String> cbLoai;
    private JTable bangDuLieu;
    private DefaultTableModel moHinhBang;
    private JButton btnThem, btnSua, btnXoa, btnLamMoi;
    private JLabel lblTongSoDu;

    public GiaoDienChinh() {
        dieuKhien = new DieuKhienGiaoDich();
        thietLapGiaoDien();
        taoGiaoDien();
        taiDuLieu();
    }

    private void thietLapGiaoDien() {
        try {
            for (UIManager.LookAndFeelInfo thongTin : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(thongTin.getName())) {
                    UIManager.setLookAndFeel(thongTin.getClassName());
                    break;
                }
            }
        } catch (Exception e) {
        }
    }

    private void taoGiaoDien() {
        setTitle("Phần mềm Quản lý Thu Chi Cá Nhân");
        setSize(980, 560);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        
        JPanel pnlChinh = new JPanel(new BorderLayout(15, 15));
        pnlChinh.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
        pnlChinh.setBackground(new Color(245, 245, 250));
        setContentPane(pnlChinh);

        Font kieuChu = new Font("Segoe UI", Font.PLAIN, 14);
        Font kieuChuDam = new Font("Segoe UI", Font.BOLD, 14);

        JPanel pnlNhapLieu = new JPanel(new GridLayout(6, 2, 10, 15));
        pnlNhapLieu.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.GRAY), "Nhập thông tin giao dịch", 0, 0, kieuChuDam),
                BorderFactory.createEmptyBorder(15, 15, 15, 15)
        ));
        pnlNhapLieu.setPreferredSize(new Dimension(350, 0));
        pnlNhapLieu.setBackground(Color.WHITE);

        JLabel lblMa = new JLabel("Mã giao dịch:");
        lblMa.setFont(kieuChu);
        txtMa = new JTextField();
        txtMa.setFont(kieuChu);
        pnlNhapLieu.add(lblMa);
        pnlNhapLieu.add(txtMa);

        JLabel lblNgay = new JLabel("Ngày (dd/mm/yyyy):");
        lblNgay.setFont(kieuChu);
        try {
            MaskFormatter dinhDangNgay = new MaskFormatter("##/##/####");
            dinhDangNgay.setPlaceholderCharacter('_');
            txtNgay = new JFormattedTextField(dinhDangNgay);
        } catch (ParseException e) {
            txtNgay = new JFormattedTextField();
        }
        txtNgay.setFont(kieuChu);
        pnlNhapLieu.add(lblNgay);
        pnlNhapLieu.add(txtNgay);

        JLabel lblNoiDung = new JLabel("Nội dung:");
        lblNoiDung.setFont(kieuChu);
        txtNoiDung = new JTextField();
        txtNoiDung.setFont(kieuChu);
        pnlNhapLieu.add(lblNoiDung);
        pnlNhapLieu.add(txtNoiDung);

        JLabel lblSoTien = new JLabel("Số tiền (VNĐ):");
        lblSoTien.setFont(kieuChu);
        txtSoTien = new JTextField();
        txtSoTien.setFont(kieuChu);
        pnlNhapLieu.add(lblSoTien);
        pnlNhapLieu.add(txtSoTien);

        JLabel lblPhanLoai = new JLabel("Phân loại:");
        lblPhanLoai.setFont(kieuChu);
        cbLoai = new JComboBox<>(new String[]{"Khoản Thu", "Khoản Chi"});
        cbLoai.setFont(kieuChu);
        pnlNhapLieu.add(lblPhanLoai);
        pnlNhapLieu.add(cbLoai);

        pnlChinh.add(pnlNhapLieu, BorderLayout.WEST);

        String[] cot = {"STT", "Mã GD", "Ngày", "Phân loại", "Nội dung", "Số tiền (VNĐ)"};
        moHinhBang = new DefaultTableModel(cot, 0);
        bangDuLieu = new JTable(moHinhBang);
        bangDuLieu.setFont(kieuChu);
        bangDuLieu.setRowHeight(25);
        bangDuLieu.getTableHeader().setFont(kieuChuDam);
        
        bangDuLieu.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        bangDuLieu.getColumnModel().getColumn(0).setPreferredWidth(50);
        bangDuLieu.getColumnModel().getColumn(1).setPreferredWidth(100);
        bangDuLieu.getColumnModel().getColumn(2).setPreferredWidth(120);
        bangDuLieu.getColumnModel().getColumn(3).setPreferredWidth(120);
        bangDuLieu.getColumnModel().getColumn(4).setPreferredWidth(250);
        bangDuLieu.getColumnModel().getColumn(5).setPreferredWidth(150);
        
        bangDuLieu.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int dong = bangDuLieu.getSelectedRow();
                if (dong >= 0) {
                    txtMa.setText(moHinhBang.getValueAt(dong, 1).toString());
                    txtNgay.setText(moHinhBang.getValueAt(dong, 2).toString());
                    cbLoai.setSelectedItem(moHinhBang.getValueAt(dong, 3).toString());
                    txtNoiDung.setText(moHinhBang.getValueAt(dong, 4).toString());
                    txtSoTien.setText(moHinhBang.getValueAt(dong, 5).toString().replace(".", ""));
                }
            }
        });
        
        JScrollPane cuonBang = new JScrollPane(bangDuLieu);
        cuonBang.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        cuonBang.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        
        cuonBang.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(Color.GRAY, 1),
                BorderFactory.createEmptyBorder(0, 0, 3, 0)
        ));
        cuonBang.getHorizontalScrollBar().setPreferredSize(new Dimension(0, 22));
        
        pnlChinh.add(cuonBang, BorderLayout.CENTER);

        JPanel pnlDuoi = new JPanel(new BorderLayout());
        pnlDuoi.setBackground(new Color(245, 245, 250));
        
        JPanel pnlNutBam = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 10));
        pnlNutBam.setBackground(new Color(245, 245, 250));
        
        btnThem = new JButton("Thêm mới");
        btnSua = new JButton("Cập nhật");
        btnXoa = new JButton("Xóa");
        btnLamMoi = new JButton("Làm mới");

        btnThem.setFont(kieuChuDam);
        btnSua.setFont(kieuChuDam);
        btnXoa.setFont(kieuChuDam);
        btnLamMoi.setFont(kieuChuDam);

        pnlNutBam.add(btnThem);
        pnlNutBam.add(btnSua);
        pnlNutBam.add(btnXoa);
        pnlNutBam.add(btnLamMoi);

        lblTongSoDu = new JLabel("Tổng số dư hiện tại: 0 VNĐ", SwingConstants.CENTER);
        lblTongSoDu.setFont(new Font("Segoe UI", Font.BOLD, 18));
        lblTongSoDu.setForeground(new Color(41, 128, 185));
        lblTongSoDu.setBorder(BorderFactory.createEmptyBorder(10, 0, 10, 0));

        pnlDuoi.add(pnlNutBam, BorderLayout.NORTH);
        pnlDuoi.add(lblTongSoDu, BorderLayout.SOUTH);
        pnlChinh.add(pnlDuoi, BorderLayout.SOUTH);

        btnThem.addActionListener(e -> xuLyThemSua(true));
        btnSua.addActionListener(e -> xuLyThemSua(false));
        btnXoa.addActionListener(e -> xuLyXoa());
        btnLamMoi.addActionListener(e -> xoaForm());
    }

    private void xuLyThemSua(boolean laThem) {
        try {
            String ma = txtMa.getText().trim();
            String ngay = txtNgay.getText().replace("_", "").trim();
            String noiDung = txtNoiDung.getText().trim();
            
            if (ma.isEmpty() || ngay.isEmpty() || noiDung.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Vui lòng nhập đầy đủ thông tin chữ!", "Cảnh báo", JOptionPane.WARNING_MESSAGE);
                return;
            }
            
            if (ngay.length() < 10) {
                JOptionPane.showMessageDialog(this, "Lỗi: Ngày tháng chưa nhập đủ (dd/mm/yyyy)!", "Lỗi định dạng", JOptionPane.ERROR_MESSAGE);
                return;
            }

            try {
                DateTimeFormatter kieuNgay = DateTimeFormatter.ofPattern("dd/MM/uuuu").withResolverStyle(ResolverStyle.STRICT);
                LocalDate.parse(ngay, kieuNgay);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Lỗi: Ngày tháng không hợp lệ trên lịch dương!", "Lỗi ngày tháng", JOptionPane.ERROR_MESSAGE);
                return;
            }

            int viTriKiemTra = laThem ? -1 : bangDuLieu.getSelectedRow();
            if (dieuKhien.kiemTraTrungMa(ma, viTriKiemTra)) {
                JOptionPane.showMessageDialog(this, "Lỗi: Mã giao dịch đã tồn tại!", "Trùng Dữ Liệu", JOptionPane.ERROR_MESSAGE);
                return;
            }

            double tien = Double.parseDouble(txtSoTien.getText().trim());

            if (tien <= 0) {
                throw new LoiSoTienKhongHopLe("Số tiền nhập vào phải lớn hơn 0!");
            }

            GiaoDich gd;
            if (cbLoai.getSelectedIndex() == 0) {
                gd = new KhoanThu(ma, ngay, noiDung, tien);
            } else {
                gd = new KhoanChi(ma, ngay, noiDung, tien);
            }

            if (laThem) {
                dieuKhien.themGiaoDich(gd);
                JOptionPane.showMessageDialog(this, "Thêm giao dịch thành công!");
            } else {
                if (viTriKiemTra >= 0) {
                    dieuKhien.suaGiaoDich(viTriKiemTra, gd);
                    JOptionPane.showMessageDialog(this, "Cập nhật thành công!");
                } else {
                    JOptionPane.showMessageDialog(this, "Vui lòng chọn 1 dòng trên bảng để cập nhật.");
                    return;
                }
            }

            taiDuLieu();
            xoaForm();

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Lỗi: Số tiền phải là kiểu số hợp lệ!", "Lỗi định dạng", JOptionPane.ERROR_MESSAGE);
        } catch (LoiSoTienKhongHopLe ex) {
            JOptionPane.showMessageDialog(this, "Lỗi Nghiệp vụ: " + ex.getMessage(), "Lỗi Dữ liệu", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void xuLyXoa() {
        int dong = bangDuLieu.getSelectedRow();
        if (dong >= 0) {
            int xacNhan = JOptionPane.showConfirmDialog(this, "Bạn có chắc muốn xóa giao dịch này?", "Xác nhận", JOptionPane.YES_NO_OPTION);
            if (xacNhan == JOptionPane.YES_OPTION) {
                dieuKhien.xoaGiaoDich(dong);
                taiDuLieu();
                xoaForm();
            }
        } else {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn 1 dòng để xóa.");
        }
    }

    private void xoaForm() {
        txtMa.setText("");
        txtNgay.setValue(null);
        txtNoiDung.setText("");
        txtSoTien.setText("");
        cbLoai.setSelectedIndex(0);
        bangDuLieu.clearSelection();
    }

    private void taiDuLieu() {
        moHinhBang.setRowCount(0);
        int stt = 1;
        for (GiaoDich gd : dieuKhien.layDanhSach()) {
            String loaiCoDau = gd.layLoaiGiaoDich().equals("Khoan Thu") ? "Khoản Thu" : "Khoản Chi";
            String tienDinhDang = String.format("%,.0f", gd.getSoTien()).replace(',', '.');
            moHinhBang.addRow(new Object[]{
                    stt++,
                    gd.getMaGiaoDich(),
                    gd.getNgayThang(),
                    loaiCoDau,
                    gd.getNoiDung(),
                    tienDinhDang
            });
        }
        double tong = dieuKhien.tinhTongSoDu();
        lblTongSoDu.setText(String.format("Tổng số dư hiện tại: %,.0f VNĐ", tong).replace(',', '.'));
    }
}