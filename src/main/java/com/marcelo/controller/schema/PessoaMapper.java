package com.marcelo.controller.schema;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import com.marcelo.model.Pessoa;


@Mapper
public interface PessoaMapper {
	
	PessoaMapper INSTANCE = Mappers.getMapper(PessoaMapper.class);
	
	@Mapping(source = "enderecoResponse", target = "endereco")
	@Mapping(source = "pessoa.id", target = "id")	
	PessoaResponse toPessoaResponse(Pessoa pessoa, EnderecoResponse enderecoResponse);

}
