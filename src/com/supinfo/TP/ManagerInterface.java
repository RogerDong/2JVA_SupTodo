package com.supinfo.TP;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Label;

public class ManagerInterface extends JFrame implements FocusListener {

	
	private static final long serialVersionUID = 1L;

	private JPanel contentPane;
	private final JTextArea textArea = new JTextArea();

	/**
	 * Create the frame.
	 *  @param mgr deliver from login interface
	 */
	public ManagerInterface(Manager mgr) {
		setTitle("SUPTODO");
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 640, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{594};
		gbl_contentPane.rowHeights = new int[]{36, 77, 155, 32, 27};
		gbl_contentPane.columnWeights = new double[]{0.0};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		
		Label titleLabel = new Label("Write new Todo");
		titleLabel.setFont(new Font("Courier New", Font.BOLD, 20));
		titleLabel.setAlignment(SwingConstants.CENTER);
		GridBagConstraints gbc_titleLabel = new GridBagConstraints();
		gbc_titleLabel.fill = GridBagConstraints.VERTICAL;
		gbc_titleLabel.insets = new Insets(0, 0, 5, 0);
		gbc_titleLabel.gridx = 0;
		gbc_titleLabel.gridy = 0;
		contentPane.add(titleLabel, gbc_titleLabel);
		
		this.getContentPane().add(textArea);
		
		JTextArea txtrEnterNewTodo = new JTextArea();
		txtrEnterNewTodo.setWrapStyleWord(true);
		txtrEnterNewTodo.setLineWrap(true);
		txtrEnterNewTodo.setRows(10);
		txtrEnterNewTodo.setColumns(30);
		txtrEnterNewTodo.setFont(new Font("Serif", Font.PLAIN, 19));
		txtrEnterNewTodo.setText("Enter new Todo...");
		txtrEnterNewTodo.addFocusListener(this);
		GridBagConstraints gbc_txtrEnterNewTodo = new GridBagConstraints();
		gbc_txtrEnterNewTodo.fill = GridBagConstraints.BOTH;
		gbc_txtrEnterNewTodo.insets = new Insets(0, 0, 5, 0);
		gbc_txtrEnterNewTodo.gridx = 0;
		gbc_txtrEnterNewTodo.gridy = 2;
		contentPane.add(txtrEnterNewTodo, gbc_txtrEnterNewTodo);
		
		JButton addTodo = new JButton("Add Todo");
		addTodo.setFont(new Font("Segoe UI Light", Font.BOLD, 15));
		GridBagConstraints gbc_addTodo = new GridBagConstraints();
		gbc_addTodo.fill = GridBagConstraints.VERTICAL;
		gbc_addTodo.gridx = 0;
		gbc_addTodo.gridy = 4;
		contentPane.add(addTodo, gbc_addTodo);
		
		addTodo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				if(!txtrEnterNewTodo.getText().equals("Enter new Todo..."))
				{
					String todoString=txtrEnterNewTodo.getText();
					
					todoString=todoString.replaceAll("\\<.*?\\>", "");    //remove the html tag
					mgr.Add_Todo(todoString+"\r\nDate: "+df.format(new Date()).toString(),
							df.format(new Date()).toString());
					JOptionPane.showMessageDialog(null, "Adding a new todo successful!!!");
					txtrEnterNewTodo.setText("Enter new Todo...");
				}
				else
				{
					JOptionPane.showMessageDialog(null, "Please try to add something");
				}
			}
		});
	}

	@Override
	public void focusGained(FocusEvent arg0) {
		// TODO Auto-generated method stub
		JTextArea text = new JTextArea();
		text = (JTextArea)arg0.getSource();
		if(text.getText().equals("Enter new Todo..."))
		{
			text.setText("");
		}
		
	}

	@Override
	public void focusLost(FocusEvent arg0) {
		// TODO Auto-generated method stub
		JTextArea text = new JTextArea();
		text = (JTextArea)arg0.getSource();
		if(text.getText().equals(""))
		{
			text.setText("Enter new Todo...");
		}
	}
}
