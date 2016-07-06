package com.supinfo.TP;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.Checkbox;
import java.sql.SQLException;
import java.awt.Font;

public class Register extends JFrame implements FocusListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private JPanel contentPane;
	private JTextField txtUsername;
	private JPasswordField passwordField;
	private JLabel lblNewLabel;
	private JPasswordField passwordAgain;
	public Register() {
		setTitle("SUPTODO");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 564, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblNewLabel = new JLabel("Register Page");
		lblNewLabel.setFont(new Font("Cambria", Font.BOLD, 18));
		lblNewLabel.setBounds(196, 13, 152, 41);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblNewLabel);
		
		txtUsername = new JTextField();
		txtUsername.setFont(new Font("Cambria", Font.PLAIN, 18));
		txtUsername.setBounds(5, 130, 536, 24);
		txtUsername.setText("Username");
		txtUsername.addFocusListener(this);
		contentPane.add(txtUsername);
		txtUsername.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setFont(new Font("Cambria", Font.PLAIN, 18));
		passwordField.setBounds(5, 183, 536, 24);
		passwordField.setText("Password");
		passwordField.addFocusListener(this);
		passwordField.setEchoChar((char)0);
		passwordField.setColumns(16);
		contentPane.add(passwordField);
		
		JButton registerButton = new JButton("register");
		registerButton.setFont(new Font("Cambria", Font.BOLD, 18));
		registerButton.setBounds(180, 313, 124, 27);
		contentPane.add(registerButton);
		
		Checkbox managerCheck = new Checkbox("Manager");
		managerCheck.setBounds(39, 261, 118, 25);
		contentPane.add(managerCheck);
		
		Checkbox employeeCheck = new Checkbox("Employee");
		employeeCheck.setBounds(359, 261, 118, 25);
		contentPane.add(employeeCheck);
		
		passwordAgain = new JPasswordField();
		passwordAgain.setFont(new Font("Cambria", Font.PLAIN, 18));
		passwordAgain.setBounds(5, 220, 536, 24);
		passwordAgain.setText("check again");
		passwordAgain.addFocusListener(this);
		passwordAgain.setEchoChar((char)0);
		passwordAgain.setColumns(16);
		contentPane.add(passwordAgain);
		
		registerButton.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
				
				 if(managerCheck.getState()&&employeeCheck.getState()){
					JOptionPane.showMessageDialog(null,"You can't choose both identities");
				}
				 else if(managerCheck.getState()){
					if(passwordField.getText().equals(passwordAgain.getText()) && !(txtUsername.getText().equals("Username"))){
						Manager registerMgr=new Manager(txtUsername.getText(),passwordField.getText());
						try {
							registerMgr.addManager();
							
						} catch (SQLException e1) {
	
							System.out.println("Add manager wrong!!!");
						}
					}else{
						JOptionPane.showMessageDialog(null,"Username is empty or Password isn't same");
					}
					
				
				}
				else if(employeeCheck.getState()){
					if(passwordField.getText().equals(passwordAgain.getText()) && !(txtUsername.getText().equals("Username"))){
					
						Employee registerEmp=new Employee(txtUsername.getText(),passwordField.getText());
						try {
							registerEmp.addEmployee();
							
						} catch (SQLException e1) {
							System.out.println("Add employee wrong!!!");
						}
					}else{
						JOptionPane.showMessageDialog(null,"Username is empty or Password isn't same");
					}
				}
			}
		});
		
	}
	
	@SuppressWarnings("deprecation")
	@Override
	public void focusGained(FocusEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()== txtUsername  )
		{
			JTextField text = new JTextField();
			text = (JTextField)e.getSource();
			
			if(text.getText().equals("Username"))
			{
				
				text.setText(null);
			}
		}
		else if(e.getSource() == passwordField)
		{
			JPasswordField text = new JPasswordField();
			text = (JPasswordField)e.getSource();
			if(text.getText().equals("Password"))
			{
				text.setText("");
				text.setEchoChar('*');
			}
			
		}
		else if(e.getSource() == passwordAgain)
		{
			JPasswordField text = new JPasswordField();
			text = (JPasswordField)e.getSource();
			if(text.getText().equals("check again"))
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
		if(e.getSource() == txtUsername)
		{
			
			JTextField text = (JTextField)e.getSource();
			if(text.getText().equals(""))
			{
				text.setText("Username");
			}
			
		}
		else if(e.getSource() == passwordField)
		{
			JPasswordField text = new JPasswordField();
			text = (JPasswordField)e.getSource();
			
			if(text.getText().equals(""))
			{
				text.setText("Password");
				
				text.setEchoChar((char)0);
			}
			
		}
		else if(e.getSource() == passwordAgain)
		{
			JPasswordField text = new JPasswordField();
			text = (JPasswordField)e.getSource();
			
			if(text.getText().equals(""))
			{
				text.setText("check again");
				
				text.setEchoChar((char)0);
			}
			
		}
		
	}
}
