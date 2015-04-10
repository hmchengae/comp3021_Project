package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EtchedBorder;
import javax.swing.border.LineBorder;

import unit.Post;
import unit.User;
import blog.Blog;

public class BlogGUI 
{
	//generated serial id
	private static final long serialVersionUID = 3306702270988902055L;
	
	private JFrame mainFrame;
	private JTextArea postTextArea;
	private JTextArea postContent;
	private JLabel desriptionLabel;
	private JButton refresh;
	private JButton post;
	private Blog myBlog;
	
	public BlogGUI() 
	{
		//need to set up my blog (with user name 
		User user = new User(1, "Comp3021", "Comp3021@ust.hk");
		myBlog = new Blog(user);
		myBlog.load("tempStorage.blog");
		
		mainFrame = new JFrame("Micro Blog Demo");
		mainFrame.setLayout(new GridLayout(2, 1));
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel upperPanel = new JPanel();
		upperPanel.setLayout(new BorderLayout());
		upperPanel.setBorder(BorderFactory.createCompoundBorder(
				BorderFactory.createEmptyBorder(10,10,10,10), BorderFactory.createLineBorder(Color.black)));
		
		desriptionLabel = new JLabel("You can still input 140 characters.");
		upperPanel.add(desriptionLabel, BorderLayout.NORTH);
		
		postTextArea = new JTextArea("");
		postTextArea.setBackground(new Color(240,255,223));
		postTextArea.setLineWrap(true);
		postTextArea.addKeyListener(new lengthListener());
		
		JScrollPane scrollPane1 = new JScrollPane(postTextArea);
		upperPanel.add(scrollPane1, BorderLayout.CENTER);
		
		JPanel buttonPanel = new JPanel();
		buttonPanel.setLayout(new GridLayout(1,2));
		refresh = new JButton("refresh");
		refresh.addActionListener(new refreshListener());
		
		post = new JButton("post");
		post.addActionListener(new postListener());
		
		refresh.setBackground(Color.orange);
		post.setBackground(Color.orange);
		buttonPanel.add(refresh);
		buttonPanel.add(post);
		upperPanel.add(buttonPanel, BorderLayout.SOUTH);
		
		mainFrame.add(upperPanel);
		
		postContent = new JTextArea("");
		postContent.setLineWrap(true);
		postContent.setBackground(null);
		postContent.setBorder(BorderFactory.createCompoundBorder(
				BorderFactory.createEmptyBorder(0,10, 5 ,10), BorderFactory.createLineBorder(Color.black)));
		
		JScrollPane scrollPane2 = new JScrollPane(postContent);
		mainFrame.add(scrollPane2);
		
		mainFrame.setSize(600, 600);
		mainFrame.setResizable(false);
		mainFrame.setLocationRelativeTo(null);
		mainFrame.setVisible(true);
		
	}
	
	
	public static void main(String[] args) 
	{
		BlogGUI blogGUi = new BlogGUI();
	}

	
	public class postListener implements ActionListener  
	{

		@Override
		public void actionPerformed(ActionEvent e) 
		{
			
			String content = postTextArea.getText();
			content = content.trim();
			
			//check empty or not
			if(content == null || content.equals(""))
			{
				return;
			}
			
			//check the length of the string
			if(content.length() > 140)
			{
				JOptionPane.showMessageDialog(null, "The length of the content "
				+ "can't exceed 140.","Error Message",JOptionPane.WARNING_MESSAGE);  
				
				return;
			}
			
			//output the blog to the file
			Post newPost = new Post(new Date(System.currentTimeMillis()), content);
			myBlog.post(newPost);
			myBlog.save("tempStorage.blog");
			
			//display in the post content
			if(postContent.getText().equals(""))
			{
				postContent.append("Current Post:\n");
				postContent.append(newPost.toString());
			}
			else
			{
				postContent.append("\n\n" + newPost.toString());
			}
			
			//clear the text area and set back the label
			postTextArea.setText("");
			desriptionLabel.setText("You can still input 140 characters.");
			
		}
		
	}
	
	public class refreshListener implements ActionListener  
	{
		@Override
		public void actionPerformed(ActionEvent e) 
		{
			
			//everything in the myBlog is up to date so no need to load again
			//need to clear the postContent first
			postContent.setText("");
			
			ArrayList<Post> tempList = myBlog.getPostsList();
			
			//check not null
			if(tempList == null || tempList.size() == 0)
			{
				return;
			}
			
			//display
			postContent.append("All the post(s):\n");
			
			int count = 1;
			for(Post p: tempList)
			{
				postContent.append(p.toString());
				
				if(count < tempList.size())
				{
					postContent.append("\n\n");
				}
				++count;
			}
			
		}
	}
	
	public class lengthListener implements KeyListener  
	{

		@Override
		public void keyPressed(KeyEvent arg0) 
		{
			
		}

		@Override
		public void keyReleased(KeyEvent arg0) 
		{
			String content = postTextArea.getText();
			content = content.trim();
			
			//check empty or not
			if(content == null || content.equals(""))
			{
				desriptionLabel.setText("You can still input 140 characters.");
				return;
			}
			
			if(content.length() > 140)
			{
				desriptionLabel.setText("Your post length has exceeded 140!");
				return;
			}
			
			desriptionLabel.setText("You can still input " + 
			(140-content.length()) + " characters.");
			
		}

		@Override
		public void keyTyped(KeyEvent arg0) 
		{
			
			
		}
		
	}
	
}
