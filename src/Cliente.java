package teatro;

import java.util.ArrayList;
import java.util.List;

public class Cliente {
    private String nome;
    private String cpf;
    private List<Pedido> pedidos = new ArrayList<>();

    public Cliente(String nome, String cpf) {
        this.nome = nome;
        this.cpf = cpf;
    }

    public void adicionaPedido(Pedido pedido) {
        if (pedido != null) pedidos.add(pedido);
    }

    public String getCpf() { 
        return cpf; 
    }
}
