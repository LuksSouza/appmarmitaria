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

import com.marmitaria.app.domain.Pedido;
import com.marmitaria.app.dto.PedidoDTO;
import com.marmitaria.app.service.PedidoService;

@RestController
@RequestMapping("/pedido")
public class PedidoController {
	
	@Autowired
	private PedidoService pedidoService;

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<PedidoDTO>> listar() {
		return ResponseEntity.status(HttpStatus.OK).body(pedidoService.listarPedidos());
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> salvar(@RequestBody Pedido pedido) {
		pedido = pedidoService.salvar(pedido);
		
		URI uri = ServletUriComponentsBuilder
					.fromCurrentRequest()
					.path("{id}")
					.buildAndExpand(pedido.getId())
					.toUri();
		
		return ResponseEntity.created(uri).build();
	}
	
	public ResponseEntity<Pedido> buscar(Long id) {
		Pedido pedido = pedidoService.buscar(id);
		
		if (pedido == null)
			return ResponseEntity.notFound().build();
		
		return ResponseEntity.status(HttpStatus.OK).body(pedido);
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.DELETE)
	public ResponseEntity<Void> excluir(@PathVariable("id") Long id) {
		try {
			pedidoService.excluir(id);
		} catch (EmptyResultDataAccessException e) {
			return ResponseEntity.notFound().build();
		}
		
		return ResponseEntity.noContent().build();
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.PUT)
	public ResponseEntity<Void> atualizar(@RequestBody Pedido pedido, @PathVariable("id") Long id) {
		pedido.setId(id);
		pedidoService.salvar(pedido);
		
		return ResponseEntity.noContent().build();
	}
}
