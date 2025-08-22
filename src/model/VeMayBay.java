package model;

import java.util.*;
import util.FileIOUtil;

public class VeMayBay {

    public enum HangVe {
        PHO_THONG,
        THUONG_GIA
    }

    private String maVe;
    private ChuyenBay chuyenBay;
    private HangVe hangVe;
    private double giaVe;

    public VeMayBay() {
    }

    public VeMayBay(String maVe, ChuyenBay chuyenBay, HangVe hangVe, double giaVe) {
        this.maVe = maVe;
        this.chuyenBay = chuyenBay;
        this.hangVe = hangVe;
        this.giaVe = giaVe;
    }

    public String getMaVe() {
        return maVe;
    }

    public void setMaVe(String maVe) {
        this.maVe = maVe;
    }

    public ChuyenBay getChuyenBay() {
        return chuyenBay;
    }

    public void setChuyenBay(ChuyenBay chuyenBay) {
        this.chuyenBay = chuyenBay;
    }

    public HangVe getHangVe() {
        return hangVe;
    }

    public void setHangVe(HangVe hangVe) {
        this.hangVe = hangVe;
    }

    public double getGiaVe() {
        return giaVe;
    }

    public void setGiaVe(double giaVe) {
        if (giaVe < 0) {
            throw new IllegalArgumentException("Giá vé không được âm");
        }
        this.giaVe = giaVe;
    }

    public boolean laThuongGia() {
        return hangVe == HangVe.THUONG_GIA;
    }

    public boolean laPhoThong() {
        return hangVe == HangVe.PHO_THONG;
    }

    public double tinhGiaSauThue(double thue) {
        return giaVe * (1 + thue);
    }

    public void capNhatThongTin(VeMayBay moi) {
        this.chuyenBay = moi.getChuyenBay();
        this.hangVe = moi.getHangVe();
        this.giaVe = moi.getGiaVe();
    }

    @Override
    public String toString() {
        return "VeMayBay{"
                + "maVe='" + maVe + '\''
                + ", chuyenBay=" + chuyenBay
                + ", hangVe=" + hangVe
                + ", giaVe=" + giaVe
                + '}';
    }

    public static List<VeMayBay> docTuFile(String tenFile) {
        return FileIOUtil.docTuFile(tenFile, VeMayBay.class);
    }

    public static void ghiVaoFile(String tenFile, List<VeMayBay> danhSach) {
        FileIOUtil.ghiVaoFile(tenFile, danhSach);
    }
}
