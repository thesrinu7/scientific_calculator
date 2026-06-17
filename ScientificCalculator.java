import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ScientificCalculator extends JFrame implements ActionListener {

    JTextField textField;
    double num1, num2, result;
    String operator;

    public ScientificCalculator() {
        setTitle("Scientific Calculator");
        setSize(450, 550);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        textField = new JTextField();
        textField.setFont(new Font("Arial", Font.BOLD, 24));
        add(textField, BorderLayout.NORTH);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(6, 4, 5, 5));

        String[] buttons = {
                "7", "8", "9", "/",
                "4", "5", "6", "*",
                "1", "2", "3", "-",
                "0", ".", "=", "+",
                "sin", "cos", "tan", "√",
                "log", "x²", "C", "%"
        };

        for (String text : buttons) {
            JButton button = new JButton(text);
            button.setFont(new Font("Arial", Font.BOLD, 18));
            button.addActionListener(this);
            panel.add(button);
        }

        add(panel, BorderLayout.CENTER);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();

        try {
            if ("0123456789.".contains(command)) {
                textField.setText(textField.getText() + command);
            }
            else if ("+-*/".contains(command)) {
                num1 = Double.parseDouble(textField.getText());
                operator = command;
                textField.setText("");
            }
            else if (command.equals("=")) {
                num2 = Double.parseDouble(textField.getText());

                switch (operator) {
                    case "+":
                        result = num1 + num2;
                        break;
                    case "-":
                        result = num1 - num2;
                        break;
                    case "*":
                        result = num1 * num2;
                        break;
                    case "/":
                        result = num1 / num2;
                        break;
                }
                textField.setText(String.valueOf(result));
            }
            else if (command.equals("sin")) {
                num1 = Double.parseDouble(textField.getText());
                textField.setText(String.valueOf(Math.sin(Math.toRadians(num1))));
            }
            else if (command.equals("cos")) {
                num1 = Double.parseDouble(textField.getText());
                textField.setText(String.valueOf(Math.cos(Math.toRadians(num1))));
            }
            else if (command.equals("tan")) {
                num1 = Double.parseDouble(textField.getText());
                textField.setText(String.valueOf(Math.tan(Math.toRadians(num1))));
            }
            else if (command.equals("√")) {
                num1 = Double.parseDouble(textField.getText());
                textField.setText(String.valueOf(Math.sqrt(num1)));
            }
            else if (command.equals("log")) {
                num1 = Double.parseDouble(textField.getText());
                textField.setText(String.valueOf(Math.log10(num1)));
            }
            else if (command.equals("x²")) {
                num1 = Double.parseDouble(textField.getText());
                textField.setText(String.valueOf(num1 * num1));
            }
            else if (command.equals("%")) {
                num1 = Double.parseDouble(textField.getText());
                textField.setText(String.valueOf(num1 / 100));
            }
            else if (command.equals("C")) {
                textField.setText("");
            }
        } catch (Exception ex) {
            textField.setText("Error");
        }
    }

    public static void main(String[] args) {
        new ScientificCalculator();
    }
}