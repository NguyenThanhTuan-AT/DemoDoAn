package model;

import java.util.*;
import util.FileIOUtil;

public class TaiKhoan {

    public enum LoaiTaiKhoan {
        ADMIN,
        USER
    }

    private String tenDangNhap;
    private String matKhau;
    private LoaiTaiKhoan loaiTaiKhoan;

    public TaiKhoan() {
    }

    public TaiKhoan(String tenDangNhap, String matKhau, LoaiTaiKhoan loaiTaiKhoan) {
//Chưa cần thiết
//        if (matKhau == null || matKhau.length() < 6) {
//            throw new IllegalArgumentException("Mật khẩu phải có ít nhất 6 ký tự");
//        }
        this.tenDangNhap = tenDangNhap;
        this.matKhau = matKhau;
        this.loaiTaiKhoan = loaiTaiKhoan;
    }

    public String getTenDangNhap() {
        return tenDangNhap;
    }

    public void setTenDangNhap(String tenDangNhap) {
        this.tenDangNhap = tenDangNhap;
    }

    public String getMatKhau() {
        return matKhau;
    }

    public void setMatKhau(String matKhau) {
//        Chưa cần thiết
//        if (matKhau == null || matKhau.length() < 6) {
//            throw new IllegalArgumentException("Mật khẩu phải có ít nhất 6 ký tự");
//        }
        this.matKhau = matKhau;
    }

    public LoaiTaiKhoan getLoaiTaiKhoan() {
        return loaiTaiKhoan;
    }

    public void setLoaiTaiKhoan(LoaiTaiKhoan loaiTaiKhoan) {
        this.loaiTaiKhoan = loaiTaiKhoan;
    }

    public boolean laAdmin() {
        return loaiTaiKhoan == LoaiTaiKhoan.ADMIN;
    }

    public boolean kiemTraMatKhau(String matKhauNhapVao) {
        return this.matKhau.equals(matKhauNhapVao);
    }

    public void doiMatKhau(String matKhauMoi) {
        setMatKhau(matKhauMoi);
    }

    public void capNhatThongTin(TaiKhoan moi) {
        this.matKhau = moi.getMatKhau();
        this.loaiTaiKhoan = moi.getLoaiTaiKhoan();
    }

    @Override
    public String toString() {
        return "TaiKhoan{"
                + "tenDangNhap='" + tenDangNhap + '\''
                + ", loaiTaiKhoan=" + loaiTaiKhoan
                + '}';
    }

    public static List<TaiKhoan> docTuFile(String tenFile) {
        return FileIOUtil.docTuFile(tenFile, TaiKhoan.class);
    }

    public static void ghiVaoFile(String tenFile, List<TaiKhoan> danhSach) {
        FileIOUtil.ghiVaoFile(tenFile, danhSach);
    }
}
