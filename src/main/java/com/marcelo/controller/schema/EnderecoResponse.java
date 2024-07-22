package com.marcelo.controller.schema;

public record EnderecoResponse(
		Long id,
		String cep, 
		String estado, 
		String cidade, 
		String rua,
		String bairro,
		Integer numero
	){
}
