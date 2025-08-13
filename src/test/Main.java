package test;

import model.ChuyenBay;
import model.HangHangKhong;
import model.HanhKhach;
import model.MayBay;
import model.QuanLyChung;
import model.TaiKhoan;
import model.VeMayBay;
import view.LoginFrame;

public class Main {

    public static void main(String[] args) {
        QuanLyChung qlc = new QuanLyChung();

        // Đọc dữ liệu từ thư mục data
        qlc.getDanhSachTaiKhoan().addAll(TaiKhoan.docTuFile("TaiKhoan.json"));
        qlc.getDanhSachChuyenBay().addAll(ChuyenBay.docTuFile("ChuyenBay.json"));
        qlc.getDanhSachVe().addAll(VeMayBay.docTuFile("VeMayBay.json"));
        qlc.getDanhSachHanhKhach().addAll(HanhKhach.docTuFile("HanhKhach.json"));
        qlc.getDanhSachHang().addAll(HangHangKhong.docTuFile("HangHangKhong.json"));
        qlc.getDanhSachMayBay().addAll(MayBay.docTuFile("MayBay.json"));

        // Mở giao diện đăng nhập
        javax.swing.SwingUtilities.invokeLater(() -> {
            new LoginFrame(qlc).setVisible(true);
        });
    }
}
