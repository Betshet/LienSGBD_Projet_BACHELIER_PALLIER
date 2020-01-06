package view.User;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import control.ControlMain;
import control.DAOSchedule;
import control.DAOUser;
import model.User;

import javax.swing.JButton;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

public class UserLogged extends JFrame {


	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private User user;

	/**
	 * Create the frame.
	 */
	public UserLogged(User userInput) {
		
		user = userInput;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 300, 200);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JButton btnBookAppointment = new JButton("Book appointment");
		btnBookAppointment.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ControlMain control = new ControlMain();
				control.BookAppointment(user);
			}
		});
		
		JButton btnPayAppointment = new JButton("View appointments");
		btnPayAppointment.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ControlMain control = new ControlMain();
				control.TableLaunch(user);
			}
		});
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(btnBookAppointment)
					.addPreferredGap(ComponentPlacement.RELATED, 64, Short.MAX_VALUE)
					.addComponent(btnPayAppointment))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(63)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnBookAppointment)
						.addComponent(btnPayAppointment))
					.addContainerGap(65, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
		
	}
	
	public void afficher()
	{
		setVisible(true);
	}

	public User getUser() {
		return user;
	}
}
