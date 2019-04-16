package view;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Textures {
	
	public static BufferedImage XTexture;
	public static BufferedImage OTexture;
	public static BufferedImage nullTexture;
	public static BufferedImage titleTexture;

	public static void loadTextures() {
		try {
			XTexture = ImageIO.read(new File("textures/XImage.png"));
			OTexture = ImageIO.read(new File("textures/OImage.png"));;
			nullTexture = ImageIO.read(new File("textures/nullImage.png"));
			titleTexture = ImageIO.read(new File("textures/titleImage.png"));
		} catch (IOException e) {
			e.printStackTrace();
			System.exit(-1);
		}
	}
}
