import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Arrays;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.SwingConstants;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

public class Customer_App {

	private JFrame frame;
	private JTextField id;
	private JPasswordField password;
	private JTextField name;
	private JTextField phone;
	private JTextField age;
	private JTextField birthday;
	private JTextField search;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Customer_App window = new Customer_App();
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
	public Customer_App() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		Customer customer = new Customer();
		frame = new JFrame();
		frame.getContentPane().setLayout(null);
		String[][] data = customer.getCustomers();
		String[] headers = new String[]{"Name","Phone","Gender","Age","Note"};
		ImagePanel mainPanel = new ImagePanel(new ImageIcon("C:/eclipse/swing practice/image/register.jpg").getImage());
		
		ImagePanel tablePanel = new ImagePanel(new ImageIcon("C:/eclipse/swing practice/image/list.jpg").getImage());
		tablePanel.setBounds(0, 1, 853, 510);
		tablePanel.setVisible(false);
		ImagePanel welcomePanel = new ImagePanel(new ImageIcon("C:/eclipse/swing practice/image/welcome.jpg").getImage());
		welcomePanel.setBounds(0, 1, 853, 510);
		frame.setSize(welcomePanel.getWidth(),welcomePanel.getHeight());
		frame.getContentPane().add(welcomePanel);
		
