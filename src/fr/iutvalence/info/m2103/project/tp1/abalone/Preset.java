/**
 * 
 */
package fr.iutvalence.info.m2103.project.tp1.abalone;

/**
 * This class contain all the available starting positions
 * @author Amaglio & Arsac
 *
 */
public class Preset {
	
	
	// TODO (done) write a comment
	/**
	 * Contains the start positions of white marbles
	 */
	private final Position[] whiteMarbles;

	// TODO (done) write a comment
		/**
		 * Contains the start positions of black marbles
		 */
		private final Position[] blackMarbles;

	// TODO (done) finsih writing comment
	/**
	 * Create a preset that define the starting positions of the marbles on the board
	 * @param whiteMarbles Is an Position array that define the white marbles start
	 * @param blackMarbles Is an Position array that define the black marbles start
	 */
	public Preset(Position[] whiteMarbles, Position[] blackMarbles) {
		this.whiteMarbles = whiteMarbles;
		this.blackMarbles = blackMarbles;
	}

	// TODO (done) write a comment
	/**
	 * getter of the white marbles position
	 * @return the white marbles position array
	 */
	public Position[] getWhiteMarbles() {
		return whiteMarbles;
	}

	// TODO (done) write a comment
		/**
		 * getter of the black marbles position
		 * @return the black marbles position array
		 */
		public Position[] getBlackMarbles() {
		return blackMarbles;
	}
}
