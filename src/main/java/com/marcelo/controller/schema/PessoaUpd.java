package com.marcelo.controller.schema;

import com.marcelo.model.EstadoCivilEnum;
import com.marcelo.model.TipoPessoaEnum;

import jakarta.validation.constraints.NotNull;

public record PessoaUpd( 
		
	@NotNull	
	String nome,
	
	@NotNull		
	EnderecoUpd endereco,
	
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
