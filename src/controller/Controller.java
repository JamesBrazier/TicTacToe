package controller;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.*;
import javax.swing.border.LineBorder;

import view.*;
import model.*;

public class Controller {
	
	public static final int windowWidth = (
			GameScreen.panelOffset * 2) + (GameScreen.panelSize * 3) + (GameScreen.panelSpacing * 2);
	public static final int windowHeight = (
			GameScreen.sidePanelSize + GameScreen.sidePanelOffset + (GameScreen.panelOffset * 3) + (GameScreen.panelSize * 3) + (GameScreen.panelSpacing * 2) + (GameScreen.buttonOffset) + GameScreen.buttonHeight);
	
	private MainWindow window;
	private GameScreen gameScreen;
	private StartScreen startScreen;
	private Game board;
	
	public Controller() {
		Textures.loadTextures();
		window = new MainWindow();
		gameScreen = new GameScreen();
		startScreen = new StartScreen();
		startScreen.getStartButton().setAction(new StartAction("Start Game!"));
		window.add(startScreen);
		for (int column = 0; column < 3; column++) {
			for (int row = 0; row < 3; row++) {
				gameScreen.getPanels()[row][column].addMouseListener(new SquareMouse(row, column));
			}
		}
		gameScreen.getButton().setAction(new StartAction("Restart"));
		window.add(gameScreen);
		gameScreen.setVisible(false);
	}
	
	public void resetGame() {
		for (int column = 0; column < 3; column++) {
			for (int row = 0; row < 3; row++) {
				gameScreen.getPanels()[row][column].changeTexture(Textures.nullTexture);
			}
		}
	}
	
	public void updateGame() {
		if (board.isWon()) {
			gameScreen.getTurnLabel().setText("Player " + board.getPlayer() + " Has Won!");
		} else if (board.getPlayer() == 1) {
			gameScreen.getTurnPanel().changeTexture(Textures.XTexture);
			gameScreen.getTurnLabel().setText("Player 1 Turn");
		} else {
			gameScreen.getTurnPanel().changeTexture(Textures.OTexture);
			gameScreen.getTurnLabel().setText("Player 2 Turn");
		}
	}
	
	public void playTurn(int row, int column) {
		if (board.canMove(row, column)) {
			board.setMove(board.getPlayer(), row, column);
			if (board.getPlayer() == 1) {
				gameScreen.getPanels()[row][column].changeTexture(Textures.XTexture);
			} if (board.getPlayer() == 2) {
				gameScreen.getPanels()[row][column].changeTexture(Textures.OTexture);
			}
			board.nextTurn();
			updateGame();
		} else {
			gameScreen.getTurnLabel().setText("That Square is full");
		}
	}
	
	@SuppressWarnings("serial")
	public class StartAction extends AbstractAction{
		
		public StartAction(String name) {
			super(name);
		}
		
		@Override
		public void actionPerformed(ActionEvent e) {
			startScreen.setVisible(false);
			gameScreen.setVisible(true);
			board = new Game();
			board.nextTurn();
			resetGame();
			updateGame();
		}
	}
	
	public class SquareMouse extends MouseAdapter {
		
		private int column;
		private int row;
		
		public SquareMouse(int row, int column) {
			super();
			this.column = column;
			this.row = row;
		}
		
		@Override
		public void mousePressed(MouseEvent e) {
			if (!board.isWon()) {
				playTurn(row, column);
			}
		}
		
		@Override
		public void mouseEntered(MouseEvent e) {
			if (!board.isWon()) {
				gameScreen.getPanels()[row][column].setBorder(new LineBorder(Color.WHITE, 6));
			}
		}
		
		@Override
		public void mouseExited(MouseEvent e) {
			if (!board.isWon()) {
				gameScreen.getPanels()[row][column].setBorder(null);
			}
		}
	}
	
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				new Controller();
			}
		});
	}
}
