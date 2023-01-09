package br.com.treino.soap;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebService;

import br.com.treino.model.Exame;

@WebService ()
public interface ExameService {

	@WebMethod
	boolean deletarExame(int id);
	
	@WebMethod
	List<Exame> buscarExames(String nomePaciente);
	
	@WebMethod
	List<Exame> getExames();
	
	@WebMethod
	boolean alterarExame(Exame exame);
	
	@WebMethod
	boolean setExame(Exame exame);
}
