import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Lesson8 {

	public static void main(String[] args) {
		JFrame frame = new JFrame("Lesson 8");
		frame.setSize(640,480);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		
		ImagePanel panel = new ImagePanel(new ImageIcon("./image/afk.jpg").getImage());
		File f = new File("./image/afk.jpg");
		System.out.println(f.exists() ? "yes" : "no");
		frame.add(panel);
		frame.pack();
		

	}

}
class ImagePanel extends JPanel{
	private Image img;
	
	public ImagePanel(Image img) {
		this.img = img;
		setSize(new Dimension(img.getWidth(null),img.getHeight(null)));
		setPreferredSize(new Dimension(img.getWidth(null),img.getHeight(null)));
		setLayout(null);
	}
	public void paintComponent(Graphics g) {
		g.drawImage(img,0,0,null);
	}
}