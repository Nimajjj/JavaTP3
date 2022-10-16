package PExercices.PExercice2;
// TP 3-2 : Graphique -> JButton

import javax.swing.*;
import java.awt.*;
import java.util.Objects;

public class Part1 {
    public static void Run() {
        System.out.println("\nPart 1 ----------");

        javax.swing.SwingUtilities.invokeLater(Part1::createAndShowGUI);
    }

    private static void createAndShowGUI() {
        JFrame window = new JFrame();
        window.setLocation((int) (240 * 1.5), 120 + 128);
        window.setTitle("Test des boutons");
        window.setSize(320*2, 320-50);


        JPanel rootPanel = new JPanel();
        rootPanel.setAlignmentX(Component.CENTER_ALIGNMENT);


        JButton bt1 = new JButton("Boutton simple");
        JButton bt2 = new JButton("Bouton fantaisie", new ImageIcon("ressource/duck.jpg"));

        //add event listener to each button
        bt1.addActionListener(e -> {
            // open a dialog box with a message and a title
            JOptionPane.showMessageDialog(null, "Vous avez appuyé sur : Bouton simple", "Message", JOptionPane.INFORMATION_MESSAGE);
        });

        bt2.addActionListener(e -> {
            JOptionPane.showMessageDialog(null, "Vous avez appuyé sur : Bouton fantaisie", "Message", JOptionPane.INFORMATION_MESSAGE);

            //bt2.setIcon(new ImageIcon("ressource/duck2.jpg"));

            if (Objects.equals(bt2.getIcon().toString(), "ressource/duck.jpg")) {
                bt2.setIcon(new ImageIcon("ressource/duck2.jpg"));
            } else {
                bt2.setIcon(new ImageIcon("ressource/duck.jpg"));
            }
        });


        rootPanel.add(bt1);
        rootPanel.add(bt2);

        window.setContentPane(rootPanel);

        window.setVisible(true);
    }


}
