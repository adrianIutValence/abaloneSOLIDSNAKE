package fr.iutvalence.info.m2103.project.tp1.abalone;

/**
 * Define the coordinates of a marble on the board 1 2 3 4 5 A O O O O O 6 B O O
 * O O O O 7 C O O O O O O O 8 D O O O O O O O O 9 E O O O O O O O O O F O O O O
 * O O O O G O O O O O O O H O O O O O O I O O O O O
 */
public class Position {

	/**
	 * Left coordinate
	 */
	private int left;

	/**
	 * right coordinate
	 */
	private int right;

	/**
	 * Returns a new position with the specified coordinates
	 * 
	 * @param left
	 *            Specify the left coordinate of the Position
	 * @param right
	 *            Specify the right coordinate of the Position
	 */
	public Position(int left, int right) {
		this.left = left;
		this.right = right;
	}

	// TODO (done) write a comment
	/**
	 * Left coordinate getter
	 * @return the left coordinate of the position
	 */
	public int getLeft() {
		return left;
	}

	// TODO (done) write a comment
		/**
		 * Right coordinate getter
		 * @return the right coordinate of the position
		 */
		public int getRight() {
		return right;
	}

	/**
	 * Positions are equals if their coordinates are equals
	 */
	@Override
	public boolean equals(Object obj) {

		if (obj == this)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof Position))
			return false;

		Position position = (Position) obj;
		if (position.left == this.left && position.right == this.right)
			return true;
		return false;

	}

	@Override
	public int hashCode() {
		return this.left * 10 + this.right;
	}

	@Override
	public String toString() {
		return "(" + this.left + ", " + this.right + ")";
	}

}
