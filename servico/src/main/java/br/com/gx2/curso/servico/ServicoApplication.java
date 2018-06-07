package br.com.gx2.curso.servico;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.gx2.curso.servico.repository.ClienteRepository;
import br.com.gx2.curso.servico.repository.MovieRepository;

@SpringBootApplication
public class ServicoApplication implements CommandLineRunner{

	@Autowired
	private MovieRepository repository;
	
	@Autowired
	private ClienteRepository clientRepository;

	
	public static void main(String[] args) {
		SpringApplication.run(ServicoApplication.class, args);
	}
	
	@Override
	public void run(String... args) throws Exception {
		//clientRepository.deleteAll();
	}
	
	
	
	
}
