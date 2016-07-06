package com.supinfo.TP;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTabbedPane;
import java.awt.Checkbox;
import java.awt.TextArea;
import javax.swing.JButton;
import javax.swing.JTextArea;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;

public class EmployeeInterface extends JFrame {

	private static final long serialVersionUID = 1L;

	private JPanel contentPane;
	
	/**
	 * Create the frame.
	 * @throws SQLException
	 * @param emp is delivered from employee interface 
	 */
	
	//the variable outside to control the circle.
	
	int i=1,j=1,k=1;
	public EmployeeInterface(Employee emp) throws SQLException {
		
		int[] IdList=new int[100];                      			//store the todo ID
		ArrayList<JButton> allbutton=new ArrayList<JButton>();		//store all the JButton
		ArrayList<TextArea> alltext=new ArrayList<TextArea>();	    //store all the text;
		ArrayList<JTextArea> allcomment=new ArrayList<JTextArea>(); //store all the comment
		ArrayList<Checkbox> allbox=new ArrayList<Checkbox>(); 		//store all the Checkbox

		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); 
		setBounds(100, 100, 600, 500);
		contentPane = new JPanel();                      
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{554};
		gbl_contentPane.rowHeights = new int[]{427};
		gbl_contentPane.columnWeights = new double[]{0.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		// create a tabbedPane to store the components
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		GridBagConstraints gbc_tabbedPane = new GridBagConstraints();
		gbc_tabbedPane.fill = GridBagConstraints.BOTH;
		gbc_tabbedPane.gridx = 0;
		gbc_tabbedPane.gridy = 0;
		contentPane.add(tabbedPane, gbc_tabbedPane);
		
		//to link to the database to find the result.
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			System.out.println("can't find the driver");
			e.printStackTrace();
		}
		String url ="jdbc:mysql://127.0.0.1:3306/suptodo";
		
		Connection con=DriverManager.getConnection(url,"root","");
		//to find all todo;
		PreparedStatement pstmt = con.prepareStatement(
				"SELECT * FROM todo");
		ResultSet rs = pstmt.executeQuery();
		//fetch todo one by one;
		while(rs.next())
		{
			//if the todo is not checked. then show it
			if(rs.getString("CHECKED").equals("false")){
				IdList[i]=Integer.parseInt(rs.getString("Id"));//store the todo id ;
				
				JPanel panel = new JPanel(); //create a JPanel to store the component for each todo;
				panel.setBounds(0, 0, 560, 430);
				tabbedPane.addTab("Task"+i, panel);
				panel.setLayout(null);
		
				TextArea textArea = new TextArea("",0,0,TextArea.SCROLLBARS_VERTICAL_ONLY);
				textArea.setBounds(10, 41, 529, 203);
				textArea.setFont(new Font("Serif",Font.PLAIN,19));
				textArea.setEditable(false);
				panel.add(textArea);
				textArea.setText(rs.getString("message"));
				alltext.add(textArea);
			
				Checkbox checkbox = new Checkbox("Mark as done");
				checkbox.setBounds(10, 262, 118, 30);
				panel.add(checkbox);
				allbox.add(checkbox);
				
				JButton btnNewButton = new JButton("Save");
				btnNewButton.setBounds(10, 355, 529, 27);
				panel.add(btnNewButton);
			    allbutton.add(btnNewButton);
				
				JTextArea txtrWriteAComment = new JTextArea();
				txtrWriteAComment.setFont(new Font("Serif", Font.PLAIN, 19));
				txtrWriteAComment.setText("Write a comment");
				txtrWriteAComment.setBounds(10, 300, 529, 42);
				txtrWriteAComment.setLineWrap(true);
				txtrWriteAComment.setWrapStyleWord(true);
				allcomment.add(txtrWriteAComment);
				
				panel.add(txtrWriteAComment);
				
				i++;
			}
		}
		for(j=1;j<i;j++)
		 {
			 allbutton.get(j-1).addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						for(k=1;k<i;k++)
						{
							//to check which button is selected.
							if(e.getSource()==allbutton.get(k-1)){
								// if the check box is selected and comment is not null .
								if(allbox.get(k-1).getState()&&!(allcomment.get(k-1).getText().equals("Write a comment"))){
									
									SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
									String newText=alltext.get(k-1).getText()+"\r\n\nComment by "+
											emp.Name +" :"+allcomment.get(k-1).getText()+" "+df.format(new Date()).toString();
									
									try {
										PreparedStatement update = con.prepareStatement(
												"UPDATE todo SET MESSAGE=?,CHECKED=? WHERE ID=?"
											);
										update.setString(1, newText);
										update.setString(2, "true");
										update.setInt(3, IdList[k]);
										update.executeUpdate();
										allcomment.get(k-1).setText("Write a comment");
										alltext.get(k-1).setText(newText);
									} catch (SQLException e1) {
										System.out.println("update error");
										e1.printStackTrace();
									}
									
								}
								// if the check box is selected and comment is null .
								else if(allbox.get(k-1).getState()&&allcomment.get(k-1).getText().equals("Write a comment")){
									JOptionPane.showMessageDialog(null, "You must Comment");
								}
								// if the comment is not null .
								else if(!(allcomment.get(k-1).getText().equals("Write a comment"))){
									
									SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
									String newText=alltext.get(k-1).getText()+"\r\n\nComment by "+
											emp.Name +" :"+allcomment.get(k-1).getText()+" "+df.format(new Date()).toString();
									
									try {
										PreparedStatement addComm = con.prepareStatement(
												"UPDATE todo SET MESSAGE=? WHERE ID=?"
											);
										addComm.setString(1, alltext.get(k-1).getText()+"\r\n\nComment by "+
										emp.Name +" :"+allcomment.get(k-1).getText()+" "+df.format(new Date()).toString());
										addComm.setInt(2, IdList[k]);
										addComm.executeUpdate();
										allcomment.get(k-1).setText("Write a comment");
										alltext.get(k-1).setText(newText);
										
									} catch (SQLException e1) {
										System.out.println("update error");
										e1.printStackTrace();
									}
								}
							}
						}
						
					}
				});
		 }
		
	}
}
