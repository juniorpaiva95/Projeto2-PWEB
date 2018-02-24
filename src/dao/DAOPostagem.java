package dao;

import java.util.List;

import javax.persistence.NoResultException;
import javax.persistence.Query;

import model.Postagem;

public class DAOPostagem extends DAO<Postagem>{
	private static DAOPostagem daoPostagem = null;
	
	public static DAOPostagem getInstance(){
	    if (daoPostagem==null)
	        daoPostagem = new DAOPostagem();
	    return daoPostagem;
	      
	}
	
	public static List<Postagem> pesquisarPostagens(String search){
		try{
			Query query = manager.createQuery("SELECT p FROM Postagem p JOIN p.tema t WHERE p.titulo LIKE :search or t.nome LIKE :search");
			query.setParameter("search", "%" + search + "%");
			return (List<Postagem>) query.getResultList();
		}catch(NoResultException e){
			return null;
		}
	}
	
	@Override
	public List<Postagem> listar() {
		try{
			Query query = manager.createQuery("SELECT p FROM Postagem p JOIN p.tema t JOIN p.usuario u");
			return (List<Postagem>) query.getResultList();
		}catch(NoResultException e){		
			return null;
		}
	}
	
	
}
