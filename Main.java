import java.awt.Robot;

import java.io.File;
import java.awt.Toolkit;
import java.awt.Rectangle;
import java.io.IOException;
import java.awt.AWTException;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.awt.event.*;

public class Main {
    public static void main(String[] args) {
		try {ImageIO.write(grabScreen(), "png", new File("screen.png"));} catch (IOException e) {System.out.println("IO exception"+e);}
		
		// move(50, 30);
		// press(300, 150);
		// press(300, 150);
		// press(50, 30);
		// move(1400, 175);
		press(1400, 175);
	}

	private static void press(int x, int y) {
		try {
			Robot bot = new Robot();
			bot.mouseMove(x, y);
    		bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
    		bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
		} catch (AWTException e) {
			e.printStackTrace();
		}
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