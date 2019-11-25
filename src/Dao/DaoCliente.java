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


public class DaoCliente {
	@SuppressWarnings("rawtypes")
	public ArrayList clienteList ;
    private Map<String,Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
    public Connection connec;
    public Cliente cliente = new Cliente();
    
	Conexao conn;
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public ArrayList clienteList(){
		conn = new Conexao();
        try{
            clienteList = new ArrayList();
            connec = conn.getConn();
            Statement stmt= conn.getConn().createStatement();  
            ResultSet rs=stmt.executeQuery("select id, nomeCliente from cliente");  
            while(rs.next()){
                Cliente cliente = new Cliente();
              	cliente.setId(rs.getInt("id"));
            	cliente.setNomeCliente(rs.getString("nomeCliente"));
            	
                clienteList.add(cliente);
            }
            conn.fecharConexao();        
        }catch(Exception e){
            System.out.println(e);
        }
        return clienteList;
    }
	
	
	public boolean editarCliente(int id){
	 	Cliente cliente =null;
    	conn = new Conexao();
        System.out.println(id);
        try{
            connec = conn.getConn();
            Statement stmt=conn.getConn().createStatement();  
            ResultSet rs=stmt.executeQuery("select * from cliente where id = "+(id));
            rs.next();
            cliente = new Cliente();
            cliente.setId(rs.getInt("id"));
        	cliente.setNomeCliente(rs.getString("nomeCliente"));
        	cliente.setCpf(rs.getString("cpf"));
        	cliente.setTelefone(rs.getString("telefone"));
      
            sessionMap.put("clienteLivro", cliente);            
            conn.fecharConexao();
        }catch(Exception e){
            System.out.println(e);
        }       
        return true;
    }

public boolean update(Cliente c){
	conn = new Conexao();

    try{
        connec = conn.getConn();  
        PreparedStatement stmt=connec.prepareStatement("update cliente set nomeCliente=?,cpf=?,telefone=? where id=?");
        stmt.setString(1,c.getNomeCliente());  
        stmt.setString(2,c.getCpf());  
        stmt.setString(3,c.getTelefone());  
        stmt.setInt(4,c.getId());  
        
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
        PreparedStatement stmt = connec.prepareStatement("delete from cliente where id = "+id);  
        stmt.executeUpdate();  
    }catch(Exception e){
        System.out.println(e);
    }
}
}
