package edu.unl.cc.poo.ape.unidaduno.apetres.preguntacuatro.domain;

public class Fraction {
    private int numerador;
    private int denominador;

    public Fraction(int numerador, int denominador) {
        if (denominador == 0) {
            throw new IllegalArgumentException("El denominador no puede ser cero.");
        }
        this.numerador = numerador;
        this.denominador = denominador;
    }
    
    public int getNumerador() { return numerador; }
    public void setNumerador(int numerador) { this.numerador = numerador; }
    public int getDenominador() { return denominador; }

    public void setDenominador(int denominador) {
        if (denominador == 0) throw new IllegalArgumentException("No puede ser cero.");
        this.denominador = denominador;
    }

    @Override
    public String toString() {
        return numerador + "/" + denominador;
    }
}