
import java.util.Scanner;

public class Calculadora {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        boolean menu = true;

        while (menu) {
            System.out.println("[1] - Calcular Pre�o Total");
            System.out.println("[2] - Calcular Troco");
            System.out.println("[3] - Sair");

            int escolha = scanner.nextInt();

            switch (escolha) {
                case 1:
                    precoTotal();
                    break;
                case 2:
                    troco();
                    break;
                case 3:
                    menu = false;
                    break;
                default:
                    System.out.println("Erro! Digite uma op��o v�lida!");
            }
        }
    }

    public static void precoTotal() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite o pre�o do produto: ");
        double preco = scanner.nextDouble();
        System.out.println("Digite a quantidade de produtos: ");
        int quantidade = scanner.nextInt();
        double total = preco * quantidade;
        System.out.println("O pre�o total �: " + total);
    }

    public static void troco() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite o valor do produto: ");
        double valor = scanner.nextDouble();
        System.out.println("Digite o valor pago: ");
        double pago = scanner.nextDouble();
        double troco = pago - valor;
        System.out.println("O troco �: " + troco);
    }
}
