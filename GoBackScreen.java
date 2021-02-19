import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Lesson6 {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Lesson6 window = new Lesson6();
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
	public Lesson6() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("Lesson6");
		frame.setBounds(100, 100, 800, 600);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel endPage = new JPanel();
		endPage.setBounds(0, 0, 794, 571);
		frame.getContentPane().add(endPage);
		endPage.setLayout(null);
		
		JButton btnBefore = new JButton("GO TO LAST");
		btnBefore.setFont(new Font("HY°ß°íµñ", Font.PLAIN, 20));
		btnBefore.setBounds(529, 98, 189, 282);
		endPage.add(btnBefore);
		
		JPanel startPage = new JPanel();
		startPage.setBounds(12, 10, 770, 551);
		frame.getContentPane().add(startPage);
		startPage.setLayout(null);
		
		JButton btnNext = new JButton("GO TO NEXT");
		btnNext.setBounds(59, 76, 267, 327);
		startPage.add(btnNext);
		endPage.setVisible(false);	//startPage 먼저 보이도록
		btnNext.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				endPage.setVisible(true);
				startPage.setVisible(false);
				
			}
			
		});
		btnBefore.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				startPage.setVisible(true);
				endPage.setVisible(false);
			}
		});
	}
}
