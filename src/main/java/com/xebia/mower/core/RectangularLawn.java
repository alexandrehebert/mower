package com.xebia.mower.core;

/**
 * The Interface Lawn.<br />
 * Represente la pelouse à tondre.
 */
public interface RectangularLawn {

    /**
     * Gets the height.
     * 
     * @return the height
     */
    int getHeight();

    /**
     * Gets the width.
     * 
     * @return the width
     */
    int getWidth();

    /**
     * Mow.
     * 
     * @param x
     * @param y
     */
    void mow(int x, int y);

}
