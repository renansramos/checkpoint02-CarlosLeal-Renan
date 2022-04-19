package br.com.fiap.jpa.dao.impl;

import br.com.fiap.jpa.entity.Fabricante;

public class FabricanteDAOImpl extends HibernateGenericDAO<Fabricante, Long> {

	private static FabricanteDAOImpl instance;
	
	private FabricanteDAOImpl() {
		super(Fabricante.class);
	}
	
	public static FabricanteDAOImpl getInstance() {
		
		if (instance == null) {
			instance = new FabricanteDAOImpl();
		}
		
		return instance;
	}

}
