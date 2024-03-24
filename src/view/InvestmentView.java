package view;

import model.Investor;
import model.Transaction;

import javax.swing.*;
import java.awt.*;
import java.util.Date;
import java.util.List;

public class InvestmentView extends JDialog {
    private JPanel investmentPanel;
    private final GridBagLayout gbl;
    private final GridBagConstraints gbc;
    private JLabel balanceLabel;
    private final JTextArea transactionsArea;
    private final JButton investButton;
    private final JButton withdrawButton;

    // getters
    public JButton getInvestButton(){
        return investButton;
    }

    public JButton getWithdrawButton(){
        return withdrawButton;
    }

    // constructor
    public InvestmentView(){
        gbl = new GridBagLayout();
        investmentPanel = new JPanel(gbl);
        gbc = new GridBagConstraints();
        transactionsArea = new JTextArea(10,40);
        investButton = new JButton("Investir");
        withdrawButton = new JButton("Retirer");

        // Affichage de la fenêtre principale
        setTitle("Gestion des Investissements");
        setSize(600, 400);
        setLocationRelativeTo(null);
        setResizable(false); // windows not resizable
        setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        setLayout(gbl);

        add(investmentPanel);

        gbc.insets = new Insets(5, 5, 5, 5); // Marge externe pour chaque composant

        // label pour la balance du compte investissseur
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        gbc.fill = GridBagConstraints.NONE;
        balanceLabel = new JLabel("Solde actuel : 0$");
        investmentPanel.add(balanceLabel, gbc);

        // label pour la zone des transactions
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 1;
        gbc.fill = GridBagConstraints.NONE;
        JLabel lblTransaction = new JLabel("Liste des transactions :");
        investmentPanel.add(lblTransaction, gbc);

        // zone d'affichage des transactions
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 3;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        transactionsArea.setEditable(false);
        investmentPanel.add(new JScrollPane(transactionsArea), gbc);

        // bouton "Retirer"
        gbc.gridx = 1;
        gbc.gridy = 4;
        gbc.gridwidth = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        investmentPanel.add(withdrawButton, gbc);

        // Bouton "Investir"
        gbc.gridx = 2;
        gbc.gridy = 4;
        gbc.gridwidth = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        investmentPanel.add(investButton, gbc);
    }

    // method pour mettre a jour le solde des sommes investis
    public void updateBalance(Double balance){
        balanceLabel.setText("Solde actuel: " + balance + "$");
    }

    public void updateView(Investor investor) {
        double solde = 0;
        if(investor != null){
            transactionsArea.setText("");
            for (Transaction t: investor.getTransactions()
                 ) {
                if(t.getTypeTransaction().equals(Transaction.TransactionType.Investissement.name())){
                    solde += t.getMontant();
                } else {
                    solde -= t.getMontant();
                }
                transactionsArea.append(t.getDate().toString() + " : " + t.getTypeTransaction() + " $" + t.getMontant() + "\n");
            }
        }
        balanceLabel.setText("Solde actuel: " + solde + "$");
    }

    // ajout des transactions dans la zone textArea
    public void addTransaction(Date date, double montant, Transaction.TransactionType type){
        String transactionType = type == Transaction.TransactionType.Investissement ? "Investi" : "Retiré";
        transactionsArea.append(date.toString() + " : " + transactionType + " $" + montant + "\n");
    }
}
