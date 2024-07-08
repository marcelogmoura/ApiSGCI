package com.marcelo.controller.schema;

import com.marcelo.model.EstadoCivilEnum;
import com.marcelo.model.TipoPessoaEnum;

import jakarta.validation.constraints.NotNull;

public record PessoaReq( 
		
	@NotNull	
	String nome,
	
	@NotNull		
	EnderecoReq endereco,
	
	@NotNull	
	TipoPessoaEnum tipo,
	
	@NotNull	
	String documento,
	
	@NotNull	
	String profissao,
	
	@NotNull	
	EstadoCivilEnum estadoCivil
	
) {
}
