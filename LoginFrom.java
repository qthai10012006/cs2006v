package test;


import javax.swing.*;
import rapphim.*;

public class LoginForm extends JFrame {
    private JTextField txtUser;
    private JPasswordField txtPass;
    private JButton btnLogin, btnRegister;

    private TaiKhoanService service = new TaiKhoanService();

    public LoginForm() {
        setTitle("Đăng nhập");
        setSize(350, 220);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);

        JLabel lblUser = new JLabel("Username:");
        lblUser.setBounds(30, 20, 80, 25);
        add(lblUser);

        txtUser = new JTextField();
        txtUser.setBounds(120, 20, 160, 25);
        add(txtUser);

        JLabel lblPass = new JLabel("Password:");
        lblPass.setBounds(30, 60, 80, 25);
        add(lblPass);

        txtPass = new JPasswordField();
        txtPass.setBounds(120, 60, 160, 25);
        add(txtPass);

        btnLogin = new JButton("Login");
        btnLogin.setBounds(40, 120, 100, 30);
        add(btnLogin);

        btnRegister = new JButton("Register");
        btnRegister.setBounds(170, 120, 100, 30);
        add(btnRegister);

        // 👉 KHÔNG cần gọi lại loadFromFile nếu constructor đã gọi
        // service.loadFromFile();

        // ================= LOGIN =================
        btnLogin.addActionListener(e -> {
            String user = txtUser.getText();
            String pass = new String(txtPass.getPassword());

            // ❌ KHÔNG đăng ký ở đây nữa

            KhachHang kh = service.dangNhap(user, pass);

            if (kh != null) {
                JOptionPane.showMessageDialog(this, "Đăng nhập thành công");

                new RapGUI().setVisible(true);
                dispose();
            } else {
                JOptionPane.showMessageDialog(this, "Sai tài khoản hoặc mật khẩu");
            }
        });

        // ================= REGISTER =================
        btnRegister.addActionListener(e -> {
            String user = txtUser.getText();
            String pass = new String(txtPass.getPassword());

            // kiểm tra rỗng
            if (user.isEmpty() || pass.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Không được để trống!");
                return;
            }

            service.dangKy(new KhachHang(user, pass, user + "@gmail.com"));

            JOptionPane.showMessageDialog(this, "Đăng ký thành công");
        });
    }

    public static void main(String[] args) {
        new LoginForm().setVisible(true);
    }
}
