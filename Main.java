import java.awt.Robot;

import java.io.File;
import java.awt.Toolkit;
import java.awt.Rectangle;
import java.io.IOException;
import java.awt.AWTException;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;

public class Main {
    public static void main(String[] args) {
		try {ImageIO.write(grabScreen(), "png", new File("screen.png"));} catch (IOException e) {System.out.println("IO exception"+e);}
		
		move(250, 250);
	}

	private static void move(int x, int y) {
		try {
			Robot bot = new Robot();
			bot.mouseMove(x, y);  
		} catch (AWTException e) {
			e.printStackTrace();
		}
	}
	private static BufferedImage grabScreen() { 
		try {
			return new Robot().createScreenCapture(new Rectangle(Toolkit.getDefaultToolkit().getScreenSize())) ;
		} catch (SecurityException e) {
		} catch (AWTException e) {
		}
		return null;
	}
}