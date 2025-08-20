package model;

import java.util.ArrayList;
import java.util.List;
import util.FileIOUtil;

public class HangHangKhong {

    private String maHang;
    private String tenHang;
    private List<MayBay> danhSachMayBay;
    private List<ChuyenBay> danhSachChuyenBay = new ArrayList<>();

    public void themChuyenBay(ChuyenBay cb) {
        danhSachChuyenBay.add(cb);
    }

    public List<ChuyenBay> getDanhSachChuyenBay() {
        return danhSachChuyenBay;
    }

    public HangHangKhong() {
        danhSachMayBay = new ArrayList<>();
    }

    public HangHangKhong(String maHang, String tenHang) {
        this.maHang = maHang;
        this.tenHang = tenHang;
        this.danhSachMayBay = new ArrayList<>();
    }

    public String getMaHang() {
        return maHang;
    }

    public void setMaHang(String maHang) {
        this.maHang = maHang;
    }

    public String getTenHang() {
        return tenHang;
    }

    public void setTenHang(String tenHang) {
        this.tenHang = tenHang;
    }

    public List<MayBay> getDanhSachMayBay() {
        return danhSachMayBay;
    }

    public void themMayBay(MayBay mb) {
        danhSachMayBay.add(mb);
    }

    @Override
    public String toString() {
        return "HangHangKhong{" + "maHang='" + maHang + "', tenHang='" + tenHang + "', danhSachMayBay=" + danhSachMayBay + '}';
    }

    public static List<HangHangKhong> docTuFile(String tenFile) {
        return FileIOUtil.docTuFile(tenFile, HangHangKhong.class);
    }

    public static void ghiVaoFile(String tenFile, List<HangHangKhong> danhSach) {
        FileIOUtil.ghiVaoFile(tenFile, danhSach);
    }

}
