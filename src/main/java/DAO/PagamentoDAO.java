package DAO;

import Model.Pagamento;
import Singleton.ConexaoSingleton;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;

/**
 *
 * @author miste
 */
public class PagamentoDAO {
    private Connection conexao;
    
    public PagamentoDAO(){
        this.conexao = ConexaoSingleton.FazerConexao();
    }
    
    public ArrayList listaPagamento(){
    
        ArrayList<Pagamento> listaDePagamentos = new ArrayList<>();

        try {
             String sql = "SELECT * FROM pagamento";
             PreparedStatement stm = conexao.prepareStatement(sql);
             ResultSet rs = stm.executeQuery();

            while(rs.next()){
                Pagamento pagamento = new Pagamento();
                pagamento.setId(rs.getInt("id"));
                pagamento.setResidencia_id(rs.getInt("residencia_id"));
                pagamento.setMes(rs.getString("mes"));
                pagamento.setAno(rs.getInt("ano"));
                pagamento.setPago(rs.getBoolean("pago"));
      
                //java.sql.Date -- data do banco
                java.sql.Date data = rs.getDate("data_pagamento");
                if (data != null) {
                    // converte para o localDate
                    pagamento.setData_pagamento(data.toLocalDate());
                } else {
                    pagamento.setData_pagamento(null);
                }

                listaDePagamentos.add(pagamento);                
            }

            rs.close();
            stm.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return listaDePagamentos;
    }
    
    public boolean AtualizaInformacaoPagamento(int idMorador, int idCasa, String mes, int ano, LocalDate data) {

        String sql = "INSERT INTO pagamento (residencia_id, mes, ano, pago, data_pagamento) VALUES (?, ?, ?, ?, ?)";

        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setInt(1, idCasa);
            stmt.setString(2, mes);
            stmt.setInt(3, ano);
            stmt.setBoolean(4, true);
            stmt.setDate(5, java.sql.Date.valueOf(data));

            int linhasInseridas = stmt.executeUpdate();
            return linhasInseridas > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    
    public boolean AtualizaInformacaoPagamentoAtrasado(int idResidencia, String mes, LocalDate data) {

        String sql = "UPDATE pagamento SET pago = ?, data_pagamento = ? WHERE residencia_id = ? and mes = ?";

        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setBoolean(1, true); 
            stmt.setDate(2, java.sql.Date.valueOf(data));
            stmt.setInt(3, idResidencia); 
            stmt.setString(4, mes); 

            int linhasInseridas = stmt.executeUpdate();
            return linhasInseridas > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
