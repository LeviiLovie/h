import java.io.File;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.Rectangle;
import java.io.IOException;
import java.awt.AWTException;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import javax.swing.filechooser.FileSystemView;

public class Main {
    public static void main(String[] args) {
		try {
			ImageIO.write(grabScreen(), "png", new File(getHomeDir(), "screen.png"));
		} catch (IOException e) {
			System.out.println("IO exception"+e);
		}
	}

	private static File getHomeDir() {
		FileSystemView fsv = FileSystemView.getFileSystemView();
		return fsv.getHomeDirectory();
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