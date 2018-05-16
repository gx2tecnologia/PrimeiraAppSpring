package br.com.gx2.curso.servico.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import br.com.gx2.curso.servico.entities.Pessoa;
import br.com.gx2.curso.servico.repository.PessoaRepository;

@RestController
public class HelloController {

	@Autowired
	private PessoaRepository pessoaRepository;
	
	@RequestMapping(path="/Hello", method=RequestMethod.GET)
	String sayHello() {
		return "Hello Christhensen!";
	}
	
	@RequestMapping(path="/SayMyName/{name}", method=RequestMethod.POST)
	Pessoa sayMyName(@PathVariable String name) {
		
		Pessoa p = new Pessoa();
		p.setName(name);
		
		return p;
	}
	
	@RequestMapping(path="hello/body", method=RequestMethod.POST)
	Pessoa sayHelloBody(@RequestBody Pessoa pessoa) {
		
		Pessoa saved = pessoaRepository.save(pessoa);
		
		return saved;
	}
	
	@RequestMapping(path="people/findbyname", method=RequestMethod.POST)
	Pessoa findPeople(@RequestBody Pessoa pessoa) {
		
		Pessoa p = pessoaRepository.findByName(pessoa.getName());
		
		return p;
	}
	
}
