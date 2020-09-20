package com.local.apipdfsignature.service;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.List;

import com.local.apipdfsignature.model.Digitador;

public interface DigitadorService {
	
	public List<Digitador> listarTodosDigitadores();
	public Digitador exibirDigitador(Long iddigitador);
	public ByteArrayInputStream exportarExcel() throws IOException;
	
}
