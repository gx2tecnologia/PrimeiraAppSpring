package br.com.gx2.curso.servico.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.gx2.curso.servico.entities.Movie;
import br.com.gx2.curso.servico.repository.MovieRepository;

@Service
public class MovieService {

	@Autowired
	private MovieRepository movieRepository;
	
	public void insert (ArrayList<Movie> movie) {
		
		movieRepository.saveAll(movie);
		
	}
	
	public List<Movie> find (String id) {
		List<Movie> movie = new ArrayList<>();
		
		if (id==null) {
			movie = movieRepository.findAll();	
		}else {
			Optional<Movie> oneMovie = movieRepository.findById(id);
			movie.add(oneMovie.get());
			
		}
		
		return movie;
	}
	
	public List<Movie> findActor (String actor){
		List<Movie> movie = movieRepository.findCustomByActors(actor);
		return movie;
	}
	
	

}