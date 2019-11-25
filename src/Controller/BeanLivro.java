package Controller;

import java.util.ArrayList;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.model.DataModel;

import Dao.DaoLivro;
import Model.Livro;

@ManagedBean(name = "Beanlivro")  
@RequestScoped
public class BeanLivro {
	
	private DaoLivro Daolivro;
    private Livro livro;
    
	 
	 	public String editarLivro(int id){
	        Daolivro = new DaoLivro();
	        boolean editar = Daolivro.editarLivro(id);
	        if(editar == true) {
	        return "/alterarLivro.xhtml?faces-redirect=true";
	        }else {
	        	return "/visualizarLivros.xhtml?faces-redirect=true";
	        }
	        
	    }
	    public String alterarLivro(Livro l){
	        Daolivro = new DaoLivro();
	        boolean result = Daolivro.update(l);
	        
	        if(result == true) {
		        return "/visualizarLivros.xhtml?faces-redirect=true";
		        }else {
		        	return "/alterarLivro.xhtml?faces-redirect=true";
		        }     
	    }
	    
	    public void removerLivro(int id){
	        Daolivro = new DaoLivro();
	        Daolivro.delete(id);
	    }
	 
	    public Livro getLivro() {
	        return livro;
	    }
	 
	    public void setLivro(Livro livro) {
	        this.livro = livro;
	    }
	    
	    @SuppressWarnings("rawtypes")
		public ArrayList mostrarLivros() {
	        Daolivro = new DaoLivro();
	        ArrayList livros = Daolivro.livroList();
	        return livros;
	    }
	    
	    @SuppressWarnings("rawtypes")
		public void setLivros(ArrayList livros) {
	    }
	    
	    public String getStatus(char statusLivro){
	        if(statusLivro == 'D'){
	            return "Disponivel";
	        }else if(statusLivro == 'A') {
	        	return "Alugado";
	        }
			return null;
	    }
	    
	    @SuppressWarnings("rawtypes")
		public ArrayList mostrarLivrosDisponiveis() {
	        Daolivro = new DaoLivro();
	        ArrayList livros = Daolivro.alugarList();
	        return livros;
	    }
	    
	    @SuppressWarnings("rawtypes")
		public ArrayList mostrarLivrosAlugados() {
	        Daolivro = new DaoLivro();
	        ArrayList livros = Daolivro.desalugarList();
	        return livros;
	    }
}
