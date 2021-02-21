import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.ImageIcon;

public class Lesson9 {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Lesson9 window = new Lesson9();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Lesson9() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 676, 404);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 10, 648, 345);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JButton btnNewButton = new JButton("");
		btnNewButton.setIcon(new ImageIcon("D:\\DATA (\uC808\uB300 \uC0AD\uC81C\uAE08\uC9C0)\\Desktop\\common9LE8GR1P.jpg"));
		btnNewButton.setSelectedIcon(new ImageIcon("D:\\DATA (\uC808\uB300 \uC0AD\uC81C\uAE08\uC9C0)\\Desktop\\common9LE8GR1P.jpg"));
		btnNewButton.setBounds(32, 45, 267, 100);
		btnNewButton.setPressedIcon(new ImageIcon("C:\\eclipse\\swing practice\\image\\afk.jpg"));
		panel.add(btnNewButton);
	}
}
