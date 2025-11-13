package teatro;

import java.util.ArrayList;
import java.util.List;

public class Pedido {
    private List<Entrada> entradas = new ArrayList<>();

    public Pedido() {}

    public void adicionaEntrada(Entrada entrada) {
        if (entrada != null) entradas.add(entrada);
    }

    public double calculaValorTotal() {
        double total = 0;
        for (Entrada e : entradas) total += e.calculaValor();
        return total;
    }

    public List<Entrada> getEntradas() { 
        return entradas; 
    }
}
