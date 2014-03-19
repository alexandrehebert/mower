package com.xebia.mower.core;

/**
 * The Interface ExtraMower.
 */
public interface ExtraMower extends Mower {

    /**
     * Relocate.
     * 
     * @param x
     *            the x
     * @param y
     *            the y
     * @param direction
     *            the direction
     */
    void relocate(int x, int y, Orientation direction);

}
