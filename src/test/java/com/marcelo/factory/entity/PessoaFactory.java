package com.marcelo.factory.entity;

import org.springframework.data.domain.Sort.Direction;

import com.marcelo.controller.schema.EnderecoReq;
import com.marcelo.controller.schema.EnderecoUpd;
import com.marcelo.controller.schema.PessoaFilter;
import com.marcelo.controller.schema.PessoaReq;
import com.marcelo.controller.schema.PessoaUpd;
import com.marcelo.model.Endereco;
import com.marcelo.model.EstadoCivilEnum;
import com.marcelo.model.Pessoa;
import com.marcelo.model.TipoPessoaEnum;

public class PessoaFactory {
	
	public static Pessoa getPessoa(Endereco endereco) {		
		return new Pessoa( 
				"Ana", 
				TipoPessoaEnum.PESSOA_FISICA, 
				"12345678", 
				"Pintor", 
				EstadoCivilEnum.CASADO, 
				endereco);
	}

	public static PessoaReq getPessoaReq(EnderecoReq enderecoReq, String documento) {
		
		return new PessoaReq(
				"Ana", 
				enderecoReq, 
				TipoPessoaEnum.PESSOA_FISICA, 
				documento, 
				"Pintor" , 
				EstadoCivilEnum.DIVORCIADO);
	}
	
	public static PessoaUpd getPessoaUpd(EnderecoUpd endereco) {
		return new PessoaUpd( 
				"Ana Atualizada", 
				endereco,
				TipoPessoaEnum.PESSOA_FISICA, 
				"00000000010", 
				"Pintor atualizado", 
				EstadoCivilEnum.SOLTEIRO);		
	}
	
	public static PessoaFilter getPessoaFilter() {
		PessoaFilter filtros = new PessoaFilter();
		filtros.setPage(0);
		filtros.setSize(1);
		filtros.setDirection(Direction.ASC);
		filtros.setOrdenarPor("nome");
		
		return filtros;
	}
}
