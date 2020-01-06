package view;

import javax.swing.*;

public class SignInConfirm extends JPanel{

	private static final long serialVersionUID = 1L;
	

	
	public SignInConfirm(String userCreatedName) 
	{
		
		JOptionPane.showConfirmDialog(
				null,
				"User \""+userCreatedName+"\" successfully created.\nYou can now log in.",
                "Success",
                JOptionPane.PLAIN_MESSAGE,
                JOptionPane.PLAIN_MESSAGE
                );
	}

	

}