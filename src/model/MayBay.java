package model;

import java.util.*;
import util.FileIOUtil;

public class MayBay {

    private String soHieuMayBay;
    private String maHang;

    public MayBay() {
    }

    public MayBay(String soHieuMayBay, String maHang) {
        this.soHieuMayBay = soHieuMayBay;
        this.maHang = maHang;
    }

    public String getSoHieuMayBay() {
        return soHieuMayBay;
    }

    public void setSoHieuMayBay(String soHieuMayBay) {
        this.soHieuMayBay = soHieuMayBay;
    }

    public String getMaHang() {
        return maHang;
    }

    public void setMaHang(String maHang) {
        this.maHang = maHang;
    }

    public void capNhatThongTin(MayBay moi) {
        this.maHang = moi.getMaHang();
    }

    @Override
    public String toString() {
        return "MayBay{" + "soHieuMayBay='" + soHieuMayBay + "', maHang='" + maHang + "'}";
    }

    public static List<MayBay> docTuFile(String tenFile) {
        return FileIOUtil.docTuFile(tenFile, MayBay.class);
    }

    public static void ghiVaoFile(String tenFile, List<MayBay> danhSach) {
        FileIOUtil.ghiVaoFile(tenFile, danhSach);
    }

}
