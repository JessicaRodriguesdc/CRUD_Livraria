package Controller;

import java.util.ArrayList;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import Dao.DaoCliente;
import Dao.DaoLivro;
import Model.Cliente;
import Model.Livro;


@ManagedBean(name = "BeanCliente")  
@RequestScoped
public class BeanCliente {
	private DaoCliente Daocliente;
    private Cliente cliente;
	
	
    public String editarCliente(int id){
    	Daocliente = new DaoCliente();
        boolean editar = Daocliente.editarCliente(id);
        if(editar == true) {
        return "/alterarCliente.xhtml?faces-redirect=true";
        }else {
        	return "/visualizarClientes.xhtml?faces-redirect=true";
        }
        
    }
    public String alterarCliente(Cliente c){
        Daocliente = new DaoCliente();
        boolean result = Daocliente.update(c);
        
        if(result == true) {
	        return "/visualizarClientes.xhtml?faces-redirect=true";
	        }else {
	        	return "/alterarCliente.xhtml?faces-redirect=true";
	        }     
    }
    
    public void removerCliente(int id){
    	Daocliente = new DaoCliente();
    	Daocliente.delete(id);
    }
 
    public Cliente getCliente() {
        return cliente;
    }
 
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
 
    
	 @SuppressWarnings("rawtypes")
		public ArrayList mostrarClientes() {
	        Daocliente = new DaoCliente();
	        ArrayList clientes = Daocliente.clienteList();
	        return clientes;
	    }
	    
	    @SuppressWarnings("rawtypes")
		public void setLivros(ArrayList clientes) {
	    }
}
