package com.local.apipdfsignature.dto;

import java.util.List;
import java.util.stream.Collectors;

import com.local.apipdfsignature.model.Digitador;

public class DigitadorDto {
	
	private String matricula;
	private String nome;

	public DigitadorDto(Digitador dig) {
		this.matricula = dig.getMatricula();
		this.nome = dig.getNome();
	}
	
	public List<DigitadorDto> converter(List<Digitador> digs){
		return digs.stream().map(DigitadorDto::new).collect(Collectors.toList());
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
	
	public Digitador toDigitador() {
		final Digitador dig = new Digitador();
		
		dig.setMatricula(matricula);
		dig.setNome(nome);
		
		return dig;
	}
	
	

}
