package com.supinfo.TP;

import java.awt.HeadlessException;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.TextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.FocusListener;
import java.sql.SQLException;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Label;
import javax.swing.JPasswordField;
import java.awt.event.FocusEvent;
import javax.swing.JTextArea;

public class LoginInterface extends JFrame implements FocusListener, ActionListener{
	
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JPasswordField Password;
	private TextField Username;
	
	private final JTextArea textArea = new JTextArea();

	/**
	 * Create the login frame.
	 */
	public LoginInterface() {
		
		setTitle("SUPTODO");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{179, 181, 193, 4};
		gbl_contentPane.rowHeights = new int[]{33, 121, 31, 39, 29, 44, 31, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		Username = new TextField();
		Username.setColumns(16);
		Username.setFont(new Font("Bell MT", Font.PLAIN, 20));
		Username.setText("Username...");
		Username.addFocusListener(this);
		
		Label titleLabel = new Label("Login to SUPtodo");
		titleLabel.setAlignment(SwingConstants.CENTER);
		titleLabel.setFont(new Font("Courier New", Font.BOLD, 20));
		GridBagConstraints gbc_titleLabel = new GridBagConstraints();
		gbc_titleLabel.anchor = GridBagConstraints.NORTHWEST;
		gbc_titleLabel.insets = new Insets(0, 0, 5, 5);
		gbc_titleLabel.gridx = 1;
		gbc_titleLabel.gridy = 0;
		contentPane.add(titleLabel, gbc_titleLabel);
		GridBagConstraints gbc_textArea = new GridBagConstraints();
		gbc_textArea.anchor = GridBagConstraints.SOUTHWEST;
		gbc_textArea.insets = new Insets(0, 0, 5, 0);
		gbc_textArea.gridx = 3;
		gbc_textArea.gridy = 0;
		this.getContentPane().add(textArea, gbc_textArea);
		GridBagConstraints gbc_Username = new GridBagConstraints();
		gbc_Username.anchor = GridBagConstraints.NORTH;
		gbc_Username.fill = GridBagConstraints.HORIZONTAL;
		gbc_Username.insets = new Insets(0, 0, 5, 5);
		gbc_Username.gridwidth = 3;
		gbc_Username.gridx = 0;
		gbc_Username.gridy = 2;
		contentPane.add(Username, gbc_Username);
		
		JButton RegisterButton = new JButton("Register");
		RegisterButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Register register =new Register();
				register.setVisible(true);
				register.setResizable(false);				
			}
		});
		
		Password = new JPasswordField();
		Password.setFont(new Font("Bell MT", Font.PLAIN, 20));
		Password.addFocusListener(this);
		Password.setEchoChar((char)0);
		Password.setColumns(16);
		Password.setText("Password. . .");
		
		GridBagConstraints gbc_Password = new GridBagConstraints();
		gbc_Password.anchor = GridBagConstraints.NORTH;
		gbc_Password.fill = GridBagConstraints.HORIZONTAL;
		gbc_Password.insets = new Insets(0, 0, 5, 5);
		gbc_Password.gridwidth = 3;
		gbc_Password.gridx = 0;
		gbc_Password.gridy = 4;
		contentPane.add(Password, gbc_Password);
		
		JButton LoginButton = new JButton("login");
		LoginButton.setFont(new Font("Cambria", Font.BOLD, 18));
		GridBagConstraints gbc_LoginButton = new GridBagConstraints();
		gbc_LoginButton.anchor = GridBagConstraints.NORTHEAST;
		gbc_LoginButton.insets = new Insets(0, 0, 0, 5);
		gbc_LoginButton.gridx = 0;
		gbc_LoginButton.gridy = 6;
		contentPane.add(LoginButton, gbc_LoginButton);
		
		LoginButton.addActionListener(this);
		RegisterButton.setFont(new Font("Cambria", Font.BOLD, 18));
		GridBagConstraints gbc_RegisterButton = new GridBagConstraints();
		gbc_RegisterButton.anchor = GridBagConstraints.NORTHWEST;
		gbc_RegisterButton.insets = new Insets(0, 0, 0, 5);
		gbc_RegisterButton.gridx = 2;
		gbc_RegisterButton.gridy = 6;
		contentPane.add(RegisterButton, gbc_RegisterButton);
		
	}
	
	
	public void actionPerformed(ActionEvent arg0) {
		
		@SuppressWarnings("deprecation")
		Manager manager =new Manager(Username.getText(),Password.getText());
		@SuppressWarnings("deprecation")
		Employee employee = new Employee(Username.getText(),Password.getText());
		try {
			if(!manager.login()&&!employee.login())
			{
				JOptionPane.showMessageDialog(null,"Username or Password error!");
			}
			else if(manager.login())
			{
				ManagerInterface frame1=new ManagerInterface(manager);
				frame1.setVisible(true);
				frame1.setResizable(false);
				Username.setText("Username...");
				Password.setText("Password. . .");
				Password.setEchoChar((char)0);
			}
			else if(employee.login())
			{
				EmployeeInterface frame2=new EmployeeInterface(employee);
				frame2.setVisible(true);
				frame2.setResizable(false);
				Username.setText("Username...");
				Password.setText("Password. . .");
				Password.setEchoChar((char)0);
			}
		} catch (HeadlessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	@SuppressWarnings("deprecation")
	@Override
	public void focusGained(FocusEvent e) {
		// TODO Auto-generated method stub
		
		if(e.getSource()== Username  )
		{
			TextField text = new TextField();
			text = (TextField)e.getSource();
			
			if(text.getText().equals("Username..."))
			{
				
				text.setText(null);
			}
		}
		else if(e.getSource() == Password)
		{
			JPasswordField text = new JPasswordField();
			text = (JPasswordField)e.getSource();
			if(text.getText().equals("Password. . ."))
			{
				text.setText("");
				text.setEchoChar('*');
			}
			
		}
	}

	@SuppressWarnings("deprecation")
	@Override
	public void focusLost(FocusEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == Username)
		{
			
			TextField text = (TextField)e.getSource();
			if(text.getText().equals(""))
			{
				text.setText("Username...");
			}
			
		}
		else if(e.getSource() == Password)
		{
			JPasswordField text = new JPasswordField();
			text = (JPasswordField)e.getSource();
			
			if(text.getText().equals(""))
			{
				text.setText("Password. . .");
				
				text.setEchoChar((char)0);
			}
			
		}
		
	}
}
