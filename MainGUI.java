/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package rapphim;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.*;
import test.LoginForm;


/**
 *
 * @author DELL
 */
public class MainGUI extends JFrame {

    public MainGUI() {
        setTitle("Rạp Chiếu Phim");
        setSize(400, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JButton btnStart = new JButton("Bắt đầu");
        btnStart.setBounds(120, 100, 150, 40);
        setLayout(null);

        btnStart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new LoginForm().setVisible(true); //  chuyển sang login
                dispose();
            }
        });

        add(btnStart);
    }

    public static void main(String[] args) {
        new MainGUI().setVisible(true);
    }
}
