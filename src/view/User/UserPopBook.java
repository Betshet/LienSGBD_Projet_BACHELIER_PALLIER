package view.User;

import java.util.ArrayList;

import javax.swing.*;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

import model.Analysis;

public class UserPopBook extends JPanel{

	private static final long serialVersionUID = 1L;
	JComboBox<Object> comboBox;

	public UserPopBook(ArrayList<Object> analysisList) 
	{
		setBounds(100, 100, 300, 200); 
		
		comboBox = new JComboBox<Object>(analysisList.toArray());
	
		
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(260, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
					.addContainerGap(92, Short.MAX_VALUE)
					.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(86))
		);
		setLayout(groupLayout);
		
		JOptionPane.showConfirmDialog(
				null,
				this,
                "Log In",
                JOptionPane.PLAIN_MESSAGE,
                JOptionPane.PLAIN_MESSAGE
                );
	}

	public JComboBox<Object> getComboBox() {
		return comboBox;
	}
}