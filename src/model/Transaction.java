package model;

import java.time.LocalDate;

// Classe representant une transaction
public class Transaction {

    private TransactionType type; // Enum pour Investir ou Retirer
    private String typeTransaction;
    private Investor investor;
    private int transactionId;
    private double montant;
    private LocalDate date;

    //Getters
    public TransactionType getType() {
        return type;
    }

    public double getMontant(){
        return montant;
    }

    public LocalDate getDate(){
        return date;
    }

    //Constructor
    public Transaction(){
        this.investor = new Investor();
    }
    public Transaction(TransactionType type, double montant, LocalDate date){
        this.type = type;
        this.montant = montant;
        this.date = date;
    }

    public int getTransactionId() {
        return transactionId;
    }

    public Investor getInvestor() {
        return investor;
    }

    public void setInvestor(Investor investor) {
        this.investor = investor;
    }

    public void setTransactionId(int transactionId) {
        this.transactionId = transactionId;
    }

    public void setMontant(double montant) {
        this.montant = montant;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getTypeTransaction() {
        return typeTransaction;
    }

    public void setTypeTransaction(String typeTransaction) {
        this.typeTransaction = typeTransaction;
    }

    // Enum pour le type de transaction(Investir ou Retirer)
    public enum TransactionType{
        Investissement, Retrait
    }
}
