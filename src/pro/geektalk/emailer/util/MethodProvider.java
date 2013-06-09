package pro.geektalk.emailer.util;

public class MethodProvider {

	public static void log(Object o) {
		System.out.println(o);
	}

	public static void sleep(final long ms) {
		try {
			Thread.sleep(ms);
		} catch (final Exception e) {
			e.printStackTrace();
		}
	}

}
