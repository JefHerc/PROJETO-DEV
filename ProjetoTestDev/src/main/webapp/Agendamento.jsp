<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<s:if test="agendamento.codAgendamento != null">
	<s:set var="title" value="%{'Alterar Agendamento'}" />
</s:if>
<s:else>
	<s:set var="title" value="%{'Cadastrar novo Agendamento'}" />
</s:else>
<!DOCTYPE html>
<html lang="pt-BR">

	<head>
		<meta charset="UTF-8">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<title>
			<s:property value="#title" />
		</title>
		<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet">
		<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.3.0/font/bootstrap-icons.css">
		<link rel="stylesheet" href="css/main.css">
	</head>

	<body>
		<div class="container">
			<h1 class="title">
				<s:property value="#title" />
			</h1>
				<label hidden="true" id="erro" ><s:actionerror /></label>
			

			<form action="salvarAgendamento.action" onsubmit="return validarForm()" class="needs-validation" novalidate method="post">
				<s:if test="agendamento.codAgendamento != null">
					<div class="mb-3">
						<label class="form-label">Código Agendamento</label>
						<s:textfield class="form-control" name="agendamento.codAgendamento" readonly="true" />
					</div>
				</s:if>
				<div class="mb-3">
					<label class="form-label">Paciente</label>
					<s:textfield id="paciente" maxlength="60" class="form-control to-check" name="agendamento.paciente" />
					<div class="invalid-feedback">
						Favor preencher o nome do paciente.
					</div>
				</div>
				<div class="mb-3">
					<label class="form-label">Exame</label>
					<s:textfield id="exame" maxlength="50" class="form-control to-check" name="agendamento.exame" />
					<div class="invalid-feedback">
						Favor preencher o nome do exame.
					</div>
				</div>
				<div class="mb-3">
					<label class="form-label">Data</label>
						<s:textfield type="date" maxlength="8" class="form-control to-check" id="data-agendamento"
						name="agendamento.dataAgendamento" value="%{agendamento.dataFormatadaENG}"/>
					<div class="invalid-feedback">
						A data deve ser maior que a data atual.
					</div>
				</div>
				<div class="mb-3">
					<label class="form-label">Observação / Resultado:</label>
					<s:textarea maxlength="250" class="form-control" rows="10" cols="30" name="agendamento.observacaoResultado" />
				</div>
				<s:url action="listarAgendamento.action" var="voltar"/>
				<a class="btn btn-primary" href="${voltar}">
					<i class="bi bi-arrow-return-left"></i> Agendamentos
				</a>
				<button class="btn btn-success" type="submit" id="salvar-agendamento">
					<i class="bi bi-save"></i> Salvar
				</button>
			</form>
		</div>

		<script type="text/javascript" src="js/jquery.js"></script>
		<script type="text/javascript" src="js/main.js"></script>
		<script type="text/javascript">
			var erro = document.querySelector("#erro span");
			console.log(erro)
			if(erro != null)
				alert(erro.innerText);
		</script>
	</body>
</html>