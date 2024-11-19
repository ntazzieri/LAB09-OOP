package it.unibo.mvc;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;

/**
 * A very simple program using a graphical interface.
 * 
 */
public final class SimpleGUIWithFileChooser {

    private final JFrame frame = new JFrame();
    private final Controller controller;

    public SimpleGUIWithFileChooser(Controller c) {
        this.controller = c;
        JPanel fileChooserPanel = new JPanel();
        fileChooserPanel.setLayout(new BorderLayout());
        JTextField fileTextField = new JTextField();
        JButton browse = new JButton("Browse");
        fileTextField.setFocusable(false);
        fileChooserPanel.add(fileTextField, BorderLayout.CENTER);
        fileChooserPanel.add(browse, BorderLayout.LINE_END);
        fileTextField.setText(this.controller.getCurrentFilePath());
        browse.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent e) {
                JFileChooser fChooser = new JFileChooser(controller.getCurrentFile());
                int fChooserResult = fChooser.showSaveDialog(fileChooserPanel);
                if (fChooserResult == JFileChooser.APPROVE_OPTION) {
                    c.setCurrentFile(fChooser.getSelectedFile());
                    fileTextField.setText(fChooser.getSelectedFile().getAbsolutePath());
                } else if (fChooserResult != JFileChooser.CANCEL_OPTION) {
                    JOptionPane.showMessageDialog(browse, "An error has occurred", "ERROR", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
    }
}
