package br.com.treino.business;

import java.time.LocalDate;
import java.util.List;

import br.com.treino.dao.AgendamentoDao;
import br.com.treino.exception.BusinessException;
import br.com.treino.model.Agendamento;

public class AgendamentoBusiness {

	private AgendamentoDao dao;

	public AgendamentoBusiness() {
		dao = new AgendamentoDao();
	}

	public void salvarAgendamento(Agendamento agendamento) throws BusinessException {

//		validarData(agendamento);
//		validarExame(agendamento);
//		validarPaciente(agendamento);

		if (agendamento.getCodAgendamento() == null) {
			boolean pacienteUnico = dao.isPacienteUnico(agendamento.getPaciente());
			if (!pacienteUnico)
				throw new BusinessException("Este paciente já possuí agendamento");
			dao.salvarAgendamento(agendamento);
		} else {
			boolean pacienteUnico = dao.isPacienteUnico(agendamento.getCodAgendamento(), agendamento.getPaciente());
			if (!pacienteUnico)
				throw new BusinessException("Não é possível alterar o nome do paciente para um com agendamento");
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

	public void validarData(Agendamento agendamento) throws BusinessException {
		LocalDate dataAtual = LocalDate.now();
		if (!agendamento.getDataAgendamento().isAfter(dataAtual))
			throw new BusinessException("A data do agendamento deve ser posterior a atual.");
	}

	public void validarPaciente(Agendamento agendamento) throws BusinessException {
		if (agendamento.getPaciente().trim().length() < 4)
			throw new BusinessException("O nome do paciente deve-ser preenchido");
	}

	public void validarExame(Agendamento agendamento) throws BusinessException {
		if (agendamento.getExame().trim().length() < 3)
			throw new BusinessException("O nome do exame deve ser preenchido");
	}

}
