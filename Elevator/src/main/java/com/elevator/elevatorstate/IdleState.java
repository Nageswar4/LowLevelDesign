package com.elevator.elevatorstate;

import com.elevator.beans.Elevator;

public class IdleState implements ElevatorState {

	@Override
	public void addRequest(int floorId) {
		Elevator elevator = Elevator.getInstance();
		if (floorId > elevator.getCurrentFloorId()) {
			elevator.getMovingUp().add(floorId);
			elevator.setState(new MovingUpState());
		} else {
			elevator.getMovingDown().add(floorId);
			elevator.setState(new MovingDownState());

		}

	}

	@Override
	public void move(Elevator elevator) {

	}

}
