package program;

import javax.swing.*;

public class QuickStart {

    private static void createAndShowGUI() {
        // Create and set up the window.
        JFrame.setDefaultLookAndFeelDecorated(true);

        JFrame frame = new JFrame("Thingamajig");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        // Panel
        MyPanel myPanel = new MyPanel();
        frame.getContentPane().add(myPanel);
 
        //Display the window.
        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }
}