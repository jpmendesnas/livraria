package br.com.caelum.livraria.dao;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.com.caelum.livraria.modelo.Autor;

@Stateless
public class AutorDao {

	@PersistenceContext
	private EntityManager manager;
	
	@PostConstruct
	void aposCriacao(){
		System.out.println("AutorDAO foi criado");
	}

	public void salva(Autor autor) throws InterruptedException {
		System.out.println("Ssalvando o autor "+ autor.getNome());
		manager.persist(autor);
		System.out.println("Savlou o autor " +  autor.getNome());
	}
	
	public List<Autor> todosAutores() {
		 return manager.createQuery("select a from Autor a", Autor.class)
		            .getResultList();
	}

	public Autor buscaPelaId(Integer autorId) {
		Autor autor = this.manager.find(Autor.class, autorId);
		return autor;
	}
	
}
