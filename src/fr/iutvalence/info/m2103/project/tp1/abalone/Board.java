package fr.iutvalence.info.m2103.project.tp1.abalone;

import java.util.HashMap;
import java.util.LinkedList;

/**
 * This is the abalone board that manages the marble
 * 
 * @author Amaglio & Arsac
 *
 */
public class Board {

	// TODO (done) write a comment
	/**
	 * The maximum friendly marbles it is possible to push at the same time
	 */
	private final static int MAX_PUSHABLE_MARBLE = 3;

	// TODO (done) write a comment
	/**
	 * The power amout that a marble provide to a pushing group
	 */
	private final static int MARBLE_POWER = 1;

	/**
	 * The amount of marble a player have to push out to win
	 */
	public static final int MARBLES_TO_WIN = 6;

	/**
	 * The maximum marble a player got on the board
	 */
	public static final int MAX_MARBLES = 14;

	/**
	 * The abalone board contains all the marbles locations. A map is used here
	 * to store marble locations only without allocating a complete table.
	 */
	private HashMap<Position, Marble> board;

	private LinkedList<Position> validPositions;

	/**
	 * Sets the marbles in the classic starting position
	 */
	public Board() {
		this.setMarblesFromPresetID(1);
		this.init();
	}

	/**
	 * Allow user to start the game with different layouts
	 * 
	 * @param preset
	 *            Id of the preset (define the marbles start locations)
	 */
	public Board(int presetId) {
		this.setMarblesFromPresetID(presetId);
		this.init();
	}

	/**
	 * 
	 */
	private void init() {

		validPositions = new LinkedList<Position>();
		validPositions.add(new Position(1, 1));
		validPositions.add(new Position(1, 2));
		validPositions.add(new Position(1, 3));
		validPositions.add(new Position(1, 4));
		validPositions.add(new Position(1, 5));
		validPositions.add(new Position(2, 1));
		validPositions.add(new Position(2, 2));
		validPositions.add(new Position(2, 3));
		validPositions.add(new Position(2, 4));
		validPositions.add(new Position(2, 5));
		validPositions.add(new Position(2, 6));
		validPositions.add(new Position(3, 1));
		validPositions.add(new Position(3, 2));
		validPositions.add(new Position(3, 3));
		validPositions.add(new Position(3, 4));
		validPositions.add(new Position(3, 5));
		validPositions.add(new Position(3, 6));
		validPositions.add(new Position(3, 7));
		validPositions.add(new Position(4, 1));
		validPositions.add(new Position(4, 2));
		validPositions.add(new Position(4, 3));
		validPositions.add(new Position(4, 4));
		validPositions.add(new Position(4, 5));
		validPositions.add(new Position(4, 6));
		validPositions.add(new Position(4, 7));
		validPositions.add(new Position(4, 8));
		validPositions.add(new Position(5, 1));
		validPositions.add(new Position(5, 2));
		validPositions.add(new Position(5, 3));
		validPositions.add(new Position(5, 4));
		validPositions.add(new Position(5, 5));
		validPositions.add(new Position(5, 6));
		validPositions.add(new Position(5, 7));
		validPositions.add(new Position(5, 8));
		validPositions.add(new Position(5, 9));
		validPositions.add(new Position(6, 2));
		validPositions.add(new Position(6, 3));
		validPositions.add(new Position(6, 4));
		validPositions.add(new Position(6, 5));
		validPositions.add(new Position(6, 6));
		validPositions.add(new Position(6, 7));
		validPositions.add(new Position(6, 8));
		validPositions.add(new Position(6, 9));
		validPositions.add(new Position(7, 3));
		validPositions.add(new Position(7, 4));
		validPositions.add(new Position(7, 5));
		validPositions.add(new Position(7, 6));
		validPositions.add(new Position(7, 7));
		validPositions.add(new Position(7, 8));
		validPositions.add(new Position(7, 9));
		validPositions.add(new Position(8, 4));
		validPositions.add(new Position(8, 5));
		validPositions.add(new Position(8, 6));
		validPositions.add(new Position(8, 7));
		validPositions.add(new Position(8, 8));
		validPositions.add(new Position(8, 9));
		validPositions.add(new Position(9, 5));
		validPositions.add(new Position(9, 6));
		validPositions.add(new Position(9, 7));
		validPositions.add(new Position(9, 8));
		validPositions.add(new Position(9, 9));
	}

	// TODO (done) finish writing comment
	/**
	 * Set marbles on the board depending of the coordinates stored in the
	 * wanted preset
	 * 
	 * @param preset
	 */
	private void setMarblesFromPresetID(int presetId) {
		Preset preset = Presets.preset(presetId);
		if (preset == null)
			preset = Presets.preset(0);

		this.board = new HashMap<Position, Marble>();

		Position[] blackMarblesPosition = preset.getBlackMarbles();
		Position[] whiteMarblesPosition = preset.getWhiteMarbles();

		for (Position position : blackMarblesPosition) {
			this.put(position, new Marble(Color.BLACK));
		}

		for (Position position : whiteMarblesPosition) {
			this.put(position, new Marble(Color.WHITE));
		}
	}

