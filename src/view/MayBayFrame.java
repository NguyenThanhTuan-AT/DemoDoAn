package view;

import java.awt.*;
import java.util.List;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import model.MayBay;
import model.QuanLyChung;

public class MayBayFrame extends JFrame {

    private QuanLyChung qlc;
    private JTable table;
    private DefaultTableModel model;

    public MayBayFrame(QuanLyChung qlc) {
        this.qlc = qlc;
        setTitle("Quản lý máy bay");
        setSize(600, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        initUI();
        loadData();
    }

    private void initUI() {
        model = new DefaultTableModel(new Object[]{"Số hiệu máy bay", "Mã hãng"}, 0);
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

        btnThem.addActionListener(e -> themMayBay());
        btnXoa.addActionListener(e -> xoaMayBay());
        btnGhi.addActionListener(e -> MayBay.ghiVaoFile("maybay.txt", qlc.getDanhSachMayBay()));
        btnDoc.addActionListener(e -> {
            List<MayBay> ds = MayBay.docTuFile("maybay.txt");
            qlc.getDanhSachMayBay().clear();
            qlc.getDanhSachMayBay().addAll(ds);
            loadData();
        });
    }

    private void loadData() {
        model.setRowCount(0);
        for (MayBay mb : qlc.getDanhSachMayBay()) {
            model.addRow(new Object[]{
                mb.getSoHieuMayBay(),
                mb.getMaHang()
            });
        }
    }

    private void themMayBay() {
        String soHieu = JOptionPane.showInputDialog("Số hiệu máy bay:");
        String maHang = JOptionPane.showInputDialog("Mã hãng hàng không:");
        MayBay mb = new MayBay(soHieu, maHang);
        qlc.themMayBay(mb);
        loadData();
    }

    private void xoaMayBay() {
        int row = table.getSelectedRow();
        if (row >= 0) {
            String soHieu = (String) model.getValueAt(row, 0);
            qlc.getDanhSachMayBay().removeIf(mb -> mb.getSoHieuMayBay().equals(soHieu));
            loadData();
        }
    }
}
