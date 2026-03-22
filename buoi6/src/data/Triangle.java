/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package data;

import java.awt.Point;

public class Triangle {
    private Point A;
    private Point B;
    private Point C;
    public Triangle(Point A, Point B, Point C) {
        this.A = A;
        this.B = B;
        this.C = C;
    }
    private double distance(Point p1, Point p2) {
        return Math.sqrt(
                Math.pow(p1.x - p2.x, 2) +
                Math.pow(p1.y - p2.y, 2)
        );
    }
    private double a() { return distance(B, C); }
    private double b() { return distance(A, C); }
    private double c() { return distance(A, B); }

    public boolean isValid() {
        double a = a(), b = b(), c = c();
        return a + b > c && a + c > b && b + c > a;
    }
    public double getPerimeter() {
        if (!isValid()) return 0;
        return a() + b() + c();
    }
    public double getArea() {
        if (!isValid()) return 0;
        double p = getPerimeter() / 2;
        return Math.sqrt(p * (p - a()) * (p - b()) * (p - c()));
    }
    public String getType() {
        if (!isValid()) return "Khong phai tam giac";

        double a = a(), b = b(), c = c();
        double eps = 1e-6;

        boolean deu = Math.abs(a - b) < eps && Math.abs(b - c) < eps;
        boolean can = Math.abs(a - b) < eps || Math.abs(a - c) < eps || Math.abs(b - c) < eps;
        boolean vuong =
                Math.abs(a*a - (b*b + c*c)) < eps ||
                Math.abs(b*b - (a*a + c*c)) < eps ||
                Math.abs(c*c - (a*a + b*b)) < eps;

        if (deu) return "Tam giac deu";
        if (vuong && can) return "Tam giac vuong can";
        if (vuong) return "Tam giac vuong";
        if (can) return "Tam giac can";
        return "Tam giac thuong";
    }

    @Override
    public String toString() {
        return "Triangle{" +
                "A=" + A +
                ", B=" + B +
                ", C=" + C +
                ", perimeter=" + getPerimeter() +
                ", area=" + getArea() +
                ", type='" + getType() + '\'' +
                '}';
    }
}

