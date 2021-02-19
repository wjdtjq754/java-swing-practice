import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;

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
		
		ImagePanel panel = new ImagePanel(new ImageIcon("./image/afk.jpg").getImage());	//경로에 해당하는 이미지를 가져온다.
		frame.add(panel);
		frame.pack();  // frame의 크기를 사진크기에 맞춰준다.
		

	}

}
class ImagePanel extends JPanel{
	private Image img;
	
	public ImagePanel(Image img) {
		this.img = img;
		setSize(new Dimension(img.getWidth(null),img.getHeight(null)));
		setPreferredSize(new Dimension(img.getWidth(null),img.getHeight(null)));
		setLayout(null);	//
	}
	public void paintComponent(Graphics g) {
		g.drawImage(img,0,0,null);
	}
}
