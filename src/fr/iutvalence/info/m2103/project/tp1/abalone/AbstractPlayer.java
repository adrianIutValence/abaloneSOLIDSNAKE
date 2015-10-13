/**
 * 
 */
package fr.iutvalence.info.m2103.project.tp1.abalone;

/**
 * This class define an abalone player
 * @author amaglioa
 *
 */
public abstract class AbstractPlayer implements Player {
	
	/**
	 * Number of players that actually play the game
	 */
	public static final int PLAYERS_NUMBER = 2;
	/**
	 * The color of players marbles
	 */
	private Color color;
	
	/**
	 * Create a new player
	 * @param color the color of the player
	 */
	public AbstractPlayer(Color color){
		this.color = color;
	}

	/* (non-Javadoc)
	 * @see fr.iutvalence.info.m2103.project.tp1.abalone.Player#waitAction()
	 */
	@Override
	public abstract Movement waitAction();

	/**
	 * Return the players color
	 * @return the color
	 */
	public Color getColor() {
		return this.color;
	}
}
