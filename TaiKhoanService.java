package rapphim;

import java.util.*;
import java.io.*;

public class TaiKhoanService {
    private List<KhachHang> ds = new ArrayList<>();
    private final String FILE = "taikhoan.txt";

    public TaiKhoanService() {
        loadFromFile();
    }

    // Đăng ký
    public void dangKy(KhachHang kh) {
        ds.add(kh);
        saveToFile();
    }

    // Đăng nhập
    public KhachHang dangNhap(String user, String pass) {
        for (KhachHang kh : ds) {
            if (kh.getUsername().equals(user) && kh.getPassword().equals(pass)) {
                return kh;
            }
        }
        return null;
    }

    // Lưu file
    private void saveToFile() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(FILE))) {
            for (KhachHang kh : ds) {
                bw.write(kh.toString());
                bw.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Đọc file
    public void loadFromFile() {
        File f = new File(FILE);
        if (!f.exists()) return;

        try (BufferedReader br = new BufferedReader(new FileReader(FILE))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] arr = line.split(",");
                ds.add(new KhachHang(arr[0], arr[1], arr[2]));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
}
}