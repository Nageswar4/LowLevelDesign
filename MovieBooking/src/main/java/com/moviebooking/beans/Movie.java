package com.moviebooking.beans;

import java.time.LocalDate;

public class Movie {

	private String movieId;
	private String movieName;
	private String duration;
	private LocalDate releasedate;

	public String getMovieId() {
		return movieId;
	}

	public void setMovieId(String movieId) {
		this.movieId = movieId;
	}

	public String getMovieName() {
		return movieName;
	}

	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}

	public String getDuration() {
		return duration;
	}

	public void setDuration(String duration) {
		this.duration = duration;
	}

	public Movie(String movieId, String movieName, String duration, LocalDate releasedate) {
		super();
		this.movieId = movieId;
		this.movieName = movieName;
		this.duration = duration;
		this.releasedate = releasedate;
	}

	public LocalDate getReleasedate() {
		return releasedate;
	}

	public void setReleasedate(LocalDate releasedate) {
		this.releasedate = releasedate;
	}

}
