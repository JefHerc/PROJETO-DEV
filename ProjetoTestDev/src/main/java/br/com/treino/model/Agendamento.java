package br.com.treino.model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import com.opensymphony.xwork2.conversion.annotations.Conversion;
import com.opensymphony.xwork2.conversion.annotations.TypeConversion;

import br.com.treino.conversor.DateAdpter;

@Conversion
@XmlAccessorType(XmlAccessType.FIELD)
public class Agendamento {

	private Integer codAgendamento;
	private String paciente;
	private String exame;
	
	@XmlJavaTypeAdapter(DateAdpter.class)
	private LocalDate dataAgendamento;
	
	private String observacaoResultado;
	
	 public Agendamento() {
		super();
	}

	public Agendamento(Integer codAgendamento, String paciente, String exame, LocalDate dataAgendamento,
			String observacaoResultado) {
		super();
		this.codAgendamento = codAgendamento;
		this.paciente = paciente;
		this.exame = exame;
		this.dataAgendamento = dataAgendamento;
		this.observacaoResultado = observacaoResultado;
	}

	public Integer getCodAgendamento() {
		return codAgendamento;
	}

	public void setCodAgendamento(Integer codAgendamento) {
		this.codAgendamento = codAgendamento;
	}

	public String getPaciente() {
		return paciente;
	}

	public void setPaciente(String paciente) {
		this.paciente = paciente;
	}

	public String getExame() {
		return exame;
	}

	public void setExame(String exame) {
		this.exame = exame;
	}

	public LocalDate getDataAgendamento() {
		return dataAgendamento;
	}

	@TypeConversion (converter = "br.com.treino.conversor.ConversorStringToDate")
	public void setDataAgendamento(LocalDate dataAgendamento) {
		this.dataAgendamento = dataAgendamento;
	}

	public String getObservacaoResultado() {
		return observacaoResultado;
	}

	public void setObservacaoResultado(String observacaoResultado) {
		this.observacaoResultado = observacaoResultado;
	}

	public String getDataFormatadaBR() {
	    	DateTimeFormatter formatador = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	        return formatador.format(getDataAgendamento());
	    }
	 
	 public String dataFormatadaENG() {
	    	DateTimeFormatter formatador = DateTimeFormatter.ofPattern("yyyy-MM-dd");
	        return formatador.format(getDataAgendamento());
	    }

	@Override
	public String toString() {
		return "Agendamento [codAgendamento=" + codAgendamento + ", paciente=" + paciente + ", exame=" + exame
				+ ", dataAgendamento=" + dataAgendamento + ", observacaoResultado=" + observacaoResultado + "]";
	}

	
}
