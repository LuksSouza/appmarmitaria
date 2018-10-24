package com.marmitaria.app.dto;

import com.marmitaria.app.domain.Pedido;

public class PedidoDTO {

	private Long id;
	private int quantidade;
	private String nomeDoCliente;
	private String prato;
	
	public PedidoDTO(Pedido p) {
		super();
		this.id = p.getId();
		this.quantidade = p.getQuantidade();
		this.nomeDoCliente = p.getCliente().getNome();
		this.prato = p.getPrato().getNome();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public String getNomeDoCliente() {
		return nomeDoCliente;
	}

	public void setNomeDoCliente(String nomeDoCliente) {
		this.nomeDoCliente = nomeDoCliente;
	}

	public String getPrato() {
		return prato;
	}

	public void setPrato(String prato) {
		this.prato = prato;
	}
		
}
