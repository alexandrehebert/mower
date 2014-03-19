package com.xebia.mower.strategy;

/**
 * The Class AStrategy.<br />
 * Action : avancer.
 */
public class AStrategy implements MowerAction {

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.xebia.mower.strategy.MowerAction#select(com.xebia.mower.strategy.
     * MowerAction.MowerActionContext)
     */
    @Override
    public boolean select(MowerActionContext context) {
	return context.getAction().equals('A');
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
	context.getMower().move(context.getLawn());
    }

}
