import java.util.ArrayList;

public class Teatro{
    private Pedido carrinho = null;
    private Espetaculo espetaculoSelecionado = null;
    private  ArrayList <Espetaculo> espetaculos;
    private ArrayList <Cliente> clientes;


    public Teatro(){
        espetaculos = new ArrayList<>();
        clientes = new ArrayList<>(); 
    }

    public void novaCompra(){

    }

    public void apresentaEspetaculos(){

    }

    public void selecionaEspetaculo(int numero){

    }

    public void novaEntrada(int tipo, int assento){

    }

    public double finalizaCompra(String cpf){
        
    }

    public void cadastrarEspetaculo(Espetaculo espetaculo){
        espetaculos.add(espetaculo);

    }
    
    public void cadastrarCliente(Cliente cliente){
        clientes.add(cliente);
    }

    
}