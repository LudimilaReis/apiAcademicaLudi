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

import com.apiacademica.domain.Notas;
import com.apiacademica.repository.INotasRepository;

@RestController
@RequestMapping("/v2/notas")
public class NotasResource2 {
	
	@Autowired
	private INotasRepository repository;
	
	@GetMapping()
	public ResponseEntity<List<Notas>> listNotas(){
		return ResponseEntity.
				status(HttpStatus.OK).
				body( repository.findAll());
	}
	
	@GetMapping(value = "/{uuid}")
	public ResponseEntity<Notas> buscarPorUuid(@PathVariable String uuid) {	
       	return ResponseEntity.
			   status(HttpStatus.OK).
			   body( repository.getByUuid(uuid) );
	}
	@DeleteMapping(value = "/{uuid}")
	public ResponseEntity<Void> excluirPessoa(@PathVariable String uuid) {
		Notas n = repository.findByUuid(uuid);
		
		if ( n != null ) {
			repository.deleteById(n.getId());
		} 
		
		return ResponseEntity.noContent().build();
	}
	
	@PostMapping()
	public ResponseEntity<Notas> salvarNotas(@RequestBody Notas n) {
		return ResponseEntity.
				status(HttpStatus.OK).
				body(this.repository.save(n));
	
	}
	
	@PutMapping()
	public void atualizarNotaResource() {
		
	}
	@DeleteMapping(value = "/{idnotas}")
	public void excluirAlunos(@PathVariable Long idnotas) {
		repository.deleteById(idnotas);
	}
}