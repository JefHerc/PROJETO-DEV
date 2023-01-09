package br.com.treino.test;

import java.net.MalformedURLException;
import java.net.URL;

import javax.xml.namespace.QName;

import br.com.treino.servico.ExameService;
import jakarta.xml.ws.Service;

public class Util  {
			
	private ExameService servicoExame;

	public Util() throws MalformedURLException {
		URL urlServico = new URL("http://localhost:8080/okami/soap?wsdl");
		QName qnameServico = new QName("http://soap.treino.com.br/", "ExameServiceImpService");
		Service servico = Service.create(urlServico, qnameServico);		
		servicoExame = servico.getPort(ExameService.class);
	}

	public ExameService getServicoExame() {
		return servicoExame;
	}	
}
