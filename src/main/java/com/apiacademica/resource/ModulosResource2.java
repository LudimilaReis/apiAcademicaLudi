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

import com.apiacademica.domain.Modulos;
import com.apiacademica.repository.IModulosRepository;

@RestController
@RequestMapping("/v2/modulos")
public class ModulosResource2 {

	@Autowired
	private IModulosRepository repository;	
	
	@GetMapping()
	public ResponseEntity<List<Modulos>> listModulos(){
		return ResponseEntity.
				status(HttpStatus.OK).
				body( repository.findAll());
	}
	
	@GetMapping(value = "/{uuid}")
	public ResponseEntity<Modulos> buscarPorUuid(@PathVariable String uuid) {	
       	return ResponseEntity.
			   status(HttpStatus.OK).
			   body( repository.getByUuid(uuid) );
	}
	@DeleteMapping(value = "/{uuid}")
	public ResponseEntity<Void> excluirPessoa(@PathVariable String uuid) {
		Modulos m = repository.findByUuid(uuid);
		
		if ( m != null ) {
			repository.deleteById(m.getId());
		} 
		
		return ResponseEntity.noContent().build();
	}
	
	@PostMapping()
	public ResponseEntity<Modulos> salvarModulos(@RequestBody Modulos m) {
		return ResponseEntity.
				status(HttpStatus.OK).
				body(this.repository.save(m));
	
	}
	
	@PutMapping()
	public void atualizarModulosResource() {
		
	}
	@DeleteMapping(value = "/{idmodulos}")
	public void excluirAlunos(@PathVariable Long idmodulos) {
		repository.deleteById(idmodulos);
	}
}

