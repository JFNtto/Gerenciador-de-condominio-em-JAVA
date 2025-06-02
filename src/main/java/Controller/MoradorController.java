package Controller;

import DAO.MoradorDAO;
import java.util.ArrayList;


public class MoradorController {
    private MoradorDAO moradorDAO;
    
    public MoradorController(){
        this.moradorDAO = new MoradorDAO();
    }
    
    public ArrayList exibir(){
        return moradorDAO.listaMorador();
    }
    
    public boolean atualizaInfo(int moradorId, String nome, String rg, String cpf, int moraNa){
        return moradorDAO.AtualizaInformacaoMorador(moradorId, nome, rg, cpf, moraNa);
    }
    
    public boolean apagarMorador(int id){
        return moradorDAO.removerItemMorador(id);
    }
    
    public boolean adicionarMorador(String nome, String rg, String cpf, int moraNa){
        if(moradorDAO.residenciaExiste(moraNa)){
            return moradorDAO.adicionarMorador(nome, rg, cpf, moraNa);
        }
        return false;
    }
}
