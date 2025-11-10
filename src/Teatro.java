
import java.util.ArrayList;

/**
 * Matrícula e Nome dos Alunos:
 * - 123456 - Aluno 1
 * - 789012 - Aluno 2
 */
public class Teatro {
    private Pedido carrinho; // [cite: 40]
    private Espetaculo espetaculoSelecionado; // [cite: 41]
    
    // Atributos adicionados para armazenar os dados do sistema
    private ArrayList<Espetaculo> espetaculos;
    private ArrayList<Cliente> clientes;

    public Teatro() { // [cite: 42]
        this.espetaculos = new ArrayList<>();
        this.clientes = new ArrayList<>();
        this.carrinho = null;
        this.espetaculoSelecionado = null;
    }

    // --- Métodos de Cadastro (Funcionalidades Iniciais) ---
    
    public void cadastrarEspetaculo(String nome, String data, String hora, double preco) { // [cite: 13]
        Espetaculo novo = new Espetaculo(nome, data, hora, preco);
        this.espetaculos.add(novo);
        System.out.println("Espetáculo cadastrado com sucesso!");
    }

    public void cadastrarCliente(String nome, String cpf) { // [cite: 14]
        // Verifica se o cliente já existe
        if (getClientePorCpf(cpf) != null) {
            System.out.println("Erro: CPF já cadastrado.");
            return;
        }
        Cliente novo = new Cliente(nome, cpf);
        this.clientes.add(novo);
        System.out.println("Cliente cadastrado com sucesso!");
    }

    // --- Métodos do Fluxo de Compra ---
    
    public void novaCompra() { // [cite: 43]
        this.carrinho = new Pedido(); // [cite: 70]
        this.espetaculoSelecionado = null;
    }

    public void apresentaEspetaculos() { // [cite: 44]
        for (int i = 0; i < espetaculos.size(); i++) {
            // [cite: 131] Utiliza o índice + 1 como número
            System.out.println((i + 1) + ") " + espetaculos.get(i).toString());
        }
    }

    public boolean temEspetaculos() {
        return !espetaculos.isEmpty();
    }

    public void selecionaEspetaculo(int numero) { // [cite: 45]
        // Ajusta para o índice (0-based)
        int indice = numero - 1;
        if (indice >= 0 && indice < espetaculos.size()) {
            this.espetaculoSelecionado = espetaculos.get(indice);
            this.espetaculoSelecionado.apresentaAssentos(); // [cite: 74]
        } else {
            System.out.println("Número de espetáculo inválido.");
        }
    }
    
    public void apresentaAssentosDoSelecionado() {
        if (this.espetaculoSelecionado != null) {
            this.espetaculoSelecionado.apresentaAssentos();
        }
    }

    public void novaEntrada(int tipo, int assento) { // [cite: 45]
        if (this.espetaculoSelecionado == null) {
            System.out.println("Erro: Nenhum espetáculo selecionado.");
            return;
        }
        if (this.carrinho == null) {
            System.out.println("Erro: Nenhuma compra iniciada.");
            return;
        }

        // Cria a entrada (polimorfismo)
        Entrada entrada = this.espetaculoSelecionado.novaEntrada(tipo, assento); // [cite: 80, 93]
        
        if (entrada != null) {
            this.carrinho.adicionaEntrada(entrada); // [cite: 83]
            System.out.println("Entrada adicionada ao carrinho.");
        } else {
            System.out.println("Não foi possível adicionar a entrada (tipo inválido ou assento ocupado).");
        }
    }

    public double finalizaCompra(String cpf) { // [cite: 45]
        Cliente cliente = getClientePorCpf(cpf);

        if (cliente == null) {
            System.out.println("Erro: Cliente com CPF " + cpf + " não encontrado.");
            return -1; // Retorna -1 para indicar erro
        }

        cliente.adicionaPedido(this.carrinho); // [cite: 49, 84]
        double valorTotal = this.carrinho.calculaValorTotal(); // [cite: 56, 85]

        // Limpa o carrinho e seleção
        this.carrinho = null;
        this.espetaculoSelecionado = null;

        return valorTotal;
    }

    // --- Métodos Auxiliares ---
    
    private Cliente getClientePorCpf(String cpf) {
        for (Cliente cliente : clientes) {
            if (cliente.getCpf().equals(cpf)) {
                return cliente;
            }
        }
        return null;
    }
}