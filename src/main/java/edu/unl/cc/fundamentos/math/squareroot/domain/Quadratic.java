package edu.unl.cc.fundamentos.math.squareroot.domain;
import java.util.Scanner;

public class Quadratic {
    private double a;
    private double b;
    private double c;

    public double getA() {
        return a;
    }

    public void setA(double a) {
        this.a = a;
    }

    public double getB() {
        return b;
    }

    public void setB(double b) {
        this.b = b;
    }

    public double getC() {
        return c;
    }

    public void setC(double c) {
        this.c = c;
    }

    // Constructor
    public Quadratic(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    // Metodo para ingresar valores
    public void getValues() {
        Scanner scanner = new Scanner(System.in);

        do {
            System.out.print("Ingrese el valor de a (Recuerde que a ≠ 0): ");
            this.a = scanner.nextDouble();

            if (this.a == 0) {
                System.out.println("Error: 'a' no puede ser 0\n");
            }

        } while (this.a == 0);

        System.out.print("Ingrese el valor de b: ");
        this.b = scanner.nextDouble();

        System.out.print("Ingrese el valor de c: ");
        this.c = scanner.nextDouble();
    }

    // Mostrar ecuación
    public void showQuadratic() {
        System.out.println("\nEcuación formada:");
        System.out.println(this.a + "x^2 + " + this.b + "x + " + this.c + " = 0");
    }

    // Calcular discriminante
    public double getDiscriminant() {
        return Math.pow(this.b, 2) - 4 * this.a * this.c;
    }

    // Obtener raíces
    public Roots getRoots() {
        double d = getDiscriminant();

        if (d > 0) {
            double x1 = (-b + Math.sqrt(d)) / (2 * a);
            double x2 = (-b - Math.sqrt(d)) / (2 * a);
            return new Roots(x1, x2, false);

        } else if (d == 0) {
            double x = (-b) / (2 * a);
            return new Roots(x, x, false);

        } else {
            return new Roots(0, 0, true);
        }
    }
}