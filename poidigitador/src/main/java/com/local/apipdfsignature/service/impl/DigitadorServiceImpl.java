package com.local.apipdfsignature.service.impl;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.local.apipdfsignature.model.Digitador;
import com.local.apipdfsignature.repository.DigitadorRepository;
import com.local.apipdfsignature.service.DigitadorService;

@Service
public class DigitadorServiceImpl implements DigitadorService{
	
	@Autowired
	private DigitadorRepository repository;

	@Override
	public List<Digitador> listarTodosDigitadores() {
		return repository.findAll();
	}

	@Override
	public Digitador exibirDigitador(Long iddigitador) {
		return repository.findById(iddigitador).get();
	}

	@Override
	public ByteArrayInputStream exportarExcel() {
		
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		
		try {
			String[] colunas = {"IDDIGITADOR", "MATRICULA","NOME","TIPO","ESCRITO","DATATRABALHO"}; 
			XSSFWorkbook workbook = new XSSFWorkbook();
		
			List<Digitador> digitadores = repository.findAll();
		
			XSSFSheet sheet = workbook.createSheet("Digitadores");
			
			XSSFRow row = sheet.createRow(0);
			XSSFCell cell;
		
			for (int col = 0; col < colunas.length; col++) {
				cell = row.createCell(col);
				cell.setCellValue(colunas[col]);
				sheet.autoSizeColumn(col);
				borderSheet(workbook, row);
			}
			
			int i = 1;
			
			for (Digitador digitador: digitadores) {
				XSSFRow row1 = sheet.createRow(i++);
				
				row1.createCell(0).setCellValue(digitador.getIddigitador());
				row1.createCell(1).setCellValue(digitador.getMatricula());
				row1.createCell(2).setCellValue(digitador.getNome());
				row1.createCell(3).setCellValue(digitador.getTipo());
				row1.createCell(4).setCellValue(digitador.getEscrito());
				row1.createCell(5).setCellValue(digitador.getDatatrabalho());
				borderSheet(workbook, row1);
				
				sheet.autoSizeColumn(i);
			}			
			
			workbook.write(out);
			workbook.close();
		} catch (IOException e) {
			System.out.println("Ocorreu um erro inexperado!!!" + e.getMessage());
		}finally {
			System.out.println("O sistema será finalizado!!!");
		}
		return new ByteArrayInputStream(out.toByteArray());
	}
	
	public static void borderSheet(XSSFWorkbook workbook, XSSFRow row) {
		XSSFCellStyle cellStyle = workbook.createCellStyle();
		cellStyle.setBorderBottom(BorderStyle.THIN);
		cellStyle.setBorderLeft(BorderStyle.THIN);
		cellStyle.setBorderRight(BorderStyle.THIN);
		cellStyle.setBorderTop(BorderStyle.THIN);
		
		for (int i = 0; i < row.getLastCellNum(); i++) {
			row.getCell(i).setCellStyle(cellStyle);
		}
		
	}
	
}
