package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import Conexao.Conexao;
import Model.Cliente;
import Model.Livro;

public class DaoLivro {
	
	@SuppressWarnings("rawtypes")
	public ArrayList livroList ;
    private Map<String,Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
    public Connection connec;
    public Livro livro = new Livro();
    
	Conexao conn;
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public ArrayList livroList(){
		conn = new Conexao();
        try{
            livroList = new ArrayList();
            connec = conn.getConn();
            Statement stmt= conn.getConn().createStatement();  
            ResultSet rs=stmt.executeQuery("select * from livro");  
            while(rs.next()){
                Livro livro = new Livro();
              	livro.setId(rs.getInt("id"));
            	livro.setNomeLivro(rs.getString("nomeLivro"));
            	livro.setAutorLivro(rs.getString("autorLivro"));
            	livro.setAnoLivro(rs.getInt("anoLivro"));
            	livro.setGeneroLivro(rs.getString("generoLivro"));
            	livro.setEditoraLivro(rs.getString("editoraLivro"));
            	livro.setPaginasLivro(rs.getInt("paginasLivro"));
            	livro.setStatusLivro(rs.getString("statusLivro"));
            	
                livroList.add(livro);
            }
            conn.fecharConexao();        
        }catch(Exception e){
            System.out.println(e);
        }
        return livroList;
    }
    
	 public boolean editarLivro(int id){
		 	Livro livro =null;
	    	conn = new Conexao();
	        System.out.println(id);
	        try{
	            connec = conn.getConn();
	            Statement stmt=conn.getConn().createStatement();  
	            ResultSet rs=stmt.executeQuery("select * from livro where id = "+(id));
	            rs.next();
	            livro = new Livro();
	            livro.setId(rs.getInt("id"));
	        	livro.setNomeLivro(rs.getString("nomeLivro"));
	        	livro.setAutorLivro(rs.getString("autorLivro"));
	        	livro.setAnoLivro(rs.getInt("anoLivro"));
	        	livro.setGeneroLivro(rs.getString("generoLivro"));
	        	livro.setEditoraLivro(rs.getString("editoraLivro"));
	        	livro.setPaginasLivro(rs.getInt("paginasLivro"));
	        	livro.setStatusLivro(rs.getString("statusLivro"));
	            sessionMap.put("editLivro", livro);            
	            conn.fecharConexao();
	        }catch(Exception e){
	            System.out.println(e);
	        }       
	        return true;
	    }
    
    public boolean update(Livro l){
    	conn = new Conexao();
 
        try{
            connec = conn.getConn();  
            PreparedStatement stmt=connec.prepareStatement("update livro set nomeLivro=?,autorLivro=?,anoLivro=?,generoLivro=?,editoraLivro=? ,paginasLivro=?,statusLivro=? where id=?");
            stmt.setString(1,l.getNomeLivro());  
            stmt.setString(2,l.getAutorLivro());  
            stmt.setInt(3,l.getAnoLivro());  
            stmt.setString(4,l.getGeneroLivro());  
            stmt.setString(5,l.getEditoraLivro());
            stmt.setInt(6,l.getPaginasLivro());  
            stmt.setString(7,l.getStatusLivro());
            stmt.setInt(8,l.getId());  
            
            stmt.executeUpdate();   
            conn.fecharConexao();
        }catch(Exception e){
            System.out.println();
        }
        return true;      
    }
    
    public void delete(int id){
    	conn = new Conexao();
        try{
            connec = conn.getConn();  
            PreparedStatement stmt = connec.prepareStatement("delete from livro where id = "+id);  
            stmt.executeUpdate();  
        }catch(Exception e){
            System.out.println(e);
        }
    }
    
    
    public ArrayList alugarList(){
		conn = new Conexao();
        try{
            livroList = new ArrayList();
            connec = conn.getConn();
            Statement stmt= conn.getConn().createStatement();  
            ResultSet rs=stmt.executeQuery("select id,nomeLivro,statusLivro from livro where statusLivro like'D'");  
            while(rs.next()){
                Livro livro = new Livro();
              	livro.setId(rs.getInt("id"));
            	livro.setNomeLivro(rs.getString("nomeLivro"));
            	livro.setStatusLivro(rs.getString("statusLivro"));
            	
                livroList.add(livro);
            }
            conn.fecharConexao();        
        }catch(Exception e){
            System.out.println(e);
        }
        return livroList;
    }
    
    public boolean aluguel(Livro l){
    	conn = new Conexao();
 
        try{
            connec = conn.getConn();  
            PreparedStatement stmt=connec.prepareStatement("update livro set nomeLivro=?,autorLivro=?,anoLivro=?,generoLivro=?,editoraLivro=? ,paginasLivro=?,statusLivro=? where id=?");
            stmt.setString(1,l.getNomeLivro());  
            stmt.setString(2,l.getAutorLivro());  
            stmt.setInt(3,l.getAnoLivro());  
            stmt.setString(4,l.getGeneroLivro());  
            stmt.setString(5,l.getEditoraLivro());
            stmt.setInt(6,l.getPaginasLivro());  
            stmt.setString(7,l.getStatusLivro());
            stmt.setInt(8,l.getId());  
            
            stmt.executeUpdate();   
            conn.fecharConexao();
        }catch(Exception e){
            System.out.println();
        }
        return true;      
    }
    
    public ArrayList desalugarList(){
		conn = new Conexao();
        try{
            livroList = new ArrayList();
            connec = conn.getConn();
            Statement stmt= conn.getConn().createStatement();
            
            ResultSet rs=stmt.executeQuery("select l.id, l.nomeLivro,c.nomeCliente, l.statusLivro \r\n" + 
            		"        	FROM livro as l\r\n" + 
            		"                inner join cliente as c on (c.id = l.idCliente)\r\n" + 
            		"        where l.statusLivro like'A'");  
            while(rs.next()){
                Livro livro = new Livro();
                Cliente cliente =  new Cliente();
              	livro.setId(rs.getInt("l.id"));
            	livro.setNomeLivro(rs.getString("l.nomeLivro"));
            	cliente.setNomeCliente(rs.getString("c.nomeCliente"));
            	
            	livro.setCliente(cliente);
            	livro.setStatusLivro(rs.getString("l.statusLivro"));
            	
                livroList.add(livro);
            }
            conn.fecharConexao();        
        }catch(Exception e){
            System.out.println(e);
        }
        return livroList;
    }
}
