package Controller;

import DAO.PagamentoDAO;
import Model.Pagamento;
import Model.PagamentoStrategy;
import java.time.LocalDate;
import java.util.ArrayList;

/**
 *
 * @author miste
 */
public class PagamentoController {
    private PagamentoDAO pagamentoDAO;
    Pagamento pagamento = new Pagamento();
    
    public PagamentoController(){
        this.pagamentoDAO = new PagamentoDAO();
    }
    
    public ArrayList exibir(){
        return pagamentoDAO.listaPagamento();
    }
    
    public Boolean adicionarPagameno(int idMorador, int idCasa, String mes, int ano, LocalDate data){
        return pagamentoDAO.AtualizaInformacaoPagamento(idMorador, idCasa, mes, ano, data);
    }
    
    public boolean adicionarPagamenoAtrasado(int idCasa, String mes, LocalDate data){
        return pagamentoDAO.AtualizaInformacaoPagamentoAtrasado(idCasa, mes, data);
    }
    
    public String registrarPagamento(PagamentoStrategy estrategia) {
        pagamento.setEstrategia(estrategia);
        return pagamento.processarPagamento();
    }
}
