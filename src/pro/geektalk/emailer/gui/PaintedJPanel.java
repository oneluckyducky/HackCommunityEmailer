package pro.geektalk.emailer.gui;

import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

public class PaintedJPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1887016014910526613L;

	public void paint(Graphics g) {
		super.paintComponents(g);
		this.paint((Graphics2D) g);
	}

	public void paint(final Graphics2D g) {

	}

}
