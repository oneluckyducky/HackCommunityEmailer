package pro.geektalk.emailer.gui.marqueecomponents;

import java.awt.Color;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class MarqueePasswordField extends JPasswordField {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String condition;

	public MarqueePasswordField(String condition) {
		this.condition = condition;
		this.setText(this.condition);
		setMarqueeText(this, this.condition);
	}

	public void setMarqueeText(final JTextField jtf, final String condition) {
		final String starting = !jtf.getText().isEmpty() ? jtf.getText() : "";
		jtf.addFocusListener(new FocusAdapter() {
			public void focusGained(final FocusEvent e) {
				String current = jtf.getText();
				if (current.equals(condition)) {
					jtf.setText("");
				}
			}

			public void focusLost(final FocusEvent e) {
				if (jtf.getText().isEmpty()) {
					jtf.setForeground(Color.LIGHT_GRAY);
					jtf.setText(starting);
				}
			}
		});
	}

}
