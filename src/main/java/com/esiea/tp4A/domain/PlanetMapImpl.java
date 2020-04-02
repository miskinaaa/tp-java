package main.java.com.esiea.tp4A.domain;

import java.util.HashSet;
import java.util.Set;

public class PlanetMapImpl implements PlanetMap {
	private Set<Position> obstaclePositions;

	public PlanetMap initialize() {
		initialize(new HashSet<>());
		return this;
	}


	public PlanetMap initialize(Set<Position> positions) {
		this.obstaclePositions = positions;
		return this;
	}

	@Override
	public Set<Position> obstaclePositions() {
		return this.obstaclePositions;
	}

	public void addObstacles(Position position) {
		this.obstaclePositions.add(position);
	}

	public boolean removeObstacles(Position position) {
		if(obstaclePositions.contains(position)) {
			obstaclePositions.remove(position);
			return true;
		}

		return false;
	}

	public boolean isThereObstacles(Position position) {
		for(Position p : obstaclePositions) {
			if(p.getX() == position.getX() && p.getY() == position.getY()) {
				System.out.println("true");
				return true;
			}
		}
		return false;
	}
}