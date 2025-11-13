package teatro;

public class EntradaMeia extends Entrada {
    public EntradaMeia(int numeroDoAssento, Espetaculo espetaculo) {
        super(numeroDoAssento, espetaculo);
    }

    public double calculaValor() {
        return espetaculo.getPreco() * 0.5;
    }
}
