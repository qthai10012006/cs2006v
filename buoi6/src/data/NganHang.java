/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package data;

/**
 *
 * @author DELL
 */
public class NganHang {

    private String tenKhachHang;
    private double soTienGui;
    private double laiSuat; // ví dụ 0.06 = 6%
    private int soNam;

    public NganHang(String tenKhachHang, double soTienGui, double laiSuat, int soNam) {
        this.tenKhachHang = tenKhachHang;
        this.soTienGui = soTienGui;
        this.laiSuat = laiSuat;
        this.soNam = soNam;
    }

    // Tính tiền lãi
    public double tinhTienLai() {
        return soTienGui * laiSuat * soNam;
    }

    // Tính tổng tiền sau khi gửi
    public double tinhTongTien() {
        return soTienGui + tinhTienLai();
    }

    @Override
    public String toString() {
        return "Khách hàng: " + tenKhachHang +
                "\nTiền gửi: " + soTienGui +
                "\nLãi suất: " + (laiSuat * 100) + "%" +
                "\nSố năm: " + soNam +
                "\nTiền lãi: " + tinhTienLai() +
                "\nTổng tiền nhận được: " + tinhTongTien();
    }
}
