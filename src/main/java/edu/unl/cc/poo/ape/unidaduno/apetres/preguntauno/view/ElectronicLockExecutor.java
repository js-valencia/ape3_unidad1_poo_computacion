package edu.unl.cc.poo.ape.unidaduno.apetres.preguntauno.view;

import edu.unl.cc.poo.ape.unidaduno.apetres.preguntauno.domain.ElectronicLock;
import java.util.Scanner;

//author: Domenica Narvaez + TwoCore Team

public class ElectronicLockExecutor {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ElectronicLock lock = new ElectronicLock(); // Instanciamos nuestro objeto
        int option = 0;

        System.out.println("--- SISTEMA DE CERRADURA ELECTRÓNICA ---");

        // Aquí sí va el ciclo, en la interfaz con el usuario
        while (option != 3) {
            System.out.println("\nMenú Interactivo:");
            System.out.println("1. Configurar clave");
            System.out.println("2. Validar clave (Abrir cerradura)");
            System.out.println("3. Salir");
            System.out.print("Seleccione una opción: ");

            if (scanner.hasNextInt()) {
                option = scanner.nextInt();

                switch (option) {
                    case 1:
                        if (!lock.hasPinConfigured()) {
                            System.out.print("Ingrese la nueva clave numérica de 4 dígitos: ");
                            if (scanner.hasNextInt()) {
                                Integer newPin = scanner.nextInt();

                                // Llamamos al método y evaluamos el boolean que retorna
                                if (lock.configurePin(newPin)) {
                                    System.out.println("Clave configurada exitosamente.");
                                } else {
                                    System.out.println("Error: La clave debe tener exactamente 4 dígitos.");
                                }
                            } else {
                                System.out.println("Entrada inválida. Debe ingresar números.");
                                scanner.next(); // Limpiar el escáner
                            }
                        } else {
                            System.out.println("La clave ya ha sido configurada previamente.");
                        }
                        break;

                    case 2:
                        if (lock.isLocked()) {
                            System.out.println("La cerradura está bloqueada por múltiples intentos fallidos.");
                            break;
                        }

                        if (!lock.hasPinConfigured()) {
                            System.out.println("Primero debe configurar una clave en la opción 1.");
                            break;
                        }

                        System.out.print("Ingrese su clave: ");
                        if (scanner.hasNextInt()) {
                            Integer enteredPin = scanner.nextInt();

                            // Pasamos el intento al objeto cerradura
                            if (lock.validatePin(enteredPin)) {
                                System.out.println("¡Clave correcta! Cerradura ABIERTA.");
                            } else {
                                // Si falló, revisamos si con ese error la cerradura se bloqueó
                                if (lock.isLocked()) {
                                    System.out.println("Clave incorrecta. ¡CERRADURA BLOQUEADA! (3 intentos fallidos).");
                                } else {
                                    System.out.println("Clave incorrecta. Intente nuevamente.");
                                }
                            }
                        } else {
                            System.out.println("Entrada inválida. Debe ingresar números.");
                            scanner.next(); // Limpiar el escáner
                        }
                        break;

                    case 3:
                        System.out.println("Saliendo del sistema...");
                        break;

                    default:
                        System.out.println("Opción no válida. Elija 1, 2 o 3.");
                }
            } else {
                System.out.println("Por favor, ingrese un número.");
                scanner.next(); // Limpiar el escáner si el usuario mete letras
            }
        }
        scanner.close();
    }
}

