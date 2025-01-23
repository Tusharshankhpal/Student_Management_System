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

public class StudentAdd{
	public StudentAdd() {
		try {
			JFrame j1=new JFrame();
			j1.setSize(513,353);
			j1.setVisible(true);
			j1.setLocationRelativeTo(null);
			j1.setTitle("Add New Student");
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbcProject", "root", "5107");
			
			JLabel message=new JLabel("Add New Student");
			message.setForeground(new Color(255, 0, 0));
			message.setFont(new Font("Calibri", Font.BOLD, 25));
			message.setBounds(148, 10, 313, 31);
			JLabel entrid=new JLabel("Enter Student id ");
			entrid.setFont(new Font("Cambria", Font.PLAIN, 18));
			entrid.setBounds(20, 68, 166, 36);
			JLabel entrname=new JLabel("Enter Student Name ");
			entrname.setFont(new Font("Cambria", Font.PLAIN, 18));
			entrname.setBounds(20, 124, 166, 37);
			JLabel entrmark=new JLabel("Enter Student Mark ");
			entrmark.setFont(new Font("Cambria", Font.PLAIN, 18));
			entrmark.setBounds(20, 186, 166, 31);
			JTextField idtxt=new JTextField(20);
			idtxt.setBounds(233, 72, 185, 36);
			JTextField nametxt=new JTextField(20);
			nametxt.setBounds(233, 128, 183, 36);
			JTextField marktxt=new JTextField(20);
			marktxt.setBounds(233, 188, 185, 34);
			JButton arrow =new JButton("<");
			arrow.setFont(new Font("Tahoma", Font.BOLD, 20));
			arrow.setBorder(null);
			arrow.setBackground(new Color(0, 128, 255));
			arrow.setSize(29, 30);
			arrow.setLocation(10, 10);
			j1.getContentPane().add(arrow);
			JButton submitBtn = new JButton("Submit");
			submitBtn.setBorder(null);
			submitBtn.setBackground(new Color(255, 255, 0));
			submitBtn.setFont(new Font("Calibri Light", Font.BOLD, 25));
			submitBtn.setBounds(180, 252, 136, 36);
			j1.getContentPane().setLayout(null);
			j1.getContentPane().add(message);
			j1.getContentPane().add(entrid);
			j1.getContentPane().add(idtxt);
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
				String query = "insert into student values(?,?,?)";
				PreparedStatement pstmt = con.prepareStatement(query);
				pstmt.setInt(1, x);
				pstmt.setString(2, n);
				pstmt.setInt(3, c);
				pstmt.executeUpdate();	
				JOptionPane.showMessageDialog(j1, "Record inserted successfully!");
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
