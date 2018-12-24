package com.marmitaria.app.dto;

import java.io.Serializable;

import com.marmitaria.app.domain.Prato;

public class PratoDTO implements Serializable {

	private String nomeDoPrato;

	public PratoDTO(Prato p) {
		super();
		this.nomeDoPrato = p.getNome();
	}

	public String getNomeDoPrato() {
		return nomeDoPrato;
	}

	public void setNomeDoPrato(String nomeDoPrato) {
		this.nomeDoPrato = nomeDoPrato;
	}

}
