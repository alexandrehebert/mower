package com.xebia.mower;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.xebia.mower.core.Mower;
import com.xebia.mower.core.Orientation;
import com.xebia.mower.core.RectangularLawn;
import com.xebia.mower.power.PowerLawn;
import com.xebia.mower.power.PowerMower;
import com.xebia.mower.strategy.MowerAction;
import com.xebia.mower.strategy.MowerAction.MowerActionContext;

/**
 * The Class MowersManager.
 */
public class MowersManager {

    /** The Constant L. */
    private static final Logger L = Logger.getLogger(MowersManager.class);

    /** The current mower. */
    Mower currentMower;

    /** The lawn. */
    RectangularLawn lawn;

    /** The mowers. */
    List<Mower> mowers = new ArrayList<>();

    /** The strategies. */
    List<MowerAction> strategies = new ArrayList<>();

    /**
     * Instantiates a new mowers manager.
     * 
     * @param lawnWidth
     *            the lawn width
     * @param lawnHeight
     *            the lawn height
     */
    public MowersManager(int lawnWidth, int lawnHeight) {
        lawn = new PowerLawn(lawnWidth, lawnHeight);
    }

    /**
     * Adds the action listener.<br />
     * Les actions sont des handlers d'évènement qui ne sont executés (c.f.
     * {@link MowerAction#execute(MowerActionContext)}) que si une condition de
     * selection est validée (c.f.
     * {@link MowerAction#select(MowerActionContext)})
     * 
     * @param mowerMoveStrategy
     *            the mower move strategy
     */
    public void registerAction(MowerAction mowerMoveStrategy) {

        strategies.add(mowerMoveStrategy);

    }

    /**
     * Creates and use mower.<br />
     * Créé une nouvelle tondeuse et la marque comme étant tondeuse courante.
     * Deux tondeuses ne pouvant pas avancer au même moment. Elle est maintenant
     * déplaçable par {@link MowersManager#executeActions(char...)}
     * 
     * @param mowerX
     *            the mower x
     * @param mowerY
     *            the mower y
     * @param mowerDirection
     *            the mower direction
     * @return the mower
     */
    public Mower createAndUseMower(int mowerX, int mowerY,
            Orientation mowerDirection) {

        PowerMower mower = new PowerMower(mowerX, mowerY, mowerDirection);
        mowers.add(mower);

        L.debug("new mower " + mower);

        return currentMower = mower;

    }

    /**
     * Execute actions.<br />
     * Applique un ensemble d'actions à la tondeuse courante<br />
     * La liste d'actions possibles ne fait pas partie d'un ensemble fini
     * 
     * @param actions
     *            the actions
     */
    public void executeActions(char... actions) {

        // parcours des actions à réaliser (A, G, D)
        for (Character action : actions) {

            MowerActionContext context = new MowerActionContext(currentMower,
                    action, lawn);

            L.debug("action " + action);

            // parcours des implémentations des actions possibles
            for (MowerAction strategy : strategies) {
                // on cherche a determiner si l'action est à executer
                if (!strategy.select(context))
                    continue;
                strategy.execute(context);
            }

        }

        System.out.println(currentMower);

    }

}
