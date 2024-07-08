package com.marcelo.manager;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import com.marcelo.controller.schema.EnderecoMapper;
import com.marcelo.controller.schema.EnderecoResponse;
import com.marcelo.controller.schema.PessoaMapper;
import com.marcelo.controller.schema.PessoaReq;
import com.marcelo.controller.schema.PessoaResponse;
import com.marcelo.controller.schema.PessoaUpd;
import com.marcelo.model.Endereco;
import com.marcelo.model.Pessoa;
import com.marcelo.repository.EnderecoRepository;
import com.marcelo.repository.PessoaRepository;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;



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

	public List<PessoaResponse> findAll() {
		
		List<PessoaResponse> listReponse = new ArrayList<PessoaResponse>();
		
		List<Pessoa> listPessoaBd = pessoaRepository.findAll();
		listPessoaBd.forEach(item -> {
			EnderecoResponse enderecoResponse = EnderecoMapper.INSTANCE.toEnderecoResponse(item.getEndereco());
			PessoaResponse pessoaResponse = PessoaMapper.INSTANCE.toPessoaResponse(item, enderecoResponse);
			listReponse.add(pessoaResponse);
		});
		
		
		return listReponse;
	}

	@Transactional
	public Pessoa updatePessoa(@Valid Long idPessoa, PessoaUpd upd) {
		
		Pessoa pessoa = pessoaRepository.findById(idPessoa).orElseThrow();
		
		pessoa.setDocumento(upd.documento());
		pessoa.setEstadoCivil(upd.estadoCivil());
		pessoa.setNome(upd.nome());
		pessoa.setProfissao(upd.profissao());
		pessoa.setTipo(upd.tipo());
		
		pessoa.getEndereco().setCep(upd.endereco().cep());
		pessoa.getEndereco().setEstado(upd.endereco().estado());
		pessoa.getEndereco().setCidade(upd.endereco().cidade());
		pessoa.getEndereco().setRua(upd.endereco().rua());
		pessoa.getEndereco().setBairro(upd.endereco().bairro());
		pessoa.getEndereco().setNumero(upd.endereco().numero());
				
		pessoaRepository.save(pessoa);
		
		return pessoa;
	}

	public PessoaResponse findById(Long idPessoa) {
		
		Pessoa pessoa = pessoaRepository.findById(idPessoa).orElseThrow();
		EnderecoResponse enderecoResponse = EnderecoMapper.INSTANCE.toEnderecoResponse(pessoa.getEndereco());
		PessoaResponse pessoaResponse = PessoaMapper.INSTANCE.toPessoaResponse(pessoa, enderecoResponse);
		
		return pessoaResponse;
	}

}



