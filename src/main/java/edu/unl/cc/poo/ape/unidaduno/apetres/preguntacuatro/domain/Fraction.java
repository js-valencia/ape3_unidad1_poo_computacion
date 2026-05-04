package edu.unl.cc.poo.ape.unidaduno.apetres.preguntacuatro.domain;

//author: Javier Guarnizo + TwoCoreTea

public class Fraction {
    private int numerator;
    private int denominator;

    public Fraction(int numerator, int denominator) {
        if (denominator == 0) {
            throw new IllegalArgumentException("Denominator cannot be zero.");
        }
        this.numerator = numerator;
        this.denominator = denominator;
    }
    
    public int getNumerator() { return numerator; }
    public void setNumerator(int numerator) { this.numerator = numerator; }
    public int getDenominator() { return denominator; }

    public void setDenominator(int denominator) {
        if (denominator == 0) throw new IllegalArgumentException("Denominator cannot be zero.");
        this.denominator = denominator;
    }

    @Override
    public String toString() {
        return numerator + "/" + denominator;
    }
}