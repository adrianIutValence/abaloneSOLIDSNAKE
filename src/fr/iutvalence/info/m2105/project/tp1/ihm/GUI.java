/**
 * 
 */
package fr.iutvalence.info.m2105.project.tp1.ihm;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSplitPane;

import fr.iutvalence.info.m2103.project.tp1.abalone.Board;

/**
 * @author amaglioa
 *
 */
public class GUI implements Runnable{
	Window window;
	BoardDisplay boardDisplay;
	Board board;
	JSplitPane mainSplit;
	JSplitPane topSplit;
	JLabel userMessage;

	JPanel directionPrompt;
	
	public GUI(Board board){
		this.board = board;
	}
	
	public void run(){
		//Definition of the direction prompt
		GridLayout grid = new GridLayout(3, 2);
		this.directionPrompt = new JPanel(grid);
		String[] directions = new String[] {"NW", "NE", "W", "E", "SW", "SE"};
		
		for(String direction : directions){
			this.directionPrompt.add(new JButton(direction));
		}
		
		this.window = new Window();
		this.userMessage = new JLabel();
		this.topSplit = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, this.userMessage, this.directionPrompt);
		this.boardDisplay = new BoardDisplay(this.board);
		this.mainSplit = new JSplitPane(JSplitPane.VERTICAL_SPLIT, this.topSplit, this.boardDisplay);
		
		
		this.window.add(this.mainSplit);
		this.window.setVisible(true);

	}

	public JLabel getUserMessage() {
		return userMessage;
	}

	public void setUserMessage(String string) {
		this.userMessage.setText(string);
	}
}