package com.xebia.mower;

import com.xebia.mower.core.Orientation;
import com.xebia.mower.strategy.AStrategy;
import com.xebia.mower.strategy.DStrategy;
import com.xebia.mower.strategy.GStrategy;

/**
 * The Class MainMower.<br />
 * {@link http://www.alexandrehebert.info/}
 * 
 * @author Alexandre HEBERT
 */
public class MainMower {

    private static final String SETTINGS_SEPARATOR = " ";

    // private static final int LAWN_WIDTH = 10;
    // private static final int LAWN_HEIGHT = 10;

    /**
     * The main method.
     * 
     * @param args
     *            the arguments
     */
    public static void main(String... args) {

	if (args.length < 3 || args.length % 2 < 1) {
	    throw new RuntimeException(
		    "usage : ./mower '(int)Width (int)Height' ['(int)X (int)Y (N|S|E|W)Direction' '(A|D|G)*Commands']*");
	}

	// calcul des dimensions de la pelouse
	String[] lawnDimensions = args[0].split(SETTINGS_SEPARATOR);
	int lawnWidth = Integer.parseInt(lawnDimensions[0]);
	int lawnHeight = Integer.parseInt(lawnDimensions[1]);
	// String[] inputs = Arrays.copyOfRange(args, 1, args.length-1);

	MowersManager manager = new MowersManager(lawnWidth, lawnHeight);

	// déclaration des différentes actions possibles
	manager.registerAction(new AStrategy());
	manager.registerAction(new GStrategy());
	manager.registerAction(new DStrategy());

	// une itération = création d'une tondeuse + déplacement
	for (int i = 1; i < args.length; i += 2) {

	    // calcul des paramètres de départ de la tondeuse
	    String[] mowerSettings = args[i].split(SETTINGS_SEPARATOR);
	    int mowerX = Integer.parseInt(mowerSettings[0]);
	    int mowerY = Integer.parseInt(mowerSettings[1]);
	    Orientation mowerDirection = Orientation.valueOf(mowerSettings[2]);

	    manager.createAndUseMower(mowerX, mowerY, mowerDirection);
	    manager.executeActions(args[i + 1].toCharArray());

	}

    }
}
