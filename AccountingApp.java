import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileWriter;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
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
import javax.swing.table.AbstractTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableRowSorter;

public class AccountingApp {

	private final String ID = "wjdtjq754";
	private final String PASS = "wjdwls78";
	private JFrame frame;
	private JTextField idField;
	private JPasswordField passField;
	private JPanel currPanel;
	private JTextField nameInput;
	private JTextField amountInput;
	private JTextField searchInput;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AccountingApp window = new AccountingApp();
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
	public AccountingApp() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		TableData td = new TableData();
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		ImagePanel loginPanel = new ImagePanel(new ImageIcon("C:\\eclipse\\swing practice\\image\\theme.jpg").getImage());
		loginPanel.setBounds(0, 0, 1574, 667);
		frame.setSize(loginPanel.getDim());
		frame.setPreferredSize(loginPanel.getDim());
		frame.pack();
		frame.setLocationRelativeTo(null);
		ImagePanel sumPanel = new ImagePanel(new ImageIcon("C:\\eclipse\\swing practice\\image\\Activation.jpg").getImage());
		sumPanel.setBounds(0, 0, 1574, 667);
		frame.getContentPane().add(sumPanel);
		sumPanel.setLayout(null);
		sumPanel.setVisible(false);
		
		ImagePanel tranPanel = new ImagePanel(new ImageIcon("C:\\eclipse\\swing practice\\image\\Activation.jpg").getImage());
		tranPanel.setBounds(0, 0, 1562, 667);
		frame.getContentPane().add(tranPanel);
		tranPanel.setVisible(false);
		
