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

public class StudentDelete {
	public StudentDelete() {
		try {
			JFrame j1=new JFrame();
			j1.setSize(513,265);
			j1.setVisible(true);
			j1.setLocationRelativeTo(null);
			j1.setTitle("Delete Existing Student");
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbcProject", "root", "5107");
			
			JLabel message=new JLabel("Delete existing Student");
			message.setForeground(new Color(255, 0, 0));
			message.setFont(new Font("Calibri", Font.BOLD, 25));
			message.setBounds(122, 10, 307, 36);
			JLabel entrid=new JLabel("Enter Student id to Delete");
			entrid.setFont(new Font("Cambria", Font.PLAIN, 18));
			entrid.setBounds(21, 56, 207, 33);
	
			JTextField idtxt=new JTextField(20);
			idtxt.setBounds(264, 59, 184, 33);
			JButton arrow =new JButton("<");
			arrow.setSize(28, 21);
			arrow.setLocation(10, 10);
			arrow.setForeground(new Color(255, 255, 255));
			arrow.setBackground(new Color(0, 128, 255));
			arrow.setBorder(null);
			arrow.setFont(new Font("Tahoma", Font.PLAIN, 31));
			JButton submitBtn = new JButton("Submit");
			submitBtn.setBackground(new Color(255, 255, 0));
			submitBtn.setBorder(null);
			submitBtn.setFont(new Font("Corbel Light", Font.BOLD, 20));
			submitBtn.setBounds(189, 115, 112, 36);
			j1.getContentPane().setLayout(null);
			j1.getContentPane().add(arrow);
			j1.getContentPane().add(message);
			j1.getContentPane().add(entrid);
			j1.getContentPane().add(idtxt);
			
			j1.getContentPane().add(submitBtn);
			arrow.addActionListener(event->{
				j1.dispose();
				new StudentMain();
			});
			
			submitBtn.addActionListener(event->{
			try{
				j1.dispose();
				int x = Integer.parseInt(idtxt.getText());
				String query="delete from student where id=?";
				PreparedStatement pstmt = con.prepareStatement(query);
				pstmt.setInt(1, x);
				pstmt.executeUpdate();	
				JOptionPane.showMessageDialog(j1, "Record Deleted successfully!");
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
