package br.com.gx2.curso.servico.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.gx2.curso.servico.entities.Cliente;
import br.com.gx2.curso.servico.repository.ClienteRepository;
import br.com.gx2.curso.servico.service.ClienteService;

@RestController
@RequestMapping(value = "/clientes")
public class ClienteController {
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	@Autowired
	private ClienteService clienteService;

	//@RequestMapping(path="/clientes/{name}", method=RequestMethod.POST)
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<Void> insert(@RequestBody Cliente cli) {
		
		clienteRepository.save(cli);
		
		return ResponseEntity.ok().build();
		
	}
	
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<List<Cliente>> listAll(@RequestParam(required=false, value="nome") String nome, @RequestParam(required=false, value="cpf") String cpf) {
		
		List<Cliente> cli = clienteService.filter(cpf, nome);
		
		return ResponseEntity.ok().body(cli);
	}
	
	@RequestMapping(path="/{id}", method=RequestMethod.GET)
	public ResponseEntity<Cliente> list(@PathVariable Integer id){
		Optional<Cliente> cli = clienteRepository.findById(id);
		
		
		return ResponseEntity.ok().body(cli.get());
	}
	
	@RequestMapping(path="/{id}/votes", method=RequestMethod.POST)
	public ResponseEntity<Cliente> votes(@PathVariable Integer id){
		Cliente cli = clienteService.vote(id);
		
		return ResponseEntity.ok().body(cli);
	}

}

	
