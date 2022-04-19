package br.com.fiap.jpa.service.impl;

import java.util.List;

import br.com.fiap.jpa.dao.impl.AcessorioDAOImpl;
import br.com.fiap.jpa.dao.impl.CarroDAOImpl;
import br.com.fiap.jpa.dao.impl.FabricanteDAOImpl;
import br.com.fiap.jpa.entity.Carro;
import br.com.fiap.jpa.service.GenericService;

public class CarroServiceImpl extends GenericService<Carro, Long>{

	private static CarroServiceImpl instance = null;
	
	private CarroDAOImpl carroDAO;
	private AcessorioDAOImpl acessorioDAO;
	private FabricanteDAOImpl fabricanteDAO;
	
	
	private CarroServiceImpl() {
		carroDAO = CarroDAOImpl.getInstance();
		acessorioDAO = AcessorioDAOImpl.getInstance();
		fabricanteDAO = FabricanteDAOImpl.getInstance();
	}
	
	public static CarroServiceImpl getInstance() {
		
		if (instance == null) {
			instance = new CarroServiceImpl();
		}
		
		return instance;
	}
	
	
	@Override
	public void inserir(Carro carro) {
		try {
			carroDAO.salvar(carro, getEntityManager());
		} catch (Exception e) {
			e.printStackTrace();
			getEntityManager().getTransaction().rollback();
		} finally {
			closeEntityManager();
		}
		
		
	}

	@Override
	public void atualizar(Carro carro) {
		try {
			carroDAO.atualizar(carro, getEntityManager());
		} catch (Exception e) {
			getEntityManager().getTransaction().rollback();
		} finally {
			closeEntityManager();
		}
		
	}

	@Override
	public void remover(Long id) {
		try {
			carroDAO.remover(id, getEntityManager());
		} catch (Exception e) {
			e.printStackTrace();
			getEntityManager().getTransaction().rollback();
		} finally {
			closeEntityManager();
		}
		
	}

	@Override
	public Carro obter(Long id) {
		Carro carro = null;
		
		try {
			carro = carroDAO.obterPorId(id, getEntityManager());
		} catch (Exception e) {
		} finally {
			closeEntityManager();
		}
		
		return carro;
	}
	@Override
	public List<Carro> listar() {
		List<Carro> carro = null;
		
		try {
			carro = carroDAO.listar(getEntityManager());
		} catch (Exception e) {
		} finally {
			closeEntityManager();
		}
		
		return carro;
	}
	
	

}
