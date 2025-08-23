/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view_DragDrop;

/**
 *
 * @author Admin
 */
public class AdminFrameForm extends javax.swing.JFrame {

    public AdminFrameForm() {
        initComponents();
        setLocationRelativeTo(null); // căn giữa

        setSize(500, 500);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnChuyenBay = new javax.swing.JButton();
        btnVe = new javax.swing.JButton();
        btnHanhKhach = new javax.swing.JButton();
        btnMayBay = new javax.swing.JButton();
        btnHang = new javax.swing.JButton();
        btnTaiKhoan = new javax.swing.JButton();
        jLabelSpace1 = new javax.swing.JLabel();
        btnThoat = new javax.swing.JButton();
        jLabelSpace2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Quản trị hệ thống - Admin");
        setResizable(false);
        setSize(new java.awt.Dimension(600, 400));
        getContentPane().setLayout(new java.awt.GridLayout(3, 3));

        btnChuyenBay.setText("Quản lý chuyến bay");
        getContentPane().add(btnChuyenBay);

        btnVe.setText("Quản lý vé");
        getContentPane().add(btnVe);

        btnHanhKhach.setText("Quản lý hành khách");
        getContentPane().add(btnHanhKhach);

        btnMayBay.setText("Quản lý máy bay");
        getContentPane().add(btnMayBay);

        btnHang.setText("Quản lý hãng hàng không");
        getContentPane().add(btnHang);

        btnTaiKhoan.setText("Quản lý tài khoản");
        btnTaiKhoan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTaiKhoanActionPerformed(evt);
            }
        });
        getContentPane().add(btnTaiKhoan);
        getContentPane().add(jLabelSpace1);

        btnThoat.setText("Thoát");
        btnThoat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThoatActionPerformed(evt);
            }
        });
        getContentPane().add(btnThoat);
        getContentPane().add(jLabelSpace2);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnThoatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThoatActionPerformed
        System.exit(0);
    }//GEN-LAST:event_btnThoatActionPerformed

    private void btnTaiKhoanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTaiKhoanActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnTaiKhoanActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AdminFrameForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnChuyenBay;
    private javax.swing.JButton btnHang;
    private javax.swing.JButton btnHanhKhach;
    private javax.swing.JButton btnMayBay;
    private javax.swing.JButton btnTaiKhoan;
    private javax.swing.JButton btnThoat;
    private javax.swing.JButton btnVe;
    private javax.swing.JLabel jLabelSpace1;
    private javax.swing.JLabel jLabelSpace2;
    // End of variables declaration//GEN-END:variables
}
