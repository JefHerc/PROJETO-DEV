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

	public void salvarAgendamento(Agendamento agendamento) throws Exception {
		
			validarData(agendamento);

			if (agendamento.getCodAgendamento() == null) {
				boolean pacienteUnico = dao.isPacienteUnico(agendamento.getPaciente());
				if (!pacienteUnico)
					throw new Exception("Este paciente já foi cadastrado");
				dao.salvarAgendamento(agendamento);
			} else {
				boolean pacienteUnico = dao.isPacienteUnico(agendamento.getCodAgendamento(), agendamento.getPaciente());
				if (!pacienteUnico)
					throw new Exception("Não é possível alterar o nome do paciente para um nome já cadastrado");
				dao.alterarAgendamento(agendamento);
			}

	}

	public List<Agendamento> listarExames() {
		return dao.listarAgendamentos();
	}

	public void excluirExame(int codAgendamento) {
		dao.excluirAgendamento(codAgendamento);
	}

	public Agendamento carregarDados(int codAgendamento) {
		return dao.carregarDadosAgendamento(codAgendamento);
	}

	public List<Agendamento> pesquisar(String parametro) {
		return dao.pesquisarAgendamentos(parametro);
	}

	public boolean validarData(Agendamento agendamento) throws Exception {
		LocalDate dataAtual = LocalDate.now();
		if (agendamento.getDataAgendamento().isAfter(dataAtual)) {
			return true;
		} else {
			throw new Exception("DATA DEVE SER MAIOR");
		}
	}
}
