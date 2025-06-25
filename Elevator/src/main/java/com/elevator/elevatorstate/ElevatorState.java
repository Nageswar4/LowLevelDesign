package com.elevator.elevatorstate;

import com.elevator.beans.Elevator;

public interface ElevatorState {
	public void addRequest(int foorId);

	public void move(Elevator elevator);

}
