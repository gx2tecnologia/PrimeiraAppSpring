package br.com.gx2.curso.servico.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.gx2.curso.servico.entities.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Integer>{
	
	List<Cliente> findByNome(String nome);
	
	List<Cliente> findByCpf(String cpf);
	
}
