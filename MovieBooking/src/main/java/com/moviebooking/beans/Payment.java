package com.moviebooking.beans;

public class Payment {

	private String paymentId;
	private String bookingId;
	private double paymentAmount;
	private PaymentStatus status;

	public String getPaymentId() {
		return paymentId;
	}

	public void setPaymentId(String paymentId) {
		this.paymentId = paymentId;
	}

	public String getBookingId() {
		return bookingId;
	}

	public void setBookingId(String bookingId) {
		this.bookingId = bookingId;
	}

	public double getPaymentAmount() {
		return paymentAmount;
	}

	public void setPaymentAmount(double paymentAmount) {
		this.paymentAmount = paymentAmount;
	}

	public PaymentStatus getStatus() {
		return status;
	}

	public void setStatus(PaymentStatus status) {
		this.status = status;
	}

	public Payment(String paymentId, String bookingId, double paymentAmount, PaymentStatus status) {
		super();
		this.paymentId = paymentId;
		this.bookingId = bookingId;
		this.paymentAmount = paymentAmount;
		this.status = status;
	}
}
