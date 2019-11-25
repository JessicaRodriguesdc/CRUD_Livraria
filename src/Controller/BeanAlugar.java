package Controller;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import Dao.DaoAlugar;
import Dao.DaoLivro;
import Model.Cliente;
import Model.Livro;


@ManagedBean(name = "BeanAlugar")  
@RequestScoped
public class BeanAlugar {

	private DaoAlugar Daoaluguel;
    private Livro livro;
	
	public String alguelLivro(int id){
		Daoaluguel = new DaoAlugar();
        boolean alugar = Daoaluguel.aluguelLivro(id);
        if(alugar == true) {
        return "/alugarLivro.xhtml?faces-redirect=true";
        }else {
        	return "/aluguelLivro.xhtml?faces-redirect=true";
        }      
    }
	
	public String alugarLivro(Livro l,int idCli){
		
		Daoaluguel = new DaoAlugar();
        boolean result = Daoaluguel.alugar(l,idCli);
        
        if(result == true) {
	        return "/aluguelLivro.xhtml?faces-redirect=true";
	        }else {
	        	return "/alugarLivro.xhtml?faces-redirect=true";
	        }     
    }

	public String getStatus(char statusLivro){
        if(statusLivro == 'D'){
            return "Disponivel";
        }else if(statusLivro == 'A') {
        	return "Alugado";
        }
		return null;
    }
	
	  public void devolverLivro(int id){
		  Daoaluguel = new DaoAlugar();
		  Daoaluguel.desalugar(id);
	    }
	
}
