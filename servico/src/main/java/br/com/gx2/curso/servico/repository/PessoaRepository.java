package br.com.gx2.curso.servico.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import br.com.gx2.curso.servico.entities.Pessoa;

public interface PessoaRepository extends JpaRepository<Pessoa, Integer> {

	Pessoa findByName(String name);
}
