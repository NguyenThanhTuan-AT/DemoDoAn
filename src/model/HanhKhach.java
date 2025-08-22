package model;

import java.util.*;
import util.FileIOUtil;

public class HanhKhach {

    private String cccd;
    private String hoTen;
    private VeMayBay ve;

    public HanhKhach() {
    }

    public HanhKhach(String cccd, String hoTen, VeMayBay ve) {
        this.cccd = cccd;
        this.hoTen = hoTen;
        this.ve = ve;
    }

    public String getCccd() {
        return cccd;
    }

    public void setCccd(String cccd) {
        if (cccd == null || !cccd.matches("\\\\d{12}")) {
            throw new IllegalArgumentException("CCCD phải gồm 12 chữ số");
        }
        this.cccd = cccd;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public VeMayBay getVe() {
        return ve;
    }

    public void setVe(VeMayBay ve) {
        this.ve = ve;
    }

    public void capNhatThongTin(HanhKhach moi) {
        this.hoTen = moi.getHoTen();
        this.ve = moi.getVe();
    }

    @Override
    public String toString() {
        return "HanhKhach{" + "cccd='" + cccd + "', hoTen='" + hoTen + "', ve=" + ve + '}';
    }

    public static List<HanhKhach> docTuFile(String tenFile) {
        return FileIOUtil.docTuFile(tenFile, HanhKhach.class);
    }

    public static void ghiVaoFile(String tenFile, List<HanhKhach> danhSach) {
        FileIOUtil.ghiVaoFile(tenFile, danhSach);
    }

}
