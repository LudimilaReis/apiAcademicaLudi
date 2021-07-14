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

import com.apiacademica.domain.Avaliacoes;
import com.apiacademica.repository.IAvaliacoesRepository;

@RestController
@RequestMapping("/v2/avaliacoes")
public class AvalicoesResource2 {
	
	@Autowired
	private IAvaliacoesRepository repository;
	
	@GetMapping()
	public ResponseEntity<List<Avaliacoes>> listAvaliacoes(){
		return ResponseEntity.
				status(HttpStatus.OK).
				body( repository.findAll());
	}
	
	@GetMapping(value = "/{uuid}")
	public ResponseEntity<Avaliacoes> buscarPorUuid(@PathVariable String uuid) {	
       	return ResponseEntity.
			   status(HttpStatus.OK).
			   body( repository.getByUuid(uuid) );
	}
@DeleteMapping(value = "/{uuid}")
	public ResponseEntity<Void> excluirPessoa(@PathVariable String uuid) {
		Avaliacoes AV = repository.findByUuid(uuid);
		
		if ( AV != null ) {
			repository.deleteById(AV.getId());
		} 
		
		return ResponseEntity.noContent().build();
	}
	
	@PostMapping()
	public ResponseEntity<Avaliacoes> salvarAvaliacoes(@RequestBody Avaliacoes ava) {
		return ResponseEntity.
				status(HttpStatus.OK).
				body(this.repository.save(ava));
	
	}
	
	@PutMapping()
	public void atualizarAvalicaoResource() {
		
	}
	@DeleteMapping(value = "/{idavaliacoes}")
	public void excluirAlunos(@PathVariable Long idavaliacoes) {
		repository.deleteById(idavaliacoes);
	}
}

