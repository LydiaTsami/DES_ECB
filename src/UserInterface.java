import java.awt.EventQueue;

import javax.swing.JFrame;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import net.miginfocom.swing.MigLayout;
import java.awt.CardLayout;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class UserInterface {

	private JFrame frame;
	private JTextField txt_plaintext;
	private JTextField txt_key;
	private String plaintext;
	private String key;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UserInterface window = new UserInterface();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public UserInterface() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		txt_plaintext = new JTextField();
		txt_plaintext.setText("TSAMILYD");
		txt_plaintext.setBounds(160, 85, 130, 22);
		frame.getContentPane().add(txt_plaintext);
		txt_plaintext.setColumns(10);
		
		JLabel lblPlaintext = new JLabel("Plaintext:");
		lblPlaintext.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblPlaintext.setBounds(96, 88, 57, 16);
		frame.getContentPane().add(lblPlaintext);
		
		JLabel lblKey = new JLabel("Key:");
		lblKey.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblKey.setHorizontalAlignment(SwingConstants.RIGHT);
		lblKey.setBounds(96, 117, 56, 16);
		frame.getContentPane().add(lblKey);
		
		txt_key = new JTextField();
		txt_key.setText("F46E986435465354");
		txt_key.setBounds(160, 114, 130, 22);
		frame.getContentPane().add(txt_key);
		txt_key.setColumns(10);
		
		JButton btnStart = new JButton("Start");
		btnStart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				plaintext= txt_plaintext.getText();
				key = txt_key.getText();
				Key newkey = new Key(key);
				//newkey.getpc1();
				Text newtext = new Text(plaintext);
				
			}
		});
		btnStart.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnStart.setBounds(160, 163, 97, 25);
		frame.getContentPane().add(btnStart);
	}
}
