public class EntradaMeia{
    private double entradaMeia;
    
    public double calcularValor () {
        entradaMeia = Espetaculo.getPreco * 0.50;
        return entradaMeia;
    }
}