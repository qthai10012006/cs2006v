/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rapphim;
import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.time.LocalDateTime;


/**
 *
 * @author DELL
 */
public class RapGUI extends JFrame {

    private CardLayout layout;
    private JPanel mainPanel;

    private QuanLyRap ql;
    private DatVeService service;

    private Phim phimDuocChon;
    private SuatChieu suatDuocChon;
    private PhongChieu phongHienTai;

    private JPanel panelGhe;
    private Map<Ghe, JButton> mapBtn = new HashMap<>();

    private JCheckBox cbBap, cbNuoc;

    private JTextArea txtHoaDon;

    public RapGUI() {
        setTitle("🎬 Rạp phim");
        setSize(800, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        layout = new CardLayout();
        mainPanel = new JPanel(layout);

        add(mainPanel);

        khoiTaoDuLieu();

        taoManHinhChaoBackground();
        taoManHinhPhim();
        taoManHinhSuat();
        taoManHinhGhe();
        taoManHinhThanhToan();

        layout.show(mainPanel, "chao");

        setVisible(true);
    }

    // ================= DATA =================
    private void khoiTaoDuLieu() {
        ql = new QuanLyRap();

        PhongChieu p1 = new PhongChieu(5, 5);
        PhongChieu p2 = new PhongChieu(5, 5);

        Phim phim1 = new Phim("Avengers", 120);
        Phim phim2 = new Phim("Batman", 110);

        ql.themPhong(p1);
        ql.themPhong(p2);

        ql.themSuatChieu(new SuatChieu(phim1, p1, LocalDateTime.now()));
        ql.themSuatChieu(new SuatChieu(phim2, p2, LocalDateTime.now().plusHours(2)));

        service = new DatVeService();
    }

    // ================= MÀN CHÀO =================
    private void taoManHinhChao() {
        JPanel p = new JPanel();
        p.setLayout(new GridLayout(2,1));

        JLabel title = new JLabel("🎬 RẠP PHIM ABC", SwingConstants.CENTER);
        JButton btn = new JButton("Bắt đầu");

        btn.addActionListener(e -> layout.show(mainPanel, "phim"));

        p.add(title);
        p.add(btn);

        mainPanel.add(p, "chao");
    }

   private void taoManHinhPhim() {
    JPanel p = new JPanel(new BorderLayout());

    DefaultListModel<Phim> model = new DefaultListModel<>();

    // 👉 thêm phim có đầy đủ thông tin
    Phim p1 = new Phim("Avengers", 120, DoTuoi.C13, TheLoai.HANH_DONG);
    p1.themDienVien(new DienVien("Iron Man", 1970));

    Phim p2 = new Phim("Batman", 110, DoTuoi.C16, TheLoai.HANH_DONG);
    p2.themDienVien(new DienVien("Bruce Wayne", 1980));

    model.addElement(p1);
    model.addElement(p2);

    JList<Phim> list = new JList<>(model);

    // XEM CHI TIẾT
    list.addListSelectionListener(e -> {
        if (!e.getValueIsAdjusting()) {
            Phim pSelected = list.getSelectedValue();
            if (pSelected != null) {
                JOptionPane.showMessageDialog(this, pSelected.hienThiChiTiet());
            }
        }
    });

    JButton btnNext = new JButton("Tiếp →");
    JButton btnBack = new JButton("← Quay lại");

    btnNext.addActionListener(e -> {
        phimDuocChon = list.getSelectedValue();

        if (phimDuocChon == null) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn phim!");
            return;
        }

        layout.show(mainPanel, "suat");
    });

    btnBack.addActionListener(e -> layout.show(mainPanel, "chao"));

    JPanel bottom = new JPanel();
    bottom.add(btnBack);
    bottom.add(btnNext);

    p.add(new JScrollPane(list), BorderLayout.CENTER);
    p.add(bottom, BorderLayout.SOUTH);

    mainPanel.add(p, "phim");
}

    // ================= MÀN SUẤT =================
    private void taoManHinhSuat() {
           JPanel p = new JPanel(new BorderLayout());

    JComboBox<SuatChieu> combo = new JComboBox<>();

    for (SuatChieu s : ql.getDsSuat()) {
        combo.addItem(s);
    }

    JButton btnNext = new JButton("Tiếp →");
    JButton btnBack = new JButton("← Quay lại");

    btnNext.addActionListener(e -> {
        suatDuocChon = (SuatChieu) combo.getSelectedItem();

        if (suatDuocChon == null) {
            JOptionPane.showMessageDialog(this, "Chọn suất chiếu!");
            return;
        }

        phongHienTai = suatDuocChon.getPhong();

        loadGhe(); // 🔥 CỰC KỲ QUAN TRỌNG

        layout.show(mainPanel, "ghe"); // 👉 sang màn ghế
    });

    btnBack.addActionListener(e -> {
        layout.show(mainPanel, "phim");
    });

    JPanel bottom = new JPanel();
    bottom.add(btnBack);
    bottom.add(btnNext);

    p.add(combo, BorderLayout.CENTER);
    p.add(bottom, BorderLayout.SOUTH);

    mainPanel.add(p, "suat"); // ✅ PHẢI LÀ "suat"
    }

