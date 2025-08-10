package com.example;

import javax.swing.*;
import java.awt.*;

// Custom Exception for Invalid Input
class InvalidInputException extends Exception {
    public InvalidInputException(String message) {
        super(message);
    }
}

public class SinhCalculatorGUI extends JFrame {
    private JTextField inputField;
    private JTextField outputField;
    private JButton calculateButton;
    private JButton clearButton;

    public SinhCalculatorGUI() {
        setTitle("Sinh(x) Calculator");
        setSize(400, 300);
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JLabel heading = new JLabel("Sinh(x) Calculator", javax.swing.SwingConstants.CENTER);
        heading.setFont(new Font("Arial", Font.BOLD, 20));
        add(heading, BorderLayout.NORTH);

        JPanel centerPanel = new JPanel(new GridLayout(2, 2, 10, 10));
        centerPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        JLabel inputLabel = new JLabel("Enter x for sinh(x):");
        centerPanel.add(inputLabel);

        inputField = new JTextField();
        inputField.setToolTipText("Enter a numeric value to calculate sinh(x)");
        inputField.getAccessibleContext().setAccessibleName("Input field for sinh(x)");
        centerPanel.add(inputField);

        calculateButton = new JButton("Calculate");
        calculateButton.setToolTipText("Click to calculate sinh(x) for the input value");
        calculateButton.getAccessibleContext().setAccessibleName("Calculate button");
        centerPanel.add(calculateButton);

        clearButton = new JButton("Clear");
        clearButton.setToolTipText("Click to clear input and output fields");
        clearButton.getAccessibleContext().setAccessibleName("Clear button");
        centerPanel.add(clearButton);

        add(centerPanel, BorderLayout.CENTER);

        outputField = new JTextField();
        outputField.setEditable(false);
        outputField.setFont(new Font("Arial", Font.PLAIN, 14));
        outputField.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(Color.GRAY),
                BorderFactory.createEmptyBorder(5, 5, 5, 5)));
        outputField.setToolTipText("Displays the result or error messages");
        outputField.getAccessibleContext().setAccessibleName("Output field");
        add(outputField, BorderLayout.SOUTH);

        // Set default button so Enter triggers calculate
        getRootPane().setDefaultButton(calculateButton);

        // Allow Enter key press in inputField to trigger calculation
        inputField.addActionListener(e -> calculateButton.doClick());

        // Button Action with error handling and color feedback
        calculateButton.addActionListener(event -> {
            try {
                double inputValue = parseInput(inputField.getText());
                double result = computeSinh(inputValue, 10);
                outputField.setForeground(Color.BLACK);
                outputField.setText("sinh(" + inputValue + ") = " + String.format("%.6f", result));
            } catch (InvalidInputException ex) {
                outputField.setForeground(Color.RED);
                outputField.setText("Error: " + ex.getMessage());
            }
        });

        clearButton.addActionListener(e -> {
            inputField.setText("");
            outputField.setText("");
            outputField.setForeground(Color.BLACK);
        });
    }

    public double computeSinh(double value, int terms) {
        double result = 0.0;
        for (int n = 0; n < terms; n++) {
            int power = 2 * n + 1;
            double numerator = power(value, power);
            double denominator = factorial(power);
            result += numerator / denominator;
        }
        return result;
    }

    // Helper to calculate power
    private double power(double base, int exp) {
        double result = 1.0;
        for (int i = 0; i < exp; i++) {
            result *= base;
        }
        return result;
    }

    // Helper to calculate factorial
    private double factorial(int number) {
        double result = 1.0;
        for (int i = 2; i <= number; i++) {
            result *= i;
        }
        return result;
    }

    // Input parser with validation
    private double parseInput(String input) throws InvalidInputException {
        try {
            return Double.parseDouble(input);
        } catch (NumberFormatException e) {
            throw new InvalidInputException("Please enter a valid numeric value.");
        }
    }

    // Main function
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            SinhCalculatorGUI gui = new SinhCalculatorGUI();
            gui.setVisible(true);
        });
    }
}
