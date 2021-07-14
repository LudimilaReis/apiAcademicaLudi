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

import com.apiacademica.domain.Notas;
import com.apiacademica.repository.INotasRepository;

@RestController
@RequestMapping("/v1/notas")
public class NotasResource {
	
	@Autowired
	private INotasRepository repository;
	
	@GetMapping()
	public ResponseEntity<List<Notas>> listNotas(){
		return ResponseEntity.
				status(HttpStatus.OK).
				body( repository.findAll());
	}
	
	@PostMapping()
		public void salvarNotasResource(@RequestBody Notas n){

			repository.save(n);
	
	}
	
	@PutMapping()
	public void atualizarNotaResource() {
		
	}
	@DeleteMapping()
	public void excluirNotaResource() {
		
	}

	

}