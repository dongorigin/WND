package au.edu.unimelb.benz.projb.betatest;

public class PlayerData implements Comparable<PlayerData>{
	
	private String username;
	private String familyName;
	private String givenName;
	private int playedNum;
	private int wonNum;
	private Integer rate;
	
	public PlayerData() {
		username = "nimUser";
		familyName = "Smith";
		givenName = "John";
		playedNum = 0;
		wonNum = 0;
		rate = 0;
	}
	
	public int compareTo(PlayerData r) {
		int firstResult = rate.compareTo(r.getRate());
		int finalResult = 0;
		if (firstResult == 0) {
			finalResult = username.compareTo(r.getUsername());
		} else {
			finalResult = -firstResult;
		}
		return finalResult;
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
	
	public void editNumbers(int playedN, int wonN) {
		playedNum += playedN;
		wonNum += wonN;
		doRate();
	}
	
	public void resetNumbers() {
		playedNum = 0;
		wonNum = 0;
		doRate();
	}
	
	public String getUsername() {
		return username;
	}
	
	public Integer getRate() {
		return rate;
	}
	
	public void doRate() {
		rate = (int) Math.round((float) wonNum / (float) playedNum * 100.0);
	}
}
