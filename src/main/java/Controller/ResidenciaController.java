package Controller;

import DAO.ResidenciaDAO;
import java.util.ArrayList;


public class ResidenciaController {
    private ResidenciaDAO residenciaDAO;
    
    public ResidenciaController(){
        this.residenciaDAO = new ResidenciaDAO();
    }
    
    public ArrayList exibir(){
        return residenciaDAO.listaResidencia();
    }
    
    public boolean atualizaInfo(int numero_casa, String rua, String cep, int dono_id){
        return residenciaDAO.AtualizaInformacaoCasa(numero_casa, rua, cep, dono_id);
    }
    
    public boolean apagaCasa(int numero_casa){
        if(residenciaDAO.podeApagarResidencia(numero_casa)){
            return residenciaDAO.removerItemCasa(numero_casa);  
        }
        return false;
    }
    
    public boolean adicionaCasa(int numero_casa, String rua, String cep){
        return residenciaDAO.adicionarResidecia(numero_casa, rua, cep);
    }
}
