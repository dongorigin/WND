package cn.dong.projb;

public class Player implements Comparable<Player> {
	private static final String FORMAT_DISPLAY = "%s,%s,%s,%d games,%d wins\n";
	private String userName;
	private String givenName;
	private String familyName;
	private int playedNum;
	private int wonNum;
	private int rate;

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

	public String getGivenName() {
		return givenName;
	}

	public String getFamilyName() {
		return familyName;
	}

	public void played(boolean isWin) {
		playedNum++;
		if (isWin) {
			wonNum++;
		}
		rate = (int) (((double) wonNum) / playedNum * 100);
	}

	public int getPlayedNum() {
		return playedNum;
	}

	public int getRate() {
		return rate;
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
		if (this.rate > player.rate) {
			return 1;
		} else if (this.rate < player.rate) {
			return -1;
		} else {
			// 胜率相等时，按照用户名排序
			return this.userName.compareTo(player.userName);
		}
	}

}
