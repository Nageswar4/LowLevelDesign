package com.elevator.elevatorstate;

import com.elevator.beans.Elevator;

public class MovingDownState implements ElevatorState {

	@Override
	public void addRequest(int floorId) {

		Elevator elevator = Elevator.getInstance();
		if (floorId < elevator.getCurrentFloorId()) {
			elevator.getMovingDown().add(floorId);
		} else {
			elevator.getMovingUp().add(floorId);
		}
	}

	@Override
	public void move(Elevator elevator) {

		if (!elevator.getMovingDown().isEmpty()) {
			int nextFloor = elevator.getMovingDown().poll();
			elevator.setCurrentFloorId(nextFloor);
		} else {
			if (!elevator.getMovingUp().isEmpty()) {
				elevator.setState(new MovingUpState());
			} else {
				elevator.setState(new IdleState());
			}
		}

	}

}
