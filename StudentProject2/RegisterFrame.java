package StudentProject2;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.swing.*;
import java.awt.Font;
import java.awt.Color;
public class RegisterFrame extends JFrame implements ActionListener{
	JLabel name,phone,username,password,message;
	JTextField txtname,txtphone,txtusername;
	JPasswordField txtPassword;
	JButton registerbtn,cancelbtn;
	
	RegisterFrame(){
		message=new JLabel("Register");
		message.setForeground(new Color(255, 0, 0));
		message.setFont(new Font("Calibri", Font.BOLD, 25));
		message.setSize(118, 31);
		message.setLocation(193, 17);
		name=new JLabel("Enter Name");
		name.setFont(new Font("Cambria", Font.PLAIN, 18));
		name.setBounds(67, 58, 155, 31);
		txtname=new JTextField(20);
		txtname.setBounds(232, 58, 198, 33);
		phone=new JLabel("Enter phone");
		phone.setFont(new Font("Cambria", Font.PLAIN, 18));
		phone.setBounds(67, 99, 155, 31);
		txtphone=new JTextField(20);
		txtphone.setBounds(232, 99, 198, 33);
		username=new JLabel("Enter username");
		username.setFont(new Font("Cambria", Font.PLAIN, 18));
		username.setBounds(67, 141, 155, 31);
		txtusername=new JTextField(20);
		txtusername.setBounds(232, 140, 198, 33);
		password=new JLabel("Enter Password");
		password.setFont(new Font("Cambria", Font.PLAIN, 18));
		password.setBounds(67, 182, 155, 31);
		txtPassword=new JPasswordField(20);
		txtPassword.setBounds(232, 183, 198, 33);
		registerbtn=new JButton("Register");
		registerbtn.setBackground(new Color(255, 255, 0));
		registerbtn.setBorder(null);
		registerbtn.setFont(new Font("Corbel Light", Font.BOLD, 20));
		registerbtn.setBounds(67, 245, 132, 31);
		cancelbtn=new JButton("Cancel");
		cancelbtn.setFont(new Font("Corbel Light", Font.BOLD, 20));
		cancelbtn.setBackground(new Color(0, 255, 255));
		cancelbtn.setBorder(null);
		cancelbtn.setBounds(298, 244, 132, 31);
		getContentPane().setLayout(null);
		
		
		
		getContentPane().add(name);
		getContentPane().add(txtname);
		getContentPane().add(message);
		getContentPane().add(phone);
		getContentPane().add(txtphone);
		getContentPane().add(username);
		getContentPane().add(txtusername);
		getContentPane().add(password);
		getContentPane().add(txtPassword);
		
		getContentPane().add(registerbtn);
		getContentPane().add(cancelbtn);
		
		registerbtn.addActionListener(this);
		cancelbtn.addActionListener(this);
		
		setLocationRelativeTo(null);
		setSize(513,346);
		setVisible(true);
		setTitle("Register Frame");
	}
//	public static void main(String[] args) {
//		new RegisterFrame();
//	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==registerbtn) {
			try {

				String entrusername=txtusername.getText();
				String entrname=txtname.getText();
				long entrphoneno=Long.parseLong(txtphone.getText());
				String entrpass=txtPassword.getText();
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbcProject","root","5107");
				String query = "insert into logindetail values(?,?,?,?)";
				PreparedStatement pstmt = con.prepareStatement(query);
				pstmt.setString(1,entrusername );
				pstmt.setString(2, entrname);
				pstmt.setLong(3, entrphoneno);
				pstmt.setString(4, entrpass);
				pstmt.executeUpdate();	
				JOptionPane.showMessageDialog(this, "Record inserted successfully!");
	            pstmt.close(); 
			
			}
			catch(Exception ex) {
				JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage());
			}
		}
		else if(e.getSource()==cancelbtn) {
			this.dispose();
			new LoginFrame();
		}
	}
}
