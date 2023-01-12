package br.com.treino.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import br.com.treino.model.Exame;

public class ExameDao extends Dao {

	public void salvarExame(Exame exame) {
		String sql = "INSERT INTO exame (paciente, exame, obersevacao_resultado, data_exame) VALUES (?, ?, ?, ?)";

		try (Connection con = getConexao(); PreparedStatement pstm = con.prepareStatement(sql)) {
			pstm.setString(1, exame.getPaciente());
			pstm.setString(2, exame.getExame());
			pstm.setString(3, exame.getObservacaoResultado());
			pstm.setObject(4, exame.getDataExame());

			pstm.execute();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public boolean isPacienteUnico(String paciente) {
		int cod = 0;
		String query = "SELECT COUNT(1) FROM exame WHERE LOWER(paciente) = LOWER(?);";
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
		String query = "SELECT * FROM exame WHERE LOWER(paciente) = LOWER(?);";
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

	public List<Exame> listarExames() {
		List<Exame> exames = new ArrayList<>();
		String sql = "SELECT * FROM exame ORDER BY paciente, exame";

		try (Connection con = getConexao(); PreparedStatement pstm = con.prepareStatement(sql)) {
			ResultSet rst = pstm.executeQuery();
			while (rst.next()) {
				exames.add(new Exame(rst.getInt(1), rst.getString(2), rst.getString(3),
						rst.getObject(4, LocalDate.class), rst.getString(5)));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return exames;
	}

	public Exame carregarDadosExame(int codExame) {
		String sql = "SELECT * FROM exame WHERE cod_agendamento = ?";
		Exame exame = null;
		try (Connection con = getConexao(); PreparedStatement pstm = con.prepareStatement(sql)) {
			pstm.setInt(1, codExame);
			ResultSet rst = pstm.executeQuery();
			if (rst.next()) {
				int cod = rst.getInt("cod_agendamento");
				String paciente = rst.getString("paciente");
				String nomeExame = rst.getString("exame");
				LocalDate exameData = rst.getObject("data_exame", LocalDate.class);
				String obs = rst.getString("obersevacao_resultado");
				exame = new Exame(cod, paciente, nomeExame, exameData, obs);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return exame;
	}

	public void excluirExame(int codExame) {
		String sql = "DELETE FROM exame WHERE cod_agendamento = ?";
		try (Connection con = getConexao(); PreparedStatement pstm = con.prepareStatement(sql)) {
			pstm.setInt(1, codExame);

			boolean isDeleted = pstm.execute();
			if (!isDeleted)
				throw new Exception("Não foi possível deletar o agendamento");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void alterarExame(Exame exame) {
		String sql = "UPDATE exame SET paciente = ?, exame = ?, data_exame = ?, obersevacao_resultado = ? WHERE cod_agendamento = ?";
		try (Connection con = getConexao(); PreparedStatement pstm = con.prepareStatement(sql)) {
			pstm.setString(1, exame.getPaciente());
			pstm.setString(2, exame.getExame());
			pstm.setObject(3, exame.getDataExame());
			pstm.setString(4, exame.getObservacaoResultado());
			pstm.setInt(5, exame.getCodAgendamento());
			boolean isUpdated = pstm.execute();
			if (!isUpdated)
				throw new Exception("Não foi possível deletar o agendamento");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public List<Exame> pesquisarExames(String parametro) {
		List<Exame> exames = new ArrayList<>();
		String query = "SELECT * FROM exame WHERE LOWER(paciente) LIKE LOWER(?) ORDER BY paciente";
		try (Connection con = getConexao(); PreparedStatement pstm = con.prepareStatement(query)) {
			pstm.setString(1, "%" + parametro + "%");
			pstm.execute();
			ResultSet rst = pstm.getResultSet();

			while (rst.next()) {
				exames.add(new Exame(rst.getInt(1), rst.getString(2), rst.getString(3),
						rst.getObject(4, LocalDate.class), rst.getString(5)));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return exames;
	}

}
