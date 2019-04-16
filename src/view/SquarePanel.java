package view;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class SquarePanel extends JPanel {
	
	private BufferedImage texture;
	
	public SquarePanel() {
		this.texture = Textures.nullTexture;
	}
	
	public SquarePanel(BufferedImage texture) {
		this.texture = texture;
	}
	
	public void changeTexture(BufferedImage texture) {
		this.texture = texture;
		this.getGraphics().drawImage(texture, 0, 0, this.getWidth(), this.getHeight(), null);
	}
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(texture, 0, 0, this.getWidth(), this.getHeight(), null);
	}
	
	public BufferedImage getTexture() {
		return texture;
	}
}
