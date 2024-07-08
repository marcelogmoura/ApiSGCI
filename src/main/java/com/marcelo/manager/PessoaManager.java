package com.marcelo.manager;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import com.marcelo.controller.schema.PessoaReq;
import com.marcelo.model.Endereco;
import com.marcelo.model.Pessoa;
import com.marcelo.repository.EnderecoRepository;
import com.marcelo.repository.PessoaRepository;

import jakarta.transaction.Transactional;

@Service
@Validated
public class PessoaManager {
	
	@Autowired
	PessoaRepository pessoaRepository;
	
	@Autowired
	EnderecoRepository enderecoRepository;

	@Transactional
	public Pessoa createPessoa(PessoaReq req) {
		
		Endereco endereco = new Endereco(
					req.endereco().cep(), 
					req.endereco().estado(), 
					req.endereco().cidade(), 
					req.endereco().rua(), 
					req.endereco().bairro(), 
					req.endereco().numero());
		
		Pessoa pessoa = new Pessoa(					
					req.nome(), 
					req.tipo(), 
					req.documento(), 
					req.profissao(), 
					req.estadoCivil(), 
					endereco);
		
		pessoaRepository.save(pessoa);

		return pessoa;
	}

	@Transactional
	public void deletePessoa(Long idPessoa) {		
		Pessoa pessoa = pessoaRepository.findById(idPessoa).orElseThrow();
		pessoaRepository.delete(pessoa);		
	}

	public List<Pessoa> findAll() {
		
		return pessoaRepository.findAll();
	}

}



