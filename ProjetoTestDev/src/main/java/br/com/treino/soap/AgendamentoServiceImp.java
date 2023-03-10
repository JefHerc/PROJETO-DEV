package br.com.treino.soap;

import java.util.ArrayList;
import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebService;

import br.com.treino.business.AgendamentoBusiness;
import br.com.treino.exception.BusinessException;
import br.com.treino.model.Agendamento;

@WebService(endpointInterface = "br.com.treino.soap.AgendamentoService")
public class AgendamentoServiceImp implements AgendamentoService {

	private static AgendamentoBusiness agendamentoBusiness = new AgendamentoBusiness();

	@Override
	public boolean deletarAgendamento(int id) {
			agendamentoBusiness.excluirExame(id);
			return true;
	}

	@Override
	public List<Agendamento> buscarAgendamentos(String nomePaciente) {
		List<Agendamento> exames = new ArrayList<>();
		exames.addAll(agendamentoBusiness.pesquisar(nomePaciente));
		return exames;
	}

	@Override
	public List<Agendamento> getAgendamentos() {
		List<Agendamento> exames = new ArrayList<>();
		exames.addAll(agendamentoBusiness.listarExames());
		return exames;
	}

	@Override
	public boolean alterarAgendamento(Agendamento agendamento) throws BusinessException {
		
			agendamentoBusiness.salvarAgendamento(agendamento);
			return true;
	}

	@Override
	@WebMethod(operationName = "CadastraNovoAgendamento")
	public boolean setAgendamento(Agendamento agendamento) throws BusinessException {
		
			agendamentoBusiness.salvarAgendamento(agendamento);
			return true;
		
	}

}
