package com.example.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.springframework.stereotype.Component;



@Entity
@Table(name="SOTTOCATEGORIA")
@Component
public class SottoCategoria {
	//
	public static final String PROPERTY_ID ="idsottocategoria";
	//
	@Column(name = "idsottocategoria")
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int idsottocategoria;
	
	@Column(name="codice")
	@NotBlank(message="il campo non può essere vuoto")
	private String codice;

	@Column(name="sottocategoria")
	@NotBlank(message="il campo non può essere vuoto")
	private String sottocategoria;

	@Column(name="budget")
	@NotNull(message="il campo non può essere vuoto")
	private float budget;
	
	@Column(name="budgetspeso")
	@NotNull(message="il campo non può essere vuoto")
	private float budgetspeso;
	
	@ManyToOne
	@JoinColumn(name = "idarea")
	@NotNull(message="il campo non può essere vuoto")
	private AreaInvestimento oarea;

	public int getIdsottocategoria() {
		return idsottocategoria;
	}

	public void setIdsottocategoria(int idsottocategoria) {
		this.idsottocategoria = idsottocategoria;
	}

	public String getCodice() {
		return codice;
	}

	public void setCodice(String codice) {
		this.codice = codice;
	}

	public String getSottocategoria() {
		return sottocategoria;
	}

	public void setSottocategoria(String sottocategoria) {
		this.sottocategoria = sottocategoria;
	}

	public float getBudget() {
		return budget;
	}

	public void setBudget(float budget) {
		this.budget = budget;
	}

	public float getBudgetspeso() {
		return budgetspeso;
	}

	public void setBudgetspeso(float budgetspeso) {
		this.budgetspeso = budgetspeso;
	}

	public AreaInvestimento getOarea() {
		return oarea;
	}

	public void setOarea(AreaInvestimento oarea) {
		this.oarea = oarea;
	}

	
	

}