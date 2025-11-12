
import java.util.Locale;
import java.util.Scanner;

/**
 * Matrícula e Nome dos Alunos:
 * - 123456 - Aluno 1
 * - 789012 - Aluno 2
 */
public class Main {

    public static void main(String[] args) {
        // Define o Locale para US para garantir que o ponto seja usado como separador decimal
        Locale.setDefault(Locale.US);
        Scanner scanner = new Scanner(System.in);
        Teatro mackTheater = new Teatro();
        String entrada = scanner.nextLine();

        int opcao; // Não é mais necessário inicializar com 0

        // Loop DO-WHILE: Garante que o menu execute pelo menos uma vez
        do {
            System.out.println("\n*** MACK THEATHER ***"); //
            System.out.println("1) Cadastrar Espetáculo"); //
            System.out.println("2) Cadastrar Cliente"); //
            System.out.println("3) Compra de Entradas"); //
            System.out.println("4) Sair"); //
            System.out.print("Selecione uma opção: "); //

            // Tratamento de exceção básico para entrada não numérica
            

            if (entrada.matches("\\d+")) { // se for só número
                opcao = Integer.parseInt(entrada);
            } else { // se tiver letra ou símbolo
                opcao = 0;
            }


            switch (opcao) {
                case 1:
                    cadastrarEspetaculo(mackTheater, scanner);
                    break;
                case 2:
                    cadastrarCliente(mackTheater, scanner);
                    break;
                case 3:
                    comprarEntradas(mackTheater, scanner);
                    break;
                case 4:
                    System.out.println("Saindo do sistema...");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        } while (opcao != 4); // A condição é verificada no final do loop

        scanner.close();
    }

    /**
     * Fluxo para cadastrar um novo espetáculo.
     * (Este método não muda)
     */
    private static void cadastrarEspetaculo(Teatro teatro, Scanner scanner) {
        System.out.println("\n*** CADASTRO DE ESPETÁCULO ***"); //
        System.out.print("Nome do Espetáculo: ");
        String nome = scanner.nextLine();
        System.out.print("Data: ");
        String data = scanner.nextLine();
        System.out.print("Hora: ");
        String hora = scanner.nextLine();
        System.out.print("Preço da Entrada Inteira: ");
        double preco = Double.parseDouble(scanner.nextLine());

        teatro.cadastrarEspetaculo(nome, data, hora, preco); //
        System.out.println("\n>>> Retornar ao menu principal <<<"); //
    }

    /**
     * Fluxo para cadastrar um novo cliente.
     * (Este método não muda)
     */
    private static void cadastrarCliente(Teatro teatro, Scanner scanner) {
        System.out.println("\n*** CADASTRO DE CLIENTE ***"); //
        System.out.print("Nome do Cliente: ");
        String nome = scanner.nextLine();
        System.out.print("CPF: ");
        String cpf = scanner.nextLine();

        teatro.cadastrarCliente(nome, cpf); //
        System.out.println("\n>>> Retornar ao menu principal <<<<<"); //
    }

    /**
     * Fluxo principal para a compra de entradas.
     * (Este método não muda)
     */
    private static void comprarEntradas(Teatro teatro, Scanner scanner) {
        System.out.println("\n*** VENDA DE ENTRADAS ESPETÁCULOS ***"); //
        
        teatro.novaCompra(); //
        teatro.apresentaEspetaculos(); //

        if (!teatro.temEspetaculos()) {
            System.out.println("Nenhum espetáculo cadastrado.");
            System.out.println("\n>>> Retornar ao menu principal <<<<<");
            return;
        }

        System.out.print("Selecione um espetáculo: ");
        int numEspetaculo = Integer.parseInt(scanner.nextLine());
        teatro.selecionaEspetaculo(numEspetaculo); //

        String maisEntrada;
        do {
            System.out.print("Selecione um assento: "); //
            int assento = Integer.parseInt(scanner.nextLine());

            System.out.println("||| Tipos de Entrada ||"); //
            System.out.println("1) Inteira");
            System.out.println("2) Meia"); //
            System.out.println("3) Professor"); //
            System.out.print("Selecione um tipo de entrada: "); //
            int tipo = Integer.parseInt(scanner.nextLine());

            teatro.novaEntrada(tipo, assento); //

            System.out.print("Deseja comprar outra entrada (S/N)? "); //
            maisEntrada = scanner.nextLine();

            if (maisEntrada.equalsIgnoreCase("S")) {
                System.out.println("\n||| Assentos Disponíveis |||"); //
                teatro.apresentaAssentosDoSelecionado(); // Mostra assentos atualizados
            }

        } while (maisEntrada.equalsIgnoreCase("S"));

        System.out.print("Informe o CPF do Cliente Cadastrado: "); //
        String cpf = scanner.nextLine();

        double valorTotal = teatro.finalizaCompra(cpf); //

        if (valorTotal == -1) {
            System.out.println("Cliente não cadastrado. A compra não pode ser finalizada.");
        } else {
            System.out.printf("Valor Total: R$ %.2f\n", valorTotal); //
        }

        System.out.println("\n>>> Retornar ao menu principal <<<<<"); //
    }
}