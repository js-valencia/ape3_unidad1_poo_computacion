package edu.unl.cc.poo.ape.unidaduno.apetres.preguntados.domain;

public class BankAccount {
    private String numberAccount;
    private String nameOwner;
    private double balance;
    private String[] history;
    private int numberTransaction;
 
    public BankAccount(String numberAccount, String nameOwner, double balance) {
        this.numberAccount = numberAccount;
        this.nameOwner = nameOwner;
        this.balance = balance;
        this.history = new String[100];
        this.numberTransaction = 0;
    }
 
    public String getNameOwner() {
        return nameOwner;
    }
 
    public String getNumberAccount() {
        return numberAccount;
    }
 
    public int getNumberTransaction() {
        return numberTransaction;
    }
 
    public double getBalance() {
        return this.balance;
    }
 
    public String[] getHistory() {
        return history;
    }
 
    public double deposit(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("El monto debe ser mayor a 0");
        }
        balance += amount;
        history[numberTransaction] = "Deposito: " + amount;
        numberTransaction++;
        return balance;
    }
 
    public double withdraw(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("El monto debe ser mayor a 0");
        }
        if (balance < amount) {
            throw new IllegalArgumentException("Saldo insuficiente");
        }
        balance -= amount;
        history[numberTransaction] = "Retiro: " + amount;
        numberTransaction++;
        return balance;
    }
 
    public String getBalanceInfo() {
        return "Titular: " + nameOwner + "\n" +
               "Numero de cuenta: " + numberAccount + "\n" +
               "Saldo actual: " + balance;
    }
 
    public String getHistoryInfo() {
        StringBuilder sb = new StringBuilder();
        sb.append("Titular: ").append(nameOwner).append("\n");
        sb.append("Numero de cuenta: ").append(numberAccount).append("\n");
        if (numberTransaction == 0) {
            sb.append("No se han realizado transacciones");
        } else {
            sb.append("Historial de transacciones:\n");
            for (int i = 0; i < numberTransaction; i++) {
                sb.append(history[i]).append("\n");
            }
        }
        return sb.toString();
    }
}