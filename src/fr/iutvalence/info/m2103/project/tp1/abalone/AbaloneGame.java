package fr.iutvalence.info.m2103.project.tp1.abalone;

/**
 * Start and manage a game
 * 
 * @author Arsac & Amaglio
 *
 */
public class AbaloneGame {

	public static final int HALF_BOARD_RIGHT_COORDINATE = 4;
	public static final int HALF_BOARD_LEFT_COORDINATE = 5;
	public static final int BOARD_COORDINATES = 9;
	public static final int COORDINATES_COUNT_START = 1;
	public static final int SPACES_COUNT_START = 0;
	/**
	 * The abalone board
	 */
	private Board board;


	public Board getBoard() {
		return board;
	}

	/**
	 * return a game with a set up board with marbles
	 */
	public AbaloneGame() {
		this.board = new Board(0);
	}

	/**
	 * Create a board with specific marble's starting location
	 * @param preset Preset ID
	 */
	public AbaloneGame(int preset) {
		this.board = new Board(preset);
	}

	
	@Override
	/**
	 * Display the board in ascii-art
	 */
	public String toString() {
		String ret = "";

		// TODO (done) replace hard-coded numbers with constants if possible
		for (int leftCoordinate = COORDINATES_COUNT_START; leftCoordinate <= HALF_BOARD_LEFT_COORDINATE; leftCoordinate++) {
			for (int nbSpaces = SPACES_COUNT_START; nbSpaces < HALF_BOARD_LEFT_COORDINATE - leftCoordinate; nbSpaces++)
				ret += " ";
			for (int rightCoordinate = COORDINATES_COUNT_START; rightCoordinate <= (HALF_BOARD_RIGHT_COORDINATE + leftCoordinate); rightCoordinate++) {
				Marble marble = board.getMarble(new Position(leftCoordinate,
						rightCoordinate));
				if (marble == null)
					ret += "+ ";
				else
					ret += marble + " ";
			}
			ret += "\n";
		}
		for (int leftCoordinate = HALF_BOARD_LEFT_COORDINATE+1; leftCoordinate <= BOARD_COORDINATES; leftCoordinate++) {
			for (int nbSpaces = SPACES_COUNT_START; nbSpaces < leftCoordinate - HALF_BOARD_LEFT_COORDINATE; nbSpaces++)
				ret += " ";
			for (int rightCoordinate = leftCoordinate-HALF_BOARD_RIGHT_COORDINATE; rightCoordinate <= BOARD_COORDINATES; rightCoordinate++) {
				Marble marble = board.getMarble(new Position(leftCoordinate,
						rightCoordinate));
				if (marble == null)
					ret += "+ ";
				else
					ret += marble + " ";
			}
			ret += "\n";
		}

		return ret;
	}

	/**
	 * Test if a game is won
	 * @return the player that won the game
	 */
	public Player won(AbstractPlayer[] players) {
		for(int count = 0; count< players.length; count++){
			if(this.board.countMarbles(players[count].getColor()) < Board.MAX_MARBLES - Board.MARBLES_TO_WIN)
				return players[count%AbstractPlayer.PLAYERS_NUMBER];
		}
		return null;
	}

}
