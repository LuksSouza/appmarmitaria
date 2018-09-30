package com.marmitaria.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.marmitaria.app.domain.Pedido;
import com.marmitaria.app.repository.PedidoRepository;

@Service
public class PedidoService {
	
	@Autowired
	private PedidoRepository pedidoRepository;

	public List<Pedido> listarPedidos() {
		return pedidoRepository.findAll();
	}

	public Pedido salvar(Pedido pedido) {
		return pedidoRepository.save(pedido);
	}

	public Pedido buscar(Long id) {
		Optional<Pedido> pedido = null;
		
		try {
			pedido = pedidoRepository.findById(id);
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
		return pedido.isPresent() ? pedido.get() : null;
	}

	public void excluir(Long id) {
		Pedido pedido = buscar(id);
		
		if (pedido != null)
			pedidoRepository.delete(pedido);
	}

}
