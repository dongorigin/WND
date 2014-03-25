package au.edu.unimelb.benz;

public class PlayerData {
	private String username;
	private String familyName;
	private String givenName;
	private int playedNum;
	private int wonNum;
	
	public PlayerData() {
		username = "nimUser";
		familyName = "Smith";
		givenName = "John";
		playedNum = 0;
		wonNum = 0;
	}
	
	public PlayerData(String userN, String familyN, String givenN) {
		this();
		username = userN;
		familyName = familyN;
		givenName = givenN;
	}
	
	public void setNames(String userN, String familyN, String givenN) {
		username = userN;
		familyName = familyN;
		givenName = givenN;
	}
	
	public String[] getData() {
		String[] player = new String[5];
		player[0] = username;
		player[1] = familyName;
		player[2] = givenName;
		player[3] = Integer.toString(playedNum);
		player[4] = Integer.toString(wonNum);
		return player;
	}
	
	public void finish(String result) {
		playedNum ++;
		if (result == "won") {
			wonNum ++;
		}
	}
	
	public void resetNumbers() {
		playedNum = 0;
		wonNum = 0;
	}
	
	public String getUsername() {
		return username;
	}
}
