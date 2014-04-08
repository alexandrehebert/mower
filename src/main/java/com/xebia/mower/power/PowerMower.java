package com.xebia.mower.power;

import java.util.Arrays;

import org.apache.log4j.Logger;

import com.xebia.mower.MowersManager;
import com.xebia.mower.core.Direction;
import com.xebia.mower.core.Mower;
import com.xebia.mower.core.Orientation;
import com.xebia.mower.core.RectangularLawn;

/**
 * The Class PowerMower.
 */
public class PowerMower implements Mower {

    private static final Logger L = Logger.getLogger(MowersManager.class);

    /** The y. */
    private int x, y;

    /** The direction. */
    private Orientation orientation;

    /**
     * Instantiates a new power mower.
     */
    public PowerMower() {
        this(0, 0, Orientation.N);
    }

    /**
     * Instantiates a new power mower.
     * 
     * @param x
     *            the x
     * @param y
     *            the y
     * @param direction
     *            the direction
     */
    public PowerMower(int x, int y, Orientation direction) {
        this.x = x;
        this.y = y;
        this.orientation = direction;
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.xebia.mower.core.Mower#getX()
     */
    @Override
    public int getX() {
        return x;
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.xebia.mower.core.Mower#getY()
     */
    @Override
    public int getY() {
        return y;
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.xebia.mower.core.Mower#getDirection()
     */
    @Override
    public Orientation getOrientation() {
        return orientation;
    }

    /**
     * Move.<br />
     * Déplace la tondeuse sur la pelouse. La tondeuse est bloquée par les bords
     * 
     * @param lawn
     *            the lawn
     * @return the mower
     */
    @Override
    public Mower move(RectangularLawn lawn) {
        L.debug("move from " + this);
        switch (orientation) {
        case E:
            if (x < lawn.getWidth() - 1)
                x++;
            break;
        case W:
            if (x > 0)
                x--;
            break;
        case N:
            if (y < lawn.getHeight() - 1)
                y++;
            break;
        case S:
            if (y > 0)
                y--;
            break;
        }
        L.debug("> to " + this);
        lawn.mow(getX(), getY());
        return this;
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.xebia.mower.core.Mower#rotate(com.xebia.mower.core.Sens)
     */
    @Override
    public Orientation rotate(Direction direction) {
        L.debug("rotate from " + this);
        int d = Arrays.asList(Orientation.values()).indexOf(orientation);
        switch (direction) {
        case D: // virage à droite
            d = ++d % 4;
            break;
        case G: // virage à gauche
            d--;
            if (d < 0)
                d = 3;
            break;
        }
        orientation = Orientation.values()[d];
        L.debug("> to " + this);
        return getOrientation();
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return x + " " + y + " " + orientation;
    }

}
