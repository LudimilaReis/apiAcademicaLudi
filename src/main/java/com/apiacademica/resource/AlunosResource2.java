package com.apiacademica.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.apiacademica.domain.Alunos;
import com.apiacademica.repository.IAlunosRepository;;

@RestController
@RequestMapping("/v2/alunos")
public class AlunosResource2 {
	
	@Autowired
	private IAlunosRepository repository;
	
	@GetMapping()
	public ResponseEntity<List<Alunos>> listAlunos(){
		return ResponseEntity.
				status(HttpStatus.OK).
				body( repository.findAll());
		
	}
	@GetMapping(value = "/{uuid}")
	public ResponseEntity<Alunos> buscarPorUuid(@PathVariable String uuid) {	
       	return ResponseEntity.
			   status(HttpStatus.OK).
			   body( repository.getByUuid(uuid) );
	}
	@DeleteMapping(value = "/{uuid}")
	public ResponseEntity<Void> excluirAlunos(@PathVariable String uuid) {
		Alunos a = repository.findByUuid(uuid);
		
		if ( a != null ) {
			repository.deleteById(a.getId());
		} 
		
		return ResponseEntity.noContent().build();
	}
	
	@PostMapping()
	public ResponseEntity<Alunos> salvarAlunos(@RequestBody Alunos a) {
		return ResponseEntity.
				status(HttpStatus.OK).
				body(this.repository.save(a));
	
	}
	
	@PutMapping()
	public void atualizarAlunoResource() {
	}

	@DeleteMapping(value = "/{idalunos}")
	public void excluirAlunos(@PathVariable Long idalunos) {
		repository.deleteById(idalunos);
	}
	
}