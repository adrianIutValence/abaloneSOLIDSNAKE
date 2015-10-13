/**
 * 
 */
package fr.iutvalence.info.m2105.project.tp1.ihm;

import java.util.LinkedList;

import fr.iutvalence.info.m2103.project.tp1.abalone.*;

/**
 * @author Amaglio
 *
 */
public class GraphicPlayer extends AbstractPlayer{

	/**
	 * @param color
	 */
	public GraphicPlayer(Color color) {
		super(color);
	}

	/* (non-Javadoc)
	 * @see fr.iutvalence.info.m2103.project.tp1.abalone.AbstractPlayer#waitAction()
	 */
	@Override
	public Movement waitAction() {
		LinkedList<Position> positions = new LinkedList<Position>();
		positions.add(new Position(1, 1));
		return new Movement(positions , Direction.SW);
	}


}
