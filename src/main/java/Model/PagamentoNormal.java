package Model;


public class PagamentoNormal implements PagamentoStrategy{
    
    @Override
    public String valorPagamento() {
        return "valor do pagamento normal";
    }    
}
