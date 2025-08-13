package view_code;

import java.awt.*;
import javax.swing.*;
import model.QuanLyChung;

public class AdminFrame extends JFrame {

    private QuanLyChung qlc;

    public AdminFrame(QuanLyChung qlc) {
        this.qlc = qlc;
        setTitle("Quản trị hệ thống - Admin");
        setSize(600, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        initUI();
    }

    private void initUI() {
        JPanel panel = new JPanel(new GridLayout(3, 3, 10, 10));

        JButton btnChuyenBay = new JButton("Quản lý chuyến bay");
        JButton btnVe = new JButton("Quản lý vé");
        JButton btnHanhKhach = new JButton("Quản lý hành khách");
        JButton btnMayBay = new JButton("Quản lý máy bay");
        JButton btnHang = new JButton("Quản lý hãng hàng không");
        JButton btnTaiKhoan = new JButton("Quản lý tài khoản");
        JButton btnThoat = new JButton("Thoát");

        panel.add(btnChuyenBay);
        panel.add(btnVe);
        panel.add(btnHanhKhach);
        panel.add(btnMayBay);
        panel.add(btnHang);
        panel.add(btnTaiKhoan);
        panel.add(new JLabel()); // khoảng trống
        panel.add(btnThoat);

        add(panel);

        // Sự kiện mở các frame chức năng
        btnChuyenBay.addActionListener(e -> new ChuyenBayFrame(qlc).setVisible(true));
        btnVe.addActionListener(e -> new VeFrame(qlc).setVisible(true));
        btnHanhKhach.addActionListener(e -> new HanhKhachFrame(qlc).setVisible(true));
        btnMayBay.addActionListener(e -> new MayBayFrame(qlc).setVisible(true));
        btnHang.addActionListener(e -> new HangHangKhongFrame(qlc).setVisible(true));
        btnTaiKhoan.addActionListener(e -> new TaiKhoanFrame(qlc).setVisible(true));
        btnThoat.addActionListener(e -> System.exit(0));
    }
}
