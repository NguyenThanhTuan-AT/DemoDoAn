package view;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import model.QuanLyChung;
import model.TaiKhoan;

public class LoginFrame extends JFrame {

    private JTextField txtTenDangNhap;
    private JPasswordField txtMatKhau;
    private JButton btnDangNhap;
    private QuanLyChung qlc;

    public LoginFrame(QuanLyChung qlc) {
        this.qlc = qlc;
        setTitle("Đăng nhập hệ thống");
        setSize(400, 200);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        initUI();
    }

    private void initUI() {
        JPanel panel = new JPanel(new GridLayout(3, 2, 10, 10));

        panel.add(new JLabel("Tên đăng nhập:"));
        txtTenDangNhap = new JTextField();
        panel.add(txtTenDangNhap);

        panel.add(new JLabel("Mật khẩu:"));
        txtMatKhau = new JPasswordField();
        panel.add(txtMatKhau);

        btnDangNhap = new JButton("Đăng nhập");
        panel.add(new JLabel()); // khoảng trống
        panel.add(btnDangNhap);

        add(panel);

        btnDangNhap.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String ten = txtTenDangNhap.getText();
                String mk = new String(txtMatKhau.getPassword());

                if (qlc.kiemTraDangNhap(ten, mk)) {
                    TaiKhoan tk = qlc.timTaiKhoan(ten);
                    JOptionPane.showMessageDialog(null, "Đăng nhập thành công!");

                    dispose(); // đóng cửa sổ đăng nhập

                    if (tk.laAdmin()) {
                        new AdminFrame(qlc).setVisible(true);
                    } else {
                        new UserFrame(qlc).setVisible(true);
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Sai tên đăng nhập hoặc mật khẩu!");
                }
            }
        });
    }
}
