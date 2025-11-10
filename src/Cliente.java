
import java.util.ArrayList;

/**
 * Matrícula e Nome dos Alunos:
 * - 123456 - Aluno 1
 * - 789012 - Aluno 2
 */
public class Cliente { // [cite: 47]
    private String nome; // [cite: 46]
    private String cpf; // [cite: 46]
    
    // Armazena o histórico de pedidos do cliente
    private ArrayList<Pedido> pedidos;

    public Cliente(String nome, String cpf) { // [cite: 48]
        this.nome = nome;
        this.cpf = cpf;
        this.pedidos = new ArrayList<>();
    }

    public void adicionaPedido(Pedido pedido) { // [cite: 49]
        this.pedidos.add(pedido);
    }

    public String getCpf() {
        return cpf;
    }

    public String getNome() {
        return nome;
    }
}