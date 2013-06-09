package pro.geektalk.emailer.gui;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.ToolTipManager;

import pro.geektalk.emailer.gui.marqueecomponents.MarqueeNumberField;
import pro.geektalk.emailer.gui.marqueecomponents.MarqueePasswordField;
import pro.geektalk.emailer.gui.marqueecomponents.MarqueeTextArea;
import pro.geektalk.emailer.gui.marqueecomponents.MarqueeTextField;
import pro.geektalk.emailer.misc.SMTP;

public class Gui extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	// -- containers
	JPanel credsTab;
	JPanel setupTab;
	JPanel aboutTab;
	JTabbedPane tabbedPane;
	// --/

	MarqueeTextField username;
	MarqueePasswordField password;
	MarqueeTextField victimEmail;
	JComboBox<String> comboSMTPs;
	JTextField txtHost, txtPort;
	// --/

	// -- setup tab
	JCheckBox spam;
	MarqueeTextField subject;
	MarqueeTextArea body;
	JComboBox<String> spamType;
	MarqueeNumberField secondsOrAmount;

	// -- /

	JButton send;
	JButton test;

	GridLayout layout = new GridLayout();

	private void sendButton() {
		System.out.println(this.getSize());
	}

	private void spamListener() {
		spamType.setEnabled(spam.isSelected());
		secondsOrAmount.setEnabled(spam.isSelected());
	}

	private void comboSMTPListener() {
		txtHost.setText(SMTP.values()[comboSMTPs.getSelectedIndex()]
				.getHostName());
		txtPort.setText(SMTP.values()[comboSMTPs.getSelectedIndex()]
				.getHostPort() + "");
	}

	public Gui() {
		ToolTipManager.sharedInstance().setInitialDelay(10);

		tabbedPane = new JTabbedPane(JTabbedPane.TOP);

		send = new JButton("Send");
		send.setBounds(10, 233, 90, 25);
		send.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				sendButton();
			}
		});

		test = new JButton("Test Credentials");
		test.setBounds(send.getWidth() + send.getX() + 25, send.getY(), 150, 25);

		// -- credentials tab
		credsTab = new JPanel(null);

		username = new MarqueeTextField("Your email");
		username.setBounds(10, 10, 110, 25);
		username.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		username.setToolTipText("Your email including @provider.com");
		credsTab.add(username);

		password = new MarqueePasswordField("Password");
		password.setBounds(username.getX(),
				username.getY() + username.getHeight() + 10,
				username.getWidth(), username.getHeight());
		password.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		password.setToolTipText("Your email password");
		credsTab.add(password);

		victimEmail = new MarqueeTextField("Victim(s) email(s)");
		victimEmail.setBounds(password.getX(),
				password.getHeight() + password.getY() + 40,
				password.getWidth(), password.getHeight());
		victimEmail.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		victimEmail
				.setToolTipText("Can enter multiple recipients. Seperate by comma!");
		credsTab.add(victimEmail);

		comboSMTPs = new JComboBox<String>(new String[] { "GMail", "AOL",
				"Yahoo!", "Hotmail" });
		comboSMTPs.setBounds(username.getX() + username.getWidth() + 50,
				username.getY() + username.getHeight() / 3, 100, 25);
		comboSMTPs.setToolTipText("Choose your SMTP server");
		comboSMTPs.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				comboSMTPListener();
			}
		});
		credsTab.add(comboSMTPs);

		txtHost = new JTextField("smtp.gmail.com");
		txtHost.setBounds(comboSMTPs.getX(), victimEmail.getY(), 125, 25);
		txtHost.setEditable(false);
		credsTab.add(txtHost);

		txtPort = new JTextField("587");
		txtPort.setBounds(txtHost.getX(), txtHost.getY() + txtHost.getHeight()
				+ 10, 90, 25);
		txtPort.setEditable(false);
		credsTab.add(txtPort);

		tabbedPane.addTab("Credentials", credsTab);
		// -- /

		setupTab = new JPanel(null);

		subject = new MarqueeTextField("Subject");
		subject.setBounds(10, 10, 180, 25);
		subject.setToolTipText("Subject of the email");
		setupTab.add(subject);

		body = new MarqueeTextArea("Body");
		body.setWrapStyleWord(true);
		body.setLineWrap(true);
		body.setToolTipText("Body of the email");
		JScrollPane sp = new JScrollPane(body, 20, 31);
		sp.setBounds(password.getX(), password.getY(), 180, 140);
		setupTab.add(sp);

		spam = new JCheckBox("Mass Mailing Mode");
		spam.setBounds(subject.getX() + subject.getWidth() + 20,
				subject.getY(), 150, 25);
		spam.setToolTipText("Select if using as a bomber");
		spam.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				spamListener();
			}
		});
		setupTab.add(spam);

		spamType = new JComboBox<String>(
				new String[] { "By time", "By amount" });
		spamType.setBounds(spam.getX() + 20, spam.getY() + spam.getHeight()
				+ 10, 100, 25);
		spamType.setToolTipText("By time in seconds. By amount one by one");
		spamType.setEnabled(false);
		setupTab.add(spamType);

		secondsOrAmount = new MarqueeNumberField("Time/Amount");
		secondsOrAmount.setBounds(spamType.getX(),
				spamType.getY() + spamType.getHeight() + 10, 110, 25);
		secondsOrAmount.setToolTipText("Numbers only silly ;)");
		secondsOrAmount.setEnabled(false);
		setupTab.add(secondsOrAmount);

		tabbedPane.addTab("Setup", setupTab);

		aboutTab = new JPanel();
		tabbedPane.addTab("About", aboutTab);

		tabbedPane.setBounds(0, 0, 500, 230);
		this.add(tabbedPane);
		this.add(send);
		this.add(test);

		this.setLayout(null);
		this.setSize(385, 300);
		this.setPreferredSize(getSize());
		this.setMaximumSize(getSize());
		this.setTitle("Hack Community Emailer");
		this.setAlwaysOnTop(true);
		this.setVisible(true);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		// this.setResizable(false);

	}
}
