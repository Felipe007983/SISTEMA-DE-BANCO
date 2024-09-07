import java.util.Scanner;

public class Main {  // Alterei o nome da classe principal para Main
    // Classe interna ContaBancaria
    static class ContaBancaria {
        private String titular;
        private double saldo;

        public ContaBancaria(String titular) {
            this.titular = titular;
            this.saldo = 0.0;  // Inicialmente, o saldo é 0
        }

        public void depositar(double valor) {
            if (valor > 0) {
                saldo += valor;
                System.out.println("Depósito de R$" + valor + " realizado com sucesso.");
            } else {
                System.out.println("O valor de depósito deve ser maior que zero.");
            }
        }

        public void sacar(double valor) {
            if (valor > 0 && valor <= saldo) {
                saldo -= valor;
                System.out.println("Saque de R$" + valor + " realizado com sucesso.");
            } else {
                System.out.println("Saque não realizado. Verifique o valor solicitado.");
            }
        }

        public double consultarSaldo() {
            return saldo;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Digite o nome do titular da conta: ");
        String titular = scanner.nextLine();

        ContaBancaria conta = new ContaBancaria(titular);

        int opcao;
        do {
            System.out.println("\n--- Banco Simulado ---");
            System.out.println("1. Consultar Saldo");
            System.out.println("2. Depositar");
            System.out.println("3. Sacar");
            System.out.println("4. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    System.out.println("Saldo atual: R$" + conta.consultarSaldo());
                    break;
                case 2:
                    System.out.print("Digite o valor para depositar: R$");
                    double valorDeposito = scanner.nextDouble();
                    conta.depositar(valorDeposito);
                    break;
                case 3:
                    System.out.print("Digite o valor para sacar: R$");
                    double valorSaque = scanner.nextDouble();
                    conta.sacar(valorSaque);
                    break;
                case 4:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        } while (opcao != 4);

        scanner.close();
        System.out.println("Obrigado por usar o banco simulado!");
    }
}
