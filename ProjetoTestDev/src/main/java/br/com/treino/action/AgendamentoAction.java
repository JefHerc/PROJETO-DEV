package br.com.treino.action;

import java.util.ArrayList;
import java.util.List;

import com.opensymphony.xwork2.ActionSupport;

import br.com.treino.business.AgendamentoBusiness;
import br.com.treino.model.Agendamento;

public class AgendamentoAction extends ActionSupport {
	
	private AgendamentoBusiness agendamentoBusiness = new AgendamentoBusiness();
	private Agendamento agendamento = new Agendamento();
	private List<Agendamento> agendamentos = new ArrayList<>();
	private String parametro = null;
	
	public String listar() {
		agendamentos.addAll(agendamentoBusiness.listarExames());
		return "listar";
	}
	
	public String salvar() {
		
		try {
			agendamentoBusiness.salvarAgendamento(agendamento);
			return SUCCESS;
		} catch (Exception e) {
			e.printStackTrace();
			addActionError(e.getMessage());
			return INPUT;
		}
	}
	
	public String alterar() {
		int cod = agendamento.getCodAgendamento();
		this.agendamento = agendamentoBusiness.carregarDados(agendamento.getCodAgendamento());
		System.out.println(agendamento);
		return "alterar";
	}
	
	public String incluir() {
		return "novo";
	}

	
	public String deletar() {
		agendamentoBusiness.excluirExame(agendamento.getCodAgendamento());
		return SUCCESS;
	} 
	
	public String procurar() {
		agendamentos.addAll(agendamentoBusiness.pesquisar(getParametro()));
		return "pesquisar";
	}

	public AgendamentoBusiness getAgendamentoBusiness() {
		return agendamentoBusiness;
	}

	public void setAgendamentoBusiness(AgendamentoBusiness agendamentoBusiness) {
		this.agendamentoBusiness = agendamentoBusiness;
	}

	public Agendamento getAgendamento() {
		return agendamento;
	}

	public void setAgendamento(Agendamento agendamento) {
		this.agendamento = agendamento;
	}

	public List<Agendamento> getAgendamentos() {
		return agendamentos;
	}

	public void setAgendamentos(List<Agendamento> agendamentos) {
		this.agendamentos = agendamentos;
	}

	public String getParametro() {
		return parametro;
	}

	public void setParametro(String parametro) {
		this.parametro = parametro;
	}	
}
