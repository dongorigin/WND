package cn.dong.projb;

public class Player implements Comparable<Player> {
	private static final String FORMAT_DISPLAY = "%s,%s,%s,%d games,%d wins\n";
	private String userName;
	private String givenName;
	private String familyName;
	private int playedNum;
	private int wonNum;
	private double winRate;

	public Player(String userName, String givenName, String familyName) {
		setName(userName, givenName, familyName);
	}

	public void setName(String userName, String givenName, String familyName) {
		this.userName = userName;
		this.givenName = givenName;
		this.familyName = familyName;
	}

	public String getUserName() {
		return userName;
	}

	public void played(boolean isWin) {
		playedNum++;
		if (isWin) {
			wonNum++;
		}
		winRate = wonNum / playedNum;
	}

	public void resetStats() {
		playedNum = 0;
		wonNum = 0;
	}

	public void display() {
		System.out.printf(FORMAT_DISPLAY, userName, givenName, familyName, playedNum, wonNum);
	}

	@Override
	public int compareTo(Player player) {
		if (this.winRate > player.winRate) {
			return 1;
		} else if (this.winRate < player.winRate) {
			return -1;
		} else {
			return 0;
		}
	}

}
