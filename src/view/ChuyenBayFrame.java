package view;

import java.awt.*;
import java.time.LocalDateTime;
import java.util.List;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import model.ChuyenBay;
import model.MayBay;
import model.QuanLyChung;

public class ChuyenBayFrame extends JFrame {

    private QuanLyChung qlc;
    private JTable table;
    private DefaultTableModel model;

    public ChuyenBayFrame(QuanLyChung qlc) {
        this.qlc = qlc;
        setTitle("Quản lý chuyến bay");
        setSize(800, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        initUI();
        loadData();
    }

    private void initUI() {
        model = new DefaultTableModel(new Object[]{"Số hiệu", "Máy bay", "Điểm đi", "Điểm đến", "Giờ đi", "Giờ đến", "TG", "PT", "Đã bán"}, 0);
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

        btnThem.addActionListener(e -> themChuyenBay());
        btnXoa.addActionListener(e -> xoaChuyenBay());
        btnGhi.addActionListener(e -> ChuyenBay.ghiVaoFile("chuyenbay.txt", qlc.getDanhSachChuyenBay()));
        btnDoc.addActionListener(e -> {
            List<ChuyenBay> ds = ChuyenBay.docTuFile("chuyenbay.txt");
            qlc.getDanhSachChuyenBay().clear();
            qlc.getDanhSachChuyenBay().addAll(ds);
            loadData();
        });
    }

    private void loadData() {
        model.setRowCount(0);
        for (ChuyenBay cb : qlc.getDanhSachChuyenBay()) {
            model.addRow(new Object[]{
                cb.getSoHieuChuyenBay(),
                cb.getMayBay().getSoHieuMayBay(),
                cb.getDiemDi(),
                cb.getDiemDen(),
                cb.getThoiGianDi(),
                cb.getThoiGianDen(),
                cb.getSoThuongGia(),
                cb.getSoPhoThong(),
                cb.getSoVeDaBan()
            });
        }
    }

    private void themChuyenBay() {
        String soHieu = JOptionPane.showInputDialog("Số hiệu chuyến bay:");
        String mayBayId = JOptionPane.showInputDialog("Số hiệu máy bay:");
        MayBay mb = qlc.timMayBay(mayBayId);
        String diemDi = JOptionPane.showInputDialog("Điểm đi:");
        String diemDen = JOptionPane.showInputDialog("Điểm đến:");
        LocalDateTime tgDi = LocalDateTime.now();
        LocalDateTime tgDen = LocalDateTime.now().plusHours(2);
        int tg = Integer.parseInt(JOptionPane.showInputDialog("Số chỗ thương gia:"));
        int pt = Integer.parseInt(JOptionPane.showInputDialog("Số chỗ phổ thông:"));

        ChuyenBay cb = new ChuyenBay(soHieu, mb, diemDi, diemDen, tgDi, tgDen, tg, pt, 0);
        qlc.themChuyenBay(cb);
        loadData();
    }

    private void xoaChuyenBay() {
        int row = table.getSelectedRow();
        if (row >= 0) {
            String soHieu = (String) model.getValueAt(row, 0);
            qlc.xoaChuyenBay(soHieu);
            loadData();
        }
    }
}
