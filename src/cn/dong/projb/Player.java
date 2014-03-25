package cn.dong.projb;

public class Player {
	private static final String FORMAT_DISPLAY = "%s,%s,%s,%d games,%d wins\n";
	private String userName;
	private String givenName;
	private String familyName;
	private int playedNum;
	private int wonNum;

	public Player(String userName, String givenName, String familyName) {
		setName(userName, givenName, familyName);
	}

	public void setName(String userName, String givenName, String familyName) {
		this.userName = userName;
		this.givenName = givenName;
		this.familyName = familyName;
	}

	public void play() {
		playedNum++;
	}

	public void win() {
		wonNum++;
	}

	public void resetStats() {
		playedNum = 0;
		wonNum = 0;
	}

	public void display() {
		System.out.printf(FORMAT_DISPLAY, userName, givenName, familyName, playedNum, wonNum);
	}

}
