public class EntradaInteira extends Entrada {
    public EntradaInteira(int numeroDoAssento, Espetaculo espetaculo) {
        super(numeroDoAssento, espetaculo);
    }

    public double calculaValor() {
        return getEspetaculo().getPreco();
    }
}
