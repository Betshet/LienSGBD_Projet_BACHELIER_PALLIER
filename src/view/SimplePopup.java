package view;

import javax.swing.*;

public class SimplePopup extends JPanel{

	private static final long serialVersionUID = 1L;
	

	
	public SimplePopup(String title,String text) 
	{
		
		JOptionPane.showConfirmDialog(
				null,
				text,
                title,
                JOptionPane.PLAIN_MESSAGE,
                JOptionPane.PLAIN_MESSAGE
                );
	}

	

}