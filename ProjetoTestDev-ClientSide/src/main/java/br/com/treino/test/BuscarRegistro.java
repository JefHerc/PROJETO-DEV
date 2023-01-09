package br.com.treino.test;

import java.util.ArrayList;
import java.util.List;

import br.com.treino.servico.Exame;
import br.com.treino.servico.ExameService;

public class BuscarRegistro {

	public static void main(String[] args) throws Exception {
		Util util = new Util();
		ExameService servicoExame = util.getServicoExame();
		
		String paciente = "joey";
		System.out.println("Buscar registro que contém o paciente: " + paciente);
		
		List<Exame> resultado = new ArrayList<>();
		resultado.addAll(servicoExame.buscarExames(paciente));
		
		for (Exame exame : resultado) {
			System.out.println("Cod: " + exame.getCodAgendamento() + "/ Paciente: " + exame.getPaciente() + 
					"/ Exame: " + exame.getExame() + "/ Data: " + exame.getDataExame() + "/ Observação/Resultado: " + exame.getObservacaoResultado());
		}

	}

}
