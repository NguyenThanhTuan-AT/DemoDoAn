package model;

import java.time.LocalDateTime;
import java.util.*;
import model.VeMayBay.HangVe;
import util.FileIOUtil;

public class ChuyenBay {

    private String soHieuChuyenBay;
    private MayBay mayBay;
    private String diemDi;
    private String diemDen;
    private LocalDateTime thoiGianDi;
    private LocalDateTime thoiGianDen;
    private int soThuongGia;
    private int soPhoThong;
    private int soVeDaBan;
    private List<VeMayBay> danhSachVe = new ArrayList<>();

    public void themVe(VeMayBay ve) {
        danhSachVe.add(ve);
    }

    public List<VeMayBay> getDanhSachVe() {
        return danhSachVe;
    }

    public ChuyenBay() {
    }

    public ChuyenBay(String soHieuChuyenBay, MayBay mayBay, String diemDi, String diemDen, LocalDateTime thoiGianDi, LocalDateTime thoiGianDen, int soThuongGia, int soPhoThong, int soVeDaBan) {
        this.soHieuChuyenBay = soHieuChuyenBay;
        this.mayBay = mayBay;
        this.diemDi = diemDi;
        this.diemDen = diemDen;
        this.thoiGianDi = thoiGianDi;
        this.thoiGianDen = thoiGianDen;
        this.soThuongGia = soThuongGia;
        this.soPhoThong = soPhoThong;
        this.soVeDaBan = soVeDaBan;
    }

    public String getSoHieuChuyenBay() {
        return soHieuChuyenBay;
    }

    public void setSoHieuChuyenBay(String soHieuChuyenBay) {
        this.soHieuChuyenBay = soHieuChuyenBay;
    }

    public MayBay getMayBay() {
        return mayBay;
    }

    public void setMayBay(MayBay mayBay) {
        this.mayBay = mayBay;
    }

    public String getDiemDi() {
        return diemDi;
    }

    public void setDiemDi(String diemDi) {
        this.diemDi = diemDi;
    }

    public String getDiemDen() {
        return diemDen;
    }

    public void setDiemDen(String diemDen) {
        this.diemDen = diemDen;
    }

    public LocalDateTime getThoiGianDi() {
        return thoiGianDi;
    }

    public void setThoiGianDi(LocalDateTime thoiGianDi) {
        this.thoiGianDi = thoiGianDi;
    }

    public LocalDateTime getThoiGianDen() {
        return thoiGianDen;
    }

    public void setThoiGianDen(LocalDateTime thoiGianDen) {
        if (thoiGianDi != null && thoiGianDen.isBefore(thoiGianDi)) {
            throw new IllegalArgumentException("Thời gian đến phải sau thời gian đi");
        }
        this.thoiGianDen = thoiGianDen;
    }

    public int getSoThuongGia() {
        return soThuongGia;
    }

    public void setSoThuongGia(int soThuongGia) {
        this.soThuongGia = soThuongGia;
    }

    public int getSoPhoThong() {
        return soPhoThong;
    }

    public void setSoPhoThong(int soPhoThong) {
        this.soPhoThong = soPhoThong;
    }

    public int getSoVeDaBan() {
        return soVeDaBan;
    }

    public void setSoVeDaBan(int soVeDaBan) {
        int tongCho = soPhoThong + soThuongGia;
        if (soVeDaBan > tongCho) {
            throw new IllegalArgumentException("Số vé đã bán vượt quá số chỗ");
        }
        this.soVeDaBan = soVeDaBan;
    }

    public boolean conChoTrong(HangVe hangVe) {
        int daBan = this.soVeDaBan;
        if (hangVe == HangVe.THUONG_GIA) {
            return daBan < soThuongGia;
        } else {
            return daBan < soPhoThong;
        }
    }

    public int tongSoCho() {
        return soThuongGia + soPhoThong;
    }

    public void capNhatThongTin(ChuyenBay moi) {
        this.diemDi = moi.getDiemDi();
        this.diemDen = moi.getDiemDen();
        this.thoiGianDi = moi.getThoiGianDi();
        this.thoiGianDen = moi.getThoiGianDen();
        this.soPhoThong = moi.getSoPhoThong();
        this.soThuongGia = moi.getSoThuongGia();
    }

    @Override
    public String toString() {
        return "ChuyenBay{" + "soHieuChuyenBay='" + soHieuChuyenBay + "', mayBay="
                + mayBay + ", diemDi='" + diemDi + "', diemDen='" + diemDen + "', thoiGianDi="
                + thoiGianDi + ", thoiGianDen=" + thoiGianDen + ", soThuongGia=" + soThuongGia
                + ", soPhoThong=" + soPhoThong + ", soVeDaBan=" + soVeDaBan + '}';
    }

    public static List<ChuyenBay> docTuFile(String tenFile) {
        return FileIOUtil.docTuFile(tenFile, ChuyenBay.class);
    }

    public static void ghiVaoFile(String tenFile, List<ChuyenBay> danhSach) {
        FileIOUtil.ghiVaoFile(tenFile, danhSach);
    }

}
