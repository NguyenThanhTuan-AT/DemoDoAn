package view_code;

import java.awt.*;
import java.util.List;
import javax.swing.*;
import model.ChuyenBay;
import model.HanhKhach;
import model.QuanLyChung;

public class UserFrame extends JFrame {

    private QuanLyChung qlc;

    public UserFrame(QuanLyChung qlc) {
        this.qlc = qlc;
        setTitle("Giao diện người dùng");
        setSize(600, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        initUI();
    }

    private void initUI() {
        JPanel panel = new JPanel(new GridLayout(3, 1, 10, 10));

        JButton btnXemChuyenBay = new JButton("Xem danh sách chuyến bay");
        JButton btnDatVe = new JButton("Đặt vé máy bay");
        JButton btnXemVe = new JButton("Xem vé đã đặt");

        panel.add(btnXemChuyenBay);
        panel.add(btnDatVe);
        panel.add(btnXemVe);

        add(panel);

        btnXemChuyenBay.addActionListener(e -> {
            List<ChuyenBay> ds = qlc.locChuyenBayTheoNgay(java.time.LocalDate.now());
            JOptionPane.showMessageDialog(null, ds.toString());
        });

        btnDatVe.addActionListener(e -> {
            new VeFrame(qlc).setVisible(true); // dùng lại VeFrame để đặt vé
        });

        btnXemVe.addActionListener(e -> {
            List<HanhKhach> dsHK = qlc.locHanhKhachTheoChuyenBay("CB001"); // ví dụ chuyến bay
            JOptionPane.showMessageDialog(null, dsHK.toString());
        });
    }
}
