package com.marcelo.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;

import com.marcelo.model.Pessoa;

public interface PessoaRepository extends JpaRepository<Pessoa, Long>{

	Page<Pessoa> findAll(Specification<Pessoa> filtrosCustomizados, Pageable pageRequest);

}
