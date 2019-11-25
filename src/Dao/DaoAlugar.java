package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Map;

import javax.faces.context.FacesContext;

import Conexao.Conexao;
import Model.Cliente;
import Model.Livro;

public class DaoAlugar {
	
	@SuppressWarnings("rawtypes")
	public ArrayList alugarList ;
    private Map<String,Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
    public Connection connec;
    public Livro livro = new Livro();
    public Cliente cliente = new Cliente();
	
	Conexao conn;

	public boolean aluguelLivro(int id){
	 	Livro livro =null;
    	conn = new Conexao();
        System.out.println(id);
        try{
            connec = conn.getConn();
            Statement stmt=conn.getConn().createStatement();  
            ResultSet rs=stmt.executeQuery("select id,nomeLivro,idCliente,statusLivro from livro where id = "+(id));
            rs.next();
            livro = new Livro();
            livro.setId(rs.getInt("id"));
        	livro.setNomeLivro(rs.getString("nomeLivro"));
        	livro.setStatusLivro(rs.getString("statusLivro"));
            sessionMap.put("alugarLivro", livro);            
            conn.fecharConexao();
        }catch(Exception e){
            System.out.println(e);
        }       
        return true;
    }
	
	 public boolean alugar(Livro l,int id){
	    	conn = new Conexao();
	    	try{
	            connec = conn.getConn();  
	            PreparedStatement stmt=connec.prepareStatement("update livro set statusLivro="+l.getStatusLivro()+" idCliente="+id+" where id="+l.getId());
	            stmt.executeUpdate();   
	            conn.fecharConexao();
	        }catch(Exception e){
	            System.out.println();
	        }
	        return true;      
	    }
	
	   public void desalugar(int id){
	    	conn = new Conexao();
	        try{
	            connec = conn.getConn();  
	            PreparedStatement stmt = connec.prepareStatement("update livro set statusLivro='D', idCliente=0 where id = "+id);  
	            stmt.executeUpdate();  
	        }catch(Exception e){
	            System.out.println(e);
	        }
	    }
}
