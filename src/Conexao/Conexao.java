package Conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {
	
	private String driver = "com.mysql.jdbc.Driver";
    private String URL = "jdbc:mysql://localhost/livraria";
    private String USER = "root";
    private String SENHA = "";
    public Connection conn;
 
    public Connection getConn(){
        try{
            Class.forName(driver);   
            conn = DriverManager.getConnection(URL, USER, SENHA);
        }catch(Exception e){
            System.out.println(e);
        }
        return conn;
    }
 
    public void fecharConexao() {
        try {
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