	/**
	 * Return True if the marble can go in the specified direction
	 * 
	 * @param direction
	 *            One of Direction enumeration
	 * @param power
	 *            Specify how many marbles are moving (set this param to 1)
	 * @param attack
	 *            true if marbles are pushing ennemy ones (set this param to
	 *            false)
	 * @return True if the marble can go in this direction. False else
	 */
	public boolean canGo(Movement movement, int power, boolean attack)
			throws NoMarbleFound {

		if (movement == null)
			return false;

		if (movement.getPositions().size() > 1) {
			if (!this.areAlignedAndAdjacents(movement.getPositions())) {
				return false;
			}
			for (Position position : movement.getPositions()) {
				if (this.getMarble(this.nextMarblePosition(position,
						movement.getDirection())) != null
						|| !this.onTheBoard(this.nextMarblePosition(position,
								movement.getDirection())))
					return false;
			}
			return true;
		} else {
			Position position = movement.getFirstPosition();
			Direction direction = movement.getDirection();

			// If there is no marble at this position
			if (this.getMarble(position) == null)
				throw new NoMarbleFound();

			Position nextMarblePosition = this.nextMarblePosition(position,
					direction);

			// if no marble detected
			if (this.getMarble(nextMarblePosition) == null) {

				if (attack) {
					return power >= 1;
				}
				if (power <= MAX_PUSHABLE_MARBLE
						&& this.onTheBoard(nextMarblePosition))
					return true;
				return false;
			}

			if (this.getMarble(nextMarblePosition).getColor() != this
					.getMarble(position).getColor()) {
				if (attack)
					return false;
				return this.canGo(movement.setPosition(nextMarblePosition),
						power - MARBLE_POWER, true);
			}

			if (attack) {
				if (power <= MARBLE_POWER)
					return false;
				return this.canGo(movement.setPosition(nextMarblePosition),
						power - MARBLE_POWER, attack);
			}

			if (power < MAX_PUSHABLE_MARBLE)
				return this.canGo(movement.setPosition(nextMarblePosition),
						power + MARBLE_POWER, attack);
			return false;
		}
	}

	/**
	 * Test if the positions in parameter are contiguous and aligned
	 * 
	 * @param positions
	 *            the positions that will be tested
	 * @return true if the conditions are verified
	 */
	private boolean areAlignedAndAdjacents(LinkedList<Position> positions) {
		if (positions.size() == 2
				&& Math.abs(positions.get(0).getLeft()
						- positions.get(1).getLeft()) <= 1
				&& Math.abs(positions.get(0).getRight()
						- positions.get(1).getRight()) <= 1) {
			return true;

		} else if (positions.size() == 3
				&& positions.get(0).getLeft() - positions.get(1).getLeft() == positions
						.get(1).getLeft() - positions.get(2).getLeft()
				&& positions.get(0).getRight() - positions.get(1).getRight() == positions
						.get(1).getRight() - positions.get(2).getRight()
				&& positions.get(0).getLeft() - positions.get(1).getLeft() <= 1
				&& positions.get(0).getRight() - positions.get(1).getRight() <= 1) {
			return true;
		} else
			return false;
	}

	public void move(Movement movement) throws NoMarbleFound {

		if (movement.getPositions().size() > 1) {
			for (Position position : movement.getPositions()) {
				this.put(
						this.nextMarblePosition(position,
								movement.getDirection()),
						this.getMarble(position));
				this.removeMarble(position);
			}
		} else {

			Position currentPosition = movement.getFirstPosition();

			Marble marbleToPlace = null, marbleToReplace;

			while (this.getMarble(currentPosition) != null) {
				marbleToReplace = this.getMarble(currentPosition);
				this.removeMarble(currentPosition);
				this.put(currentPosition, marbleToPlace);
				marbleToPlace = marbleToReplace;

				currentPosition = this.nextMarblePosition(currentPosition,
						movement.getDirection());

			}
			this.put(currentPosition, marbleToPlace);
		}
	}

	/**
	 * @param marblePosition
	 */
	private void removeMarble(Position position) {
		this.board.remove(position);

	}

	/**
	 * @param nextMarblePosition
	 * @return
	 */
	private boolean onTheBoard(Position position) {
		return this.validPositions.contains(position);
	}

	public boolean isMouvementValid(Movement mouvement, AbstractPlayer player) {
		if (mouvement == null || mouvement.getPositions() == null)
			return false;

		for (Position position : mouvement.getPositions()) {
			if (this.getMarble(position).getColor() != player.getColor())
				return false;
		}

		try {
			System.out.println(mouvement + " -> "
					+ this.canGo(mouvement, Board.MARBLE_POWER, false));
			return this.canGo(mouvement, Board.MARBLE_POWER, false);
		} catch (NoMarbleFound e) {
			e.printStackTrace();
			return false;
		}
	}

	/**
	 * Give the marble next to this one in the specified direction. null else
	 * 
	 * @param direction
	 *            The direction to check
	 * @return The marble or null
	 */
	private Position nextMarblePosition(Position position, Direction direction) {
		return new Position(position.getLeft() + direction.getLeftDelta(),
				position.getRight() + direction.getRightDelta());
	}

	/**
	 * Insert a marble on the board at the specified position
	 * 
	 * @param position
	 *            Where the marble should be placed
	 * @param marble
	 *            The marble
	 */
	public void put(Position position, Marble marble) {
		if (marble == null)
			return;
		this.board.put(position, marble);
	}

	/**
	 * Return the marble at the given location
	 * 
	 * @param position
	 * @return marble
	 */
	public Marble getMarble(Position position) {
		return this.board.get(position);
	}

	/**
	 * Count the blacks marbles on the board in the color in parameter
	 * 
	 * @return the marbles number
	 */
	public int countMarbles(Color color) {
		int number = 0;
		for (Marble marble : this.board.values()) {
			if (marble.getColor() == color)
				number++;
		}
		return number;
	}
}
