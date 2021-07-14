package com.apiacademica.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.apiacademica.domain.Notas;

public interface INotasRepository extends JpaRepository<Notas, Long>{
	Notas getBynota1(String nota1);
	Notas getByUuid(String uuid);
	Notas findByUuid(String uuid);
	void deleteByUuid(String uuid);

}
