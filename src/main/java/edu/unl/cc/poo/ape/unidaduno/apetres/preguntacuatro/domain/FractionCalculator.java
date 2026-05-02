package edu.unl.cc.poo.ape.unidaduno.apetres.preguntacuatro.domain;

public class FractionCalculator {

    public static Fraction sumar(Fraction f1, Fraction f2) {
        int n = (f1.getNumerador() * f2.getDenominador()) + (f1.getDenominador() * f2.getNumerador());
        int d = f1.getDenominador() * f2.getDenominador();
        return obtenerSimplificada(new Fraction(n, d));
    }

    public static Fraction restar(Fraction f1, Fraction f2) {
        int n = (f1.getNumerador() * f2.getDenominador()) - (f1.getDenominador() * f2.getNumerador());
        int d = f1.getDenominador() * f2.getDenominador();
        return obtenerSimplificada(new Fraction(n, d));
    }

    public static Fraction multiplicar(Fraction f1, Fraction f2) {
        int n = f1.getNumerador() * f2.getNumerador();
        int d = f1.getDenominador() * f2.getDenominador();
        return obtenerSimplificada(new Fraction(n, d));
    }

    public static Fraction dividir(Fraction f1, Fraction f2) {
        if (f2.getNumerador() == 0) {
            throw new ArithmeticException("No se puede dividir por una fracción con numerador cero.");
        }
        int n = f1.getNumerador() * f2.getDenominador();
        int d = f1.getDenominador() * f2.getNumerador();
        return obtenerSimplificada(new Fraction(n, d));
    }

    public static Fraction obtenerInversa(Fraction f) {
        if (f.getNumerador() == 0) {
            throw new ArithmeticException("No se puede invertir una fracción con numerador cero.");
        }
        return new Fraction(f.getDenominador(), f.getNumerador());
    }

    public static double obtenerDecimal(Fraction f) {
        return (double) f.getNumerador() / f.getDenominador();
    }

    public static Fraction obtenerSimplificada(Fraction f) {
        int divisor = mcd(f.getNumerador(), f.getDenominador());
        return new Fraction(f.getNumerador() / divisor, f.getDenominador() / divisor);
    }

    private static int mcd(int a, int b) {
        a = Math.abs(a);
        b = Math.abs(b);
        while (b > 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}
