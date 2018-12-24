package com.marmitaria.app.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.marmitaria.app.domain.Pedido;
import com.marmitaria.app.domain.Prato;

public class PedidoDTO implements Serializable {

	private Long id;
	private int quantidade;
	private String nomeDoCliente;
	private List<PratoDTO> pratos = new ArrayList<>();

	public PedidoDTO(Pedido p) {
		super();
		this.id = p.getId();
		this.quantidade = p.getQuantidade();
		this.nomeDoCliente = p.getCliente().getNome();
		for (Prato prato : p.getPratos()) {
			pratos.add(new PratoDTO(prato));
		}
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

	public List<PratoDTO> getPratos() {
		return pratos;
	}

	public void setPratos(List<PratoDTO> pratos) {
		this.pratos = pratos;
	}

}
