package test;

import java.util.List;
import model.*;
import util.FileIOUtil;

public class TestDocTatCa {

    public static void main(String[] args) {
        docVaThongBao("ChuyenBay.json", ChuyenBay.class);
        docVaThongBao("VeMayBay.json", VeMayBay.class);
        docVaThongBao("TaiKhoan.json", TaiKhoan.class);
        docVaThongBao("MayBay.json", MayBay.class);
        docVaThongBao("HangHangKhong.json", HangHangKhong.class);
        docVaThongBao("HanhKhach.json", HanhKhach.class);
    }

    public static <T> void docVaThongBao(String tenFile, Class<T> clazz) {
        List<T> danhSach = FileIOUtil.docTuFile(tenFile, clazz);
        System.out.println(tenFile + ": "
                + (danhSach.isEmpty() ? "Không đọc được hoặc file trống." : "Đọc thành công " + danhSach.size() + " đối tượng."));
    }
}
