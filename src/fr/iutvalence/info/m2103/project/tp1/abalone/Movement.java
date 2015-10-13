/**
 * 
 */
package fr.iutvalence.info.m2103.project.tp1.abalone;

import java.util.LinkedList;

/**
 * this class define an abalone movement.
 * 
 * @author amaglioa
 *
 */
public class Movement {
	/**
	 * A set that include 1 to 3 marble positions. If there is only one position, it's a pushing movement. It's a lateral one else.
	 */
	private LinkedList<Position> positions;
	
	/**
	 * The movement direction
	 */
	private Direction direction;
	
	
	/**
	 * Create a movement 
	 * @param positions the position(s)
	 * @param direction the direction
	 */
	public Movement(LinkedList<Position> positions, Direction direction){
		this.positions = positions;
		this.direction = direction;
	}
	
	/**
	 * Positions getter
	 * @return the movement potition(s)
	 */
	public LinkedList<Position> getPositions() {
		return positions;
	}
	
	/**
	 * Return the first element of the Position set
	 * To use if there is only one element
	 * @return The element of the Positions set
	 */
	public Position getFirstPosition(){
		
		return (Position)(this.positions.toArray()[0]);
	}
	
	/**
	 * Direction getter
	 * @return the movement direction
	 */
	public Direction getDirection() {
		return this.direction;
	}

	@Override
	public String toString() {
		String str = new String();
		for(Position position: this.positions){
			str += position + " ";
		}
		return str + this.direction;
	}

	/**
	 * @param nextMarblePosition
	 * @return
	 */
	public Movement setPosition(Position position) {
		this.positions = new LinkedList<Position>();
		this.positions.add(position);
		return this;
	}

	/**
	 * @return
	 */
	public Movement copy() {
		LinkedList<Position> positions = new LinkedList<Position>();

		for(Position position : this.positions){
			positions.add(position);
		}
		
		return new Movement(positions, this.direction);
	}

}
