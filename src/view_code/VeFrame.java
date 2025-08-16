package view_code;

import java.awt.*;
import java.util.List;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import model.ChuyenBay;
import model.QuanLyChung;
import model.VeMayBay;
import model.VeMayBay.HangVe;

public class VeFrame extends JFrame {

    private QuanLyChung qlc;
    private JTable table;
    private DefaultTableModel model;

    public VeFrame(QuanLyChung qlc) {
        this.qlc = qlc;
        setTitle("Quản lý vé máy bay");
        setSize(700, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        initUI();
        loadData();
    }

    private void initUI() {
        model = new DefaultTableModel(new Object[]{"Mã vé", "Chuyến bay", "Hạng vé", "Giá vé"}, 0);
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

        btnThem.addActionListener(e -> themVe());
        btnXoa.addActionListener(e -> xoaVe());
        btnGhi.addActionListener(e -> VeMayBay.ghiVaoFile("ve.txt", qlc.getDanhSachVe()));
        btnDoc.addActionListener(e -> {
            List<VeMayBay> ds = VeMayBay.docTuFile("ve.txt");
            qlc.getDanhSachVe().clear();
            qlc.getDanhSachVe().addAll(ds);
            loadData();
        });
    }

    private void loadData() {
        model.setRowCount(0);
        for (VeMayBay ve : qlc.getDanhSachVe()) {
            model.addRow(new Object[]{
                ve.getMaVe(),
                ve.getChuyenBay().getSoHieuChuyenBay(),
                ve.getHangVe(),
                ve.getGiaVe()
            });
        }
    }

    private void themVe() {
        String maVe = JOptionPane.showInputDialog("Mã vé:");
        String maCB = JOptionPane.showInputDialog("Số hiệu chuyến bay:");
        ChuyenBay cb = qlc.timChuyenBay(maCB);

        if (cb == null) {
            JOptionPane.showMessageDialog(null, "Chuyến bay không tồn tại!");
            return;
        }

        String input = JOptionPane.showInputDialog("Hạng vé (phổ thông/thương gia):");
        HangVe hangVe = null;

        if (input != null) {
            switch (input.trim().toLowerCase()) {
                case "phổ thông":
                    hangVe = HangVe.PHO_THONG;
                    break;
                case "thương gia":
                    hangVe = HangVe.THUONG_GIA;
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Hạng vé không hợp lệ!");
                    return;
            }
            double giaVe = Double.parseDouble(JOptionPane.showInputDialog("Giá vé:"));

            VeMayBay ve = new VeMayBay(maVe, cb, hangVe, giaVe);
            qlc.themVe(ve);
            loadData();
        }
    }

    private void xoaVe() {
        int row = table.getSelectedRow();
        if (row >= 0) {
            String maVe = (String) model.getValueAt(row, 0);
            qlc.xoaVe(maVe);
            loadData();
        }
    }
}
