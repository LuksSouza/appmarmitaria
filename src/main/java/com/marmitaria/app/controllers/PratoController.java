package com.marmitaria.app.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.marmitaria.app.domain.Cliente;
import com.marmitaria.app.domain.Prato;
import com.marmitaria.app.service.PratoService;

@RestController
@RequestMapping("/prato")
public class PratoController {

	@Autowired
	private PratoService pratoService;
	
	@RequestMapping(method=RequestMethod.GET)
	public List<Prato> listar() {
		return pratoService.listar(); 
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public void salvar(@RequestBody Prato prato) {
		pratoService.salvar(prato);
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public Prato buscar(@PathVariable("id") Long id) {
		return pratoService.buscar(id);
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.DELETE)
	public void excluir(@PathVariable("id") Long id) {
		pratoService.excluir(id);
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.PUT)
	public void atualizar(@RequestBody Prato prato, @PathVariable("id") Long id) {
		prato.setId(id);
		pratoService.salvar(prato);
	}
}
