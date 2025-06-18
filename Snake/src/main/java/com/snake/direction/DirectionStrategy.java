package com.snake.direction;

import java.util.HashMap;
import java.util.Map;

public class DirectionStrategy {

	public Map<Integer, Direction> mapDirection;

	public DirectionStrategy() {
		this.mapDirection = new HashMap<>();
		this.mapDirection.put(1, new LeftDirection());
		this.mapDirection.put(2, new DownDirection());
		this.mapDirection.put(3, new RightDirection());
		this.mapDirection.put(4, new UpDirection());
	}

	public Direction getDirection(int count) {
		return this.mapDirection.getOrDefault(count, null);
	}

}
