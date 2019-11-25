package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import Conexao.Conexao;

@ManagedBean(name = "cliente")  
@RequestScoped
public class Cliente {
	
	private int id;
	private String nomeCliente;
	private String cpf;
	private String telefone;
	@SuppressWarnings("rawtypes")
	public ArrayList clienteList;
    private Map<String,Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
	

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNomeCliente() {
		return nomeCliente;
	}
	public void setNomeCliente(String nomeCliente) {
		this.nomeCliente = nomeCliente;
	}

	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
		
	public Connection connec;
	Conexao conn;
	
	public String novoCliente(){
    	conn = new Conexao();
        int result = 0;
        try{
            connec = conn.getConn();
            PreparedStatement stmt = connec.prepareStatement("insert into cliente(nomeCliente,cpf,telefone) "
            		+ "values ('" + getNomeCliente() +"','" +getCpf() + "','"+ getTelefone()+"')");
            result = stmt.executeUpdate();
            conn.fecharConexao();
        }catch(Exception e){
            System.out.println(e);
        }
        if(result !=0)
            return "visualizarClientes.xhtml?faces-redirect=true";
        else return "novoCliente.xhtml?faces-redirect=true"; 
    }
	
}
