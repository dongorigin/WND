package au.edu.unimelb.benz;

public class PlayerData {
	private String username;
	private String firstName;
	private String familyName;
	private int playedNum;
	private int wonNum;
	
	public PlayerData() {
		username = "nimUser";
		firstName = "John";
		familyName = "Smith";
		playedNum = 0;
		wonNum = 0;
	}
	
	public PlayerData(String userN, String firstN, String familyN) {
		this();
		username = userN;
		firstName = firstN;
		familyName = familyN;
	}
	
	public void setNames(String userN, String firstN, String familyN) {
		username = userN;
		firstName = firstN;
		familyName = familyN;
	}
	
	public String[] getData() {
		String[] player = new String[5];
		player[0] = username;
		player[1] = firstName;
		player[2] = familyName;
		player[3] = Integer.toString(playedNum);
		player[4] = Integer.toString(wonNum);
		return player;
	}
	
	public void setGames(int playedN, int wonN) {
		playedNum += playedN;
		wonNum += wonN;
	}
}
