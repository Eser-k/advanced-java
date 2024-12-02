package gui;

import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class MainPanel extends JPanel {
	private static final long serialVersionUID = 1L;
	private UserFormListener formListener;

	public MainPanel() {
		JLabel formLabel = new JLabel("Add User");
		formLabel.setFont(new Font("Serif", Font.PLAIN, 30));

		setLayout(new GridBagLayout());

		GridBagConstraints gc = new GridBagConstraints();

		gc.gridx = 0;
		gc.gridy = 0;

		gc.weighty = 1;

		add(formLabel, gc);

		gc.weighty = 1.5;
		gc.gridy++;
		gc.anchor = GridBagConstraints.FIRST_LINE_START;
		add(createFormPanel(), gc);

	}

	public void setFormListener(UserFormListener formListener) {
		this.formListener = formListener;
	}

	private JPanel createFormPanel() {

		JLabel nameLabel = new JLabel("Name:");
		JLabel passLabel = new JLabel("Password:");

		JTextField nameField = new JTextField(10);
		JTextField passField = new JTextField(10);

		JButton addButton = new JButton("Save");
		addButton.addActionListener(e -> {
			String username = nameField.getText();
			String password = passField.getText();

			if (this.formListener != null) {
				this.formListener.formSubmitted(username, password);
			}

		});

		JPanel panel = new JPanel();

		var padding = 20;
		var etchedBorder = BorderFactory.createEtchedBorder();
		var emptyBorder = BorderFactory.createEmptyBorder(padding, padding, padding, padding);

		panel.setBorder(BorderFactory.createCompoundBorder(etchedBorder, emptyBorder));

		GridBagConstraints gc = new GridBagConstraints();

		panel.setLayout(new GridBagLayout());

		gc.gridwidth = 1;

		gc.gridy++;
		gc.gridx = 0;
		gc.anchor = GridBagConstraints.LINE_END;
		gc.weighty = 0.1;
		gc.insets = new Insets(0, 0, 0, 10);
		panel.add(nameLabel, gc);

		gc.anchor = GridBagConstraints.LINE_START;
		gc.gridx++;
		gc.insets = new Insets(0, 0, 0, 0);
		panel.add(nameField, gc);

		gc.gridy++;
		gc.gridx = 0;
		gc.anchor = GridBagConstraints.LINE_END;
		gc.insets = new Insets(0, 0, 0, 10);
		panel.add(passLabel, gc);

		gc.gridx++;
		gc.anchor = GridBagConstraints.LINE_START;
		gc.insets = new Insets(0, 0, 0, 0);
		panel.add(passField, gc);

		gc.gridy++;
		gc.weighty = 30;
		gc.anchor = GridBagConstraints.FIRST_LINE_END;
		panel.add(addButton, gc);

		return panel;
	}
}
