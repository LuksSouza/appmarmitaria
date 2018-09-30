package com.marmitaria.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.marmitaria.app.domain.Cliente;
import com.marmitaria.app.repository.ClienteRepository;

@Service
public class ClienteService {

	@Autowired
	private ClienteRepository clienteRepository;

	public List<Cliente> listar() {
		return clienteRepository.findAll();
	}

	public Cliente salvar(Cliente cliente) {
		return clienteRepository.save(cliente);
	}

	public Cliente buscar(Long id) {
		Optional<Cliente> c = null;
		try {
			c = clienteRepository.findById(id);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		return c.isPresent() ? c.get() : null;
	}

	public void apagar(Long id) {
		clienteRepository.deleteById(id);
	}

	public void excluir(Long id) {
		Cliente cliente = buscar(id);
		
		if (cliente != null)
			clienteRepository.delete(cliente);
	}

}
