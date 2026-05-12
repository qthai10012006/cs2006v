/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rapphim;
import java.time.LocalDateTime;

/**
 *
 * @author DELL
 */




public class SuatChieu {
    private Phim phim;
    private PhongChieu phong;
    private LocalDateTime thoiGian;

    public SuatChieu(Phim phim, PhongChieu phong, LocalDateTime tg) {
        this.phim = phim;
        this.phong = phong;
        this.thoiGian = tg;
    }

    public Phim getPhim() {
        return phim;
    }

    public PhongChieu getPhong() {
        return phong;
    }

    public LocalDateTime getThoiGian() {
        return thoiGian;
    }

    public String toString() {
        return phim.getTenPhim() + " - " + thoiGian;
    }
}