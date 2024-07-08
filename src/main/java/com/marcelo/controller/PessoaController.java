package com.marcelo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.marcelo.controller.schema.PessoaReq;
import com.marcelo.manager.PessoaManager;
import com.marcelo.model.Pessoa;

import jakarta.validation.Valid;

@RestController
@RequestMapping("pessoas")
public class PessoaController {
	
	@Autowired
	private PessoaManager pessoaManager;
	
	@PostMapping
	public ResponseEntity<Long> createPessoa(@Valid @RequestBody PessoaReq req){
		Pessoa pessoa = pessoaManager.createPessoa(req);
		return ResponseEntity.ok(pessoa.getId());
	}
	
	@GetMapping
	public ResponseEntity<List<Pessoa>> findAll(){
		
		return ResponseEntity.ok(pessoaManager.findAll());
	}

//	@PutMapping
	
	@DeleteMapping(path = { "{idPessoa}" })
	public ResponseEntity<Long> deletePessoa(@PathVariable Long idPessoa ) {
		pessoaManager.deletePessoa(idPessoa);
		return ResponseEntity.ok().build();
	}
	
	
}
