package view.User;

import javax.swing.*;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

public class UserPopSign extends JPanel{

	private static final long serialVersionUID = 1L;
	

	private JTextField nameField;
	private JTextField surnameField;
	private JTextField ssnbField;
	private JTextField addressField;
	private JTextField mailField;

	
	

	public JTextField getNameField() {
		return nameField;
	}

	public JTextField getSurnameField() {
		return surnameField;
	}

	public JTextField getSsnbField() {
		return ssnbField;
	}

	public JTextField getAddressField() {
		return addressField;
	}

	public JTextField getMailField() {
		return mailField;
	}

	public UserPopSign() 
	{
			
		nameField = new JTextField();
		nameField.setColumns(10);
		
		JLabel lblTitre = new JLabel("Name");
		
		surnameField = new JTextField();
		surnameField.setColumns(10);
		
		JLabel lblIsbn = new JLabel("Surname");
		
		JLabel lblAuteur = new JLabel("Social Security Number");
		
		JLabel lblEditeur = new JLabel("Address");
		
		ssnbField = new JTextField();
		ssnbField.setColumns(10);
		
		addressField = new JTextField();
		addressField.setColumns(10);
		
		JLabel lblMail = new JLabel("Mail");
		
		mailField = new JTextField();
		mailField.setColumns(10);
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(nameField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblTitre)
						.addComponent(lblIsbn)
						.addComponent(lblAuteur)
						.addComponent(surnameField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblEditeur)
						.addComponent(ssnbField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(addressField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblMail)
						.addComponent(mailField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(344, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(5)
					.addComponent(lblTitre)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(nameField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(lblIsbn)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(surnameField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(19)
					.addComponent(lblAuteur)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(ssnbField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(20)
					.addComponent(lblEditeur)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(addressField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(lblMail)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(mailField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(20, Short.MAX_VALUE))
		);
		setLayout(groupLayout);
		
		JOptionPane.showConfirmDialog(
				null,
				this,
                "",
                JOptionPane.PLAIN_MESSAGE,
                JOptionPane.PLAIN_MESSAGE
                );
	}
}