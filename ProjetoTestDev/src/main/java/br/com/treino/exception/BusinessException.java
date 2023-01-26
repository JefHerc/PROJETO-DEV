package br.com.treino.exception;

import javax.xml.ws.WebFault;

@WebFault(name="AutorizacaoFault") 
public class BusinessException extends Exception {
	
	public BusinessException(String s) {
		super(s);
	}
}
