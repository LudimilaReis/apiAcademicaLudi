package com.apiacademica.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.apiacademica.domain.Modulos;

public interface IModulosRepository extends JpaRepository<Modulos, Long>{
	Modulos getBydisciplina(String disciplina);
	Modulos getByUuid(String uuid);
	Modulos findByUuid(String uuid);
	void deleteByUuid(String uuid);

}
