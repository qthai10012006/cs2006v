/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rapphim;

/**
 *
 * @author DELL
 */
public enum TheLoai {
    HANH_DONG("Hanh dong"),
    TINH_CAM("Tinh cam"),
    KINH_DI("Kinh di"),
    HAI("Hai"),
    HOAT_HINH("Hoat hinh");

    private String ten;

    TheLoai(String ten) {
        this.ten = ten;
    }

    public String getTen() {
        return ten;
    }

    @Override
    public String toString() {
        return ten;
    }
}
