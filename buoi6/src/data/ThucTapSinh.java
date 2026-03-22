/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package data;

/**
 *
 * @author DELL
 */public class ThucTapSinh extends NhanVien {
    private String truongDaiHoc;

    public ThucTapSinh(String ten, double luongCoBan, String truongDaiHoc) {
        super(ten, luongCoBan);
        this.truongDaiHoc = truongDaiHoc;
    }

    @Override
    public double tinhLuong() {
        return getLuongCoBan() * 0.8;
    }

    @Override
    public String toString() {
        return "ThucTapSinh{" +
                "ten='" + getTen() + '\'' +
                ", truongDaiHoc='" + truongDaiHoc + '\'' +
                ", luong=" + tinhLuong() +
                '}';
    }
}

    

