package br.com.treino.test;

import br.com.treino.servico.ExameService;

public class DeletarRegistro {
	
	public static void main(String[] args) throws Exception {
		
		Util util = new Util();
		ExameService servicoExame = util.getServicoExame();
		
		int id = 4;
		System.out.println("Deletar registro id: " + id);
		System.out.println(servicoExame.deletarExame(id));

	}
}
