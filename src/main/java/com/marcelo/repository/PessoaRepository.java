package com.marcelo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.marcelo.model.Pessoa;

public interface PessoaRepository extends JpaRepository<Pessoa, Long>{

}
