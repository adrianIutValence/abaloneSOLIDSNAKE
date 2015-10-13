/**
 * 
 */
package fr.iutvalence.info.m2103.project.tp1.abalone;

/**
 * Contain all the starting positions of the different presets
 * 
 * @author Amaglio & Arsac
 *
 */
public class Presets {

	/**
	 * The first presets set a marble
	 */
	private final static Preset[] PRESETS = new Preset[] {
			new Preset(
					new Position[] { new Position(1, 1), new Position(1, 2),
							new Position(1, 3), new Position(1, 4),
							new Position(1, 5), new Position(2, 1),
							new Position(2, 2), new Position(2, 3),
							new Position(2, 4), new Position(2, 5),
							new Position(2, 6), new Position(3, 3),
							new Position(3, 4), new Position(3, 5) },
					new Position[] { new Position(7, 5), new Position(7, 6),
							new Position(7, 7), new Position(8, 4),
							new Position(8, 5), new Position(8, 6),
							new Position(8, 7), new Position(8, 8),
							new Position(8, 9), new Position(9, 5),
							new Position(9, 6), new Position(9, 7),
							new Position(9, 8), new Position(9, 9) }),

			new Preset(
					new Position[] { new Position(1, 4), new Position(1, 5),
							new Position(2, 4), new Position(2, 5),
							new Position(2, 6), new Position(3, 5),
							new Position(3, 6), new Position(7, 4),
							new Position(7, 5), new Position(8, 4),
							new Position(8, 5), new Position(8, 6),
							new Position(9, 5), new Position(9, 6) },
					new Position[] { new Position(1, 1), new Position(1, 2),
							new Position(2, 1), new Position(2, 2),
							new Position(2, 3), new Position(3, 2),
							new Position(3, 3), new Position(7, 7),
							new Position(7, 8), new Position(8, 7),
							new Position(8, 8), new Position(8, 9),
							new Position(9, 8), new Position(9, 9) })

	};

	// TODO write a comment
	/**
	 * This method return a defined list of start positions for both black and white marbles
	 * @param id It define which preset will be returned
	 * @return The selected preset
	 */
	public static Preset preset(int id) {
		return PRESETS[id];
	}
}
