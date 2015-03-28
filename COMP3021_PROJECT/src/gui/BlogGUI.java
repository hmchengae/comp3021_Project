package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EtchedBorder;
import javax.swing.border.LineBorder;

public class BlogGUI implements ActionListener
{
	//generated serial id
	private static final long serialVersionUID = 3306702270988902055L;
	
	private JFrame mainFrame;
	private JTextArea postTextArea;
	private JTextField postContent;
	private JButton refresh;
	private JButton post;
	
	public BlogGUI() 
	{
		mainFrame = new JFrame("Micro Blog Demo");
		mainFrame.setLayout(new GridLayout(2, 1));
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel upperPanel = new JPanel();
		upperPanel.setLayout(new BorderLayout());
		upperPanel.setBorder(BorderFactory.createCompoundBorder(
				BorderFactory.createEmptyBorder(10,10,10,10), BorderFactory.createLineBorder(Color.black)));
		
		JLabel desriptionLabel = new JLabel("You can still input 140 characters.");
		upperPanel.add(desriptionLabel, BorderLayout.NORTH);
		
		postTextArea = new JTextArea("What's on your mind?");
		postTextArea.setBackground(new Color(240,255,223));
		upperPanel.add(postTextArea, BorderLayout.CENTER);
		
		JPanel buttonPanel = new JPanel();
		buttonPanel.setLayout(new GridLayout(1,2));
		refresh = new JButton("refresh");
		refresh.addActionListener(this);
		
		post = new JButton("post");
		post.addActionListener(this);
		
		refresh.setBackground(Color.orange);
		post.setBackground(Color.orange);
		buttonPanel.add(refresh);
		buttonPanel.add(post);
		upperPanel.add(buttonPanel, BorderLayout.SOUTH);
		
		mainFrame.add(upperPanel);
		
		postContent = new JTextField("Here is my post!");
		postContent.setHorizontalAlignment(JTextField.CENTER);
		postContent.setBackground(null);
		postContent.setBorder(BorderFactory.createCompoundBorder(
				BorderFactory.createEmptyBorder(0,10, 5 ,10), BorderFactory.createLineBorder(Color.black)));
		mainFrame.add(postContent);
		
		mainFrame.setSize(600, 600);
		mainFrame.setResizable(false);
		mainFrame.setLocationRelativeTo(null);
		mainFrame.setVisible(true);
		
	}
	
	
	public static void main(String[] args) 
	{
		BlogGUI blogGUi = new BlogGUI();
	}


	@Override
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource() == refresh)
		{
			postContent.setText("You click REFRESH!");
		}
		else if(e.getSource() == post)
		{
			postContent.setText("You click POST!");
		}
		
	}
	
	
}
