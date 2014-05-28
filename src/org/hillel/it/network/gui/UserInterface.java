package org.hillel.it.network.gui;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class UserInterface {
	private JLabel jlab;
	
	public UserInterface () {
		JFrame jfrm = new JFrame ("Test window");
		jfrm.setLayout(new FlowLayout());
		jfrm.setSize(320, 900);
		jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		String nickname;
		String name;
		String surname;
		Calendar birthDay = new GregorianCalendar ();
		String education;
		String job;
		String city;
		String email;
		String password;

//		JLabel jlabUserNickname = new JLabel ("You must learn Spring");
//		JLabel jlabUserName = new JLabel ("You must learn Spring");
//		JLabel jlabUserSurname = new JLabel ("You must learn Spring");
//		JLabel jlabUserBirthday = new JLabel ("You must learn Spring");
//		JLabel jlabUserEducation = new JLabel ("You must learn Spring");
//		JLabel jlabUserJob = new JLabel ("You must learn Spring");
//		JLabel jlabUserCity = new JLabel ("You must learn Spring");
//		JLabel jlabUserEmail = new JLabel ("You must learn Spring");
//		JLabel jlabUserPassword = new JLabel ("You must learn Spring");

		jfrm.add(new JLabel ("Nickname"+"\nName"));
		jfrm.add(new JLabel ("\nName"));
		jfrm.add(new JLabel ("Surname"));
		jfrm.add(new JLabel ("Birth day"));
		jfrm.add(new JLabel ("Education"));
		jfrm.add(new JLabel ("Job"));
		jfrm.add(new JLabel ("City"));
		jfrm.add(new JLabel ("E-mail"));
		jfrm.add(new JLabel ("Password"));
		
		JButton jbtnOk = new JButton ("Ok");
		JButton jbtnCancel = new JButton ("Cancel");
		
		jbtnOk.addActionListener(new ActionListener() {
			public void actionPerformed (ActionEvent ae) {
				jlab.setText("Ok was pressed");
			}
		});

		jbtnCancel.addActionListener(new ActionListener() {
			public void actionPerformed (ActionEvent ae) {
				jlab.setText("''was pressed");
			}
		});

		
		jfrm.add(jbtnOk);
		jfrm.add(jbtnCancel);
		
		jlab = new JLabel ("You must learn Spring");
		jfrm.add(jlab);
		
		jfrm.setVisible(true);
		
	}
}
