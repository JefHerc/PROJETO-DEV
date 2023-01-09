package br.com.treino.soap;

import java.util.ArrayList;
import java.util.List;

import javax.jws.WebService;

import br.com.treino.business.ExameBusiness;
import br.com.treino.model.Exame;

@WebService(endpointInterface = "br.com.treino.soap.ExameService")
public class ExameServiceImp implements ExameService {

	private static ExameBusiness exameBusiness = new ExameBusiness();

	@Override
	public boolean deletarExame(int id) {
		try {
			exameBusiness.excluirExame(id);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public List<Exame> buscarExames(String nomePaciente) {
		List<Exame> exames = new ArrayList<>();
		exames.addAll(exameBusiness.pesquisar(nomePaciente));
		return exames;
	}

	@Override
	public List<Exame> getExames() {
		List<Exame> exames = new ArrayList<>();
		try {
			exames.addAll(exameBusiness.listarExames());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return exames;
	}

	@Override
	public boolean alterarExame(Exame exame) {
		try {
			exameBusiness.salvarAgendamento(exame);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean setExame(Exame exame) {
		try {
			exameBusiness.salvarAgendamento(exame);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

}
