package StudentProject2;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.*;
import java.awt.Font;
import java.awt.Color;

public class LoginFrame extends JFrame implements ActionListener{
	JLabel usernamelbl,passwordlbl,message;
	JTextField usernametxt;
	JPasswordField passwordtxt;
	JButton loginbtn,registerbtn;
	public LoginFrame() {
		usernamelbl=new JLabel("Enter Username");
		usernamelbl.setFont(new Font("Cambria", Font.PLAIN, 18));
		usernamelbl.setBounds(58, 52, 129, 29);
		passwordlbl=new JLabel("Enter Password");
		passwordlbl.setFont(new Font("Cambria", Font.PLAIN, 18));
		passwordlbl.setBounds(58, 97, 129, 29);
		message=new JLabel("Login");
		message.setForeground(new Color(255, 0, 0));
		message.setFont(new Font("Calibri", Font.BOLD, 25));
		message.setSize(211, 29);
		message.setLocation(205, 10);
		usernametxt=new JTextField(30);
		usernametxt.setBounds(255, 56, 175, 27);
		passwordtxt=new JPasswordField(30);
		passwordtxt.setBounds(255, 101, 175, 27);
		loginbtn=new JButton("Login");
		loginbtn.setBackground(new Color(255, 255, 0));
		loginbtn.setBorder(null);
		loginbtn.setFont(new Font("Corbel Light", Font.BOLD, 20));
		loginbtn.setBounds(198, 164, 91, 39);
		registerbtn=new JButton("Register");
		registerbtn.setBackground(new Color(0, 255, 255));
		registerbtn.setBorder(null);
		registerbtn.setFont(new Font("Calibri Light", Font.BOLD, 20));
		registerbtn.setBounds(359, 219, 130, 34);
		
		registerbtn.addActionListener(this);
		loginbtn.addActionListener(this);
		getContentPane().setLayout(null);
		getContentPane().add(usernamelbl);
		getContentPane().add(usernametxt);
		getContentPane().add(passwordlbl);
		getContentPane().add(passwordtxt);
		getContentPane().add(loginbtn);
		getContentPane().add(registerbtn);
		getContentPane().add(message);
		
		setSize(513,300);
		setVisible(true);
		setTitle("Login");
		setLocationRelativeTo(null);
	}
	public static void main(String[] args) {
		new LoginFrame();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==loginbtn) {
			try {
				
				String entusername=usernametxt.getText();
				String enterPass=passwordtxt.getText();
				
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbcProject","root","5107");
				Statement stmt=con.createStatement();
				ResultSet rs = stmt.executeQuery("select * from logindetail");
				
				boolean isValid=false;
					while(rs.next()) {
						
						String dbusername=rs.getString(1);
						String dbPass=rs.getString(4);
						if(dbusername.equals(entusername)&&dbPass.equals(enterPass)) {
							this.dispose();
							new StudentMain();
							isValid=true;
							break;
						}
					}
					if (!isValid) {
						JOptionPane.showMessageDialog(this, "Invalid username or password!", "Login Error", JOptionPane.ERROR_MESSAGE);
					}
			}
			catch(Exception e2) {
				System.out.println(e2);
			}
		}
		else if(e.getSource()==registerbtn) {
			this.dispose();
			new RegisterFrame();
		}
		
	}
}
