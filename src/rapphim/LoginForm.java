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

        // LOAD FILE
        try {
            service.loadFromFile();
        } catch (Exception e) {}

        // LOGIN
        btnLogin.addActionListener(e -> {
            String user = txtUser.getText();
            String pass = new String(txtPass.getPassword());

            KhachHang kh = service.dangNhap(user, pass);

            if (kh != null) {
                JOptionPane.showMessageDialog(this, "Đăng nhập thành công");

                // 👉 mở giao diện chính
                new RapGUI().setVisible(true);
                dispose(); // đóng login
            } else {
                JOptionPane.showMessageDialog(this, "Sai tài khoản");
            }
        });

        // REGISTER
        btnRegister.addActionListener(e -> {
            String user = txtUser.getText();
            String pass = new String(txtPass.getPassword());

            service.dangKy(new KhachHang(user, pass, user + "@gmail.com"));

            try {
                service.saveToFile();
            } catch (Exception ex) {}

            JOptionPane.showMessageDialog(this, "Đăng ký thành công");
        });
    }

    public static void main(String[] args) {
        new LoginForm().setVisible(true);
    }
}