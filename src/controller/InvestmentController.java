package controller;

import Dao.TransactionDAOImpl;
import model.Investment;
import model.Investor;
import model.Transaction;
import view.InvestmentView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;

public class InvestmentController {
    private Investment model;
    private InvestmentView view;
    private TransactionDAOImpl transactionDAOImpl;

    //constructor
    public InvestmentController(Investment model, InvestmentView view, Investor investor){
        this.model = model;
        this.view = view;
        this.transactionDAOImpl = new TransactionDAOImpl();
        // Recuperation des transactions
        ArrayList<Transaction> transactions = transactionDAOImpl.getAllTransactionsByInvestorId(investor.getUserId());
        investor.setTransactions(transactions);
        view.updateView(investor, model);
        //Add addActionListener to Buttons
        view.getInvestButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // logique pour l'action investir
                System.out.println("Bouton Investir cliqué");
                try{
                    double montant = Double.parseDouble(JOptionPane.showInputDialog(view,"Montant à Investir :"));
                    if(montant > 100){
                        Transaction transaction = new Transaction();
                        transaction.setTypeTransaction(Transaction.TransactionType.Investissement.name());
                        transaction.setInvestor(investor);
                        transaction.setDate(LocalDate.now());
                        transaction.setMontant(montant);

                        transaction = transactionDAOImpl.addTransaction(transaction);

                        investor.getTransactions().add(transaction);

                        //model.investir(montant);
                        view.updateView(investor, model);
                        // view.addTransaction(new Date(), montant, Transaction.TransactionType.Investissement);
                    } else {
                        JOptionPane.showMessageDialog(view,"Le montant entre doit etre superieur $100. Reessayer!");
                    }
                } catch (NumberFormatException exception) {
                    JOptionPane.showMessageDialog(view, "Veuillez saisir un montant valide.", "Erreur de saisie", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        view.getWithdrawButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // logique pour l'action le retrait
                System.out.println("bouton Retiré cliqué");
                try{
                    double montant = Double.parseDouble(JOptionPane.showInputDialog(view,"Montant à retirer : "));
                    if(montant > 0 && model.getBalance() >= montant) {
                        Transaction transaction = new Transaction();
                        transaction.setTypeTransaction(Transaction.TransactionType.Retrait.name());
                        transaction.setInvestor(investor);
                        transaction.setDate(LocalDate.now());
                        transaction.setMontant(montant);

                        transaction = transactionDAOImpl.addTransaction(transaction);

                        investor.getTransactions().add(transaction);

                        //model.retirer(montant);
                        view.updateView(investor, model);
                    } else {
                        JOptionPane.showMessageDialog(view,"Le montant entré ne doit pas être négatif ou supérieur au solde actuel. Réessayer!");
                    }
                } catch (NumberFormatException exception) {
                    JOptionPane.showMessageDialog(view, "Veuillez saisir un montant valide.", "Erreur de saisie", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
    }
}
