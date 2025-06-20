package com.moviebooking.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import com.moviebooking.beans.*;
import com.moviebooking.exception.NoSeatAvailable;

public class TheaterService {
	private static TheaterService theaterService;
	private Map<String, Theater> theaterMapping;
	private Map<String, Screen> screenMapping;
	private Map<String, Show> showMapping;

	public static TheaterService getInstance() {
		if (theaterService == null) {
			synchronized (TheaterService.class) {
				if (theaterService == null) {
					theaterService = new TheaterService();
				}
			}

		}
		return theaterService;
	}

	private TheaterService() {
		this.theaterMapping = new ConcurrentHashMap<>();
		this.screenMapping = new ConcurrentHashMap<>();
		this.showMapping = new ConcurrentHashMap<>();

	}

	public boolean addTheater(Theater theater) {
		this.theaterMapping.put(theater.getTheaterId(), theater);
		return true;
	}

	public boolean addScreen(Screen screen) {
		this.screenMapping.put(screen.getScreenId(), screen);
		return true;
	}

	public boolean addShow(Show show) {
		this.showMapping.put(show.getShowId(), show);
		return true;
	}

	public List<Theater> getAllTheater(String movieId) {
		List<Theater> theatersList = new ArrayList<>();

		for (Screen screen : this.screenMapping.values()) {
			if (movieId.equals(screen.getMovieId())) {
				if (!theatersList.contains(this.theaterMapping.get(screen.getTheaterId()))) {
					theatersList.add(this.theaterMapping.get(screen.getTheaterId()));
				}
			}
		}

		return theatersList;
	}

	public List<Show> getAllShows(String movieId, String theaterId) {
		List<Show> result = new ArrayList<>();
		for (Show show : this.showMapping.values()) {
			Screen screen = this.screenMapping.get(show.getScreenId());
			if (screen != null && screen.getTheaterId().equals(theaterId) && show.getMovieId().equals(movieId)) {
				result.add(show);
			}
		}
		return result;
	}

	public boolean bookTickets(String showId, List<String> seatIds) {

		Show show = this.showMapping.get(showId);
		List<ShowSeat> lockedSeat = new ArrayList<>();
		Collections.sort(seatIds);
		if (show == null)
			return false;

		try {
			for (String seatId : seatIds) {
				ShowSeat seat = findShowSeatId(showId, seatId);
				synchronized (seat) {
					if (seat.getSeatStatus().equals(SeatStatus.OPEN)) {
						seat.setSeatStatus(SeatStatus.INPROGRESS);
						lockedSeat.add(seat);
					} else {
						throw new NoSeatAvailable(" SeatId is " + seat.getSeatId());
					}

				}
			}
			for (ShowSeat seat : lockedSeat) {
				seat.setSeatStatus(SeatStatus.BOOKED);
			}
			return true;
		} catch (Exception e) {
			for (ShowSeat seat : lockedSeat) {

				synchronized (seat) {
					if (seat.getSeatStatus().equals(SeatStatus.INPROGRESS)) {
						seat.setSeatStatus(SeatStatus.OPEN);
					}
				}

			}

			return false;

		}

	}

	public boolean cancelTickets(String showId, List<String> seatIds) {

		Show show = this.showMapping.get(showId);
		List<ShowSeat> lockedSeat = new ArrayList<>();
		Collections.sort(seatIds);
		if (show == null)
			return false;

		try {
			for (String seatId : seatIds) {
				ShowSeat seat = findShowSeatId(showId, seatId);
				synchronized (seat) {
					if (seat.getSeatStatus().equals(SeatStatus.BOOKED)) {
						seat.setSeatStatus(SeatStatus.INPROGRESS);
						lockedSeat.add(seat);
					} else {
						throw new NoSeatAvailable(" SeatId is " + seat.getSeatId());
					}

				}
			}
			for (ShowSeat seat : lockedSeat) {
				seat.setSeatStatus(SeatStatus.OPEN);
			}
			return true;
		} catch (Exception e) {
			for (ShowSeat seat : lockedSeat) {

				synchronized (seat) {
					if (seat.getSeatStatus().equals(SeatStatus.INPROGRESS)) {
						seat.setSeatStatus(SeatStatus.BOOKED);
					}
				}

			}

			return false;

		}

	}

	private ShowSeat findShowSeatId(String showId, String seatId) {
		for (ShowSeat seat : this.showMapping.get(showId).getBookedSeats()) {
			if (seat.getSeatId().equals(seatId)) {
				return seat;
			}
		}

		return null;
	}

};
