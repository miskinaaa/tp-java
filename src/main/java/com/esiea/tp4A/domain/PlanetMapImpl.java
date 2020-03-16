package com.esiea.tp4A.domain;

import java.util.HashSet;
import java.util.Set;

public class PlanetMapImpl implements PlanetMap {
	private Set<Position> obstaclePositions = new HashSet<Position>();
		
	@Override
	public Set<Position> obstaclePositions() {
		return obstaclePositions;
	}
	
	public void addObstacles(int x, int y) {
		obstaclePositions.add(Position.of(x, y, Direction.NORTH));
	}

	public boolean removeObstacles(int x, int y) {
		if(obstaclePositions.contains(Position.of(x, y, Direction.NORTH))) {
			obstaclePositions.remove(Position.of(x, y, Direction.NORTH));
			return true;
		}

		return false;

	}
	
	public boolean isThereObstacles(Position position) {
		for(Position p : obstaclePositions) {
			if(p.getX() == position.getX() && p.getY() == position.getY()) {
				return true;
			}
		}
		return false;
	}
}
