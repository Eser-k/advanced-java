package gui;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class MainPanel extends JPanel {
	private static final long serialVersionUID = 1L;

	public MainPanel() {
		JLabel formLabel = new JLabel("Add User");
		JLabel nameLabel = new JLabel("Name:");
		JLabel passLabel = new JLabel("Password:");

		JTextField nameField = new JTextField(10);
		JTextField passField = new JTextField(10);

		JButton addButton = new JButton("Save");

		setLayout(new GridBagLayout());

		GridBagConstraints gc = new GridBagConstraints();
		
		gc.gridx = 0;
		gc.gridy = 0;
		gc.gridwidth = 2;
		add(formLabel, gc);
		
		gc.gridwidth = 1;
		
		gc.gridy++;
		gc.gridx = 0;
		add(nameLabel, gc);
		
		gc.gridx++;
		add(nameField, gc);
		
		gc.gridy++;
		gc.gridx = 0;
		add(passLabel, gc);
		
		gc.gridx++;
		add(passField, gc);
		
		gc.gridy++;
		add(addButton, gc);
		
	}
}
