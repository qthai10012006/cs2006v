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




public class PhongChieu {
    private Ghe[][] maTran;
    private Map<String, Ghe> mapGhe;
    private int soHang, soCot;

    public PhongChieu(int soHang, int soCot) {
        this.soHang = soHang;
        this.soCot = soCot;
        maTran = new Ghe[soHang][soCot];
        mapGhe = new HashMap<>();
        khoiTao();
    }

   private void khoiTao() {
    for (int i = 0; i < soHang; i++) {
        for (int j = 0; j < soCot; j++) {

            String ma = (char) ('A' + i) + "" + (j + 1);
            Ghe ghe;

            // ================= PHÂN LOẠI GHẾ =================
            if (i == 0 || i == 1) {
                // A, B → ghế thường
                ghe = new GheThuong(ma, i, j);

            } else if (i == 2 || i == 3) {
                // C, D → ghế VIP
                ghe = new GheVip(ma, i, j);

            } else {
                // E → ghế đôi
                ghe = new GheDoi(ma, i, j);
            }

            maTran[i][j] = ghe;
            mapGhe.put(ma, ghe);
        }
    }
}

    public Ghe[][] getMaTran() {
        return maTran;
    }

    public Collection<Ghe> getTatCaGhe() {
        return mapGhe.values();
    }
}