package com.marmitaria.app.controllers;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.marmitaria.app.domain.Prato;
import com.marmitaria.app.service.PratoService;

@RestController
@RequestMapping("/prato")
public class PratoController {

	@Autowired
	private PratoService pratoService;
	
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<List<Prato>> listar() {
		return ResponseEntity.status(HttpStatus.OK).body(pratoService.listar()); 
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<Void> salvar(@RequestBody Prato prato) {
		prato = pratoService.salvar(prato);
		
		URI uri = ServletUriComponentsBuilder
					.fromCurrentRequest()
					.path("{id}")
					.buildAndExpand(prato)
					.toUri();
		
		return ResponseEntity.created(uri).build();
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<Prato> buscar(@PathVariable("id") Long id) {
		Prato prato = pratoService.buscar(id);
		
		if (prato == null)
			return ResponseEntity.notFound().build();
		
		return ResponseEntity.status(HttpStatus.OK).body(prato);
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.DELETE)
	public ResponseEntity<Void> excluir(@PathVariable("id") Long id) {
		try {
			pratoService.excluir(id);			
		} catch (EmptyResultDataAccessException e) {
			return ResponseEntity.notFound().build();
		}
		
		return ResponseEntity.noContent().build();
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.PUT)
	public ResponseEntity<Void> atualizar(@RequestBody Prato prato, @PathVariable("id") Long id) {
		prato.setId(id);
		pratoService.salvar(prato);
		
		return ResponseEntity.noContent().build();
	}
}
