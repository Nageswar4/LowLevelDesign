package com.moviebooking.service;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import com.moviebooking.beans.*;

public class MovieService {

	private static MovieService movieService;
	private Map<String, Movie> movieMapping;

	private MovieService() {
		this.movieMapping = new ConcurrentHashMap<>();
	}

	public static MovieService getInstance() {
		if (movieService == null) {
			synchronized (MovieService.class) {
				if (movieService == null) {
					movieService = new MovieService();
				}
			}
		}
		return movieService;
	}

	public boolean addMovie(Movie movie) {
		this.movieMapping.put(movie.getMovieId(), movie);
		return true;

	}

	public Map<String, Movie> getAllMovies() {
		return this.movieMapping;
	}

	public Movie getMovie(String movieId) {
		return this.movieMapping.getOrDefault(movieId, null);
	}

	public boolean removeMovie(String movieId) {
		if (this.movieMapping.containsKey(movieId))
			this.movieMapping.remove(movieId);

		return true;
	}

}
