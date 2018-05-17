package br.com.gx2.curso.servico.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.gx2.curso.servico.entities.Cliente;
import br.com.gx2.curso.servico.repository.ClienteRepository;

public class ClienteService {

	@Autowired
	private ClienteRepository clienteRepository;
	
	public List<Cliente> filter (String cpf, String nome) {
		List<Cliente> cli = new ArrayList<>();
		
		if(!cpf.isEmpty() && !nome.isEmpty())
			cli = clienteRepository.findAll();
		else {
			if(!cpf.isEmpty()) {
				 cli = clienteRepository.findByCpf(cpf);
			}
			if(!nome.isEmpty()) {
				 cli = clienteRepository.findByNome(nome);
			}
			
		}
		
		return cli;
	}
}
