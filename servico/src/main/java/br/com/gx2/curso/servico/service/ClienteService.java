package br.com.gx2.curso.servico.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.gx2.curso.servico.entities.Cliente;
import br.com.gx2.curso.servico.repository.ClienteRepository;

@Service
public class ClienteService {

	@Autowired
	private ClienteRepository clienteRepository;
	
	public List<Cliente> filter (String cpf, String nome) {
		List<Cliente> cli = new ArrayList<>();
		
		if(cpf == null && nome == null)
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
	
	public Cliente vote(Integer clientId) {
		Cliente client = new Cliente();
		try {
		
			client = clienteRepository.getOne(clientId);
		
			client.setVote(client.getVote() + 1);
		
			client = clienteRepository.save(client);
			
		}catch(Exception ex) {
			
		}
		
		return client;
	}
}
