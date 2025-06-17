package com.fitflix.beans;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Slot {

	private String slotId;
	private String centerId;
	private String slotName;
	private int maxCount;
	private int startTime;
	private int endTime;
	private WorkOutType workOutType;
	@Id
	private String id;

	public Slot(String slotId, String centerId, String slotName, int maxCount, int startTime, int endTime,
			WorkOutType workOutType) {
		super();
		this.slotId = slotId;
		this.centerId = centerId;
		this.slotName = slotName;
		this.maxCount = maxCount;
		this.startTime = startTime;
		this.endTime = endTime;
		this.workOutType = workOutType;
	}

	public WorkOutType getWorkOutType() {
		return workOutType;
	}

	public void setWorkOutType(WorkOutType workOutType) {
		this.workOutType = workOutType;
	}

	public String getSlotId() {
		return slotId;
	}

	public void setSlotId(String slotId) {
		this.slotId = slotId;
	}

	public String getCenterId() {
		return centerId;
	}

	public void setCenterId(String centerId) {
		this.centerId = centerId;
	}

	public String getSlotName() {
		return slotName;
	}

	public void setSlotName(String slotName) {
		this.slotName = slotName;
	}

	public int getMaxCount() {
		return maxCount;
	}

	public void setMaxCount(int maxCount) {
		this.maxCount = maxCount;
	}

	public int getStartTime() {
		return startTime;
	}

	public void setStartTime(int startTime) {
		this.startTime = startTime;
	}

	public int getEndTime() {
		return endTime;
	}

	public void setEndTime(int endTime) {
		this.endTime = endTime;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

}
