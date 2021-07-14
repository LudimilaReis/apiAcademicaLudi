package com.apiacademica.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.apiacademica.domain.Avaliacoes;

public interface IAvaliacoesRepository extends JpaRepository<Avaliacoes, Long>{
	Avaliacoes getBycurso(String curso);
	Avaliacoes getByUuid(String uuid);
	Avaliacoes findByUuid(String uuid);
	void deleteByUuid(String uuid);

}
