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
    private JTextArea outputArea;
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

        JPanel centerPanel = new JPanel(new GridLayout(2, 2, 2, 2));
        centerPanel.setBorder(BorderFactory.createEmptyBorder(2, 2, 2, 2));

        centerPanel.add(new JLabel("Enter x for sinh(x):"));
        inputField = new JTextField();
        centerPanel.add(inputField);

        calculateButton = new JButton("Calculate");
        clearButton = new JButton("Clear");

        centerPanel.add(calculateButton);
        centerPanel.add(clearButton);
        add(centerPanel, BorderLayout.CENTER);

        outputArea = new JTextArea();
        outputArea.setEditable(false);
        outputArea.setMargin(new Insets(5, 5, 5, 5));
        add(new JScrollPane(outputArea), BorderLayout.SOUTH);

        // Button Action
        calculateButton.addActionListener(event -> {
            try {
                double inputValue = parseInput(inputField.getText());
                double result = computeSinh(inputValue, 10);
                outputArea.setText("sinh(" + inputValue + ") = " + String.format("%.6f", result));
            } catch (InvalidInputException ex) {
                outputArea.setText("Error: " + ex.getMessage());
            }
        });

        clearButton.addActionListener(e -> {
            inputField.setText("");
            outputArea.setText("");
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

    //Helper to calculate power
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
            }
        );
    }
}
