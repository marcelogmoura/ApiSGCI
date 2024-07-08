package com.marcelo.controller.schema;

import com.marcelo.model.EstadoCivilEnum;
import com.marcelo.model.TipoPessoaEnum;

public record PessoaResponse( 
		
	String nome,
	EnderecoResponse endereco,
	TipoPessoaEnum tipo,
	String documento,
	String profissao,
	EstadoCivilEnum estadoCivil
	
) {
}
