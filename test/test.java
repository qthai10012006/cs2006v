/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rapphim;
/**
 *
 * @author DELL
 */

public class test {
    public static void main(String[] args) {
        try {
            TaiKhoanService service = new TaiKhoanService();

            // đăng ký
            service.dangKy(new KhachHang("tho", "123", "tho@gmail.com"));

            // lưu file
            service.saveToFile();

            // load lại
            service.loadFromFile();

            // đăng nhập
            KhachHang user = service.dangNhap("tho", "123");

            if (user != null) {
                System.out.println("Đăng nhập thành công");
            } else {
                System.out.println("Sai tài khoản");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
