package br.com.gx2.curso.servico.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.gx2.curso.servico.entities.Movie;
import br.com.gx2.curso.servico.repository.MovieRepository;
import br.com.gx2.curso.servico.service.MovieService;

@RestController
@RequestMapping(value = "/movies")
public class MovieController {
	
	@Autowired
	private MovieService movieService;
	
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<Void> insert(@RequestBody ArrayList<Movie> movie) {
		
		movieService.insert(movie);
		
		return ResponseEntity.ok().build();
	}
	
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<List<Movie>> find (@RequestParam(required=false, value="id") String id){
		
		List<Movie> movie = movieService.find(id);
		return ResponseEntity.ok().body(movie);
	}
	
	@RequestMapping(path="/{actors}", method=RequestMethod.GET)
	public ResponseEntity<List<Movie>> findActor (@RequestParam(required=true, value="actor") String actor){
		
		List<Movie> movie = movieService.findActor(actor);
		return ResponseEntity.ok().body(movie);
	}

}
