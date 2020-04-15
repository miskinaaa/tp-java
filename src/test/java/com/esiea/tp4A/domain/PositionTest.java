package com.esiea.tp4A.domain;

import org.assertj.core.api.Assertions;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PositionTest {
    @Test
    public void getX() {
        Position position = Position.of(0,0,Direction.NORTH);
        assertEquals(0,position.getX());
    }


    @Test
    public void getY() {
        Position position = Position.of(0,0,Direction.NORTH);
        assertEquals(0,position.getY());
    }

    @Test
    public void getDirection() {
        Position position = Position.of(0,0,Direction.NORTH);
        assertEquals(Direction.NORTH,position.getDirection());
    }
}
