package view;

import java.awt.Font;

import javax.swing.*;
import controller.Controller;

@SuppressWarnings("serial")
public class StartScreen extends JPanel {
	
	public static final int fontSize = 35;
	public static final int buttonWidth = 300;
	public static final int buttonHeight = 100;
	public static final int buttonAreaSize = 300;
	
	private JButton startButton;
	
	public StartScreen() {
		this.setBounds(0, 0, Controller.windowWidth, Controller.windowHeight);
		this.setLayout(null);
		JLabel label = new JLabel();
		label.setText("Welcome to Tic Tac Toe!");
		label.setBounds(0, 0, Controller.windowWidth, Controller.windowHeight - buttonAreaSize);
		label.setHorizontalAlignment(JLabel.CENTER);
		label.setFont(new Font(null, 0, fontSize));
		this.add(label);
		startButton = new JButton();
		startButton.setBounds((Controller.windowWidth / 2) - 150, (Controller.windowHeight - buttonAreaSize), buttonWidth, buttonHeight);
		startButton.setFont(new Font(null, 0, fontSize));
		this.add(startButton);
	}
	
	public JButton getStartButton() {
		return startButton;
	}
}
