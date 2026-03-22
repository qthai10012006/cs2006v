/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package data;

/**
 *
 * @author DELL
 */
public class NhanVien {
    String ten;
    double luongCoBan;
   public static int tongNhanVien = 0;
   public static String tenCongTy= "ABC";
   
   public NhanVien (String ten, double luongCoBan){
       this.ten= ten;
       this.luongCoBan= luongCoBan;
     tongNhanVien++;
    if (luongCoBan < 0) {
        System.out.println("❌ Loi: Luong khong duoc am");
        luongCoBan = 0;
    }
// if (luongCoBan < 0) {
// this.luongcoban= luôgcoban
//else { sys out prin
//dem+=1
//tôngluong+ = luongcoban

 
       
   }
     
     public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public double getLuongCoBan() {
        return luongCoBan;
    }

    public void setLuongCoBan(double luongCoBan) {
        this.luongCoBan = luongCoBan;
    } 
    public double tinhLuong(){
        return this.luongCoBan;
 }
@Override
    public String toString() {
        return "NhanVien{ten='" + ten + "', luongCoBan=" + luongCoBan + "}";
    }

    
    
}