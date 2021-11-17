package com.devrev.apirest.service;

import java.io.File;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Map;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;

@Service
public class RelatorioService implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public byte[] gerarRelatorio(String nomeRelatorio, ServletContext servletContext, Map<String, Object> params) throws SQLException, JRException {
		
		// Obter a conexão com o banco
		Connection connection = jdbcTemplate.getDataSource().getConnection();
		// Carregar o caminho do arquivo de relatorio Jasper
		String caminhoJasper = servletContext.getRealPath("relatorios")
							 + File.separator + nomeRelatorio + ".jasper";
		
		// Gerar o relatório com os dados e conexão
		JasperPrint print = JasperFillManager.fillReport(caminhoJasper,params, connection);
		
		byte[] retorno = JasperExportManager.exportReportToPdf(print);
		
		connection.close();
		
		// Exporta para byte o PDF para fazer o download
		return retorno;
		
	}
	
}
