package model;

import java.util.ArrayList;
import java.util.List;

public class Investment {
    private double balance;
    private List<String> transactions;

    //constructor
    public Investment(){
        this.balance = balance;
        this.transactions = new ArrayList<>();
    }

    //Getters and Setters
    public double getBalance(){
        return balance;
    }

    public void setBalance(double balance){
        this.balance = balance;
    }

    public List<String> getTransactions() {
        return transactions;
    }
    // function which change the transaction list
    public void addTransaction(String transaction){
        transactions.add(transaction);
    }

    // method investir: invest money to the balance
    public void investir(double montant){
        if(montant > 0){
            balance += montant;
            addTransaction("Investi : +" + montant + "$ le " + java.time.LocalDate.now());
        }
    }

    // method retirer : cashout money from the balance
    public void retirer(double montant){
        if(montant > 0 && montant <= balance){
            balance -= montant;
            addTransaction("Retiré : -" + montant + "$ le " + java.time.LocalDate.now());
        }
    }
}
