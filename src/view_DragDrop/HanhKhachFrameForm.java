/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view_DragDrop;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;
import javax.swing.table.DefaultTableModel;
import model.HanhKhach;
import model.QuanLyChung;
import model.VeMayBay;

/**
 *
 * @author Admin
 */
public class HanhKhachFrameForm extends javax.swing.JFrame {

    private QuanLyChung qlc;
    private JTable table;
    private DefaultTableModel model;

    public HanhKhachFrameForm(QuanLyChung qlc) {
        this.qlc = qlc;
        setTitle("Quản lý hành khách");
        setSize(700, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        loadData();
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

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        btnThem = new javax.swing.JButton();
        btnXoa = new javax.swing.JButton();
        btnGhi = new javax.swing.JButton();
        btnDoc = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Quản lý hành khách");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "CCCD", "Họ tên", "Mã vé"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

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
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        QuanLyChung qlc = new QuanLyChung();
        java.awt.EventQueue.invokeLater(() -> {
            new HanhKhachFrameForm(qlc).setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDoc;
    private javax.swing.JButton btnGhi;
    private javax.swing.JButton btnThem;
    private javax.swing.JButton btnXoa;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
