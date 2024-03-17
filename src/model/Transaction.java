package model;

import java.util.Date;

// Classe representant une transaction
public class Transaction {

    private TransactionType type; // Enum pour Investir ou Retirer
    private double montant;
    private Date date;

    //Getters
    public TransactionType getType() {
        return type;
    }

    public double getMontant(){
        return montant;
    }

    public Date getDate(){
        return date;
    }

    //Constructor
    public Transaction(TransactionType type, double montant, Date date){
        this.type = type;
        this.montant = montant;
        this.date = date;
    }

    // Enum pour le type de transaction(Investir ou Retirer)
    public enum TransactionType{
        Investissement, Retrait
    }



}
