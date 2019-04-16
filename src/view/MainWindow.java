package view;

import javax.swing.*;
import controller.Controller;

@SuppressWarnings("serial")
public class MainWindow extends JFrame {
	
	public MainWindow() {
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(Controller.windowWidth, Controller.windowHeight);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setTitle("Tic Tac Toe");
		this.setIconImage(Textures.titleTexture);
	}
}
