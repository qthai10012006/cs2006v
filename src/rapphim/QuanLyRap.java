/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rapphim;
import java.util.*;


/**
 *
 * @author DELL
 */


public class QuanLyRap {
    private List<PhongChieu> dsPhong = new ArrayList<>();
    private List<SuatChieu> dsSuat = new ArrayList<>();

    public void themPhong(PhongChieu p) {
        dsPhong.add(p);
    }

    public void themSuatChieu(SuatChieu s) {
        dsSuat.add(s);
    }

    public List<SuatChieu> getDsSuat() {
        return dsSuat;
    }
}
