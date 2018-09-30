package com.marmitaria.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.marmitaria.app.domain.Prato;
import com.marmitaria.app.repository.PratoRepository;

@Service
public class PratoService {
	
	@Autowired
	private PratoRepository pratoRepository;

	public List<Prato> listar() {
		return pratoRepository.findAll();
	}

	public void salvar(Prato prato) {
		pratoRepository.save(prato);
	}

	public Prato buscar(Long id) {
		Optional<Prato> prato = null;
		
		try {
			prato = pratoRepository.findById(id);
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
		return prato.isPresent() ? prato.get() : null;
	}

	public void excluir(Long id) {
		Prato prato = buscar(id);
		
		if (prato != null)
			pratoRepository.delete(prato);
	}

}
