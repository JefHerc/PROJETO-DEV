package br.com.treino.business;

import java.time.LocalDate;
import java.util.List;

import br.com.treino.dao.ExameDao;
import br.com.treino.model.Exame;

public class ExameBusiness {

	private ExameDao dao;

	public ExameBusiness() {
		dao = new ExameDao();
	}

	public void salvarAgendamento(Exame exame) {
		try {

			validarData(exame);

			if (exame.getCodAgendamento() == null) {
				boolean pacienteUnico = dao.isPacienteUnico(exame.getPaciente());
				if (!pacienteUnico)
					throw new Exception("Este paciente já foi cadastrado");
				dao.salvarExame(exame);
			} else {
				boolean pacienteUnico = dao.isPacienteUnico(exame.getCodAgendamento(), exame.getPaciente());
				if (!pacienteUnico)
					throw new Exception("Não é possível alterar o nome do paciente para um nome já cadastrado");
				dao.alterarExame(exame);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public List<Exame> listarExames() {
		return dao.listarExames();
	}

	public void excluirExame(int codExame) {
		dao.excluirExame(codExame);
	}

	public Exame carregarDados(int codExame) {
		return dao.carregarDadosExame(codExame);
	}

	public List<Exame> pesquisar(String parametro) {
		return dao.pesquisarExames(parametro);
	}

	public boolean validarData(Exame exame) throws Exception {
		LocalDate dataAtual = LocalDate.now();
		if (exame.getDataExame().isAfter(dataAtual)) {
			return true;
		} else {
			throw new Exception("DATA DEVE SER MAIOR");
		}
	}
}
