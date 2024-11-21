package it.unibo.mvc;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 * A very simple program using a graphical interface.
 * 
 */
public final class SimpleGUIWithFileChooser {

    private static final int PROPORTION = 5;
    private final JFrame frame = new JFrame();
    private final Controller controller = new Controller();

    /**
     * Builds a SimpleGUIWithFileChooser.
     */
    public SimpleGUIWithFileChooser() {
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("My second java graphical interface");
        final JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());
        final JTextArea textArea = new JTextArea();
        final JButton save = new JButton("Save");
        mainPanel.add(textArea, BorderLayout.CENTER);
        mainPanel.add(save, BorderLayout.SOUTH);
        frame.add(mainPanel);
        save.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent e) {
                try {
                    controller.writeOnCurrentFile(textArea.getText());
                } catch (final IOException e1) {
                    JOptionPane.showMessageDialog(mainPanel, e1, "IO ERROR", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        final JPanel fileChooserPanel = new JPanel();
        fileChooserPanel.setLayout(new BorderLayout());
        final JTextField fileTextField = new JTextField();
        final JButton browse = new JButton("Browse...");
        fileTextField.setEditable(false);
        fileChooserPanel.add(fileTextField, BorderLayout.CENTER);
        fileChooserPanel.add(browse, BorderLayout.LINE_END);
        fileTextField.setText(this.controller.getCurrentFilePath());
        browse.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent e) {
                final JFileChooser fChooser = new JFileChooser(controller.getCurrentFile());
                final int fChooserResult = fChooser.showSaveDialog(fileChooserPanel);
                if (fChooserResult == JFileChooser.APPROVE_OPTION) {
                    controller.setCurrentFile(fChooser.getSelectedFile());
                    fileTextField.setText(fChooser.getSelectedFile().getAbsolutePath());
                } else if (fChooserResult != JFileChooser.CANCEL_OPTION) {
                    JOptionPane.showMessageDialog(browse, "An error has occurred", "ERROR", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        mainPanel.add(fileChooserPanel, BorderLayout.NORTH);
    }

    /**
     * Displays the Simple GUI with file chooser.
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
        new SimpleGUIWithFileChooser().display();
    }
}
