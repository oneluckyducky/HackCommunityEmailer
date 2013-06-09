package pro.geektalk.emailer;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.io.PrintStream;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.UIManager;
import javax.swing.text.DefaultCaret;

import pro.geektalk.emailer.gui.Gui;
import pro.geektalk.emailer.misc.Settings;
import pro.geektalk.emailer.util.MethodProvider;
import pro.geektalk.emailer.util.TextAreaOutputStream;

public class HCEmailer extends MethodProvider {

	static Settings settings = new Settings();

	public static ArrayList<String> consoleData = new ArrayList<String>();
	public static Gui gui;

	public static void main(String... args) {
		createGui();
		createConsole();

	}

	private static void createConsole() {
		JFrame frame = new JFrame("Console");
		frame.setPreferredSize(new Dimension(300, 150));
		frame.setMinimumSize(new Dimension(300, 150));
		frame.add(new JLabel("Hack Community Emailer"), BorderLayout.NORTH);

		JTextArea ta = new JTextArea();
		ta.setBackground(Color.BLACK);
		ta.setForeground(Color.GRAY.brighter());
		ta.setEditable(false);
		DefaultCaret caret = (DefaultCaret) ta.getCaret();
		caret.setUpdatePolicy(DefaultCaret.ALWAYS_UPDATE);

		TextAreaOutputStream taos = new TextAreaOutputStream(ta, 60);
		PrintStream ps = new PrintStream(taos);
		System.setOut(ps);
		System.setErr(ps);

		frame.add(new JScrollPane(ta));

		frame.pack();
		frame.setVisible(true);
	}

	private static void createGui() {
		try {
			UIManager.setLookAndFeel("com.jtattoo.plaf.hifi.HiFiLookAndFeel");
			EventQueue.invokeLater(new Runnable() {

				@Override
				public void run() {
					gui = new Gui();
				}
			});
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
