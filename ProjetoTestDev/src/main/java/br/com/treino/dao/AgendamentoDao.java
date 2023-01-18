package br.com.treino.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import br.com.treino.model.Agendamento;

public class AgendamentoDao extends Dao {

	public void salvarExame(Agendamento agendamento) {
		String sql = "INSERT INTO agendamento (paciente, exame, obersevacao_resultado, data_agendamento) VALUES (?, ?, ?, ?)";

		try (Connection con = getConexao(); PreparedStatement pstm = con.prepareStatement(sql)) {
			pstm.setString(1, agendamento.getPaciente());
			pstm.setString(2, agendamento.getExame());
			pstm.setString(3, agendamento.getObservacaoResultado());
			pstm.setObject(4, agendamento.getdataAgendamento());

			pstm.execute();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public boolean isPacienteUnico(String paciente) {
		int cod = 0;
		String query = "SELECT COUNT(1) FROM agendamento WHERE LOWER(paciente) = LOWER(?);";
		try (Connection con = getConexao(); PreparedStatement pstm = con.prepareStatement(query)) {
			pstm.setString(1, paciente);
			ResultSet rst = pstm.executeQuery();
			if (rst.next()) {
				cod = rst.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		boolean resultado = cod == 0 ? true : false;
		return resultado;
	}

	public boolean isPacienteUnico(int codAgendamento, String paciente) {
		boolean resultado = true;
		String query = "SELECT * FROM agendamento WHERE LOWER(paciente) = LOWER(?);";
		try (Connection con = getConexao(); PreparedStatement pstm = con.prepareStatement(query)) {
			pstm.setString(1, paciente);
			ResultSet rst = pstm.executeQuery();
			if (rst.next()) {
				int cod = rst.getInt("cod_agendamento");
				if (cod != codAgendamento) {
					resultado = false;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return resultado;
	}

	public List<Agendamento> listarAgendamentos() {
		List<Agendamento> agendamentos = new ArrayList<>();
		String sql = "SELECT * FROM agendamento ORDER BY paciente, exame";

		try (Connection con = getConexao(); PreparedStatement pstm = con.prepareStatement(sql)) {
			ResultSet rst = pstm.executeQuery();
			while (rst.next()) {
				agendamentos.add(new Agendamento(rst.getInt(1), rst.getString(2), rst.getString(3),
						rst.getObject(4, LocalDate.class), rst.getString(5)));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return agendamentos;
	}

	public Agendamento carregarDadosExame(int codAgendamento) {
		String sql = "SELECT * FROM agendamento WHERE cod_agendamento = ?";
		Agendamento exame = null;
		try (Connection con = getConexao(); PreparedStatement pstm = con.prepareStatement(sql)) {
			pstm.setInt(1, codAgendamento);
			ResultSet rst = pstm.executeQuery();
			if (rst.next()) {
				int cod = rst.getInt("cod_agendamento");
				String paciente = rst.getString("paciente");
				String nomeExame = rst.getString("exame");
				LocalDate exameData = rst.getObject("data_exame", LocalDate.class);
				String obs = rst.getString("obersevacao_resultado");
				exame = new Agendamento(cod, paciente, nomeExame, exameData, obs);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return exame;
	}

	public void excluirExame(int codAgendamento) {
		String sql = "DELETE FROM agendamento WHERE cod_agendamento = ?";
		try (Connection con = getConexao(); PreparedStatement pstm = con.prepareStatement(sql)) {
			pstm.setInt(1, codAgendamento);

			boolean isDeleted = pstm.execute();
			if (!isDeleted)
				throw new Exception("Não foi possível deletar o agendamento");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void alterarExame(Agendamento agendamento) {
		String sql = "UPDATE agendamento SET paciente = ?, exame = ?, data_agendamento = ?, obersevacao_resultado = ? WHERE cod_agendamento = ?";
		try (Connection con = getConexao(); PreparedStatement pstm = con.prepareStatement(sql)) {
			pstm.setString(1, agendamento.getPaciente());
			pstm.setString(2, agendamento.getExame());
			pstm.setObject(3, agendamento.getdataAgendamento());
			pstm.setString(4, agendamento.getObservacaoResultado());
			pstm.setInt(5, agendamento.getCodAgendamento());
			boolean isUpdated = pstm.execute();
			if (!isUpdated)
				throw new Exception("Não foi possível alterar o agendamento");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public List<Agendamento> pesquisarAgendamentos(String parametro) {
		List<Agendamento> agendamentos = new ArrayList<>();
		String query = "SELECT * FROM agendamento WHERE LOWER(paciente) LIKE LOWER(?) ORDER BY paciente";
		try (Connection con = getConexao(); PreparedStatement pstm = con.prepareStatement(query)) {
			pstm.setString(1, "%" + parametro + "%");
			pstm.execute();
			ResultSet rst = pstm.getResultSet();

			while (rst.next()) {
				agendamentos.add(new Agendamento(rst.getInt(1), rst.getString(2), rst.getString(3),
						rst.getObject(4, LocalDate.class), rst.getString(5)));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return agendamentos;
	}

}
