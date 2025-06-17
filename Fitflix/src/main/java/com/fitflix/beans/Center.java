package com.fitflix.beans;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Center {
	private String centerId;
	private String centerName;
	private GymStatus status;
	private String location;
	@Id
	private String id;

	public Center(String centerId, String centerName, GymStatus status, String location) {
		super();
		this.centerId = centerId;
		this.centerName = centerName;
		this.status = status;
		this.location = location;
	}

	public String getCenterId() {
		return centerId;
	}

	public void setCenterId(String centerId) {
		this.centerId = centerId;
	}

	public String getCenterName() {
		return centerName;
	}

	public void setCenterName(String centerName) {
		this.centerName = centerName;
	}

	public GymStatus getStatus() {
		return status;
	}

	public void setStatus(GymStatus status) {
		this.status = status;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

}
