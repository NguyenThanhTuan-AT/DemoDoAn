package view_code;

import java.awt.*;
import java.util.List;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import model.HangHangKhong;
import model.QuanLyChung;

public class HangHangKhongFrame extends JFrame {

    private QuanLyChung qlc;
    private JTable table;
    private DefaultTableModel model;

    public HangHangKhongFrame(QuanLyChung qlc) {
        this.qlc = qlc;
        setTitle("Quản lý hãng hàng không");
        setSize(600, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        initUI();
        loadData();
    }

    private void initUI() {
        model = new DefaultTableModel(new Object[]{"Mã hãng", "Tên hãng", "Số lượng máy bay"}, 0);
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

        btnThem.addActionListener(e -> themHang());
        btnXoa.addActionListener(e -> xoaHang());
        btnGhi.addActionListener(e -> HangHangKhong.ghiVaoFile("hang.txt", qlc.getDanhSachHang()));
        btnDoc.addActionListener(e -> {
            List<HangHangKhong> ds = HangHangKhong.docTuFile("hang.txt");
            qlc.getDanhSachHang().clear();
            qlc.getDanhSachHang().addAll(ds);
            loadData();
        });
    }

    private void loadData() {
        model.setRowCount(0);
        for (HangHangKhong hhk : qlc.getDanhSachHang()) {
            model.addRow(new Object[]{
                hhk.getMaHang(),
                hhk.getTenHang(),
                hhk.getDanhSachMayBay().size()
            });
        }
    }

    private void themHang() {
        String ma = JOptionPane.showInputDialog("Mã hãng:");
        String ten = JOptionPane.showInputDialog("Tên hãng:");
        HangHangKhong hhk = new HangHangKhong(ma, ten);
        qlc.themHang(hhk);
        loadData();
    }

    private void xoaHang() {
        int row = table.getSelectedRow();
        if (row >= 0) {
            String ma = (String) model.getValueAt(row, 0);
            qlc.getDanhSachHang().removeIf(h -> h.getMaHang().equals(ma));
            loadData();
        }
    }
}
