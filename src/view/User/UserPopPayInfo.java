package view.User;

import javax.swing.*;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

public class UserPopPayInfo extends JPanel{

	private static final long serialVersionUID = 1L;

	private JTextField creditCardNumber;
	private JTextField secretCode;
	


	public UserPopPayInfo() 
	{
			
		
		
		creditCardNumber = new JTextField();
		creditCardNumber.setColumns(10);
		
		JLabel lblCreditCardNumber = new JLabel("Credit card number");
		
		JLabel lblSecretCode = new JLabel("Secret code");
		
		secretCode = new JTextField();
		secretCode.setColumns(10);
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(creditCardNumber, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblCreditCardNumber)
						.addComponent(lblSecretCode)
						.addComponent(secretCode, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(344, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(13)
					.addComponent(lblCreditCardNumber)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(creditCardNumber, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(lblSecretCode)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(secretCode, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(189, Short.MAX_VALUE))
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
	
	public JTextField getCreditCardNumber() {
		return creditCardNumber;
	}



	public JTextField getSecretCode() {
		return secretCode;
	}



	public void setCreditCardNumber(JTextField creditCardNumber) {
		this.creditCardNumber = creditCardNumber;
	}



	public void setSecretCode(JTextField secretCode) {
		this.secretCode = secretCode;
	}


}