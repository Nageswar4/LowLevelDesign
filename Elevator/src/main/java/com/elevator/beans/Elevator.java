package com.elevator.beans;

import java.util.PriorityQueue;

import com.elevator.elevatorstate.ElevatorState;
import com.elevator.elevatorstate.IdleState;

public class Elevator {

	private int elevatorId;
	private Direction direction;
	PriorityQueue<Integer> movingUp;
	PriorityQueue<Integer> movingDown;
	private ElevatorState state;

	private int currentFloorId;

	private static Elevator elevator;

	private Elevator() {
		this.movingDown = new PriorityQueue<>((a, b) -> b - a);
		this.movingUp = new PriorityQueue<>((a, b) -> a - b);
		this.currentFloorId = 0;
		this.direction = Direction.IDLE;
		this.state = new IdleState();
	}

	public int getElevatorId() {
		return elevatorId;
	}

	public void setElevatorId(int elevatorId) {
		this.elevatorId = elevatorId;
	}

	public Direction getDirection() {
		return direction;
	}

	public void setDirection(Direction direction) {
		this.direction = direction;
	}

	public PriorityQueue<Integer> getMovingUp() {
		return movingUp;
	}

	public void setMovingUp(PriorityQueue<Integer> movingUp) {
		this.movingUp = movingUp;
	}

	public PriorityQueue<Integer> getMovingDown() {
		return movingDown;
	}

	public void setMovingDown(PriorityQueue<Integer> movingDown) {
		this.movingDown = movingDown;
	}

	public ElevatorState getState() {
		return state;
	}

	public void setState(ElevatorState state) {
		this.state = state;
	}

	public int getCurrentFloorId() {
		return currentFloorId;
	}

	public void setCurrentFloorId(int currentFloorId) {
		this.currentFloorId = currentFloorId;
	}

	public static Elevator getInstance() {
		if (elevator == null) {
			synchronized (Elevator.class) {
				if (elevator == null) {
					elevator = new Elevator();
				}
			}
		}
		return elevator;
	}

	public void pressFloorButtonInside(int floorId) {
		System.out.println("Inside request to go to floor " + floorId);
		state.addRequest(floorId);
	}

	public void move() {
		state.move(this);
	}

}
