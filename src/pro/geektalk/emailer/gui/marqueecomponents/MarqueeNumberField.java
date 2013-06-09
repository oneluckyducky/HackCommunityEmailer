package pro.geektalk.emailer.gui.marqueecomponents;

import java.awt.Color;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.KeyEvent;
import java.util.Arrays;

import javax.swing.JTextField;

public class MarqueeNumberField extends JTextField {
	private static final long serialVersionUID = 1L;

	private static final int[] VALID_KEYS = { KeyEvent.VK_ENTER,
			KeyEvent.VK_BACK_SPACE, KeyEvent.VK_DELETE };

	private String condition;

	public MarqueeNumberField(final String condition) {
		super(condition);
		Arrays.sort(VALID_KEYS);
		this.condition = condition;
		this.setText(this.condition);
		setMarqueeText(this, this.condition);
	}

	public void changeCondition(final String condition) {
		this.condition = condition;
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

	@Override
	public void processKeyEvent(final KeyEvent e) {
		if (Character.isDigit(e.getKeyChar())
				|| Arrays.binarySearch(VALID_KEYS, e.getKeyCode()) != -1) {
			super.processKeyEvent(e);
			return;
		}
		e.consume();
	}
}
