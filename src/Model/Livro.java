package Model;

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

@ManagedBean(name = "livro")  
@RequestScoped

public class Livro {
	
	private int id;
	private String nomeLivro;
	private String autorLivro;
	private int anoLivro;
	private String generoLivro;
	private String editoraLivro;
	private int paginasLivro;
	private String statusLivro;
	@SuppressWarnings("rawtypes")
	public ArrayList livroList ;
    private Map<String,Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNomeLivro() {
		return nomeLivro;
	}
	public void setNomeLivro(String nomeLivro) {
		this.nomeLivro = nomeLivro;
	}
	public String getAutorLivro() {
		return autorLivro;
	}
	public void setAutorLivro(String autorLivro) {
		this.autorLivro = autorLivro;
	}
	public int getAnoLivro() {
		return anoLivro;
	}
	public void setAnoLivro(int anoLivro) {
		this.anoLivro = anoLivro;
	}
	public String getGeneroLivro() {
		return generoLivro;
	}
	public void setGeneroLivro(String generoLivro) {
		this.generoLivro = generoLivro;
	}
	public String getEditoraLivro() {
		return editoraLivro;
	}
	public void setEditoraLivro(String editoraLivro) {
		this.editoraLivro = editoraLivro;
	}
	public int getPaginasLivro() {
		return paginasLivro;
	}
	public void setPaginasLivro(int paginasLivro) {
		this.paginasLivro = paginasLivro;
	}
	public String getStatusLivro() {
		return statusLivro;
	}
	public void setStatusLivro(String statusLivro) {
		this.statusLivro = statusLivro;
	}
	
    public Connection connec;
	Conexao conn;
	
	public String save(){
    	conn = new Conexao();
        int result = 0;
        try{
            connec = conn.getConn();
            PreparedStatement stmt = connec.prepareStatement("insert into livro(nomeLivro,autorLivro,anoLivro,generoLivro,editoraLivro,paginasLivro,statusLivro) values(?,?,?,?,?,?,?)");
            stmt.setString(1,nomeLivro);  
            stmt.setString(2,autorLivro);  
            stmt.setInt(3,anoLivro);  
            stmt.setString(4,generoLivro);  
            stmt.setString(5,editoraLivro);
            stmt.setInt(6,paginasLivro);
            stmt.setString(7,statusLivro);         
            result = stmt.executeUpdate();
            conn.fecharConexao();
        }catch(Exception e){
            System.out.println(e);
        }
        if(result !=0)
            return "visualizarLivros.xhtml?faces-redirect=true";
        else return "novoLivro.xhtml?faces-redirect=true"; 
    
    }
	
}
