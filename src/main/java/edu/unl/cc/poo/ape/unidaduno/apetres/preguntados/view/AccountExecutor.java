package edu.unl.cc.poo.ape.unidaduno.apetres.preguntados.view;

import edu.unl.cc.poo.ape.unidaduno.apetres.preguntados.domain.BankAccount;

import java.util.InputMismatchException;
import java.util.Scanner;

public class AccountExecutor {
 
    private static double inputMonto(String message, Scanner scanner) {
        System.out.print(message);
        return scanner.nextDouble();
    }
 
    private static void inputWithdraw(BankAccount account, Scanner scanner) {
        while (true) {
            try {
                double monto = inputMonto("Monto a retirar: ", scanner);
                account.withdraw(monto);
                break;
            } catch (InputMismatchException e) {
                System.out.println("Dato invalido: " + e.getMessage());
                scanner.nextLine();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
 
    private static BankAccount inputAccount(Scanner scanner) {
        while (true) {
            try {
                System.out.print("Ingrese el numero de cuenta: ");
                String numberAccount = scanner.nextLine();
                System.out.print("Ingrese el nombre del titular: ");
                String nameOwner = scanner.nextLine();
                System.out.print("Ingrese el saldo inicial: ");
                double balance = scanner.nextDouble();
                scanner.nextLine();
                return new BankAccount(numberAccount, nameOwner, balance);
            } catch (InputMismatchException e) {
                System.out.println("Dato invalido: " + e.getMessage());
                scanner.nextLine();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
 
    private static void inputDeposit(BankAccount account, Scanner scanner) {
        while (true) {
            try {
                double monto = inputMonto("Monto a depositar: ", scanner);
                account.deposit(monto);
                break;
            } catch (InputMismatchException e) {
                System.out.println("Dato invalido: " + e.getMessage());
                scanner.nextLine();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
 
    public static void main(String[] args) {
        BankAccount account = null;
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("========================================");
            System.out.println("Bienvenido al Sistema de Cuenta Bancaria");
            System.out.println("========================================");
            System.out.println("1) Crear cuenta");
            System.out.println("2) Depositar");
            System.out.println("3) Retirar");
            System.out.println("4) Consultar saldo");
            System.out.println("5) Consultar historial");
            System.out.println("6) Salir");
            System.out.print("Ingrese una opcion: ");
            int option = scanner.nextInt();
            scanner.nextLine();
            switch (option) {
                case 1:
                    account = inputAccount(scanner);
                    break;
                case 2:
                    if (account == null) { 
                        System.out.println("Error: primero cree una cuenta"); 
                        break; 
                    }
                    inputDeposit(account, scanner);
                    break;
                case 3:
                    if (account == null) { 
                        System.out.println("Error: primero cree una cuenta"); 
                        break; 
                    }
                    inputWithdraw(account, scanner);
                    break;
                case 4:
                    if (account == null) { 
                        System.out.println("Error: primero cree una cuenta"); 
                        break; 
                    }
                    System.out.println(account.getBalanceInfo());   // <-- usa el método de BankAccount
                    break;
                case 5:
                    if (account == null) { 
                        System.out.println("Error: primero cree una cuenta"); 
                        break; 
                    }
                    System.out.println(account.getHistoryInfo());   // <-- usa el método de BankAccount
                    break;
                case 6:
                    System.out.println("Gracias por usar el sistema");
                    scanner.close();
                    return;
                default:
                    System.out.println("Opcion invalida, intente de nuevo.");
                    break;
            }
        }
    }
}