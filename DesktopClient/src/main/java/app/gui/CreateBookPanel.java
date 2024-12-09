package app.gui;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class CreateBookPanel extends JPanel{

	private static final long serialVersionUID = 1L;
	
	private UserFormListener formListener;
	
	public CreateBookPanel() {
		setLayout(new GridBagLayout());
		
		GridBagConstraints gc = new GridBagConstraints();
		add(createFormPanel(), gc);
	}

	private JPanel createFormPanel() {

		JLabel authorLabel = new JLabel("Author:");
		JLabel titleLabel = new JLabel("Title:");

		JTextField authorField = new JTextField(10);
		JTextField titleField = new JTextField(10);

		JButton addButton = new JButton("Save");
		addButton.addActionListener(e -> {
			String author = authorField.getText();
			String title = titleField.getText();

			if (this.formListener != null) {
				this.formListener.formSubmitted(author, title);
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
		panel.add(authorLabel, gc);

		gc.anchor = GridBagConstraints.LINE_START;
		gc.gridx++;
		gc.insets = new Insets(0, 0, 0, 0);
		panel.add(authorField, gc);

		gc.gridy++;
		gc.gridx = 0;
		gc.anchor = GridBagConstraints.LINE_END;
		gc.insets = new Insets(0, 0, 0, 10);
		panel.add(titleLabel, gc);

		gc.gridx++;
		gc.anchor = GridBagConstraints.LINE_START;
		gc.insets = new Insets(0, 0, 0, 0);
		panel.add(titleField, gc);

		gc.gridy++;
		gc.weighty = 30;
		gc.anchor = GridBagConstraints.FIRST_LINE_END;
		panel.add(addButton, gc);

		return panel;
	}
	
	public void setFormListener(UserFormListener formListener) {
		this.formListener = formListener;
	}
}
