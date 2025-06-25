package com.elevator.elevatorstate;

import com.elevator.beans.Elevator;

public class MovingUpState implements ElevatorState {

	@Override
	public void addRequest(int floorId) {

		Elevator elevator = Elevator.getInstance();
		if (floorId > elevator.getCurrentFloorId()) {
			elevator.getMovingUp().add(floorId);
		} else {
			elevator.getMovingDown().add(floorId);
		}

	}

	@Override
	public void move(Elevator elevator) {

		if (!elevator.getMovingUp().isEmpty()) {
			int nextFloor = elevator.getMovingUp().poll();
			elevator.setCurrentFloorId(nextFloor);
		} else {
			if (!elevator.getMovingDown().isEmpty()) {
				elevator.setState(new MovingDownState());
			} else {
				elevator.setState(new IdleState());
			}

		}

	}

}
