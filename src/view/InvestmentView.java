package view;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class InvestmentView extends JDialog {
    private JPanel investmentPanel;
    private final GridBagLayout gbl;
    private final GridBagConstraints gbc;
    private JLabel balanceLabel;
    private final JTextArea transactionsArea;
    private final JButton investButton;
    private final JButton cashoutButton;

    // constructor
    public InvestmentView(){
        gbl = new GridBagLayout();
        investmentPanel = new JPanel(gbl);
        gbc = new GridBagConstraints();
        transactionsArea = new JTextArea(10,40);
        investButton = new JButton("Investir");
        cashoutButton = new JButton("Retirer");

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
        JLabel lblTransaction = new JLabel("liste des transactions");
        investmentPanel.add(lblTransaction, gbc);

        // zone d'affichage des transactions
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 3;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        transactionsArea.setEditable(false);
        investmentPanel.add(transactionsArea, gbc);

        // bouton "Retirer"
        gbc.gridx = 1;
        gbc.gridy = 4;
        gbc.gridwidth = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        investmentPanel.add(cashoutButton, gbc);

        // Bouton "Investir"
        gbc.gridx = 2;
        gbc.gridy = 4;
        gbc.gridwidth = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        investmentPanel.add(investButton, gbc);
    }

    // method pour afficher le solde des sommes investis
    public void setBalance(Double balance){
        balanceLabel.setText("Solde actuel: " + balance + "$");
    }

    // method pour afficher les transactions
    public void setTransactions(List<String> transactions){
        transactionsArea.setText(""); // clear les transaction préexistantes
        // afficher la liste des transactions
        for(String transaction : transactions){
            transactionsArea.append(transaction + "\n");
        }
    }
}
