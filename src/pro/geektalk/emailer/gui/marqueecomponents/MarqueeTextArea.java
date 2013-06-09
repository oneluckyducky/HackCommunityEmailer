package pro.geektalk.emailer.gui.marqueecomponents;

import java.awt.Color;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

import javax.swing.JTextArea;

public class MarqueeTextArea extends JTextArea {
	private static final long serialVersionUID = 1L;

	private String condition;

	public MarqueeTextArea(String condition) {
		this.condition = condition;
		this.setText(this.condition);
		setMarqueeText(this, this.condition);
	}

	public void setMarqueeText(final JTextArea jta, final String condition) {
		final String starting = !jta.getText().isEmpty() ? jta.getText() : "";
		jta.addFocusListener(new FocusAdapter() {
			public void focusGained(final FocusEvent e) {
				String current = jta.getText();
				if (current.equals(condition)) {
					jta.setText("");
				}
			}

			public void focusLost(final FocusEvent e) {
				if (jta.getText().isEmpty()) {
					jta.setForeground(Color.LIGHT_GRAY);
					jta.setText(starting);
				}
			}
		});
	}

}
