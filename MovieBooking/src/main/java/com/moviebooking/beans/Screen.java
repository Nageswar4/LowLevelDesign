package com.moviebooking.beans;

public class Screen {

	private String screenId;
	private String theaterId;
	private String screenName;
	private String movieId;

	public String getMovieId() {
		return movieId;
	}

	public void setMovieId(String movieId) {
		this.movieId = movieId;
	}

	public String getScreenId() {
		return screenId;
	}

	public void setScreenId(String screenId) {
		this.screenId = screenId;
	}

	public String getTheaterId() {
		return theaterId;
	}

	public Screen(String screenId, String theaterId, String screenName) {
		super();
		this.screenId = screenId;
		this.theaterId = theaterId;
		this.screenName = screenName;
	}

	public void setTheaterId(String theaterId) {
		this.theaterId = theaterId;
	}

	public String getScreenName() {
		return screenName;
	}

	public void setScreenName(String screenName) {
		this.screenName = screenName;
	}
}
