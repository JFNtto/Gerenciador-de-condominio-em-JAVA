package DAO;

import Model.Morador;
import Singleton.ConexaoSingleton;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;


public class MoradorDAO {
    private Connection conexao;
    
    public MoradorDAO(){
        this.conexao = ConexaoSingleton.FazerConexao();
    }
    
    public ArrayList listaMorador(){
        ArrayList<Morador> listaDeMoradores = new ArrayList<>();
        
        try {
             String sql = "SELECT * FROM morador";
             PreparedStatement stm = conexao.prepareStatement(sql);
             ResultSet rs = stm.executeQuery();

            while(rs.next()){
                Morador morador = new Morador();
                morador.setId(rs.getInt("id"));
                morador.setNome(rs.getString("nome"));
                morador.setRg(rs.getString("rg"));
                morador.setCpf(rs.getString("cpf"));
                morador.setMoraNa(rs.getInt("moraNa"));
                
                listaDeMoradores.add(morador);                
            }

            rs.close();
            stm.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return listaDeMoradores;
    }
    
    public boolean AtualizaInformacaoMorador(int moradorId, String nome, String rg, String cpf, int moraNa){
        try{
            String sql = "UPDATE morador SET nome = ?, rg = ?, cpf = ?, moraNa = ? where id = ?";
            PreparedStatement stm = conexao.prepareStatement(sql);
            stm.setString(1, nome);
            stm.setString(2, rg);
            stm.setString(3, cpf);
            stm.setInt(4, moraNa);
            stm.setInt(5, moradorId);
            
            stm.executeUpdate();
            stm.close();
            return true;
        }catch(Exception e){
            e.printStackTrace();
            return false;
        }
    }
    
    
    public boolean removerItemMorador(int id){
        try{
            String sqlUpdate = "UPDATE residencia SET dono_id = NULL WHERE dono_id = ?";
            PreparedStatement smtVerifica = conexao.prepareStatement(sqlUpdate);
            smtVerifica.setInt(1, id);
            smtVerifica.executeUpdate();
            smtVerifica.close();
            
            
            String sql = "DELETE FROM morador WHERE id = ?";
            PreparedStatement smt = conexao.prepareStatement(sql);            
            smt.setInt(1, id);
            
            smt.executeUpdate();
            smt.close();
            return true;
        }catch(Exception e){
            e.printStackTrace();
            return false;
        }  
    }
    
    public boolean adicionarMorador(String nome, String rg, String cpf, int moraNa){
        try{
            String sql = "INSERT INTO morador (nome, rg, cpf, moraNa) VALUES (?, ?, ?, ?)";
            PreparedStatement smt = conexao.prepareStatement(sql);
            
            smt.setString(1, nome);
            smt.setString(2, rg);
            smt.setString(3, cpf);
            smt.setInt(4, moraNa);
            
            smt.executeUpdate();
            smt.close();
            return true;
        }catch(Exception e){
            e.printStackTrace();
            return false;
        }
    }
    
    public boolean residenciaExiste(int numeroCasa) {
        try {
            String sql = "SELECT * FROM residencia WHERE numero_casa = ?";
            PreparedStatement smt = conexao.prepareStatement(sql);
            
            smt.setInt(1, numeroCasa);
            ResultSet rs = smt.executeQuery();

            boolean existe = rs.next();

            rs.close();
            smt.close();

            return existe;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

}
