package model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import model.VeMayBay.HangVe;

public class QuanLyChung {

    private List<ChuyenBay> danhSachChuyenBay;
    private List<VeMayBay> danhSachVe;
    private List<HanhKhach> danhSachHanhKhach;
    private List<HangHangKhong> danhSachHang;
    private List<MayBay> danhSachMayBay;
    private List<TaiKhoan> danhSachTaiKhoan;

    public QuanLyChung() {
        danhSachChuyenBay = new ArrayList<>();
        danhSachVe = new ArrayList<>();
        danhSachHanhKhach = new ArrayList<>();
        danhSachHang = new ArrayList<>();
        danhSachMayBay = new ArrayList<>();
        danhSachTaiKhoan = new ArrayList<>();
    }

    // === Quản lý chuyến bay ===
    public void themChuyenBay(ChuyenBay cb) {
        danhSachChuyenBay.add(cb);
        MayBay mb = cb.getMayBay();
        if (mb != null) {
            HangHangKhong hang = timHang(mb.getMaHang());
            if (hang != null) {
                hang.themChuyenBay(cb); // cập nhật liên kết ngược
            }
        }
    }

    public void xoaChuyenBay(String soHieu) {
        danhSachChuyenBay.removeIf(cb -> cb.getSoHieuChuyenBay().equals(soHieu));
    }

    public ChuyenBay timChuyenBay(String soHieu) {
        for (ChuyenBay cb : danhSachChuyenBay) {
            if (cb.getSoHieuChuyenBay().equals(soHieu)) {
                return cb;
            }
        }
        return null;
    }

    public List<ChuyenBay> locChuyenBayTheoNgay(LocalDate ngay) {
        return danhSachChuyenBay.stream()
                .filter(cb -> cb.getThoiGianDi() != null && cb.getThoiGianDi().toLocalDate().equals(ngay))
                .collect(Collectors.toList());
    }

    public List<ChuyenBay> locChuyenBayTheoHang(String maHang) {
        return danhSachChuyenBay.stream()
                .filter(cb -> cb.getMayBay() != null && maHang.equals(cb.getMayBay().getMaHang()))
                .collect(Collectors.toList());
    }

    public List<ChuyenBay> locChuyenBayConTrongTheoNgay(LocalDate ngay) {
        return danhSachChuyenBay.stream()
                .filter(cb -> cb.getThoiGianDi() != null
                && cb.getThoiGianDi().toLocalDate().equals(ngay)
                && cb.getSoVeDaBan() < (cb.getSoPhoThong() + cb.getSoThuongGia()))
                .collect(Collectors.toList());
    }

    public List<ChuyenBay> locChuyenBayConTrongTheoKhoangGio(LocalDate ngay, int gioBatDau, int gioKetThuc) {
        return danhSachChuyenBay.stream()
                .filter(cb -> {
                    LocalDateTime tgDi = cb.getThoiGianDi();
                    return tgDi != null
                            && tgDi.toLocalDate().equals(ngay)
                            && tgDi.getHour() >= gioBatDau
                            && tgDi.getHour() <= gioKetThuc
                            && cb.getSoVeDaBan() < (cb.getSoPhoThong() + cb.getSoThuongGia());
                })
                .collect(Collectors.toList());
    }

    // === Quản lý vé ===
    public void themVe(VeMayBay ve) {
        danhSachVe.add(ve);
        ChuyenBay cb = ve.getChuyenBay();
        if (cb != null) {
            cb.themVe(ve); // cập nhật liên kết ngược
        }
    }

    public void xoaVe(String maVe) {
        danhSachVe.removeIf(ve -> ve.getMaVe().equals(maVe));
    }

    public VeMayBay timVe(String maVe) {
        for (VeMayBay ve : danhSachVe) {
            if (ve.getMaVe().equals(maVe)) {
                return ve;
            }
        }
        return null;
    }

    public double thongKeDoanhThuTheoThang(int thang, int nam) {
        return danhSachVe.stream()
                .filter(ve -> ve.getChuyenBay() != null
                && ve.getChuyenBay().getThoiGianDi() != null
                && ve.getChuyenBay().getThoiGianDi().getMonthValue() == thang
                && ve.getChuyenBay().getThoiGianDi().getYear() == nam)
                .mapToDouble(VeMayBay::getGiaVe)
                .sum();
    }

    public double thongKeDoanhThuTheoHang(String maHang, int thang, int nam) {
        return danhSachVe.stream()
                .filter(ve -> ve.getChuyenBay() != null
                && ve.getChuyenBay().getMayBay() != null
                && maHang.equals(ve.getChuyenBay().getMayBay().getMaHang())
                && ve.getChuyenBay().getThoiGianDi() != null
                && ve.getChuyenBay().getThoiGianDi().getMonthValue() == thang
                && ve.getChuyenBay().getThoiGianDi().getYear() == nam)
                .mapToDouble(VeMayBay::getGiaVe)
                .sum();
    }

    // === Quản lý hành khách ===
    public void themHanhKhach(HanhKhach hk) {
        danhSachHanhKhach.add(hk);
    }

    public HanhKhach timHanhKhach(String cccd) {
        for (HanhKhach hk : danhSachHanhKhach) {
            if (hk.getCccd().equals(cccd)) {
                return hk;
            }
        }
        return null;
    }

