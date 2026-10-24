package main;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        JFrame window = new JFrame();
        JPanel panel = new JPanel();

        panel.setLayout(null);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setResizable(false);
        window.setTitle("Calculator");

        CalculatorPanel calculatorPanel = new CalculatorPanel();
        window.add(calculatorPanel);

        window.pack();

        window.setLocationRelativeTo(null);
        window.setVisible(true);

        calculatorPanel.setupCalculator();
        calculatorPanel.startThread();
    }
}
