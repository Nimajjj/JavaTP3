package PExercices.PExercice2;

import javax.swing.*;
import java.awt.*;
import java.io.File;

public class Part3 {
    private static String[] cardsPath;
    public static void Run() {
        System.out.println("\nPart 3 ----------");

        javax.swing.SwingUtilities.invokeLater(Part3::createAndShowGUI);

        initCardsList();
    }

    private static void createAndShowGUI() {
        JFrame window = new JFrame();
        window.setLocation((int) (240 * 1.5), 120 + 128);
        window.setTitle("BoxLayout");
        window.setSize(640, 300);

        JPanel rootPanel = new JPanel();
        rootPanel.setLayout(new BoxLayout(rootPanel, BoxLayout.Y_AXIS));

        Canvas canvas = new Canvas();
        canvas.setSize(window.getSize());


        JButton bt = new JButton("Afficher carte");
        bt.addActionListener(e -> {
            // loop which iterate 3 times
            for (int i = 0; i < 3; i++) {
                int index = (int) (Math.random() * cardsPath.length);
                String path = "ressource/cards/" + cardsPath[index];
                Image cardImage = new ImageIcon(path).getImage();
                Image resizedCardImage = cardImage.getScaledInstance(691/5, 1056/5,  java.awt.Image.SCALE_SMOOTH);

                canvas.getGraphics().drawImage(new ImageIcon(resizedCardImage).getImage(), i * (691/3) + i*8, 0, rootPanel);
            }
        });

        rootPanel.add(bt);
        rootPanel.add(canvas);


        window.setContentPane(rootPanel);
        window.setVisible(true);
    }

    private static void initCardsList() {
        File directoryPath = new File("ressource/cards");
        cardsPath = directoryPath.list();
    }
}
