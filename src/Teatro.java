import java.util.ArrayList;
import java.util.List;

public class Teatro {
    private Pedido carrinho = null;
    private Espetaculo espetaculoSelecionado = null;
    private List<Espetaculo> espetaculos = new ArrayList<>();
    private List<Cliente> clientes = new ArrayList<>();

    public Teatro() {}

    public void novaCompra() {
        carrinho = new Pedido();
        espetaculoSelecionado = null;
    }

    public void apresentaEspectaculos() {
        int i = 1;
        for (Espetaculo e : espetaculos) {
            System.out.println(i + ") " + e.toString());
            i++;
        }
    }

    public void selecionaEspetaculo(int numero) {
        if (numero >= 1 && numero <= espetaculos.size())
            espetaculoSelecionado = espetaculos.get(numero - 1);
    }

    public void novaEntrada(int tipo, int assento) {
        if (espetaculoSelecionado == null || carrinho == null) return;
        Entrada en = espetaculoSelecionado.novaEntrada(tipo, assento);
        if (en != null) carrinho.adicionaEntrada(en);
    }

    public double finalizaCompra(String cpf) {
        if (carrinho == null) return 0.0;
        Cliente cliente = buscarClientePorCPF(cpf);
        if (cliente == null) {
            carrinho = null;
            espetaculoSelecionado = null;
            return -1.0;
        }
        cliente.adicionaPedido(carrinho);
        for (Entrada e : carrinho.getEntradas())
            e.getEspetaculo().marcarAssento(e.getNumeroDoAssento());
        double total = carrinho.calculaValorTotal();
        carrinho = null;
        espetaculoSelecionado = null;
        return total;
    }

    public void adicionaEspetaculo(Espetaculo e) { 
        espetaculos.add(e); 
    }
    public void adicionaCliente(Cliente c) {
         clientes.add(c); 
    }

    public Cliente buscarClientePorCPF(String cpf) {
        for (Cliente c : clientes) if (c.getCpf().equals(cpf)) return c;
        return null;
    }

    public List<Espetaculo> getEspetaculos() { 
        return espetaculos; 
    }
    public List<Cliente> getClientes() { 
        return clientes; 
    }
}
