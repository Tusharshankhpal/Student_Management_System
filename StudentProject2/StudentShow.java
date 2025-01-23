//package StudentProject2;
//
//import java.awt.FlowLayout;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.ResultSet;
//import java.sql.Statement;
//
//import javax.swing.JFrame;
//import javax.swing.JLabel;
//import java.awt.Font;
//import java.awt.Color;
//
//public class StudentShow{
//	public StudentShow() {
//		try {
//			
//			Class.forName("com.mysql.cj.jdbc.Driver");
//			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbcProject", "root", "5107");
//			Statement stm=con.createStatement();
//			ResultSet rs=stm.executeQuery("select * from student");
//			
//			JFrame j1=new JFrame();
//			j1.getContentPane().setLayout(null);
//			JLabel namelbl1=new JLabel("Id        "+"Name      "+"RollNO      "+"   Mark");
//			namelbl1.setFont(new Font("Cambria", Font.PLAIN, 18));
//			namelbl1.setBounds(77, 55, 390, 37);
//			j1.getContentPane().add(namelbl1);
//			JLabel message=new JLabel("Showing Student Details");
//			message.setForeground(new Color(255, 0, 0));
//			message.setFont(new Font("Calibri", Font.BOLD, 25));
//			message.setBounds(120, 21, 292, 37);
//			
//			j1.getContentPane().add(message);
//			j1.setSize(513,300);
//			j1.setVisible(true);
//			j1.setLocationRelativeTo(null);
//			j1.setTitle("All Student Detail");
//			while(rs.next()) {
//				//namelbl.setText(""+rs.getInt(1));
//				JLabel namelbl=new JLabel(""+rs.getInt(1)+" "+rs.getString(2)+" "+rs.getInt(3));
//				j1.getContentPane().add(namelbl);
//			}
//			
//			con.close();
//		} 
//		catch (Exception e2) {
//			// TODO Auto-generated catch block
//			e2.printStackTrace();
//		}
//	}
//}


package StudentProject2;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class StudentShow {
    public StudentShow() {
        try {
            // Database Connection
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbcProject", "root", "5107");
            Statement stm = con.createStatement();
            ResultSet rs = stm.executeQuery("select * from student");

            // JFrame Configuration
            JFrame j1 = new JFrame();
            j1.setSize(369, 322);
            j1.setVisible(true);
            j1.setLocationRelativeTo(null);
            j1.setTitle("All Student Details");
            j1.getContentPane().setLayout(new BorderLayout());

            // Title Label
            JLabel message = new JLabel("Showing Student Details");
            message.setForeground(new Color(255, 0, 0));
            message.setFont(new Font("Calibri", Font.BOLD, 25));
            message.setHorizontalAlignment(JLabel.CENTER); // Center the title
            j1.getContentPane().add(message, BorderLayout.NORTH);
            
            JButton arrow =new JButton("<");
			arrow.setSize(28, 21);
			arrow.setLocation(10, 10);
			arrow.setForeground(new Color(255, 255, 255));
			arrow.setBackground(new Color(0, 128, 255));
			arrow.setBorder(null);
			arrow.setFont(new Font("Tahoma", Font.PLAIN, 31));
			j1.getContentPane().add(arrow);
            // Header Label
            JLabel headerLabel = new JLabel("Id          Name         Mark");
            headerLabel.setForeground(new Color(128, 0, 255));
            headerLabel.setVerticalAlignment(SwingConstants.TOP);
            headerLabel.setFont(new Font("Cambria", Font.BOLD, 18));
            headerLabel.setHorizontalAlignment(JLabel.CENTER);
            j1.getContentPane().add(headerLabel, BorderLayout.CENTER);
            arrow.addActionListener(event->{
				j1.dispose();
				new StudentMain();
			});
            // Panel to Display Student Data
            JPanel studentPanel = new JPanel();
            studentPanel.setLayout(new GridLayout(0, 1, 5, 5)); // One column, rows grow dynamically
            
            // Adding rows dynamically
            while (rs.next()) {
                JLabel namelbl = new JLabel(
                    rs.getInt(1) + "          " +
                    rs.getString(2) + "          " +
                    rs.getInt(3) 
                );
                namelbl.setFont(new Font("Cambria", Font.PLAIN, 20));
                namelbl.setHorizontalAlignment(JLabel.CENTER);
                studentPanel.add(namelbl); // Add each row's data as a label
            }

            // Adding the panel to the frame
            j1.getContentPane().add(studentPanel, BorderLayout.SOUTH);

            con.close();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

}

