package pro.geektalk.emailer.misc;

public enum SMTP {

	GMAIL("Gmail", "smtp.gmail.com", 465), AOL("AOL", "smtp.aol.com", 587), YAHOO(
			"Yahoo!", "smtp.mail.yahoo.com", 25), HOTMAIL("Hotmail",
			"smtp.live.com", 587);

	private String realName, hostName;
	private int hostPort;

	SMTP(final String realName, final String hostName, final int hostPort) {
		this.realName = realName;
		this.hostName = hostName;
		this.hostPort = hostPort;
	}

	public String getRealName() {
		return this.realName;
	}

	public String getHostName() {
		return this.hostName;
	}

	public int getHostPort() {
		return this.hostPort;
	}
}
