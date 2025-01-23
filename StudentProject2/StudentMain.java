package StudentProject2;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.*;
import java.awt.Font;
import java.awt.Color;
public class StudentMain extends JFrame implements ActionListener{
	
		JLabel detaillbl,showlbl,addlbl,Updatellbl,Deletellbl;
		JButton showbtn,addbtn,Updatebtn,deletebtn,exitbtn,logoutbtn;
		public StudentMain() {
			
			 detaillbl=new JLabel("Student Detail Project");
			 detaillbl.setForeground(new Color(255, 0, 0));
			 detaillbl.setFont(new Font("Calibri", Font.BOLD, 25));
			 detaillbl.setBounds(124, 10, 254, 46);
			 showlbl=new JLabel("Click To See Student Detail");
			 showlbl.setFont(new Font("Cambria", Font.PLAIN, 18));
			 showlbl.setBounds(29, 73, 254, 37);
			 addlbl=new JLabel("Click To Add Student Detail");
			 addlbl.setFont(new Font("Cambria", Font.PLAIN, 18));
			 addlbl.setBounds(29, 120, 254, 37);
			 Updatellbl=new JLabel("Click To Update Student Detail");
			 Updatellbl.setFont(new Font("Cambria", Font.PLAIN, 18));
			 Updatellbl.setBounds(29, 167, 254, 37);
			 Deletellbl=new JLabel("Click To Delete Student Detail");
			 Deletellbl.setFont(new Font("Cambria", Font.PLAIN, 18));
			 Deletellbl.setBounds(29, 211, 254, 31);
			
			 logoutbtn=new JButton("Logout");
			 logoutbtn.setBackground(new Color(0, 255, 255));
			 logoutbtn.setFont(new Font("Corbel Light", Font.BOLD, 20));
			 logoutbtn.setBorder(null);
			 logoutbtn.setSize(94, 30);
			 logoutbtn.setLocation(395, 10);
			 showbtn=new JButton("Show");
			 showbtn.setFont(new Font("Corbel Light", Font.BOLD, 20));
			 showbtn.setBorder(null);
			 showbtn.setBackground(new Color(255, 255, 0));
			 showbtn.setBounds(336, 76, 110, 37);
			 addbtn=new JButton("Add");
			 addbtn.setBorder(null);
			 addbtn.setBackground(new Color(255, 255, 0));
			 addbtn.setForeground(new Color(0, 0, 0));
			 addbtn.setFont(new Font("Corbel Light", Font.BOLD, 20));
			 addbtn.setBounds(336, 123, 110, 37);
			 Updatebtn=new JButton("Update");
			 Updatebtn.setBackground(new Color(255, 255, 0));
			 Updatebtn.setBorder(null);
			 Updatebtn.setFont(new Font("Corbel Light", Font.BOLD, 20));
			 Updatebtn.setForeground(new Color(0, 0, 0));
			 Updatebtn.setBounds(336, 170, 110, 37);
			 deletebtn=new JButton("Delete");
			 deletebtn.setBackground(new Color(255, 255, 0));
			 deletebtn.setBorder(null);
			 deletebtn.setFont(new Font("Corbel Light", Font.BOLD, 20));
			 deletebtn.setBounds(336, 217, 110, 37);
			 exitbtn=new JButton("Exit");
			 exitbtn.setBackground(new Color(128, 255, 255));
			 exitbtn.setBorder(null);
			 exitbtn.setFont(new Font("Corbel Light", Font.BOLD, 20));
			 exitbtn.setBounds(185, 266, 110, 40);
			
			logoutbtn.addActionListener(this);
			showbtn.addActionListener(this);
			addbtn.addActionListener(this);
			Updatebtn.addActionListener(this);
			deletebtn.addActionListener(this);
			exitbtn.addActionListener(this);
			getContentPane().setLayout(null);
			
			getContentPane().add(logoutbtn);
			getContentPane().add(detaillbl);
			getContentPane().add(showlbl);
			getContentPane().add(showbtn);
			getContentPane().add(addlbl);
			getContentPane().add(addbtn);
			getContentPane().add(Updatellbl);
			getContentPane().add(Updatebtn);
			getContentPane().add(Deletellbl);
			getContentPane().add(deletebtn);
			getContentPane().add(exitbtn);
			
			setSize(513,353);
			setVisible(true);
			setLocationRelativeTo(null);
		}
		
	public static void main(String[] args) {
		new StudentMain();
	}	

	
	@Override
	public void actionPerformed(ActionEvent e) {
	
		if(e.getSource()==showbtn) {
			this.dispose();
			StudentShow s1=new StudentShow();
		}
	
		else if(e.getSource()==addbtn) {
			this.dispose();
			StudentAdd s1=new StudentAdd();
		}
	
		else if(e.getSource()==Updatebtn) {
			this.dispose();
			StudentUpdate s1=new StudentUpdate();
		}
		else if(e.getSource()==deletebtn) {
			this.dispose();
			StudentDelete s1=new StudentDelete();
		}
		else if(e.getSource()==exitbtn) {
			this.dispose();
		}
		else if(e.getSource()==logoutbtn) {
			this.dispose();
			new LoginFrame();
		}
	}
}
