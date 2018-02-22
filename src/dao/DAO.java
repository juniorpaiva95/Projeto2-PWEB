package dao;

import java.lang.reflect.ParameterizedType;
import java.util.HashMap;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class DAO<T> implements DAOInterface<T> {
	private static EntityManagerFactory factory = Persistence
            .createEntityManagerFactory("Projeto2-PWEB");
	
	protected static EntityManager manager = factory.createEntityManager();

	public DAO(){}

	public static void abrir(){
		if(manager==null){
			System.out.println("Oi, vou tentar criar a conexão agora.");
			manager = factory.createEntityManager();
		}
	}
	public static void fechar(){
		if(manager != null)
			manager = null;
	}
	public void persistir(T obj){
		manager.persist(obj);
	}
	public T atualizar(T obj){
		return manager.merge(obj);
	}
	public void apagar(T obj) {
		manager.remove(obj);
	}
	public void reler(T obj){
		manager.refresh(obj);
	}	
	@SuppressWarnings("unchecked")
	public List<T> listar(){
		Class<T> type = (Class<T>) ((ParameterizedType) this.getClass()
				.getGenericSuperclass()).getActualTypeArguments()[0];
		Query query = manager.createQuery("select x from " + type.getSimpleName() + " x");
		return (List<T>) query.getResultList();
	}

	//----------------------- TRANSAï¿½ï¿½O   ----------------------
	public static void iniciar(){
		if(!manager.getTransaction().isActive())
			manager.getTransaction().begin();
	}
	public static void efetivar(){
		if(manager.getTransaction().isActive()){
			manager.getTransaction().commit();
			manager.clear();		// ---- esvaziar o cache de objetos
		}
	}
	public static void cancelar(){
		if(manager.getTransaction().isActive())
			manager.getTransaction().rollback();
	}



	//	@SuppressWarnings("unchecked")
	//	public T localizar(Object chave){	----- localizar pela chave primaria
	//		Class<T> type = (Class<T>) ((ParameterizedType) this.getClass()
	//				.getGenericSuperclass()).getActualTypeArguments()[0];
	//		return manager.find(type, chave);
	//	}
	

}