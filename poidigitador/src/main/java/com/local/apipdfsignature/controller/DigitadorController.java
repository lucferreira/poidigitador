package com.local.apipdfsignature.controller;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.local.apipdfsignature.model.Digitador;
import com.local.apipdfsignature.service.DigitadorService;

@RestController
@RequestMapping("api/orgao/digitador")
public class DigitadorController {
	
	@Autowired
	private DigitadorService service;
	
	@GetMapping
	public List<Digitador> exibirTodosDigitadores(){
		return service.listarTodosDigitadores();
	}
	
	@GetMapping("/{iddigitador}")
	public Digitador exibirDigitador(@PathVariable Long iddigitador) {
		return service.exibirDigitador(iddigitador);
	}
	
	@GetMapping("/exportar/excel")
	public ResponseEntity<InputStreamResource> exportarDadosExcel() throws IOException {
		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-Disposition", "attachment; filename=digitadores.xlsx");
		ByteArrayInputStream out = service.exportarExcel();
		return ResponseEntity.ok().headers(headers).body(new InputStreamResource(out));
	}

}
