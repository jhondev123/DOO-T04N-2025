package fag;

import javax.swing.SwingUtilities;

public class CalculadoraApp {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            CalculadoraTela calculadora = new CalculadoraTela();
            calculadora.setVisible(true);
        });
    }
}