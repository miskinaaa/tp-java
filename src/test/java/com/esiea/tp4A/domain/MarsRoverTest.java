package com.esiea.tp4A.domain;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import static org.junit.Assert.assertEquals;


public class MarsRoverTest {
    private final PlanetMapImpl planetMap = (PlanetMapImpl) new PlanetMapImpl().initialize(100);

    @Test
    public void initializeTest(){
        MarsRover marsRover = new MarsRoverImpl((Position.of(0, 0, Direction.NORTH)), planetMap);
        Assertions.assertThat(marsRover.initialize(Position.of(0,0, Direction.NORTH))).isEqualTo(marsRover);
    }

    @Test
    public void updateMapTest(){
        MarsRover marsRover = new MarsRoverImpl((Position.of(0, 0, Direction.NORTH)), planetMap);
        Assertions.assertThat(marsRover.updateMap(new PlanetMapImpl().initialize(100))).isEqualTo(marsRover);
    }

    @Test
    public void configureLaserRangeTest(){
        MarsRover marsRover = new MarsRoverImpl((Position.of(0, 0, Direction.NORTH)), planetMap);
        Assertions.assertThat(marsRover.configureLaserRange(50)).isEqualTo(marsRover);
    }
}
