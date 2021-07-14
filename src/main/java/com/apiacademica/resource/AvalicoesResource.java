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

import com.apiacademica.domain.Avaliacoes;
import com.apiacademica.repository.IAvaliacoesRepository;

@RestController
@RequestMapping("/v1/avaliacoes")
public class AvalicoesResource {
	
	@Autowired
	private IAvaliacoesRepository repository;
	
	@GetMapping()
	public ResponseEntity<List<Avaliacoes>> listAvaliacoes(){
		return ResponseEntity.
				status(HttpStatus.OK).
				body( repository.findAll());
	}
	
	@PostMapping()
	public void salvarAvaliacoesResource(@RequestBody Avaliacoes ava){

		repository.save(ava);
	
	}
	
	@PutMapping()
	public void atualizarAvalicaoResource() {
		
	}
	@DeleteMapping()
	public void excluirAvalicaoResource() {
		
	}

	

}