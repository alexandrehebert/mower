package com.xebia.mower.strategy;

import com.xebia.mower.core.Direction;

/**
 * The Class DStrategy.<br />
 * Action : tourner à droite.
 */
public class DStrategy implements MowerAction {

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.xebia.mower.strategy.MowerAction#select(com.xebia.mower.strategy.
     * MowerAction.MowerActionContext)
     */
    @Override
    public boolean select(MowerActionContext context) {
	return context.getAction().equals('D');
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
	context.getMower().rotate(Direction.D);
    }

}
