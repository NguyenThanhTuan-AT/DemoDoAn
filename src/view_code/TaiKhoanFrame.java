package view_code;

import java.awt.*;
import java.util.List;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import model.QuanLyChung;
import model.TaiKhoan;

public class TaiKhoanFrame extends JFrame {

    private QuanLyChung qlc;
    private JTable table;
    private DefaultTableModel model;

    public TaiKhoanFrame(QuanLyChung qlc) {
        this.qlc = qlc;
        setTitle("Quản lý tài khoản");
        setSize(600, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        initUI();
        loadData();
    }

    private void initUI() {
        model = new DefaultTableModel(new Object[]{"Tên đăng nhập", "Loại tài khoản"}, 0);
        table = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(table);

        JButton btnThem = new JButton("Thêm");
        JButton btnXoa = new JButton("Xóa");
        JButton btnGhi = new JButton("Ghi file");
        JButton btnDoc = new JButton("Đọc file");

        JPanel btnPanel = new JPanel();
        btnPanel.add(btnThem);
        btnPanel.add(btnXoa);
        btnPanel.add(btnGhi);
        btnPanel.add(btnDoc);

        add(scrollPane, BorderLayout.CENTER);
        add(btnPanel, BorderLayout.SOUTH);

        btnThem.addActionListener(e -> themTaiKhoan());
        btnXoa.addActionListener(e -> xoaTaiKhoan());
        btnGhi.addActionListener(e -> TaiKhoan.ghiVaoFile("taikhoan.txt", qlc.getDanhSachTaiKhoan()));
        btnDoc.addActionListener(e -> {
            List<TaiKhoan> ds = TaiKhoan.docTuFile("taikhoan.txt");
            qlc.getDanhSachTaiKhoan().clear();
            qlc.getDanhSachTaiKhoan().addAll(ds);
            loadData();
        });
    }

    private void loadData() {
        model.setRowCount(0);
        for (TaiKhoan tk : qlc.getDanhSachTaiKhoan()) {
            model.addRow(new Object[]{
                tk.getTenDangNhap(),
                tk.getLoaiTaiKhoan()
            });
        }
    }

    private void themTaiKhoan() {
        String ten = JOptionPane.showInputDialog(this, "Tên đăng nhập:");
        if (ten == null || ten.trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Tên đăng nhập không được để trống!");
            return;
        }

        String mk = JOptionPane.showInputDialog(this, "Mật khẩu:");
        if (mk == null || mk.trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Mật khẩu không được để trống!");
            return;
        }

        String loai = JOptionPane.showInputDialog(this, "Loại tài khoản (admin/user):");
        TaiKhoan.LoaiTaiKhoan loaiTK;

        if (loai == null) {
            return;
        }
        if (loai.equalsIgnoreCase("admin")) {
            loaiTK = TaiKhoan.LoaiTaiKhoan.ADMIN;
        } else if (loai.equalsIgnoreCase("user")) {
            loaiTK = TaiKhoan.LoaiTaiKhoan.USER;
        } else {
            JOptionPane.showMessageDialog(this, "Loại tài khoản không hợp lệ!");
            return;
        }

        TaiKhoan tk = new TaiKhoan(ten.trim(), mk.trim(), loaiTK);
        qlc.themTaiKhoan(tk);
        loadData();
        JOptionPane.showMessageDialog(this, "Thêm tài khoản thành công!");
    }

    private void xoaTaiKhoan() {
        int row = table.getSelectedRow();
        if (row >= 0) {
            String ten = (String) model.getValueAt(row, 0);
            boolean removed = qlc.getDanhSachTaiKhoan().removeIf(tk -> tk.getTenDangNhap().equals(ten));
            if (removed) {
                loadData();
                JOptionPane.showMessageDialog(this, "Đã xóa tài khoản: " + ten);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn tài khoản để xóa!");
        }
    }
}
