package edu.unl.cc.squareroot.view;
import java.util.Scanner;
import edu.unl.cc.squareroot.domain.Quadratic;

public class QuadraticExecutor {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Quadratic q1 = new Quadratic(1, 0, 0);
        int opcion;

        do {
            System.out.println("\n----- MENÚ -----");
            System.out.println("1. Ingresar coeficientes");
            System.out.println("2. Mostrar ecuación");
            System.out.println("3. Calcular discriminante");
            System.out.println("4. Calcular raíces");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opción: ");

            opcion = sc.nextInt();

            switch (opcion) {
                case 1:
                    q1.getValues();
                    break;

                case 2:
                    q1.showQuadratic();
                    break;

                case 3:
                    System.out.println("Discriminante: " + q1.getDiscriminant());
                    break;

                case 4:
                    System.out.println(q1.getRoots());
                    break;

                case 0:
                    System.out.println("Fin del programa");
                    break;

                default:
                    System.out.println("Opción inválida");
            }

        } while (opcion != 0);
    }
}