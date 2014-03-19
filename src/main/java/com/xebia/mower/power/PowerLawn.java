package com.xebia.mower.power;

import com.xebia.mower.core.RectangularLawn;

/**
 * The Class PowerLawn.
 */
public class PowerLawn implements RectangularLawn {

    /** The width. */
    private int height, width;

    /**
     * Instantiates a new power lawn.
     * 
     * @param width
     *            the width
     * @param height
     *            the height
     */
    public PowerLawn(int width, int height) {
	assert width > 0;
	assert height > 0;
	this.width = width;
	this.height = height;
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.xebia.mower.core.Lawn#getHeight()
     */
    @Override
    public int getHeight() {
	return height;
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.xebia.mower.core.Lawn#getWidth()
     */
    @Override
    public int getWidth() {
	return width;
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.xebia.mower.core.RectangularLawn#mow(int, int)
     */
    @Override
    public void mow(int x, int y) {
	// on tond la pelouse ? :D
    }

}
