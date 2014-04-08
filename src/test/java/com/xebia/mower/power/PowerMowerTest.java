package com.xebia.mower.power;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

import com.xebia.mower.core.Direction;
import com.xebia.mower.core.Mower;
import com.xebia.mower.core.Orientation;
import com.xebia.mower.core.RectangularLawn;

public class PowerMowerTest {

    private static final int LAWN_WIDTH = 5;
    private static final int LAWN_HEIGHT = 5;

    private Mower mower;
    private RectangularLawn lawn;

    @Before
    public void setUp() {
        mower = new PowerMower(4, 4, Orientation.N);
        lawn = new PowerLawn(LAWN_WIDTH, LAWN_HEIGHT);
    }

    @Test
    public void testMove() {
        mower.move(lawn);
        // ne peut pas sortir des limites de la pelouse
        Assert.assertEquals(4, mower.getY());
        Assert.assertEquals(4, mower.getX());
    }

    @Test
    public void testRotate() {
        mower.rotate(Direction.D);
        Assert.assertEquals(Orientation.E, mower.getOrientation());
        mower.rotate(Direction.G);
        Assert.assertEquals(Orientation.N, mower.getOrientation());
    }

}
