import java.awt.Robot;

import java.io.File;
import java.awt.Toolkit;
import java.awt.Rectangle;
import java.io.IOException;
import java.awt.AWTException;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.awt.event.*;
import java.lang.Thread;

public class Main {
    public static void main(String[] args) {
		try {ImageIO.write(grabScreen(), "png", new File("screen.png"));} catch (IOException e) {System.out.println("IO exception"+e);}
		
		// press(1400, 175);
		press2(425, 725);

		try {Thread.sleep(1000);} catch (InterruptedException e) {e.printStackTrace();}
		press2(750, 390);
		try {Thread.sleep(1000);} catch (InterruptedException e) {e.printStackTrace();}
		press2(1200, 710);
		try {Thread.sleep(1000);} catch (InterruptedException e) {e.printStackTrace();}
		press(1200, 725);
	}

	private static void press2(int x, int y) {
		try {
			Robot bot = new Robot();
			bot.mouseMove(x, y);
    		bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
    		bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
		} catch (AWTException e) {
			e.printStackTrace();
		}
	}
	private static void press(int x, int y) {
		try {
			Robot bot = new Robot();
			bot.mouseMove(x, y);
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