/**
 * 
 */
package fr.iutvalence.info.m2103.project.tp1.abalone;

/**
 * @author amaglioa
 *
 */
public interface Player {

	/**
	 * This method waits for an user input and create the movement that correspond.
	 * @return the movement to validate and execute
	 */
	public Movement waitAction();

}