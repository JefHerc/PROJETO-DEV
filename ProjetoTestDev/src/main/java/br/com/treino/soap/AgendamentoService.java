package br.com.treino.soap;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.ParameterStyle;
import javax.jws.soap.SOAPBinding.Style;
import javax.jws.soap.SOAPBinding.Use;

import br.com.treino.model.Agendamento;

@WebService
@SOAPBinding(style = Style.DOCUMENT, use = Use.LITERAL, parameterStyle = ParameterStyle.WRAPPED)
public interface AgendamentoService {

	@WebMethod 
	boolean deletarAgendamento(@WebParam (name = "CodigoAgendamento") int id);
	
	@WebMethod
	List<Agendamento> buscarAgendamentos(@WebParam (name = "NomePaciente") String nomePaciente);
	
	@WebMethod (operationName = "TodosAgendamentos")
	@WebResult (name = "Agendamentos")
	List<Agendamento> getAgendamentos();
	
	@WebMethod
	boolean alterarAgendamento(@WebParam (name = "Agendamento") Agendamento agendamento);
	
	@WebMethod (operationName = "CadastrarAgendamento")
	boolean setAgendamento(@WebParam (name = "Agendamento") Agendamento agendamento);
}
