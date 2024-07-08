package com.marcelo.controller.schema;

public record EnderecoResponse(
		String cep, 
		String estado, 
		String cidade, 
		String rua,
		String bairro,
		Integer numero
	){
}
