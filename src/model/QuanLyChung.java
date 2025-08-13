package model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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

    // === Quản lý vé ===
    public void themVe(VeMayBay ve) {
        danhSachVe.add(ve);
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

    // === Hiển thị toàn bộ hệ thống ===
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
