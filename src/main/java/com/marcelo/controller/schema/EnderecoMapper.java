package com.marcelo.controller.schema;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.marcelo.model.Endereco;


@Mapper
public interface EnderecoMapper {

	EnderecoMapper INSTANCE = Mappers.getMapper(EnderecoMapper.class);
	
	EnderecoResponse toEnderecoResponse(Endereco endereco);
	
}
