package com.local.apipdfsignature.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "DIGITADORDB")
public class Digitador {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "IDDIGITADOR")
	private Long iddigitador;
	@Column(name = "MATRICULA")
	private String matricula;
	@Column(name = "NOME")
	private String nome;
	@Column(name = "TIPO")
	private String tipo;
	@Column(name = "ESCRITO")
	private String escrito;
	@Column(name = "DATATRABALHO")
	private String datatrabalho;
	
	public Long getIddigitador() {
		return iddigitador;
	}
	public void setIdconciliador(Long iddigitador) {
		this.iddigitador = iddigitador;
	}
	public String getMatricula() {
		return matricula;
	}
	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public String getEscrito() {
		return escrito;
	}
	public void setJuizado(String escrito) {
		this.escrito = escrito;
	}
	public String getDatatrabalho() {
		return datatrabalho;
	}
	public void setDatacontar(String datatrabalho) {
		this.datatrabalho = datatrabalho;
	}
	
}
