package DAO;

import Model.Residencia;
import Singleton.ConexaoSingleton;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;


public class ResidenciaDAO {
    private Connection conexao;
    
    public ResidenciaDAO(){
        this.conexao = ConexaoSingleton.FazerConexao();
    }
    
    public ArrayList listaResidencia(){
         ArrayList<Residencia> listaDeResidencias = new ArrayList<>();
         
         try{
             String sql = "SELECT * FROM residencia";
             PreparedStatement stm = conexao.prepareStatement(sql);
             ResultSet rs = stm.executeQuery();

             while(rs.next()){
                 Residencia residencia = new Residencia();
                 residencia.setNumero(rs.getInt("numero_casa"));
                 residencia.setRua(rs.getString("rua"));
                 residencia.setCep(rs.getString("cep"));
                 residencia.setDono(rs.getInt("dono_id"));
                 
                 listaDeResidencias.add(residencia);
             }
            rs.close();
            stm.close();
         }catch(Exception e){
            e.printStackTrace();
        }
         return listaDeResidencias;
    }
    
    
    public boolean AtualizaInformacaoCasa(int numero_casa, String rua, String cep, int dono_id){        
        try{
            String sql = "UPDATE residencia SET rua = ?, cep = ?, dono_id = ? WHERE numero_casa = ?";
            PreparedStatement stm = conexao.prepareStatement(sql);
            
            stm.setString(1, rua);
            stm.setString(2, cep);
            stm.setInt(3, dono_id);
            stm.setInt(4, numero_casa);
            
            stm.executeUpdate();
            stm.close();           
            
            return true;
        }catch(Exception e){
            e.printStackTrace();
            return false;
        }
    }
    
    public boolean removerItemCasa(int numero){
        try{
            String sql = "DELETE FROM residencia WHERE numero_casa = ?";
            PreparedStatement stm = conexao.prepareStatement(sql);
            
            stm.setInt(1, numero);
            
            stm.executeUpdate();
            stm.close();
            return true;
        }catch(Exception e){
            e.printStackTrace();
            return false;
        }
    }
    
    public boolean podeApagarResidencia(int numeroCasa) {       
        try {
            String sql = "SELECT COUNT(*) FROM morador WHERE moraNa = ?";
            PreparedStatement smt = conexao.prepareStatement(sql);
            
            smt.setInt(1, numeroCasa);
            ResultSet rs = smt.executeQuery();

            if (rs.next()) {
                int total = rs.getInt(1);
                return total == 0;
            }

            rs.close();
            smt.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    
    
    public boolean adicionarResidecia(int numero_casa, String rua, String cep){
        try{
            String sql = "INSERT INTO residencia (numero_casa, rua, cep) VALUES (?, ?, ?)";
            PreparedStatement smt = conexao.prepareStatement(sql);
            
            smt.setInt(1, numero_casa);
            smt.setString(2, rua);
            smt.setString(3, cep);
            
            smt.executeUpdate();
            smt.close();
            return true;          
        }catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
