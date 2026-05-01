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




public class DatVeService {

    public synchronized boolean chonGhe(Ghe ghe) {
        if (ghe.getTrangThai() == TrangThaiGhe.TRONG) {
            ghe.setTrangThai(TrangThaiGhe.DANG_CHON);
            return true;
        }
        return false;
    }

    public void boChon(Ghe ghe) {
        if (ghe.getTrangThai() == TrangThaiGhe.DANG_CHON) {
            ghe.setTrangThai(TrangThaiGhe.TRONG);
        }
    }

    // ✅ thêm vatPham vào tham số
    public double thanhToan(List<Ghe> dsGhe, List<VatPham> vatPham) {
        double tong = 0;

        // ================= TIỀN GHẾ =================
        for (Ghe g : dsGhe) {
            if (g.getTrangThai() == TrangThaiGhe.DANG_CHON) {
                g.setTrangThai(TrangThaiGhe.DA_DAT);
                tong += g.tinhGia();
            }
        }

        // ================= TIỀN VẬT PHẨM =================
        if (vatPham != null) {
            for (VatPham v : vatPham) {
                tong += v.tinhTien();
            }
        }

        return tong;
    }
}
