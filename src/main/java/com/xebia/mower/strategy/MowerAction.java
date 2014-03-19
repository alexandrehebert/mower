package com.xebia.mower.strategy;

import com.xebia.mower.core.Mower;
import com.xebia.mower.core.RectangularLawn;

/**
 * The Interface MowerAction.<br />
 * Action executable par la tondeuse. Permet l'extensibilité des actions
 * possibles
 */
public interface MowerAction {

    /**
     * Select.<br />
     * Retourne <strong>true</strong> si l'action est executable dans ce
     * contexte
     * 
     * @param context
     *            the context
     * @return true, if successful
     */
    boolean select(MowerActionContext context);

    /**
     * Execute.<br />
     * Execute l'action donnée
     * 
     * @param context
     *            the context
     */
    void execute(MowerActionContext context);

    /**
     * The Class MowerActionContext.<br />
     * Ensemble des informations relatives à la tondeuse et sa pelouse, à un
     * instant T
     */
    public static final class MowerActionContext {

	/** The mower. */
	private Mower mower;

	/** The action. */
	private Character action;

	/** The lawn. */
	private RectangularLawn lawn;

	/**
	 * Instantiates a new mower action context.
	 * 
	 * @param mower
	 *            the mower
	 * @param action
	 *            the action
	 * @param lawn
	 *            the lawn
	 */
	public MowerActionContext(Mower mower, Character action,
		RectangularLawn lawn) {
	    super();
	    this.mower = mower;
	    this.action = action;
	    this.lawn = lawn;
	}

	/**
	 * Gets the mower.
	 * 
	 * @return the mower
	 */
	public Mower getMower() {
	    return mower;
	}

	/**
	 * Gets the command.
	 * 
	 * @return the command
	 */
	public Character getAction() {
	    return action;
	}

	/**
	 * Gets the lawn.
	 * 
	 * @return the lawn
	 */
	public RectangularLawn getLawn() {
	    return lawn;
	}

    }

}
