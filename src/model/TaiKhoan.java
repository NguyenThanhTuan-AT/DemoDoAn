package model;

import java.util.*;
import util.FileIOUtil;

public class TaiKhoan {

    private String tenDangNhap;
    private String matKhau;
    private String loaiTaiKhoan; // admin or user

    public TaiKhoan() {
    }

    public TaiKhoan(String tenDangNhap, String matKhau, String loaiTaiKhoan) {
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
        this.matKhau = matKhau;
    }

    public String getLoaiTaiKhoan() {
        return loaiTaiKhoan;
    }

    public void setLoaiTaiKhoan(String loaiTaiKhoan) {
        this.loaiTaiKhoan = loaiTaiKhoan;
    }

    public boolean laAdmin() {
        return "admin".equalsIgnoreCase(loaiTaiKhoan);
    }

    public boolean kiemTraMatKhau(String matKhauNhapVao) {
        return this.matKhau.equals(matKhauNhapVao);
    }

    @Override
    public String toString() {
        return "TaiKhoan{" + "tenDangNhap='" + tenDangNhap + "', loaiTaiKhoan='" + loaiTaiKhoan + "'}";
    }

    public static List<TaiKhoan> docTuFile(String tenFile) {
        return FileIOUtil.docTuFile(tenFile, TaiKhoan.class);
    }

    public static void ghiVaoFile(String tenFile, List<TaiKhoan> danhSach) {
        FileIOUtil.ghiVaoFile(tenFile, danhSach);
    }

}
