package br.com.fiap.jpa.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;



@Entity
@Table(name = "tb_carro")
@SequenceGenerator(name = "carro", sequenceName = "SQ_TB_CARRO", allocationSize = 1)
public class Carro implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7840617502886711667L;

	public Carro(String placa, String cor, String chassi) {
		this.placa = placa;
		this.cor = cor;
		this.chassi = chassi;
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "carro")
	private Long id;
	
	@Column(name = "ds_placa", length = 7 , nullable = false)
	private String placa;
	
	@Column(name = "ds_cor", length = 80 , nullable = false)
	private String cor;
	
	@Column(name = "nr_chassi", length = 20 , nullable = false)
	private String chassi;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="fabricante_id")
	private Fabricante fabricante;
	
	@ManyToMany
	@JoinTable(
		name = "tb_carro_acessorio",
		joinColumns = @JoinColumn(name = "carro_id"),
		inverseJoinColumns = @JoinColumn(name = "acessorio_id")
	)
	private List<Acessorio> acessorios;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public String getCor() {
		return cor;
	}

	public void setCor(String cor) {
		this.cor = cor;
	}

	public String getChassi() {
		return chassi;
	}

	public void setChassi(String chassi) {
		this.chassi = chassi;
	}

	@Override
	public String toString() {
		
		return "\nPlaca: " + this.getPlaca() 
		+ "\nCor: " + this.getCor()
		+ "\nChassi: " + this.getChassi(); 
	}
	
}
