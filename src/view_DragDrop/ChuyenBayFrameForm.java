/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view_DragDrop;

import java.time.LocalDateTime;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import model.ChuyenBay;
import model.MayBay;
import model.QuanLyChung;

/**
 *
 * @author Admin
 */
public class ChuyenBayFrameForm extends javax.swing.JFrame {

    private QuanLyChung qlc;
    private DefaultTableModel model;

    public ChuyenBayFrameForm(QuanLyChung qlc) {
        this.qlc = qlc;
        initComponents();
        setLocationRelativeTo(null);
        setTitle("Quản lý chuyến bay");
        model = (DefaultTableModel) tableChuyenBay.getModel();
        loadData();
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
        String soHieu = JOptionPane.showInputDialog(this, "Số hiệu chuyến bay:");
        String mayBayId = JOptionPane.showInputDialog(this, "Số hiệu máy bay:");
        MayBay mb = qlc.timMayBay(mayBayId);

        if (mb == null) {
            JOptionPane.showMessageDialog(this, "Không tìm thấy máy bay có mã: " + mayBayId);
            return;
        }

        String diemDi = JOptionPane.showInputDialog(this, "Điểm đi:");
        String diemDen = JOptionPane.showInputDialog(this, "Điểm đến:");
        LocalDateTime tgDi = LocalDateTime.now();
        LocalDateTime tgDen = LocalDateTime.now().plusHours(2);
        int tg = Integer.parseInt(JOptionPane.showInputDialog(this, "Số chỗ thương gia:"));
        int pt = Integer.parseInt(JOptionPane.showInputDialog(this, "Số chỗ phổ thông:"));

        ChuyenBay cb = new ChuyenBay(soHieu, mb, diemDi, diemDen, tgDi, tgDen, tg, pt, 0);
        qlc.themChuyenBay(cb);
        loadData();
    }

    private void xoaChuyenBay() {
        int row = tableChuyenBay.getSelectedRow();
        if (row >= 0) {
            String soHieu = (String) model.getValueAt(row, 0);
            qlc.xoaChuyenBay(soHieu);
            loadData();
        } else {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn chuyến bay để xóa.");
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tableChuyenBay = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        btnThem = new javax.swing.JButton();
        btnXoa = new javax.swing.JButton();
        btnGhi = new javax.swing.JButton();
        btnDoc = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        tableChuyenBay.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Số hiệu", "Máy bay", "Điểm đi", "Điểm đến", "Giờ đi", "Giờ đến", "TG", "PT", "Đã bán"
            }
        ));
        jScrollPane1.setViewportView(tableChuyenBay);

        getContentPane().add(jScrollPane1);

        btnThem.setText("Thêm");
        jPanel1.add(btnThem);

        btnXoa.setText("Xóa");
        jPanel1.add(btnXoa);

        btnGhi.setText("Ghi file");
        jPanel1.add(btnGhi);

        btnDoc.setText("Đọc file");
        jPanel1.add(btnDoc);

        getContentPane().add(jPanel1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> {
            QuanLyChung qlc = new QuanLyChung();
            new ChuyenBayFrameForm(qlc).setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDoc;
    private javax.swing.JButton btnGhi;
    private javax.swing.JButton btnThem;
    private javax.swing.JButton btnXoa;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tableChuyenBay;
    // End of variables declaration//GEN-END:variables
}