		JLabel lblNewLabel = new JLabel("Log in");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("함초롬돋움", Font.BOLD, 30));
		lblNewLabel.setBounds(294, 88, 278, 114);
		welcomePanel.add(lblNewLabel);
		
		id = new JTextField();
		id.setFont(new Font("굴림", Font.BOLD, 30));
		id.setToolTipText("Enter ID");
		id.setBounds(269, 184, 350, 55);
		welcomePanel.add(id);
		id.setColumns(10);
		
		password = new JPasswordField();
		password.setBounds(269, 249, 350, 55);
		welcomePanel.add(password);
		
		JLabel lblNewLabel_1 = new JLabel("ID:");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("굴림", Font.BOLD, 30));
		lblNewLabel_1.setBounds(168, 184, 71, 55);
		welcomePanel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("PW:");
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1.setFont(new Font("굴림", Font.BOLD, 30));
		lblNewLabel_1_1.setBounds(168, 249, 71, 55);
		welcomePanel.add(lblNewLabel_1_1);
		
		JButton btnNewButton = new JButton("");
		btnNewButton.setIcon(new ImageIcon("C:\\eclipse\\swing practice\\image\\login.jpg"));
		btnNewButton.setPressedIcon(new ImageIcon("C:\\eclipse\\swing practice\\image\\login2.jpg"));
		btnNewButton.setBounds(317, 334, 227, 55);
		btnNewButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if(id.getText().equals("Danny") && Arrays.equals(password.getPassword(), "hello".toCharArray())) {
					System.out.println("Welcome Danny");
					welcomePanel.setVisible(false);
					mainPanel.setVisible(true);
				}else {
					JOptionPane.showMessageDialog(null, "You failed to log in");
				}
				
				
			}
			
		});
		welcomePanel.add(btnNewButton);
		tablePanel.setLayout(null);
		JTable table = new JTable(data, headers);
		table.setRowHeight(30);
		table.setFont(new Font("Sanserif",  Font.BOLD, 15));
		table.setAlignmentX(0);	//정렬
		table.setSize(800,400);
		table.setPreferredScrollableViewportSize(new Dimension(800,400));
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(90, 122, 669, 253);
		tablePanel.add(scrollPane);	//JScrollPane 스크롤이 가능하게 함
		frame.getContentPane().add(tablePanel);
		
		search = new JTextField();
		search.setFont(new Font("굴림", Font.PLAIN, 17));
		search.setBounds(90, 71, 669, 28);
		tablePanel.add(search);
		search.setColumns(10);
		
		JButton btnNewButton_3 = new JButton("New button");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tablePanel.setVisible(false);
				mainPanel.setVisible(true);
			}
		});
		btnNewButton_3.setIcon(new ImageIcon("C:\\eclipse\\swing practice\\image\\register2.jpg"));
		btnNewButton_3.setBounds(240, 374, 298, 76);
		tablePanel.add(btnNewButton_3);
		//필터 기능 만들기
		search.addKeyListener(new KeyAdapter() {	//key의 변동사항이 있을 경우
			public void keyReleased(KeyEvent e) {
				String val= search.getText();
				TableRowSorter<TableModel> trs= new TableRowSorter<>(table.getModel());	//table 정리
				table.setRowSorter(trs);
				trs.setRowFilter(RowFilter.regexFilter(val));	//행을 정리하는 기능
			}
		});	
		//column길이 조절하기
		TableColumnModel columnModels = table.getColumnModel();
		
		
		mainPanel.setBounds(0, 1, 853, 510);
		frame.getContentPane().add(mainPanel);
		mainPanel.setLayout(null);
		mainPanel.setVisible(false);
		
		JLabel lblNewLabel_2 = new JLabel("welcome This is Main Panel");
		lblNewLabel_2.setFont(new Font("Arial Black", Font.PLAIN, 25));
		lblNewLabel_2.setBounds(204, 10, 464, 78);
		mainPanel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Name");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setFont(new Font("굴림", Font.PLAIN, 21));
		lblNewLabel_3.setBounds(66, 83, 227, 60);
		mainPanel.add(lblNewLabel_3);
		
		JLabel lblNewLabel_3_1 = new JLabel("Age");
		lblNewLabel_3_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3_1.setFont(new Font("굴림", Font.PLAIN, 21));
		lblNewLabel_3_1.setBounds(66, 155, 227, 60);
		mainPanel.add(lblNewLabel_3_1);
		
		JLabel lblNewLabel_3_2 = new JLabel("Gender");
		lblNewLabel_3_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3_2.setFont(new Font("굴림", Font.PLAIN, 21));
		lblNewLabel_3_2.setBounds(66, 218, 227, 60);
		mainPanel.add(lblNewLabel_3_2);
		
		JLabel lblNewLabel_3_3 = new JLabel("Phone");
		lblNewLabel_3_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3_3.setFont(new Font("굴림", Font.PLAIN, 21));
		lblNewLabel_3_3.setBounds(426, 83, 227, 60);
		mainPanel.add(lblNewLabel_3_3);
		
		JLabel lblNewLabel_3_4 = new JLabel("Birthday");
		lblNewLabel_3_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3_4.setFont(new Font("굴림", Font.PLAIN, 21));
		lblNewLabel_3_4.setBounds(426, 155, 227, 60);
		mainPanel.add(lblNewLabel_3_4);
		
		JLabel lblNewLabel_3_5 = new JLabel("Note");
		lblNewLabel_3_5.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3_5.setFont(new Font("굴림", Font.PLAIN, 21));
		lblNewLabel_3_5.setBounds(426, 218, 227, 60);
		mainPanel.add(lblNewLabel_3_5);
		
		name = new JTextField();
		name.setFont(new Font("굴림", Font.PLAIN, 19));
		name.setBounds(230, 98, 183, 30);
		mainPanel.add(name);
		name.setColumns(10);
		
		phone = new JTextField();
		phone.setFont(new Font("굴림", Font.PLAIN, 19));
		phone.setColumns(10);
		phone.setBounds(604, 99, 183, 30);
		mainPanel.add(phone);
		
		age = new JTextField();
		age.setFont(new Font("굴림", Font.PLAIN, 19));
		age.setColumns(10);
		age.setBounds(230, 171, 183, 30);
		mainPanel.add(age);
		
		birthday = new JTextField();
		birthday.setFont(new Font("굴림", Font.PLAIN, 19));
		birthday.setColumns(10);
		birthday.setBounds(604, 172, 183, 30);
		mainPanel.add(birthday);
		
		JComboBox gender = new JComboBox(new String[] {"Male","Female"});
		gender.setFont(new Font("굴림", Font.PLAIN, 19));
		gender.setBackground(Color.WHITE);
		gender.setBounds(230, 234, 184, 37);
		mainPanel.add(gender);
		
		JTextArea note = new JTextArea();
		note.setBounds(604, 234, 183, 132);
		note.setBorder(BorderFactory.createLineBorder(Color.black));	//	 textArea 테두리 선 만들기
		mainPanel.add(note);
		
		JButton btnNewButton_1 = new JButton("Submit");
		btnNewButton_1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String nameTxt = name.getText();
				String ageTxt = age.getText();
				String phoneTxt = phone.getText();
				String genderTxt = gender.getSelectedItem().toString();
				String noteTxt = note.getText();
				
				customer.createCustomer(nameTxt, phoneTxt, genderTxt, ageTxt, noteTxt);
				JOptionPane.showMessageDialog(null, "Your data has been saved successfully");
				mainPanel.setVisible(false);
				tablePanel.setVisible(true);
			}
			
		});
		btnNewButton_1.setBounds(303, 376, 275, 60);
		mainPanel.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("");
		btnNewButton_2.setBorder(BorderFactory.createLineBorder(Color.white));
		btnNewButton_2.setBackground(Color.WHITE);
		btnNewButton_2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				mainPanel.setVisible(false);
				tablePanel.setVisible(true);
				
			}
			
		});
		
		btnNewButton_2.setIcon(new ImageIcon("C:\\eclipse\\swing practice\\image\\list2.jpg"));
		btnNewButton_2.setBounds(99, 351, 84, 85);
		mainPanel.add(btnNewButton_2);
		columnModels.getColumn(0).setPreferredWidth(100);
		columnModels.getColumn(2).setPreferredWidth(50);
		columnModels.getColumn(3).setPreferredWidth(20);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
	
	public int getWidth() {
		return img.getWidth(null);
	}
	
	public int getHeigth() {
		return img.getHeight(null);
	}
	
	public void paintComponent(Graphics g) {
		g.drawImage(img,0,0,null);
	}
}