    // ================= MÀN THANH TOÁN =================
    private void taoManHinhThanhToan() {
        JPanel p = new JPanel(new BorderLayout());

    txtHoaDon = new JTextArea(15,40);

    JButton btnXacNhan = new JButton("Xác nhận");
    JButton btnBack = new JButton("← Quay lại");

    btnXacNhan.addActionListener(e -> xuLyThanhToan());

    btnBack.addActionListener(e -> {
        layout.show(mainPanel, "ghe");
    });

    JPanel bottom = new JPanel();
    bottom.add(btnBack);
    bottom.add(btnXacNhan);

    p.add(new JScrollPane(txtHoaDon), BorderLayout.CENTER);
    p.add(bottom, BorderLayout.SOUTH);

    mainPanel.add(p, "tt");
}
    

    // ================= THANH TOÁN =================
    private void xuLyThanhToan() {
        java.util.List<Ghe> dsGhe = new ArrayList<>();
        java.util.List<VatPham> dsVP = new ArrayList<>();
        for (Ghe g : phongHienTai.getTatCaGhe()) {
            if (g.getTrangThai() == TrangThaiGhe.DANG_CHON) {
                dsGhe.add(g);
            }
        }

        if (dsGhe.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Chưa chọn ghế!");
            return;
        }

        if (cbBap.isSelected()) dsVP.add(new VatPham("Bắp", 50000, 1));
        if (cbNuoc.isSelected()) dsVP.add(new VatPham("Nước", 30000, 1));

        double tong = service.thanhToan(dsGhe, dsVP);

        Ve ve = new Ve(phimDuocChon, phongHienTai, dsGhe, tong);

        txtHoaDon.setText(ve.toString());
    }
   private void taoManHinhChaoBackground() {

    // ===== BACKGROUND PANEL =====
    BackgroundPanel bg = new BackgroundPanel("cgv.jpg");

    // ===== BUTTON =====
    JButton btn = new JButton("Bắt đầu");
    btn.setFont(new Font("Arial", Font.BOLD, 20));

    btn.addActionListener(e -> layout.show(mainPanel, "phim"));

    // ===== PANEL GIỮA =====
    JPanel center = new JPanel(new BorderLayout());
    center.setOpaque(false);

    // ❌ bỏ lblLogo
    center.add(btn, BorderLayout.SOUTH);

    bg.add(center, BorderLayout.CENTER);

    mainPanel.add(bg, "chao");
}
   // ================= MÀU =================
   private void capNhatMau(JButton btn, Ghe ghe) {
    btn.setOpaque(true);
    btn.setBorderPainted(false);

    switch (ghe.getTrangThai()) {
        case TRONG:
            btn.setBackground(Color.WHITE);
            btn.setEnabled(true);
            break;

        case DANG_CHON:
            btn.setBackground(Color.YELLOW);
            btn.setEnabled(true);
            break;

        case DA_DAT:
            btn.setBackground(Color.RED);
            btn.setEnabled(false);
            break;
    }
   }
   private void taoManHinhGhe() {
    JPanel p = new JPanel(new BorderLayout());

    panelGhe = new JPanel(new GridLayout(5,5,5,5));

    JPanel panelDoAn = new JPanel();
    cbBap = new JCheckBox("Bắp (50k)");
    cbNuoc = new JCheckBox("Nước (30k)");

    panelDoAn.add(cbBap);
    panelDoAn.add(cbNuoc);

    JButton btnNext = new JButton("Tiếp →");
    JButton btnBack = new JButton("← Quay lại");

    btnNext.addActionListener(e -> layout.show(mainPanel, "tt"));

    btnBack.addActionListener(e -> layout.show(mainPanel, "suat"));

    JPanel bottom = new JPanel();
    bottom.add(btnBack);
    bottom.add(btnNext);

    p.add(panelGhe, BorderLayout.CENTER);
    p.add(panelDoAn, BorderLayout.EAST);
    p.add(bottom, BorderLayout.SOUTH);

    mainPanel.add(p, "ghe");
   }
   private void loadGhe() {
    panelGhe.removeAll();
    mapBtn.clear();

    Ghe[][] mt = phongHienTai.getMaTran();

    for (int i = 0; i < mt.length; i++) {
        for (int j = 0; j < mt[i].length; j++) {

            Ghe ghe = mt[i][j];
            JButton btn = new JButton(ghe.getMaGhe());

            capNhatMau(btn, ghe);

            btn.addActionListener(e -> {
                if (ghe.getTrangThai() == TrangThaiGhe.DA_DAT) return;

                if (ghe.getTrangThai() == TrangThaiGhe.TRONG)
                    service.chonGhe(ghe);
                else
                    service.boChon(ghe);

                capNhatMau(btn, ghe);
            });

            mapBtn.put(ghe, btn);
            panelGhe.add(btn);
        }
    }

    panelGhe.revalidate();
    panelGhe.repaint();
}
}

//loai ghe
  