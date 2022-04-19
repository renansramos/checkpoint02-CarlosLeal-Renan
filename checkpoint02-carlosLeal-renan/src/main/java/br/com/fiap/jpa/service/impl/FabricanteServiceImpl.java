package br.com.fiap.jpa.service.impl;

import java.util.List;

import br.com.fiap.jpa.dao.impl.CarroDAOImpl;
import br.com.fiap.jpa.dao.impl.FabricanteDAOImpl;
import br.com.fiap.jpa.entity.Carro;
import br.com.fiap.jpa.entity.Fabricante;
import br.com.fiap.jpa.service.GenericService;

public class FabricanteServiceImpl extends GenericService<Fabricante, Long> {

	private static FabricanteServiceImpl instance = null;
	
	private FabricanteDAOImpl fabricanteDAO;
	private CarroDAOImpl carroDAO;
	
	private FabricanteServiceImpl() {
		fabricanteDAO = FabricanteDAOImpl.getInstance();
		carroDAO = CarroDAOImpl.getInstance();
	}
	
	public static FabricanteServiceImpl getInstance() {
		
		if (instance == null) {
			instance = new FabricanteServiceImpl();
		}
		
		return instance;
	}
	
	@Override
	public void inserir(Fabricante instance) {
		try {
			Carro carro = instance.getCarro();
			carro = carroDAO.obterPorId(carro.getId(), getEntityManager());
			instance.setCarro(carro);
			
			fabricanteDAO.salvar(instance, getEntityManager());
		} catch (Exception e) {
			e.printStackTrace();
			getEntityManager().getTransaction().rollback();
		} finally {
			closeEntityManager();
		}
	}

	@Override
	public void atualizar(Fabricante instance) {
		try {
			fabricanteDAO.atualizar(instance, getEntityManager());
		} catch (Exception e) {
			e.printStackTrace();
			getEntityManager().getTransaction().rollback();
		} finally {
			closeEntityManager();
		}
	}

	@Override
	public void remover(Long id) {

		try {
			fabricanteDAO.remover(id, getEntityManager());
		} catch (Exception e) {
			e.printStackTrace();
			getEntityManager().getTransaction().rollback();
		} finally {
			closeEntityManager();
		}
	}

	@Override
	public Fabricante obter(Long id) {
		Fabricante fabricante = null;
		
		try {
			fabricante = fabricanteDAO.obterPorId(id, getEntityManager());
		} catch (Exception e) {
		} finally {
			closeEntityManager();
		}
		
		return fabricante;
	}

	@Override
	public List<Fabricante> listar() {
		List<Fabricante> fabricantes = null;
		
		try {
			fabricantes = fabricanteDAO.listar(getEntityManager());
		} catch (Exception e) {
		} finally {
			closeEntityManager();
		}
		
		return fabricantes;
	}

}
