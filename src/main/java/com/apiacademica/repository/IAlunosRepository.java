package com.apiacademica.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.apiacademica.domain.Alunos;

public interface IAlunosRepository extends JpaRepository<Alunos, Long>{
	Alunos getByNome(String nome);
	Alunos getByUuid(String uuid);
	Alunos findByUuid(String uuid);
	void deleteByUuid(String uuid);
	

}
