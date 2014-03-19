package com.xebia.mower.strategy;

import com.xebia.mower.core.Direction;

/**
 * The Class GStrategy.<br />
 * Action : tourner à gauche.
 */
public class GStrategy implements MowerAction {

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.xebia.mower.strategy.MowerAction#select(com.xebia.mower.strategy.
     * MowerAction.MowerActionContext)
     */
    @Override
    public boolean select(MowerActionContext context) {
	return context.getAction().equals('G');
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.xebia.mower.strategy.MowerAction#compute(com.xebia.mower.strategy
     * .MowerAction.MowerActionContext)
     */
    @Override
    public void execute(MowerActionContext context) {
	context.getMower().rotate(Direction.G);
    }

}
