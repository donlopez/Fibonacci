package cop2805;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.net.*;

public class FibonacciClient {
    private JFrame frame;
    private JTextField textField;
    private JLabel resultLabel;

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                FibonacciClient window = new FibonacciClient();
                window.frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    public FibonacciClient() {
        initialize();
    }

    private void initialize() {
        frame = new JFrame();
        frame.setBounds(100, 100, 450, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(new GridLayout(2, 2, 10, 10));

        JLabel lblEnterNumber = new JLabel("Enter a positive number or 'shutdown':");
        frame.getContentPane().add(lblEnterNumber);

        textField = new JTextField();
        frame.getContentPane().add(textField);
        textField.setColumns(10);

        JButton btnCalculate = new JButton("Calculate");
        btnCalculate.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                calculateFibonacci();
            }
        });
        frame.getContentPane().add(btnCalculate);

        resultLabel = new JLabel("");
        frame.getContentPane().add(resultLabel);
    }

    private void calculateFibonacci() {
        String number = textField.getText();
        try {
            try (Socket socket = new Socket("localhost", 5050);
                 PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
                 BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {
                out.println(number);
                String response = in.readLine();
                resultLabel.setText("Response: " + response);
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        } catch (NumberFormatException ex) {
            resultLabel.setText("Invalid input. Please enter a positive integer.");
        }
    }
}