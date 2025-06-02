package Singleton;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class ConexaoSingleton {
    private static Connection conexao;
    
    private ConexaoSingleton(){}
    
    public static Connection FazerConexao(){
        if (conexao == null){
            try{
                conexao = DriverManager.getConnection("jdbc:mysql://localhost:3306/condominio", "root", "12345678");
            }catch(SQLException e){
                System.out.println("Erro na conexão: " + e.getMessage());
            }
        }
    return conexao;
    }
}
