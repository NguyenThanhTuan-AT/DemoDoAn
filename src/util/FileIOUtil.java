package util;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import java.io.*;
import java.lang.reflect.Type;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class FileIOUtil {

    private static final Gson gson = new GsonBuilder()
            .registerTypeAdapter(LocalDateTime.class, new LocalDateTimeAdapter())
            .create();
    private static final String BASE_PATH = "data/";

    // Đọc danh sách đối tượng từ file JSON
    public static <T> List<T> docTuFile(String tenFile, Class<T> clazz) {
        try (Reader reader = new FileReader(BASE_PATH + tenFile)) {
            Type type = TypeToken.getParameterized(List.class, clazz).getType();
            return gson.fromJson(reader, type);
        } catch (IOException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    // Ghi danh sách đối tượng vào file JSON
    public static <T> void ghiVaoFile(String tenFile, List<T> danhSach) {
        try (Writer writer = new FileWriter(BASE_PATH + tenFile)) {
            gson.toJson(danhSach, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static <T> void suaDoiTuong(String tenFile, T doiTuongMoi, Function<T, String> layId) {
        List<T> danhSach = docTuFile(tenFile, (Class<T>) doiTuongMoi.getClass());
        for (int i = 0; i < danhSach.size(); i++) {
            if (layId.apply(danhSach.get(i)).equals(layId.apply(doiTuongMoi))) {
                danhSach.set(i, doiTuongMoi);
                break;
            }
        }
        ghiVaoFile(tenFile, danhSach);
    }

    public static <T> void xoaDoiTuong(String tenFile, String id, Function<T, String> layId, Class<T> clazz) {
        List<T> danhSach = docTuFile(tenFile, clazz);
        danhSach.removeIf(obj -> layId.apply(obj).equals(id));
        ghiVaoFile(tenFile, danhSach);
    }

}
