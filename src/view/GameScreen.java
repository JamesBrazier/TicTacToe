package view;

import java.awt.Font;
import javax.swing.*;
import controller.Controller;

@SuppressWarnings("serial")
public class GameScreen extends JPanel {
	
	public static final int fontSize = 25;
	public static final int sidePanelSize = 120;
	public static final int sidePanelOffset = 60;
	public static final int panelSize = 120;
	public static final int panelOffset = 40;
	public static final int panelSpacing = 0;
	public static final int buttonOffset = 20;
	public static final int buttonWidth = 120;
	public static final int buttonHeight = 50;
	
	private SquarePanel[][] panels = new SquarePanel[3][3];
	private SquarePanel turnPanel;
	private JLabel turnLabel;
	private JButton button;

	public GameScreen() {
		this.setBounds(0, 0, Controller.windowWidth, Controller.windowHeight);
		this.setLayout(null);
		turnLabel = new JLabel();
		turnLabel.setBounds(panelOffset + panelSize, panelOffset, panelSize * 2, panelSize);
		turnLabel.setHorizontalAlignment(JLabel.CENTER);
		turnLabel.setFont(new Font(null, 0, fontSize));
		this.add(turnLabel);
		turnPanel = new SquarePanel();
		turnPanel.setBounds(panelOffset, panelOffset, sidePanelSize, sidePanelSize);
		this.add(turnPanel);
		for (int row = 0; row < 3; row++) {
			for (int column = 0; column < 3; column++) {
				SquarePanel panel = new SquarePanel();
				panel.setBounds(panelOffset + ((panelSpacing + panelSize) * (column)), 
						sidePanelSize + sidePanelOffset + panelOffset + ((panelSpacing + panelSize) * (row)), panelSize, panelSize);
				this.add(panel);
				panels[row][column] = panel;
			}
		}
		button = new JButton();
		button.setBounds(((Controller.windowWidth + buttonWidth) / 2) - buttonWidth, Controller.windowHeight - (buttonHeight + (buttonOffset * 3)), buttonWidth, buttonHeight);
		this.add(button);
	}
	
	public SquarePanel[][] getPanels() {
		return panels;
	}
	
	public SquarePanel getTurnPanel() {
		return turnPanel;
	}
	
	public JLabel getTurnLabel() {
		return turnLabel;
	}
	
	public JButton getButton() {
		return button;
	}

}
