package random.password.generator;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import javax.swing.border.*;

public class RandomPasswordGenerator extends JFrame implements ActionListener{
	private JPanel contentPane;
	private JTextField inpuField, inputPassLenField;
	private JButton generateButton;
	private JLabel label, l1, l2, l3;
	public int passwordLength;
	
	public RandomPasswordGenerator() {
		super("Random Password Generator");
		setBounds(250, 50, 900, 600);
		contentPane = new JPanel();
		setContentPane(contentPane);
		contentPane.setBackground(Color.WHITE);
		contentPane.setLayout(null);
		
		inpuField = new JTextField();
		inpuField.setBounds(260, 280, 350, 50);
		inpuField.setFont(new Font("Consolas", Font.BOLD, 14));
		inpuField.setForeground(Color.DARK_GRAY);
		inpuField.setEditable(false);
		inpuField.setBackground(Color.WHITE);
		inpuField.setBorder(new LineBorder(new Color(51, 50, 77), 1));
		contentPane.add(inpuField);
		
		label = new JLabel("Password Length: ");
		label.setBounds(260, 230, 200, 30);
		contentPane.add(label);
		

		l1 = new JLabel("New Label");
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("random/password/generator/icons/main.png"));
		Image i2 = i1.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);
		ImageIcon i3 = new ImageIcon(i2);
		l1 = new JLabel(i3);
		l1.setBounds(220, 20, 120, 120);
		contentPane.add(l1);
		
		l2 = new JLabel("Random Password");
		l2.setForeground(new Color(184, 154, 57));
		l2.setFont(new Font("Calibre", Font.BOLD, 32));
		l2.setBounds(350, 25, 400, 60);
		contentPane.add(l2);
		
		l3 = new JLabel("Generator");
		l3.setForeground(new Color(77, 99, 138));
		l3.setFont(new Font("Calibre", Font.BOLD, 32));
		l3.setBounds(350, 65, 400, 60);
		contentPane.add(l3);
		
		inputPassLenField = new JTextField();
		inputPassLenField.setBounds(380, 230, 20, 30);
		inputPassLenField.setFont(new Font("Consolas", Font.BOLD, 14));
		inputPassLenField.setForeground(Color.DARK_GRAY);
		inputPassLenField.setBackground(Color.WHITE);
		inputPassLenField.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, new Color(51, 50, 77)));
		contentPane.add(inputPassLenField);
		
		
		generateButton = new JButton("Generate");
		generateButton.setBounds(385, 340, 100, 40);
		generateButton.setBackground(new Color(51, 50, 77));
		generateButton.setForeground(Color.WHITE);
		generateButton.setFont(new Font("Consolas", Font.BOLD, 14));
		contentPane.add(generateButton);
		generateButton.addActionListener(this);
	}
	
	String generateRandomPass(int P_L) {
		String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz@#$%^&*?1234567890";
		StringBuilder stringBuilder = new StringBuilder();
		Random random = new Random();
		for (int i = 0; i < P_L; i++) {
		       int index = random.nextInt(chars.length()); 
		       stringBuilder.append(chars.charAt(index)); 
		}
		String password = stringBuilder.toString();
		return password;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		passwordLength = Integer.parseInt(inputPassLenField.getText());
		inpuField.setText(generateRandomPass(passwordLength));
	}
	
	public static void main(String[] args) {
		new RandomPasswordGenerator().setVisible(true);
	}
}