    public List<HanhKhach> locHanhKhachTheoChuyenBay(String soHieu) {
        return danhSachHanhKhach.stream()
                .filter(hk -> hk.getVe() != null
                && hk.getVe().getChuyenBay() != null
                && soHieu.equals(hk.getVe().getChuyenBay().getSoHieuChuyenBay()))
                .collect(Collectors.toList());
    }

    // === Quản lý hãng hàng không ===
    public void themHang(HangHangKhong hhk) {
        danhSachHang.add(hhk);
    }

    public HangHangKhong timHang(String maHang) {
        for (HangHangKhong hhk : danhSachHang) {
            if (hhk.getMaHang().equals(maHang)) {
                return hhk;
            }
        }
        return null;
    }

    // === Quản lý máy bay ===
    public void themMayBay(MayBay mb) {
        danhSachMayBay.add(mb);
    }

    public MayBay timMayBay(String soHieu) {
        for (MayBay mb : danhSachMayBay) {
            if (mb.getSoHieuMayBay().equals(soHieu)) {
                return mb;
            }
        }
        return null;
    }

    // === Quản lý tài khoản ===
    public void themTaiKhoan(TaiKhoan tk) {
        danhSachTaiKhoan.add(tk);
    }

    public TaiKhoan timTaiKhoan(String tenDangNhap) {
        for (TaiKhoan tk : danhSachTaiKhoan) {
            if (tk.getTenDangNhap().equals(tenDangNhap)) {
                return tk;
            }
        }
        return null;
    }

    public boolean kiemTraDangNhap(String tenDangNhap, String matKhau) {
        TaiKhoan tk = timTaiKhoan(tenDangNhap);
        return tk != null && tk.getMatKhau().equals(matKhau);
    }

    // === Getter methods ===
    public List<ChuyenBay> getDanhSachChuyenBay() {
        return danhSachChuyenBay;
    }

    public List<VeMayBay> getDanhSachVe() {
        return danhSachVe;
    }

    public List<HanhKhach> getDanhSachHanhKhach() {
        return danhSachHanhKhach;
    }

    public List<HangHangKhong> getDanhSachHang() {
        return danhSachHang;
    }

    public List<MayBay> getDanhSachMayBay() {
        return danhSachMayBay;
    }

    public List<TaiKhoan> getDanhSachTaiKhoan() {
        return danhSachTaiKhoan;
    }

    //Sắp xếp
    public void sapXepHanhKhachTheoTen() {
        danhSachHanhKhach.sort(Comparator.comparing(HanhKhach::getHoTen));
    }

    public void sapXepChuyenBayTheoMa() {
        danhSachChuyenBay.sort(Comparator.comparing(ChuyenBay::getSoHieuChuyenBay));
    }

    public void sapXepHangHangKhongTheoTen() {
        danhSachHang.sort(Comparator.comparing(HangHangKhong::getTenHang));
    }

    public void sapXepVeTheoMa() {
        danhSachVe.sort(Comparator.comparing(VeMayBay::getMaVe));
    }

    public List<String> goiYMaChuyenBay(String tuKhoa) {
        return danhSachChuyenBay.stream()
                .map(ChuyenBay::getSoHieuChuyenBay)
                .filter(ma -> ma.toLowerCase().contains(tuKhoa.toLowerCase()))
                .collect(Collectors.toList());
    }

    public List<String> goiYTenHangHangKhong(String tuKhoa) {
        return danhSachHang.stream()
                .map(HangHangKhong::getTenHang)
                .filter(ten -> ten.toLowerCase().contains(tuKhoa.toLowerCase()))
                .collect(Collectors.toList());
    }

    public Map<String, Map<String, Integer>> thongKeSoVeConLaiTheoNgay(LocalDate ngay) {
        Map<String, Map<String, Integer>> ketQua = new HashMap<>();
        for (ChuyenBay cb : danhSachChuyenBay) {
            if (cb.getThoiGianDi() != null && cb.getThoiGianDi().toLocalDate().equals(ngay)) {
                int phoThongCon = cb.getSoPhoThong() - demVe(cb, HangVe.PHO_THONG);
                int thuongGiaCon = cb.getSoThuongGia() - demVe(cb, HangVe.THUONG_GIA);
                Map<String, Integer> thongTin = new HashMap<>();
                thongTin.put("PHO_THONG", phoThongCon);
                thongTin.put("THUONG_GIA", thuongGiaCon);
                ketQua.put(cb.getSoHieuChuyenBay(), thongTin);
            }
        }
        return ketQua;
    }

    private int demVe(ChuyenBay cb, HangVe hangVe) {

        return (int) danhSachVe.stream()
                .filter(ve -> ve.getChuyenBay().equals(cb) && ve.getHangVe() == hangVe).count();

    }

    @Override
    public String toString() {
        return "QuanLyHeThongDatVe{"
                + "\nChuyenBay=" + danhSachChuyenBay
                + ",\nVe=" + danhSachVe
                + ",\nHanhKhach=" + danhSachHanhKhach
                + ",\nHangHangKhong=" + danhSachHang
                + ",\nMayBay=" + danhSachMayBay
                + ",\nTaiKhoan=" + danhSachTaiKhoan
                + '}';
    }
}
