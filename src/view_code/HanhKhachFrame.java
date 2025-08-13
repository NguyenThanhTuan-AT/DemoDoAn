package view_code;

import java.awt.*;
import java.util.List;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import model.HanhKhach;
import model.QuanLyChung;
import model.VeMayBay;

public class HanhKhachFrame extends JFrame {

    private QuanLyChung qlc;
    private JTable table;
    private DefaultTableModel model;

    public HanhKhachFrame(QuanLyChung qlc) {
        this.qlc = qlc;
        setTitle("Quản lý hành khách");
        setSize(700, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        initUI();
        loadData();
    }

    private void initUI() {
        model = new DefaultTableModel(new Object[]{"CCCD", "Họ tên", "Mã vé"}, 0);
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

        btnThem.addActionListener(e -> themHanhKhach());
        btnXoa.addActionListener(e -> xoaHanhKhach());
        btnGhi.addActionListener(e -> HanhKhach.ghiVaoFile("hanhkhach.txt", qlc.getDanhSachHanhKhach()));
        btnDoc.addActionListener(e -> {
            List<HanhKhach> ds = HanhKhach.docTuFile("hanhkhach.txt");
            qlc.getDanhSachHanhKhach().clear();
            qlc.getDanhSachHanhKhach().addAll(ds);
            loadData();
        });
    }

    private void loadData() {
        model.setRowCount(0);
        for (HanhKhach hk : qlc.getDanhSachHanhKhach()) {
            model.addRow(new Object[]{
                hk.getCccd(),
                hk.getHoTen(),
                hk.getVe() != null ? hk.getVe().getMaVe() : ""
            });
        }
    }

    private void themHanhKhach() {
        String cccd = JOptionPane.showInputDialog("Số CCCD:");
        String hoTen = JOptionPane.showInputDialog("Họ tên:");
        String maVe = JOptionPane.showInputDialog("Mã vé:");
        VeMayBay ve = qlc.timVe(maVe);

        if (ve == null) {
            JOptionPane.showMessageDialog(null, "Vé không tồn tại!");
            return;
        }

        HanhKhach hk = new HanhKhach(cccd, hoTen, ve);
        qlc.themHanhKhach(hk);
        loadData();
    }

    private void xoaHanhKhach() {
        int row = table.getSelectedRow();
        if (row >= 0) {
            String cccd = (String) model.getValueAt(row, 0);
            qlc.getDanhSachHanhKhach().removeIf(h -> h.getCccd().equals(cccd));
            loadData();
        }
    }
}
