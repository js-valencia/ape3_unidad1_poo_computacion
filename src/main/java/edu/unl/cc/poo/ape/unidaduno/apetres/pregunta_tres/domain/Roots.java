package edu.unl.cc.squareroot.domain;

public class Roots{
    private double x1;
    private double x2;
    boolean isComplex;

    public double getRoot1() {
        return x1;
    }

    public double getRoot2() {
        return x2;
    }

    public void setRoot1(double x1) {
        this.x1 = x1;
    }

    public void setRoot2(double x2) {
        this.x2 = x2;
    }

    public Roots(double x1, double x2, boolean isComplex) {
        this.x1 = x1;
        this.x2 = x2;
        this.isComplex = isComplex;
    }

    @Override
    public String toString() {
        if (!isComplex) {
            return "Raíces reales: { x1 = (" + x1 + "), x2 = (" + x2 + ") }";
        } else {
            return "Raíces complejas";
        }
    }
}