/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author ASUS
 */
public class MultiThreadApp extends JFrame {
    private JButton startButton, stopButton;
    private JTextArea textArea;
    private NumberThread numberThread;

    public MultiThreadApp() {
        setTitle("Thread Example");
        setSize(400, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        startButton = new JButton("Start");
        stopButton = new JButton("Stop");
        textArea = new JTextArea();
        textArea.setEditable(false);

        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                startCounting();
            }
        });

        stopButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                stopCounting();
            }
        });

        JPanel panel = new JPanel();
        panel.add(startButton);
        panel.add(stopButton);

        setLayout(new BorderLayout());
        add(panel, BorderLayout.NORTH);
        add(new JScrollPane(textArea), BorderLayout.CENTER);
    }

    private void startCounting() {
        if (numberThread == null || !numberThread.isAlive()) {
            textArea.setText("Counting...\n");
            numberThread = new NumberThread(textArea);
            numberThread.start();
        }
    }

    private void stopCounting() {
        if (numberThread != null && numberThread.isAlive()) {
            numberThread.interrupt();
            textArea.append("Counting stopped!\n");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new MultiThreadApp().setVisible(true));
    }
}