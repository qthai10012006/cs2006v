/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package data;

/**
 *
 * @author DELL
 */
public class TruongPhong  extends NhanVien{
    private double tienTrachNhiem;
     public TruongPhong(String ten, double luongCoBan, double tienTrachNhiem) {
        super(ten, luongCoBan);
        this.tienTrachNhiem = tienTrachNhiem;
    }    
@Override
    public double tinhLuong() {
        return super.tinhLuong() + tienTrachNhiem;
    }

@Override
    public String toString() {
        return "TruongPhong{" +
                "ten='" + getTen() + '\'' +
                ", luongCoBan=" + getLuongCoBan() +
                ", tienTrachNhiem=" + tienTrachNhiem +
                ", tongLuong=" + tinhLuong() +
                '}';
    }
}
// lop thuc tap sinh
        // thuoc tinh ten truong dai hoc
        // tinh luong 80%
        //lap trinh vien
        //so gio OT
        //tinh luong = luong cb + luong ot( so OT * 300k)