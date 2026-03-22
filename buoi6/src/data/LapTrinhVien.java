/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package data;

/**
 *
 * @author DELL
 */
public class LapTrinhVien extends NhanVien {
    private int soGioOT;
    private static final double LUONG_OT = 300000;

    public LapTrinhVien(String ten, double luongCoBan, int soGioOT) {
        super(ten, luongCoBan);
        this.soGioOT = soGioOT;
    }

    @Override
    public double tinhLuong() {
        return getLuongCoBan() + soGioOT * LUONG_OT;
    }

    @Override
    public String toString() {
        return "LapTrinhVien{" +
                "ten='" + getTen() + '\'' +
                ", soGioOT=" + soGioOT +
                ", tongLuong=" + tinhLuong() +
                '}';
    }
}

