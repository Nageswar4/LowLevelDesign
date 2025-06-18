package com.rover.direction;

import com.rover.controller.Moveable;
import com.rover.controller.Rover;

public interface Direction {

	public boolean isValidMove(Rover rover, Moveable[][] moveable);

	public boolean move(Rover rover, Moveable[][] moveable);

}
