package model;

import java.util.*;
import util.FileIOUtil;

public class VeMayBay {

    private String maVe;
    private ChuyenBay chuyenBay;
    private String hangVe;
    private double giaVe;

    public VeMayBay() {
    }

    public VeMayBay(String maVe, ChuyenBay chuyenBay, String hangVe, double giaVe) {
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

    public String getHangVe() {
        return hangVe;
    }

    public void setHangVe(String hangVe) {
        this.hangVe = hangVe;
    }

    public double getGiaVe() {
        return giaVe;
    }

    public void setGiaVe(double giaVe) {
        this.giaVe = giaVe;
    }

    @Override
    public String toString() {
        return "VeMayBay{" + "maVe='" + maVe + "', chuyenBay=" + chuyenBay + ", hangVe='" + hangVe + "', giaVe=" + giaVe + '}';
    }

    public static List<VeMayBay> docTuFile(String tenFile) {
        return FileIOUtil.docTuFile(tenFile, VeMayBay.class);
    }

    public static void ghiVaoFile(String tenFile, List<VeMayBay> danhSach) {
        FileIOUtil.ghiVaoFile(tenFile, danhSach);
    }

}
