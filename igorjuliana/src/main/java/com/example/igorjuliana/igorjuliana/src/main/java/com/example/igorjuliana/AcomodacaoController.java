package com.example.igorjuliana;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriBuilder;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/acomodacoes")
public class AcomodacaoController {

	@Autowired
	private AcomodacaoRepository repositorio;
	
	@GetMapping
	@RequestMapping("/todos")
	public List<AcomodacaoDTO> listar(){
		List<Acomodacao> lista = repositorio.findAll();
		return AcomodacaoDTO.converter(lista);
	}
	
	@PostMapping
	@RequestMapping("/cadastra")
	public ResponseEntity<AcomodacaoDTO> cadastrar(Acomodacao a, UriComponentsBuilder uriBuilder){
		if(a == null) {
			return new ResponseEntity<AcomodacaoDTO>(HttpStatus.BAD_REQUEST);
		}AcomodacaoDTO adto = new AcomodacaoDTO(a);
		repositorio.save(a);
		URI uri = uriBuilder.path("/acomodacoes/{id}").buildAndExpand(a.getId()).toUri();
		return ResponseEntity.created(uri).body(adto);
	}
	
	
	@GetMapping
	@RequestMapping("/detalha")
	public ResponseEntity<AcomodacaoDTO> detalha(Long id){
		Optional<Acomodacao> o = repositorio.findById(id);
		if(o.isPresent()) {
			return ResponseEntity.ok(new AcomodacaoDTO(o.get()));
		}return ResponseEntity.notFound().build();
	}
	
	
	@DeleteMapping
	@RequestMapping("/deleta")
	public ResponseEntity<?> delete(Long id){
		Optional<Acomodacao> o = repositorio.findById(id);
		if(o.isPresent()) {
			repositorio.delete(o.get());
			return ResponseEntity.ok().build();
		}return ResponseEntity.notFound().build();
	}
	
	@PutMapping
	@RequestMapping("/atualiza")
	public ResponseEntity<AcomodacaoDTO> atualizar(Long id, AcomodacaoForm af){
		Optional<Acomodacao> o = repositorio.findById(id);
		if(o.isPresent()) {
			af.atualizar(o.get());
			return ResponseEntity.ok().build();
		}return ResponseEntity.notFound().build();
	}
	
}
