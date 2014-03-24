package au.edu.unimelb.benz;

public class Player {
	private String[] names;
	private int playedNum;
	private int wonNum;
	
	public Player() {
		names = new String[3];
		names[0] = "nimUser";
		names[1] = "John";
		names[2] = "Smith";
		playedNum = 0;
		wonNum = 0;
	}
	
	public Player(String userN, String firstN, String familyN) {
		this();
		names[0] = userN;
		names[1] = firstN;
		names[2] = familyN;
	}
	
	public void setPlayer(String[] editNames) {
		names[0] = editNames[0];
		names[1] = editNames[1];
		names[2] = editNames[2];
	}
	
	public String[] getPlayer() {
		String[] player = new String[5];
		player[0] = names[0];
		player[1] = names[1];
		player[2] = names[2];
		player[3] = Integer.toString(playedNum);
		player[4] = Integer.toString(wonNum);
		return player;
	}
	
	public void setGames(int playedN, int wonN) {
		playedNum += playedN;
		wonNum += wonN;
	}
}
