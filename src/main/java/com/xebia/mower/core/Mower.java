package com.xebia.mower.core;

/**
 * The Interface Mower.<br />
 */
public interface Mower {

    /**
     * Gets the x.<br />
     * Position de la tondeuse sur l'axe [E,W]
     * 
     * @return the x
     */
    int getX();

    /**
     * Gets the y.<br />
     * Position de la tondeuse sur l'axe [N,S]
     * 
     * @return the y
     */
    int getY();

    /**
     * Gets the direction.<br />
     * Direction dans laquelle se trouve la tondeuse
     * 
     * @return the direction
     */
    Orientation getOrientation();

    /**
     * Move.<br />
     * 
     * @param lawn
     *            the lawn
     * @return the mower
     */
    Mower move(RectangularLawn lawn);

    /**
     * Rotate.
     * 
     * @param sens
     *            the sens
     * @return the direction
     */
    Orientation rotate(Direction direction);

}
