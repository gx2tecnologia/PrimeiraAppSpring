package br.com.gx2.curso.servico.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.mongodb.repository.MongoRepository;

import br.com.gx2.curso.servico.entities.Movie;

public interface MovieRepository extends MongoRepository<Movie, String>{

	public Optional<Movie> findById (String id);
	
	@Query(value = "{ 'actors' : {$in : [?0] }}")
	List<Movie> findCustomByActors(String actor);
	
}
