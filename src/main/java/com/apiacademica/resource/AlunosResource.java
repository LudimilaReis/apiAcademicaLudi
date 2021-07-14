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

import com.apiacademica.domain.Alunos;
import com.apiacademica.repository.IAlunosRepository;;

@RestController
@RequestMapping("/v1/alunos")
public class AlunosResource {
	
	@Autowired
	private IAlunosRepository repository;
	
	@GetMapping()
	public ResponseEntity<List<Alunos>> listAlunos(){
		return ResponseEntity.
				status(HttpStatus.OK).
				body( repository.findAll());
		
	}
	
	@PostMapping()
	public void salvarAlunoResource(@RequestBody Alunos a){

		repository.save(a);
	
	}
	
	@PutMapping()
	public void atualizarAlunoResource() {
	}

	@DeleteMapping()
	public void excluirAlunoResource() {
    } 
}