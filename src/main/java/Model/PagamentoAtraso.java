package Model;


public class PagamentoAtraso implements PagamentoStrategy{

    @Override
    public String valorPagamento() {
        return "multa de R$330,00 pelo atraso";
    } 
}
