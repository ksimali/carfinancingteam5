package controller;

import model.Investment;
import model.Transaction;
import view.InvestmentView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

public class InvestmentController {
    private Investment model;
    private InvestmentView view;

    //constructor
    public InvestmentController(Investment model, InvestmentView view){
        this.model = model;
        this.view = view;

        //Add addActionListener to Buttons
        view.getInvestButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // logique pour l'action investir
                System.out.println("bouton Investir cliqué");
                double montant = Double.parseDouble(JOptionPane.showInputDialog("Montant à Investir :"));
                model.investir(montant);
                view.updateBalance(model.getBalance());
                view.addTransaction(new Date(), montant, Transaction.TransactionType.Investissement);
            }
        });

        view.getWithdrawButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // logique pour l'action le retrait
                System.out.println("bouton Retiré cliqué");
                double montant = Double.parseDouble(JOptionPane.showInputDialog(JOptionPane.showInputDialog("Montant à retirer : ")));
                model.retirer(montant);
                view.updateBalance(model.getBalance());
                view.addTransaction(new Date(), montant, Transaction.TransactionType.Retrait);
            }
        });

        // Initialiser la vue avec les données du modèle
        view.updateBalance(model.getBalance());

    }
}
