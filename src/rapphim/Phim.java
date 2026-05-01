/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rapphim;

/**
 *
 * @author DELL
 */
import java.util.*;

public class Phim {
    private String tenPhim;
    private int thoiLuong;
    private DoTuoi doTuoi;
    private TheLoai theLoai;
    private List<DienVien> dsDienVien;
    
    // ✅ constructor cũ để tránh lỗi code cũ
    public Phim(String tenPhim, int thoiLuong) {
        this.tenPhim = tenPhim;
        this.thoiLuong = thoiLuong;
        this.dsDienVien = new ArrayList<>();
    }

    // constructor đầy đủ
    public Phim(String tenPhim, int thoiLuong, DoTuoi doTuoi, TheLoai theLoai) {
        this.tenPhim = tenPhim;
        this.thoiLuong = thoiLuong;
        this.doTuoi = doTuoi;
        this.theLoai = theLoai;
        this.dsDienVien = new ArrayList<>();
    }

    public String getTenPhim() {
        return tenPhim;
    }

    public int getThoiLuong() {
        return thoiLuong;
    }

    public DoTuoi getDoTuoi() {
        return doTuoi;
    }

    public TheLoai getTheLoai() {
        return theLoai;
    }

    public void themDienVien(DienVien dv) {
        dsDienVien.add(dv);
    }

    public List<DienVien> getDsDienVien() {
        return dsDienVien;
    }

    @Override
    public String toString() {
        return tenPhim + " (" + thoiLuong + "p)";
    }

    // 👉 hiển thị chi tiết (dùng cho GUI)
    public String hienThiChiTiet() {
        String dvStr = "";
        for (DienVien dv : dsDienVien) {
            dvStr += dv.toString() + ", ";
        }

        return "🎬 " + tenPhim +
               "\n " + thoiLuong + " phút" +
               "\n " + (theLoai != null ? theLoai : "") +
               "\n " + (doTuoi != null ? doTuoi : "") +
               "\n " + dvStr;
    }
}