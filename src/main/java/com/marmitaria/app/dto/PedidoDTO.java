package com.marmitaria.app.dto;

import java.util.List;

import com.marmitaria.app.domain.Pedido;

public class PedidoDTO {

	private Long id;
	private int quantidade;
	private String nomeDoCliente;
	private List<String> pratos;
	
	public PedidoDTO(Pedido p) {
		super();
		this.id = p.getId();
		this.quantidade = p.getQuantidade();
		this.nomeDoCliente = p.getCliente().getNome();
		p.getPratos().forEach(i -> {
			pratos.add(i.getNome());
		});
	}
		
}
