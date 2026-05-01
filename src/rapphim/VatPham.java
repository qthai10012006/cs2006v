/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rapphim;

/**
 *
 * @author DELL
 */

public class VatPham {
    private String ten;
    private double gia;
    private int soLuong;

    public VatPham(String ten, double gia, int soLuong) {
        this.ten = ten;
        this.gia = gia;
        this.soLuong = soLuong;
    }

    public double tinhTien() {
        return gia * soLuong;
    }

    public String toString() {
        return ten + " x" + soLuong;
    }
}
