package nobel;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;

public class ListazoAblak extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextArea txtArea;

	private StringBuilder szoveg;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the dialog.
	 */
	public ListazoAblak() {

		setModal(true);
		setTitle("5. feladat");
		setBounds(200, 100, 550, 400);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(250, 240, 230));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);

		JButton btnRendben = new JButton("Rendben");
		btnRendben.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				dispose();

			}
		});
		btnRendben.setFont(new Font("Segoe UI Black", Font.BOLD, 13));
		btnRendben.setForeground(new Color(160, 82, 45));
		btnRendben.setBackground(new Color(210, 180, 140));
		btnRendben.setBounds(200, 320, 100, 30);
		contentPanel.add(btnRendben);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 535, 300);
		contentPanel.add(scrollPane);

		txtArea = new JTextArea();
		txtArea.setFont(new Font("Microsoft YaHei", Font.ITALIC, 12));
		txtArea.setForeground(new Color(0, 0, 128));
		txtArea.setBackground(new Color(255, 255, 224));
		scrollPane.setViewportView(txtArea);

	}

	public ListazoAblak(StringBuilder szoveg) {

		this();
		this.szoveg = szoveg;
		txtArea.setText(szoveg.toString());
	}
}
