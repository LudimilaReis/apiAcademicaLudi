package com.apiacademica.resource;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.apiacademica.domain.Modulos;
import com.apiacademica.repository.IModulosRepository;

@RestController
@RequestMapping("/v1/modulos")
public class ModulosResource {

	@Autowired
	private IModulosRepository repository;	
	
	@GetMapping()
	public ResponseEntity<List<Modulos>> listModulos(){
		return ResponseEntity.
				status(HttpStatus.OK).
				body( repository.findAll());
	}
	
	@PostMapping()
	public void salvarModulosResource(@RequestBody Modulos m){

		repository.save(m);
	
	}
	
	@PutMapping()
	public void atualizarModulosResource() {
		
	}
	@DeleteMapping()
	public void excluirModulosResource() {
		
	}

	

}