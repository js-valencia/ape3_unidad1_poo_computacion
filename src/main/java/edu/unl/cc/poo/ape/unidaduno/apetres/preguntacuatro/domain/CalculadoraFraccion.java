package edu.unl.cc.poo.ape.unidaduno.apetres.preguntacuatro.domain;

public class CalculadoraFraccion {

    public static Fraccion sumar(Fraccion f1, Fraccion f2) {
        int n = (f1.getNumerador() * f2.getDenominador()) + (f1.getDenominador() * f2.getNumerador());
        int d = f1.getDenominador() * f2.getDenominador();
        return obtenerSimplificada(new Fraccion(n, d));
    }

    public static Fraccion restar(Fraccion f1, Fraccion f2) {
        int n = (f1.getNumerador() * f2.getDenominador()) - (f1.getDenominador() * f2.getNumerador());
        int d = f1.getDenominador() * f2.getDenominador();
        return obtenerSimplificada(new Fraccion(n, d));
    }

    public static Fraccion multiplicar(Fraccion f1, Fraccion f2) {
        int n = f1.getNumerador() * f2.getNumerador();
        int d = f1.getDenominador() * f2.getDenominador();
        return obtenerSimplificada(new Fraccion(n, d));
    }

    public static Fraccion dividir(Fraccion f1, Fraccion f2) {
        if (f2.getNumerador() == 0) {
            throw new ArithmeticException("No se puede dividir por una fracción con numerador cero.");
        }
        int n = f1.getNumerador() * f2.getDenominador();
        int d = f1.getDenominador() * f2.getNumerador();
        return obtenerSimplificada(new Fraccion(n, d));
    }

    public static Fraccion obtenerInversa(Fraccion f) {
        if (f.getNumerador() == 0) {
            throw new ArithmeticException("No se puede invertir una fracción con numerador cero.");
        }
        return new Fraccion(f.getDenominador(), f.getNumerador());
    }

    public static double obtenerDecimal(Fraccion f) {
        return (double) f.getNumerador() / f.getDenominador();
    }

    public static Fraccion obtenerSimplificada(Fraccion f) {
        int divisor = mcd(f.getNumerador(), f.getDenominador());
        return new Fraccion(f.getNumerador() / divisor, f.getDenominador() / divisor);
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
