/**
 * 
 */
package fr.iutvalence.info.m2105.project.tp1.ihm;

import java.awt.GridBagLayout;
import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import fr.iutvalence.info.m2103.project.tp1.abalone.AbaloneGame;
import fr.iutvalence.info.m2103.project.tp1.abalone.Board;
import fr.iutvalence.info.m2103.project.tp1.abalone.Color;
import fr.iutvalence.info.m2103.project.tp1.abalone.Marble;
import fr.iutvalence.info.m2103.project.tp1.abalone.Position;

/**
 * @author amaglioa
 *
 */
@SuppressWarnings("serial")
public class BoardDisplay extends JPanel {
	GridLayout grid;

	/**
	 * 
	 */
	public BoardDisplay(Board board) {
		this.grid = new GridLayout(9, 17);
		this.grid.setHgap(10);
		this.grid.setVgap(5);
		this.setLayout(grid);

		// TOUT DOUX :3
		int nbSpaces;
		int nbBoules;
		for (int yRange = 0; yRange < 5; yRange++) {
			nbSpaces = 0;
			nbBoules = 0;
			for (int xRange = 0; xRange < 18; xRange++) {
				if ((yRange + xRange) % 2 == 1) {
					this.add(new JLabel(""));
					continue;
				}
				if (nbSpaces < (9 - (yRange + 5)) / 2) {
					this.add(new JLabel());
					nbSpaces++;
					continue;
				}
				if (nbBoules < yRange + 5) {
					if (board.getMarble(new Position(yRange + 1,
							(xRange + yRange) / 2 - 1)) == null)
						this.add(new JLabel("O"));

					else if (board
							.getMarble(
									new Position(yRange + 1,
											(xRange + yRange) / 2 - 1))
							.getColor() == Color.BLACK)
						this.add(new JButton(new ImageIcon("img/black.png")));
					else if (board
							.getMarble(
									new Position(yRange + 1,
											(xRange + yRange) / 2 - 1))
							.getColor() == Color.WHITE)
						this.add(new JButton(new ImageIcon("img/white.png")));
					nbBoules++;
					continue;
				}
				if (nbSpaces < 9 - (yRange + 5)) {
					this.add(new JLabel(""));
					nbSpaces++;
					continue;
				}

			}
		}
		for (int yRange = 5; yRange < 9; yRange++) {
			nbSpaces = 0;
			nbBoules = 0;
			for (int xRange = 0; xRange < 18; xRange++) {
				if ((yRange + xRange) % 2 == 1) {
					this.add(new JLabel(""));
					continue;
				}
				if (nbSpaces < (yRange - 4) / 2) {
					this.add(new JLabel(""));
					nbSpaces++;
					continue;
				}
				if (nbBoules < 9 + 4 - yRange) {
					if (board.getMarble(new Position(yRange + 1,
							(xRange + yRange) / 2 - 1)) == null)
						this.add(new JLabel("O"));

					else if (board
							.getMarble(
									new Position(yRange + 1,
											(xRange + yRange) / 2 - 1))
							.getColor() == Color.BLACK)
						this.add(new JButton(new ImageIcon("img/black.png")));
					else if (board
							.getMarble(
									new Position(yRange + 1,
											(xRange + yRange) / 2 - 1))
							.getColor() == Color.WHITE)
						this.add(new JButton(new ImageIcon("../img/white.png")));
					nbBoules++;
					continue;
				}
				if (nbSpaces < yRange - 4) {
					this.add(new JLabel(""));
					nbSpaces++;
					continue;
				}

			}

		}
	}
}
