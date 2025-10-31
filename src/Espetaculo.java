public class Espetaculo{

    private String nome;
    private String data;
    private String hora;
    private double preco;
    private boolean[] assentos = new boolean[50];
    


    public Espetaculo(String nome, String data, String hora, double preco){
        this.nome = nome;
        this.data = data;
        this.hora = hora;
        this.preco = preco;
    }


    public Entrada novaEntrada(int tipo, int assento){

    }


    public void apresentaAssentos(){
        

    }


    private void marcarAssento(int assento){
        
    }

    

    public double getPreco(double preco){
        return preco;
    }

    

    @Override
    public String toString(){

    }



}