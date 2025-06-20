package com.moviebooking.beans;

import java.util.List;

public class Show {

	private String showId;
	private String screenId;
	private String movieId;
	private String showStart;
	private String showEnd;
	private List<ShowSeat> showSeats;

	public String getShowId() {
		return showId;
	}

	public void setShowId(String showId) {
		this.showId = showId;
	}

	public String getScreenId() {
		return screenId;
	}

	public void setScreenId(String screenId) {
		this.screenId = screenId;
	}

	public String getMovieId() {
		return movieId;
	}

	public void setMovieId(String movieId) {
		this.movieId = movieId;
	}

	public String getShowStart() {
		return showStart;
	}

	public void setShowStart(String showStart) {
		this.showStart = showStart;
	}

	public String getShowEnd() {
		return showEnd;
	}

	public void setShowEnd(String showEnd) {
		this.showEnd = showEnd;
	}

	public List<ShowSeat> getBookedSeats() {
		return showSeats;
	}

	public void setBookedSeats(List<ShowSeat> bookedSeats) {
		this.showSeats = bookedSeats;
	}

	public Show(String showId, String screenId, String movieId, String showStart, String showEnd,
			List<ShowSeat> bookedSeats) {
		super();
		this.showId = showId;
		this.screenId = screenId;
		this.movieId = movieId;
		this.showStart = showStart;
		this.showEnd = showEnd;
		this.showSeats = bookedSeats;
	}

}
