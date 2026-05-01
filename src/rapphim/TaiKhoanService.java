package rapphim;

import java.util.*;
import java.io.*;

public class TaiKhoanService {
    private List<KhachHang> list = new ArrayList<>();

    // đăng ký
    public void dangKy(KhachHang kh) {
        list.add(kh);
    }

    // đăng nhập
    public KhachHang dangNhap(String user, String pass) {
        for (KhachHang kh : list) {
            if (kh.getUsername().equals(user) && kh.checkPassword(pass)) {
                return kh;
            }
        }
        return null;
    }

    // lưu file
    public void saveToFile() throws Exception {
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("users.dat"));
        oos.writeObject(list);
        oos.close();
    }

    // đọc file
    public void loadFromFile() throws Exception {
        File f = new File("users.dat");
        if (!f.exists()) return;

        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(f));
        list = (List<KhachHang>) ois.readObject();
        ois.close();
    }
}