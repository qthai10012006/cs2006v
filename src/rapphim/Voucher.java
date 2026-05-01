/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rapphim;

/**
 *
 * @author DELL
 */
import java.time.LocalDate;
public class Voucher {
     private String code;
    private double discountPercent;
    private LocalDate expiryDate;

    public Voucher(String code, double discountPercent, LocalDate expiryDate) {
        this.code = code;
        this.discountPercent = discountPercent;
        this.expiryDate = expiryDate;
    }

    public boolean isValid() {
        return LocalDate.now().isBefore(expiryDate);
    }

    public double applyDiscount(double price) {
        if (isValid()) {
            return price * (1 - discountPercent / 100);
        }
        return price;
    }

    public String getCode() {
        return code;
    }
    
}
