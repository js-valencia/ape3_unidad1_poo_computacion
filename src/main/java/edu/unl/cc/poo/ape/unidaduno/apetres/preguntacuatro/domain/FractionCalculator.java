package edu.unl.cc.poo.ape.unidaduno.apetres.preguntacuatro.domain;

//author: Javier Guarnizo + TwoCoreTeam

public class FractionCalculator {

    public static Fraction add(Fraction f1, Fraction f2) {
        int n = (f1.getNumerator() * f2.getDenominator()) + (f1.getDenominator() * f2.getNumerator());
        int d = f1.getDenominator() * f2.getDenominator();
        return getSimplified(new Fraction(n, d));
    }

    public static Fraction substract(Fraction f1, Fraction f2) {
        int n = (f1.getNumerator() * f2.getDenominator()) - (f1.getDenominator() * f2.getNumerator());
        int d = f1.getDenominator() * f2.getDenominator();
        return getSimplified(new Fraction(n, d));
    }

    public static Fraction multiply(Fraction f1, Fraction f2) {
        int n = f1.getNumerator() * f2.getNumerator();
        int d = f1.getDenominator() * f2.getDenominator();
        return getSimplified(new Fraction(n, d));
    }

    public static Fraction divide(Fraction f1, Fraction f2) {
        if (f2.getNumerator() == 0) {
            throw new ArithmeticException("Cannot divide by a fraction with a numerator of zero.");
        }
        int n = f1.getNumerator() * f2.getDenominator();
        int d = f1.getDenominator() * f2.getNumerator();
        return getSimplified(new Fraction(n, d));
    }

    public static Fraction getInverse(Fraction f) {
        if (f.getNumerator() == 0) {
            throw new ArithmeticException("Cannot invert a fraction with a numerator of zero");
        }
        return new Fraction(f.getDenominator(), f.getNumerator());
    }

    public static double getDecimal(Fraction f) {
        return (double) f.getNumerator() / f.getDenominator();
    }

    public static Fraction getSimplified(Fraction f) {
        int divisor = mcd(f.getNumerator(), f.getDenominator());
        return new Fraction(f.getNumerator() / divisor, f.getDenominator() / divisor);
    }
//mcd: Minimo Comun Divisor
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
