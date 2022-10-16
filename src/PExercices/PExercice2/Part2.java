package PExercices.PExercice2;

import javax.swing.*;
import java.awt.*;

public class Part2 {
    public static void Run() {
        System.out.println("\nPart 2 ----------");

        javax.swing.SwingUtilities.invokeLater(Part2::createAndShowGUI);
    }

    private static void createAndShowGUI() {
        JFrame window = new JFrame();
        window.setLocation((int) (240 * 1.5), 120 + 128);
        window.setTitle("BoxLayout");
        window.setSize(560, 200);


        JPanel rootPanel = new JPanel();
        rootPanel.setLayout(new BoxLayout(rootPanel, BoxLayout.Y_AXIS));
        rootPanel.setAlignmentX(Component.CENTER_ALIGNMENT);


        JLabel nameLabel = new JLabel("Nom: ");
        JTextField nameTextField = new JTextField(10);
        nameTextField.setMaximumSize(nameTextField.getPreferredSize());
        JLabel passwordLabel = new JLabel("Password: ");
        JPasswordField passwordTextField = new JPasswordField(10);
        passwordTextField.setMaximumSize(nameTextField.getPreferredSize());

        JButton okBt = new JButton("OK");
        JButton cancelBt = new JButton("Cancel");
        okBt.setPreferredSize(cancelBt.getPreferredSize());
        cancelBt.setPreferredSize(cancelBt.getPreferredSize());

        okBt.addActionListener(e -> {
            String msg = "Vous avez appuyez sur : OK\n";
            msg += "nom : " + nameTextField.getText() + "\n";
            msg += "pwd : " + new String(passwordTextField.getPassword()) + "\n";

            JOptionPane.showMessageDialog(
                    null,
                    msg,
                    "Message",
                    JOptionPane.INFORMATION_MESSAGE
            );
        });

        cancelBt.addActionListener(e -> {
            String msg = "Vous avez appuyez sur : Cancel\n";
            msg += "nom : " + nameTextField.getText() + "\n";
            msg += "pwd : " + new String(passwordTextField.getPassword()) + "\n";

            JOptionPane.showMessageDialog(
                    null,
                    msg,
                    "Message",
                    JOptionPane.INFORMATION_MESSAGE
            );
        });


        JPanel namePanel = new JPanel();
        namePanel.setLayout(new BoxLayout(namePanel, BoxLayout.X_AXIS));
        namePanel.add(nameLabel);
        namePanel.add(nameTextField);

        JPanel passwordPanel = new JPanel();
        passwordPanel.setLayout(new BoxLayout(passwordPanel, BoxLayout.X_AXIS));
        passwordPanel.add(passwordLabel);
        passwordPanel.add(passwordTextField);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.X_AXIS));
        buttonPanel.add(okBt);
        buttonPanel.add(Box.createHorizontalGlue());
        buttonPanel.add(cancelBt);

        rootPanel.add(namePanel);
        rootPanel.add(Box.createRigidArea(new Dimension(0, 8)));
        rootPanel.add(passwordPanel);
        rootPanel.add(Box.createRigidArea(new Dimension(0, 64)));
        rootPanel.add(buttonPanel);

        window.setContentPane(rootPanel);
        window.setVisible(true);
    }
}
