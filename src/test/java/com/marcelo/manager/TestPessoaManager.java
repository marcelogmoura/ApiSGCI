package com.marcelo.manager;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import com.marcelo.controller.schema.EnderecoReq;
import com.marcelo.controller.schema.PessoaReq;
import com.marcelo.controller.schema.PessoaResponse;
import com.marcelo.controller.schema.PessoaUpd;
import com.marcelo.controller.schema.ResponsePagedCommom;
import com.marcelo.factory.entity.EnderecoFactory;
import com.marcelo.factory.entity.PessoaFactory;
import com.marcelo.model.Pessoa;
import com.marcelo.repository.PessoaRepository;

@ActiveProfiles("test")
@SpringBootTest
class TestPessoaManager {
	
	@Autowired
	private PessoaManager pessoaManager;
	
	@Autowired
	private PessoaRepository pessoaRepository;
	
	@Test
	void Create_Pessoa() {
		EnderecoReq enderecoReq = EnderecoFactory.getEnderecoReq();
		PessoaReq req = PessoaFactory.getPessoaReq(enderecoReq , "77744411100"); 
		
		Pessoa pessoa = pessoaManager.createPessoa(req);
		
		assertNotNull(pessoa);
		assertNotNull(pessoa.getId());
		
		// ou assertTrue(pessoa != null && pessoa.getId() > 0);
		
		System.out.println("|=====>>>>>>>> Criado |======>>> " + pessoa.getNome());
		
	}
	
	
	@Test
	void Find_Pessoa_By_Id() {
		
		// criando a pessoa para ser encontrada pelo id 
		EnderecoReq enderecoReq = EnderecoFactory.getEnderecoReq();
		PessoaReq req = PessoaFactory.getPessoaReq(enderecoReq, "45788877711"); // cpf manual p nao quebrar e criar o mesmo da classe anterior
		
		Pessoa pessoa = pessoaManager.createPessoa(req);
		
		PessoaResponse pessoaEncontrada = pessoaManager.findById(pessoa.getId());
		// checou se encontrou e SE o documento confere com o id da pessoa
		assertTrue(pessoaEncontrada != null && pessoaEncontrada.documento().equals(pessoa.getDocumento()));
		
		System.out.println("|====>>>> Encontrado pelo ID ===>>> " +pessoa.getNome());
				
	}
	
	@Test
	void Find_All_Paged() {
		
		EnderecoReq enderecoReq = EnderecoFactory.getEnderecoReq();
		PessoaReq req = PessoaFactory.getPessoaReq(enderecoReq , "17744411100"); 		
		Pessoa pessoa = pessoaManager.createPessoa(req);		
		
		ResponsePagedCommom<PessoaResponse> retorno = pessoaManager.findAll(PessoaFactory.getPessoaFilter());
		
		assertTrue(!retorno.getData().isEmpty() && retorno.getTotalPages()> 0);
		
	}
	
	
	@Test
	void Delete_Pessoa_By_Id() {
		EnderecoReq enderecoReq = EnderecoFactory.getEnderecoReq();
		PessoaReq req = PessoaFactory.getPessoaReq(enderecoReq, "00188877711");
		Pessoa pessoa = pessoaManager.createPessoa(req);
		
		pessoaManager.deletePessoa(pessoa.getId());
		
		Optional<Pessoa> pessoaOpt = pessoaRepository.findById(pessoa.getId());
		
		assertTrue(pessoaOpt.isEmpty());
		
		System.out.println("|=====  Deletado =====| ");		
		
	}
	
	@Test
	void Update_Pessoa_By_id() {
		EnderecoReq enderecoReq = EnderecoFactory.getEnderecoReq();
		PessoaReq req = PessoaFactory.getPessoaReq(enderecoReq, "00188877799");
		Pessoa pessoa = pessoaManager.createPessoa(req);
		
		PessoaUpd novosDados = PessoaFactory.getPessoaUpd(EnderecoFactory.getEnderecoUpd());		
		Pessoa pessoaAtualzida = pessoaManager.updatePessoa(pessoa.getId(), novosDados);
		
		assertTrue(pessoaAtualzida.getNome().equals(novosDados.nome()));
		assertTrue(pessoaAtualzida.getDocumento().equals(novosDados.documento()));
		
		System.out.println("|=====  Atualizado =====| ");		
	}
	
	

	
	
}