		JButton tranBtn = new JButton("");
		tranBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				currPanel.setVisible(false);
				tranPanel.setVisible(true);
				currPanel= tranPanel;
			}
		});
		
		tranBtn.setBounds(29, 182, 259, 40);
		tranBtn.setIcon(new ImageIcon("C:\\eclipse\\swing practice\\image\\Transaction.jpg"));
		tranBtn.setBorder(null);
		sumPanel.add(tranBtn);
		
		JLabel lblNewLabel_1 = new JLabel("Search :");
		lblNewLabel_1.setFont(new Font("±¼¸²", Font.PLAIN, 22));
		lblNewLabel_1.setBounds(340, 80, 160, 47);
		sumPanel.add(lblNewLabel_1);
		
		searchInput = new JTextField();
		searchInput.setFont(new Font("±¼¸²", Font.BOLD, 22));
		searchInput.setBounds(434, 80, 1068, 47);
		sumPanel.add(searchInput);
		searchInput.setColumns(10);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 10, 10);
		sumPanel.add(panel);
		
		JPanel tp = new JPanel();
		tp.setBounds(340, 137, 1162, 444);
		tp.setOpaque(false); 	//ºÒÅõ¸íµµ ¾ø¾Ö±â
		sumPanel.add(tp);
		
		
		table = new JTable(td);
		table.setBounds(340, 137, 1138, 410);
		table.setRowHeight(30);
		table.setFont(new Font("Sansserif",Font.BOLD,15));
		table.setPreferredScrollableViewportSize(new Dimension(1138,410));
		tp.add(new JScrollPane(table));
		
		JTableHeader header = table.getTableHeader();
		frame.getContentPane().add(loginPanel);
		currPanel = loginPanel;
		header.setBackground(new Color(92,179,255));
		header.setForeground(new Color(255,255,255));
		header.setFont(new Font("Sansserif",Font.BOLD,15));
		
		searchInput.addKeyListener(new KeyAdapter() {	//°Ë»öÇÑ ´Ü¾îµé °Ë»öÇÏ±â
			public void keyReleased(KeyEvent e) {
				String search = searchInput.getText();
				TableRowSorter<AbstractTableModel> trs = new TableRowSorter<>(td);
				table.setRowSorter(trs);
				trs.setRowFilter(RowFilter.regexFilter(search));
			}
		});
		
		idField = new JTextField();
		idField.setFont(new Font("±¼¸²", Font.BOLD, 26));
		idField.setBounds(1221, 309, 297, 44);
		idField.setBorder(null);	//Å×µÎ¸® ¼± ¾ø¾Ú
		loginPanel.add(idField);
		idField.setColumns(10);
		
			passField = new JPasswordField();
			passField.setFont(new Font("±¼¸²", Font.BOLD, 26));
			passField.setBounds(1221, 388, 297, 44);
			passField.setBorder(null);
			loginPanel.add(passField);
			
			JCheckBox chckbxNewCheckBox = new JCheckBox("");
			chckbxNewCheckBox.setBounds(1185, 441, 20, 23);
			loginPanel.add(chckbxNewCheckBox);
			
			JButton loginBtn = new JButton("");
			loginBtn.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if(ID.equals(idField.getText()) && PASS.equals(passField.getText())) {
						currPanel.setVisible(false);
						sumPanel.setVisible(true);
						currPanel = sumPanel;
					}else {
						JOptionPane.showMessageDialog(null, "You failed to log in");
					}
				}
			});
			loginBtn.setBounds(1183, 467, 338, 38);
			loginPanel.add(loginBtn);
			loginBtn.setBorder(null);
			loginBtn.setIcon(new ImageIcon("C:\\eclipse\\swing practice\\image\\button.jpg"));
			loginBtn.setPressedIcon(new ImageIcon("C:\\eclipse\\swing practice\\image\\btnClicked.jpg"));
		
		
		JButton sumBtn = new JButton("");
		sumBtn.setIcon(new ImageIcon("C:\\eclipse\\swing practice\\image\\Summary.jpg"));
		sumBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				currPanel.setVisible(false);
				sumPanel.setVisible(true);
				currPanel = sumPanel;
			}
		});
		
		sumBtn.setBounds(29, 123, 259, 40);
		sumBtn.setBorder(null);
		tranPanel.add(sumBtn);
		
		JLabel lblNewLabel = new JLabel("Name");
		lblNewLabel.setFont(new Font("±¼¸²", Font.BOLD, 33));
		lblNewLabel.setBounds(329, 123, 170, 53);
		tranPanel.add(lblNewLabel);
		
		JLabel lblType = new JLabel("Type");
		lblType.setFont(new Font("±¼¸²", Font.BOLD, 33));
		lblType.setBounds(329, 191, 170, 53);
		tranPanel.add(lblType);
		
		JLabel lblAmount = new JLabel("Amount");
		lblAmount.setFont(new Font("±¼¸²", Font.BOLD, 33));
		lblAmount.setBounds(329, 258, 170, 53);
		tranPanel.add(lblAmount);
		
		JLabel lblNote = new JLabel("Note");
		lblNote.setFont(new Font("±¼¸²", Font.BOLD, 33));
		lblNote.setBounds(329, 335, 170, 53);
		tranPanel.add(lblNote);
		
		nameInput = new JTextField();
		nameInput.setFont(new Font("±¼¸²", Font.PLAIN, 33));
		nameInput.setBounds(463, 123, 963, 53);
		tranPanel.add(nameInput);
		nameInput.setColumns(10);
		
		String[] typeArr = new String[] {"Deposit", "Withdraw"};
		JComboBox typeInput = new JComboBox(typeArr);
		typeInput.setFont(new Font("±¼¸²", Font.PLAIN, 33));
		typeInput.setBounds(463, 186, 475, 53);
		typeInput.setBackground(Color.white);
		tranPanel.add(typeInput);
		
		amountInput = new JTextField();
		amountInput.setFont(new Font("±¼¸²", Font.PLAIN, 33));
		amountInput.setColumns(10);
		amountInput.setBounds(463, 254, 963, 53);
		tranPanel.add(amountInput);
		
		JTextArea noteInput = new JTextArea();
		noteInput.setFont(new Font("Monospaced", Font.PLAIN, 33));
		noteInput.setBounds(463, 335, 963, 143);
		noteInput.setBorder(BorderFactory.createLineBorder(Color.GRAY));
		tranPanel.add(noteInput);
		
		JButton submitBtn = new JButton("Submit");
		submitBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					boolean fileExists = new File("./data.csv").exists();
					FileWriter fw = new FileWriter("./data.csv",true);	//false¸é µ¥ÀÌÅÍ »õ·Î ÀÛ¼ºÇÒ ¶§ ¸¶´Ù ±âÁ¸ µ¥ÀÌÅÍ »èÁ¦
					if(!fileExists) {
						fw.append("Name, Type, Amount, Note\n");
					}
					String name = nameInput.getText();
					String type = (String)typeInput.getSelectedItem();
					String amount = amountInput.getText();
					String note = noteInput.getText();
					fw.append(name+ ","+type+ ","+amount + "," + note + "\n");
					nameInput.setText("");
					typeInput.setSelectedIndex(0);
					amountInput.setText("");
					noteInput.setText("");
					JOptionPane.showMessageDialog(null, "Data saved successfully");
					fw.close();
					td.refresh();
				}catch(Exception ex) {
					JOptionPane.showMessageDialog(null, "There was an error while writing the data");
				}
				
			}
		});
		submitBtn.setFont(new Font("±¼¸²", Font.PLAIN, 33));
		submitBtn.setBounds(835, 503, 219, 53);
		tranPanel.add(submitBtn);
		
		
		
	}
}
