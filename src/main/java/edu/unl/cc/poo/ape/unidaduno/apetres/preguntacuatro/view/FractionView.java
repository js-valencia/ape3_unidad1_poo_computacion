package edu.unl.cc.poo.ape.unidaduno.apetres.preguntacuatro.view;

import edu.unl.cc.poo.ape.unidaduno.apetres.preguntacuatro.domain.FractionCalculator;
import edu.unl.cc.poo.ape.unidaduno.apetres.preguntacuatro.domain.Fraction;
import java.util.Scanner;

public class FractionView {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        try {
            System.out.println("--- INGRESO DE FRACCIÓN 1 ---");
            System.out.print("Numerador: ");
            int n1 = sc.nextInt();
            System.out.print("Denominador: ");
            int d1 = sc.nextInt();
            Fraction f1 = new Fraction(n1, d1);

            int opcion;
            do {
                System.out.println("\n--- MENÚ FRACCIONES ---");
                System.out.println("1. Mostrar detalles (Estándar, Decimal, Simplificada)");
                System.out.println("2. Ver Inversa");
                System.out.println("3. Operaciones Aritméticas (Suma, Resta, Mult, Div)");
                System.out.println("4. Salir");
                System.out.print("Opción: ");
                opcion = sc.nextInt();

                switch (opcion) {
                    case 1:
                        System.out.println("Estándar: " + f1);
                        System.out.println("Decimal: " + FractionCalculator.obtenerDecimal(f1));
                        System.out.println("Simplificada: " + FractionCalculator.obtenerSimplificada(f1));
                        break;
                    case 2:
                        try {
                            System.out.println("Inversa: " + FractionCalculator.obtenerInversa(f1));
                        } catch (Exception e) {
                            System.out.println("Error: " + e.getMessage());
                        }
                        break;
                    case 3:
                        System.out.println("\n--- INGRESO DE FRACCIÓN 2 ---");
                        System.out.print("Numerador: ");
                        int n2 = sc.nextInt();
                        System.out.print("Denominador: ");
                        int d2 = sc.nextInt();
                        Fraction f2 = new Fraction(n2, d2);

                        System.out.println("Suma: " + FractionCalculator.sumar(f1, f2));
                        System.out.println("Resta: " + FractionCalculator.restar(f1, f2));
                        System.out.println("Multiplicación: " + FractionCalculator.multiplicar(f1, f2));
                        try {
                            System.out.println("División: " + FractionCalculator.dividir(f1, f2));
                        } catch (Exception e) {
                            System.out.println("División: Error - " + e.getMessage());
                        }
                        break;
                }
            } while (opcion != 4);

        } catch (Exception e) {
            System.out.println("Ocurrió un error: " + e.getMessage());
        } finally {
            sc.close();
        }
    }
}
