package br.com.treino.business;

import java.time.LocalDate;
import java.util.List;

import br.com.treino.dao.AgendamentoDao;
import br.com.treino.model.Agendamento;

public class AgendamentoBusiness {

	private AgendamentoDao dao;

	public AgendamentoBusiness() {
		dao = new AgendamentoDao();
	}

	public void salvarAgendamento(Agendamento exame) throws Exception {
		
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

	}

	public List<Agendamento> listarExames() {
		return dao.listarAgendamentos();
	}

	public void excluirExame(int codExame) {
		dao.excluirExame(codExame);
	}

	public Agendamento carregarDados(int codExame) {
		return dao.carregarDadosExame(codExame);
	}

	public List<Agendamento> pesquisar(String parametro) {
		return dao.pesquisarAgendamentos(parametro);
	}

	public boolean validarData(Agendamento agendamento) throws Exception {
		LocalDate dataAtual = LocalDate.now();
		if (agendamento.getdataAgendamento().isAfter(dataAtual)) {
			return true;
		} else {
			throw new Exception("DATA DEVE SER MAIOR");
		}
	}
}
