package com.marcelo.factory.entity;

import com.marcelo.controller.schema.EnderecoReq;
import com.marcelo.controller.schema.EnderecoUpd;
import com.marcelo.model.Endereco;

public class EnderecoFactory {
	
	public static Endereco getEndereco() {		
		return new Endereco( "25042150", "RJ", "Caxias", "Rua Sete", "Pantanal", 7);
	}
	
	public static EnderecoReq getEnderecoReq() {
		
		return new EnderecoReq(
				"25042150", 
				"RJ", 
				"Caxias", 
				"Rua Sete", 
				"Pantanal", 
				7);
	}
	
	
	public static EnderecoUpd getEnderecoUpd() {		
		return new EnderecoUpd( "00000001", "SP", "Mooca", "Rua Mooca", "Mooca", 100);
	}
	

}
