package rapphim;

import java.util.List;
import java.util.UUID;

public class Ve {
    private String maVe;
    private Phim phim;
    private PhongChieu phong;
    private List<Ghe> dsGhe;
    private double tongTien;

    private Voucher voucher; // ✔ đặt đúng vị trí

    public Ve(Phim phim, PhongChieu phong, List<Ghe> dsGhe, double tongTien) {
        this.maVe = UUID.randomUUID().toString();
        this.phim = phim;
        this.phong = phong;
        this.dsGhe = dsGhe;
        this.tongTien = tongTien;
    }

    public String getMaVe() {
        return maVe;
    }

    // ✅ Áp dụng voucher
    public void applyVoucher(Voucher v) {
        if (v != null && v.isValid()) {
            this.tongTien = v.applyDiscount(this.tongTien); // ✔ sửa price -> tongTien
            this.voucher = v;
        } else {
            System.out.println("Voucher không hợp lệ");
        }
    }

    @Override
    public String toString() {
        String gheStr = "";
        for (Ghe g : dsGhe) {
            gheStr += g.getMaGhe() + " ";
        }

        return "Mã vé: " + maVe +
               "\nPhim: " + phim.getTenPhim() +
               "\nGhế: " + gheStr +
               "\nTổng tiền: " + tongTien +
               (voucher != null ? "\nVoucher: " + voucher.getCode() : "");
    }
}