
package fag;

import javax.swing.*;
import java.awt.*;

// Classe da interface gráfica
public class CalculadoraTela extends JFrame {

    private JTextField campoNumero1;
    private JTextField campoNumero2;
    private JLabel resultadoLabel;

    public CalculadoraTela() {
        setTitle("Calculadora Simples");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        JPanel painelEntradas = new JPanel(new GridLayout(2, 2, 5, 5));
        painelEntradas.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        campoNumero1 = new JTextField();
        campoNumero2 = new JTextField();
        painelEntradas.add(new JLabel("Número 1:"));
        painelEntradas.add(campoNumero1);
        painelEntradas.add(new JLabel("Número 2:"));
        painelEntradas.add(campoNumero2);

        JPanel painelBotoes = new JPanel(new GridLayout(1, 4, 5, 5));
        JButton btnSoma = new JButton("+");
        JButton btnSubtrai = new JButton("-");
        JButton btnMultiplica = new JButton("×");
        JButton btnDivide = new JButton("÷");
        painelBotoes.add(btnSoma);
        painelBotoes.add(btnSubtrai);
        painelBotoes.add(btnMultiplica);
        painelBotoes.add(btnDivide);

        resultadoLabel = new JLabel("Resultado: ", SwingConstants.CENTER);
        resultadoLabel.setFont(new Font("Arial", Font.BOLD, 14));
        resultadoLabel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        add(painelEntradas, BorderLayout.NORTH);
        add(painelBotoes, BorderLayout.CENTER);
        add(resultadoLabel, BorderLayout.SOUTH);

        btnSoma.addActionListener(e -> calcular('+'));
        btnSubtrai.addActionListener(e -> calcular('-'));
        btnMultiplica.addActionListener(e -> calcular('*'));
        btnDivide.addActionListener(e -> calcular('/'));
    }

    private double obterNumero(String texto) throws EntradaInvalida {
        try {
            return Double.parseDouble(texto);
        } catch (NumberFormatException e) {
            throw new EntradaInvalida("Digite um número válido.");
        }
    }

    private void calcular(char operador) {
        try {
            double num1 = obterNumero(campoNumero1.getText());
            double num2 = obterNumero(campoNumero2.getText());
            double resultado;

            switch (operador) {
                case '+':
                    resultado = num1 + num2;
                    break;
                case '-':
                    resultado = num1 - num2;
                    break;
                case '*':
                    resultado = num1 * num2;
                    break;
                case '/':
                    if (num2 == 0) {
                        throw new EntradaInvalida("Divisão por zero não é permitida.");
                    }
                    resultado = num1 / num2;
                    break;
                default:
                    throw new EntradaInvalida("Operação inválida.");
            }

            resultadoLabel.setText("Resultado: " + resultado);
        } catch (EntradaInvalida ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }
}
