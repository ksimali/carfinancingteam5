package view;

import javax.swing.*;

public class StatusView extends JDialog {
    public StatusView(JFrame parent) {
        super(parent, "Financing Request Status", true);

        setSize(400, 300);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationRelativeTo(parent);

        JLabel titleLabel = new JLabel("Financing Request Status");
        JLabel statusLabel = new JLabel("Status: In Progress");
        JProgressBar progressBar = new JProgressBar();
        progressBar.setValue(20);
        JButton closeButton = new JButton("Close");
        JButton modifyButton = new JButton("Modifier la demande");
        modifyButton.setEnabled(false);

        JPanel contentPane = new JPanel();
        contentPane.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.Y_AXIS));
        contentPane.add(titleLabel);
        contentPane.add(statusLabel);
        contentPane.add(progressBar);
        contentPane.add(Box.createVerticalStrut(10));
        contentPane.add(modifyButton);
        contentPane.add(closeButton);

        setContentPane(contentPane);

        closeButton.addActionListener(e -> dispose());
    }
}