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

        jButtonChuyenBay = new javax.swing.JButton();
        jButtonVe = new javax.swing.JButton();
        jButtonHanhKhach = new javax.swing.JButton();
        jButtonMayBay = new javax.swing.JButton();
        jButtonHang = new javax.swing.JButton();
        jButtonTaiKhoan = new javax.swing.JButton();
        jLabelSpace1 = new javax.swing.JLabel();
        jButtonThoat = new javax.swing.JButton();
        jLabelSpace2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Quản trị hệ thống - Admin");
        setResizable(false);
        setSize(new java.awt.Dimension(600, 400));
        getContentPane().setLayout(new java.awt.GridLayout(3, 3));

        jButtonChuyenBay.setText("Quản lý chuyến bay");
        getContentPane().add(jButtonChuyenBay);

        jButtonVe.setText("Quản lý vé");
        getContentPane().add(jButtonVe);

        jButtonHanhKhach.setText("Quản lý hành khách");
        getContentPane().add(jButtonHanhKhach);

        jButtonMayBay.setText("Quản lý máy bay");
        getContentPane().add(jButtonMayBay);

        jButtonHang.setText("Quản lý hãng hàng không");
        getContentPane().add(jButtonHang);

        jButtonTaiKhoan.setText("Quản lý tài khoản");
        jButtonTaiKhoan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonTaiKhoanActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonTaiKhoan);
        getContentPane().add(jLabelSpace1);

        jButtonThoat.setText("Thoát");
        jButtonThoat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonThoatActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonThoat);
        getContentPane().add(jLabelSpace2);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonThoatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonThoatActionPerformed
        System.exit(0);
    }//GEN-LAST:event_jButtonThoatActionPerformed

    private void jButtonTaiKhoanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonTaiKhoanActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonTaiKhoanActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AdminFrameForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonChuyenBay;
    private javax.swing.JButton jButtonHang;
    private javax.swing.JButton jButtonHanhKhach;
    private javax.swing.JButton jButtonMayBay;
    private javax.swing.JButton jButtonTaiKhoan;
    private javax.swing.JButton jButtonThoat;
    private javax.swing.JButton jButtonVe;
    private javax.swing.JLabel jLabelSpace1;
    private javax.swing.JLabel jLabelSpace2;
    // End of variables declaration//GEN-END:variables
}
