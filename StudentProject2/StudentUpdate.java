package StudentProject2;

import java.awt.FlowLayout;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.Color;

public class StudentUpdate {
	public StudentUpdate() {
		try {
			JFrame j1=new JFrame();
			j1.setSize(513,353);
			j1.setVisible(true);
			j1.setLocationRelativeTo(null);
			j1.setTitle("Update Existing Student");
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbcProject", "root", "5107");
			
			JLabel message=new JLabel("Update existing Student");
			message.setForeground(new Color(255, 0, 0));
			message.setBackground(new Color(255, 128, 128));
			message.setFont(new Font("Calibri", Font.BOLD, 24));
			message.setBounds(91, 26, 250, 42);
			JLabel entrid=new JLabel("Enter Student id to Update");
			entrid.setFont(new Font("Cambria", Font.PLAIN, 18));
			entrid.setBounds(25, 90, 210, 30);
			JLabel entrname=new JLabel("Enter Update Student Name ");
			entrname.setFont(new Font("Cambria", Font.PLAIN, 18));
			entrname.setBounds(25, 136, 224, 27);
			JLabel entrmark=new JLabel("Enter Update Student Mark ");
			entrmark.setFont(new Font("Cambria", Font.PLAIN, 18));
			entrmark.setBounds(25, 181, 210, 30);
			JTextField nametxt=new JTextField(20);
			nametxt.setBounds(286, 133, 180, 30);
			JTextField marktxt=new JTextField(20);
			marktxt.setBounds(286, 181, 180, 30);
			
			JButton arrow =new JButton("<");
			arrow.setSize(28, 21);
			arrow.setLocation(10, 10);
			arrow.setForeground(new Color(255, 255, 255));
			arrow.setBackground(new Color(0, 128, 255));
			arrow.setBorder(null);
			arrow.setFont(new Font("Tahoma", Font.PLAIN, 31));
			
			JButton submitBtn = new JButton("Submit");
			submitBtn.setBorder(null);
			submitBtn.setBackground(new Color(255, 255, 128));
			submitBtn.setFont(new Font("Copperplate Gothic Light", Font.BOLD, 20));
			submitBtn.setBounds(195, 236, 123, 42);
			j1.getContentPane().setLayout(null);
			j1.getContentPane().add(message);
			j1.getContentPane().add(entrid);
			JTextField idtxt=new JTextField(20);
			idtxt.setFont(new Font("Corbel Light", Font.PLAIN, 10));
			idtxt.setBounds(286, 90, 180, 30);
			j1.getContentPane().add(idtxt);
//			int x = Integer.parseInt(idtxt.getText());
			j1.getContentPane().add(arrow);
			j1.getContentPane().add(entrname);
			j1.getContentPane().add(nametxt);
			j1.getContentPane().add(entrmark);
			j1.getContentPane().add(marktxt);
			j1.getContentPane().add(submitBtn);
			
			
			arrow.addActionListener(event->{
				j1.dispose();
				new StudentMain();
			});
			submitBtn.addActionListener(event->{
			try{
				int x = Integer.parseInt(idtxt.getText());
				String n = nametxt.getText();
				int c = Integer.parseInt(marktxt.getText());
				String query = "update student set name=? ,roll=? where id=?";
				PreparedStatement pstmt = con.prepareStatement(query);
				pstmt.setString(1, n);
				pstmt.setInt(2, c);
				pstmt.setInt(3, x);
				pstmt.executeUpdate();	
				JOptionPane.showMessageDialog(j1, "Record Update successfully!");
                pstmt.close(); 
               
			}
			catch(Exception ex) {
				 JOptionPane.showMessageDialog(j1, "Error: " + ex.getMessage());
			}
			});
		} 
		catch (Exception e2) {
			System.out.println(e2);
		}
	}
}
