package PExercices.PExercice2;

import javax.swing.*;
import java.awt.*;

public class Exercice2 {
    public static void Run() {
        System.out.println("\n\nExercice 2 --------------------");
        System.out.println("See GUI for results");

        javax.swing.SwingUtilities.invokeLater(Exercice2::createAndShowGUI);
    }

    private static void createAndShowGUI() {
        JFrame window = new JFrame();
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);      // WARNING : to move once the tp is done
        window.setLocation(240, 120);
        window.setTitle("Exercice 2 - Borello");
        window.setSize(320, 128);


        JPanel rootPanel = new JPanel();
        rootPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        rootPanel.setAlignmentY(Component.CENTER_ALIGNMENT);

        JButton bt1 = new JButton("JButton");
        JButton bt2 = new JButton("BoxLayout");
        JButton bt3 = new JButton("Afficher carte");

        bt1.setMaximumSize(bt3.getPreferredSize());
        bt2.setMaximumSize(bt3.getPreferredSize());
        bt3.setMaximumSize(bt3.getPreferredSize());

        //add event listener to each button
        bt1.addActionListener(e -> {
            Part1.Run();
        });

        bt2.addActionListener(e -> {
            Part2.Run();
        });

        bt3.addActionListener(e -> {
            Part3.Run();
        });

        rootPanel.add(bt1);
        rootPanel.add(bt2);
        rootPanel.add(bt3);

        window.setContentPane(rootPanel);

        window.setVisible(true);
    }
}

