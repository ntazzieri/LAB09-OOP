package it.unibo.mvc;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 * A very simple program using a graphical interface.
 * 
 */
public final class SimpleGUI {

    private final JFrame frame = new JFrame();
    private static final int PROPORTION = 5;
    private final Controller controller = new SimpleController();

    /**
     * Builds SimpleGUI interface.
     */
    public SimpleGUI() {
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Print on console");
        final JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());
        final JTextArea textArea = new JTextArea();
        final JTextField textField = new JTextField();
        textArea.setEditable(false);
        final JButton print = new JButton("Print");
        final JButton showHistory = new JButton("Show history");
        final JPanel southPanel = new JPanel();
        southPanel.setLayout(new BorderLayout());
        southPanel.add(print, BorderLayout.WEST);
        southPanel.add(showHistory, BorderLayout.EAST);
        mainPanel.add(textField, BorderLayout.NORTH);
        mainPanel.add(textArea, BorderLayout.CENTER);
        mainPanel.add(southPanel, BorderLayout.SOUTH);
        frame.add(mainPanel);
        print.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent e) {
                controller.setStringToPrint(textField.getText());
                controller.print();
            }
        });
        showHistory.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent e) {
                textArea.setText("");
                for (final String printedStr : controller.getPrintHistory()) {
                    textArea.setText(printedStr + "\n" + textArea.getText());
                }
            }
        });
    }

    /**
     * Displays SimpleGUI.
     */
    public void display() {
        final Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
        final int sw = (int) screen.getWidth();
        final int sh = (int) screen.getHeight();
        frame.setSize(sw / PROPORTION, sh / PROPORTION);
        frame.setLocationByPlatform(true);
        frame.setVisible(true);
    }

    /**
     * Main.
     * @param args
     */
    public static void main(final String[] args) {
        new SimpleGUI().display();
    }
}
