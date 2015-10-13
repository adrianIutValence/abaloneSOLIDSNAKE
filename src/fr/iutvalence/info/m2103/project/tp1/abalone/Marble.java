package fr.iutvalence.info.m2103.project.tp1.abalone;

// TODO (done) write a comment
/**
 * This class define a marble. It is defined only by a color.
 * @author Amaglio & Arsac
 *
 */
public class Marble {
	/**
	 * Marble color
	 */
	private final Color color;
	
	// TODO (done) detail comment (how is the marble built?)
	/**
	 * Create a marble defined with its color
	 * @param color The marble color
	 */
	public Marble(Color color){
		this.color = color;
	}
	
	// TODO (done) finish writing comment (return tag)
	/**
	 * Getter of the color
	 * Return the marble color
	 */
	public Color getColor(){
		return this.color;
	}

	@Override
	public String toString() {
		if(this.color == Color.BLACK)
			return "@";
		return "O";
	}
}
