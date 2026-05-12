/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rapphim;

/**
 *
 * @author DELL
 */
public class DienVien {
    private String ten;
    private int namSinh;

    public DienVien(String ten, int namSinh) {
        this.ten = ten;
        this.namSinh = namSinh;
    }

   public String getTen() {
        return ten;
    }

    public String toString() {
        return ten + " (" + namSinh + ")";
    }
}

