<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<title>Listar Agendamentos</title>
				<link rel="stylesheet" href="css/main.css">
		
		<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet">
		<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.3.0/font/bootstrap-icons.css">
		<style type="text/css">
			.center {
				display: block;
				margin-left: auto;
				margin-right: auto;
				width: 50%;
				visibility: hidden;
			}
		</style>
	</head>
	<body>
		<div class="container">
			<h1 class="title">Agendamentos</h1>

			<form action="procurarAgendamento.action" method="post">
				<div class="d-flex flex-row mb-3">
					<div class="p-2">
						<input placeholder="Paciente" type="text" class="form-control" name="parametro" />
					</div>
					<button class="btn btn-outline-secondary" type="submit" id="Pesquisar">Search 
						<i class="bi bi-search"></i>
					</button>
				</div>
			</form>
			<div class="mb-3">
				<s:url action="incluirAgendamento.action" var="incluir" />
				<a class="btn btn-primary" href="${incluir}">
					<i class="bi bi-file-earmark-plus-fill"></i>
					<span> Incluir</span>
				</a>
			</div>
			<table class="table table-striped">
				<thead>
					<tr>
						<th>Código</th>
						<th>Paciente</th>
						<th>Exame</th>
						<th>Data</th>
						<th>Observação / Resultado</th>
						<th colspan="2">Ações</th>
					</tr>
				</thead>
				<tbody class="resultados">
					<s:iterator value="agendamentos" var="agendamento">
						<tr>
							<s:url action="deletarAgendamento" var="deletar">
								<s:param name="agendamento.codAgendamento" value="codAgendamento" />
							</s:url>
							<s:url action="alterarAgendamento" var="alterar">
								<s:param name="agendamento.codAgendamento" value="codAgendamento" />
							</s:url>
							<td>${codAgendamento}</td>
							<td>${paciente}</td>
							<td>${exame}</td>
							<td>${dataFormatadaBR}</td>
							<td>
								<s:property value="#agendamento.observacaoResultado" />
							</td>
							<td>
								<a onclick="return confirm('Tem certeza que deseja deletar este registro?')" href="${deletar}">
									<i title="Excluir" class="icone-medio bi bi-trash-fill"></i>
								</a>
							</td>
							<td>
								<a href="${alterar}">
									<i title="Editar" class="icone-medio bi bi-pencil-fill"></i>
								</a>
							</td>
						</tr>
					</s:iterator>
				</tbody>
			</table>
			<img id="noResult" class="center" alt="Sem-resultados" src="imagens/noResult.jpg" >
		</div>
	</body>
</html>