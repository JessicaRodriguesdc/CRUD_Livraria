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
    
	 
	 	public String edit(int id){
	        Daolivro = new DaoLivro();
	        boolean editar = Daolivro.edit(id);
	        if(editar == true) {
	        return "/alterarLivro.xhtml?faces-redirect=true";
	        }else {
	        	return "/index.xhtml?faces-redirect=true";
	        }
	        
	    }
	    public String alterar(Livro l){
	        Daolivro = new DaoLivro();
	        boolean result = Daolivro.update(l);
	        
	        if(result == true) {
		        return "/index.xhtml?faces-redirect=true";
		        }else {
		        	return "/alterarLivro.xhtml?faces-redirect=true";
		        }     
	    }
	    
	    public void remover(int id){
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
	        }else return "Indisponivel";
	    }
}
