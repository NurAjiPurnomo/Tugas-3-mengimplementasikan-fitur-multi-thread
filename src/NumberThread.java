/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import javax.swing.*;
/**
 *
 * @author ASUS
 */
public class NumberThread extends Thread {
    private JTextArea textArea;
    
    public NumberThread(JTextArea textArea) {
        this.textArea = textArea;
    }

    @Override
    public void run() {
        try {
            for (int i = 1; i <= 100; i++) {
                if (Thread.interrupted()) {
                    throw new InterruptedException();
                }
                textArea.append("Number: " + i + "\n");
                Thread.sleep(100); // Kurangi waktu delay jadi 0.1 detik
            }
            textArea.append("Counting finished!\n");
        } catch (InterruptedException e) {
            textArea.append("Thread interrupted!\n");
        }
    }
}