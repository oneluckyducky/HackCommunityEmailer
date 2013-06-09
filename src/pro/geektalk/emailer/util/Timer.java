package pro.geektalk.emailer.util;

public class Timer {

	private long end, start, period;

	/**
	 * Constructs a Timer with the length duration of the given parameter.
	 * 
	 * @param period
	 *            The duration of the Timer.
	 */
	public Timer(final long period) {
		this.period = period;
		start = System.currentTimeMillis();
		end = start + period;
	}

	/**
	 * Gets the amount of time the Timer has ran for.
	 * 
	 * @return The amount of time the Timer has ran for.
	 */
	public long getElapsed() {
		return System.currentTimeMillis() - start;
	}

	/**
	 * Gets the time remaining time.
	 * 
	 * @return Gets the remaining time.
	 */
	public long getRemaining() {
		return end - System.currentTimeMillis();
	}

	/**
	 * Checks if the Timer is still running.
	 * 
	 * @return <t>true</t> if the Timer is running, otherwise <t>false</t>.
	 */
	public boolean isRunning() {
		return System.currentTimeMillis() < end;
	}

	/**
	 * Sets the ending time period for the Timer.
	 * 
	 * @param newEnd
	 *            The ending time period for the Timer.
	 */
	public void setEndIn(final long newEnd) {
		end = System.currentTimeMillis() + newEnd;
	}

	/**
	 * Resets the Timer.
	 */
	public void reset() {
		start = System.currentTimeMillis();
		end = start + period;
	}

	/**
	 * Gets the elapsed time in timer format. [00:00:00]
	 * 
	 * @return The elapsed time in timer format. [00:00:00]
	 */
	public String toElapsedString() {
		final long seconds = getElapsed() / 1000;
		return String.format("%02d:%02d:%02d", seconds / 3600,
				(seconds % 3600) / 60, (seconds % 60));
	}

	/**
	 * Gets the hourly calculation of the given double.
	 * 
	 * @param element
	 *            The double to calculate.
	 * @return The hourly calculation of the given double.
	 */
	public double getHourlyCalculation(final double element) {
		return 3600000D * element / getElapsed();
	}

	public String toElapsedString(final boolean countdown) {
		final long seconds = (countdown ? getRemaining() : getElapsed()) / 1000;
		return String.format("%02d:%02d:%02d", seconds / 3600,
				(seconds % 3600) / 60, (seconds % 60));
	}
}
