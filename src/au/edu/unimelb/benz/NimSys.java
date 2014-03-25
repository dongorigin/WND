package au.edu.unimelb.benz;

import java.util.*;

public class NimSys {
	private Scanner userInput;
	private ArrayList<PlayerData> playerList;

	public NimSys() {
		userInput = new Scanner(System.in);
		playerList = new ArrayList<PlayerData>();
	}

	// test method
	public void showPlayer(int index) {
		PlayerData testPlayer = playerList.get(index);
		String[] testData = testPlayer.getData();
		System.out.println(index + " " + testData[0] + " " + testData[1] + " " + testData[2] + " " + testData[3] + " " + testData[4]);
	}
	
	public int checkPosition(String userN) {
		int position = 0;
		for (PlayerData toCheck : playerList) {
			if (toCheck.getUsername() == userN) {
				return position;
			}
			position ++;
		}
		return -1;
	}
	
	public String addPlayer(String userN, String familyN, String givenN) {
		String result = "fail";
		int index = checkPosition(userN);
		if (!(index == -1)) {
			return result;
		} else {
			PlayerData newPlayer = new PlayerData(userN, familyN, givenN);
			playerList.add(newPlayer);
			result = "succeed";
			return result;
		}
	}

	public String removePlayer(String userN) {
		int index = checkPosition(userN);
		String result = "fail";
		if (index == -1) {
			return result;
		} else {
			playerList.remove(index);
			result = "succeed";
			return result;
		}
	}

	public int removePlayer() {
		playerList.clear();
		return playerList.size();
	}

	public String editPlayer(int index, String userN, String familyN, String givenN) {
		String result = "fail";
		if (index == -1) {
			return result;
		} else {
			PlayerData editor = playerList.get(index);
			editor.setNames(userN, familyN, givenN);
			return result;
		}
	}
	
	public String resetStats(String userN) {
		int index = checkPosition(userN);
		String result = "fail";
		if (index == -1) {
			return result;
		} else {
			PlayerData editor = playerList.get(index);
			editor.resetNumbers();
			result = "succeed";
			return result;
		}
	}
	
	// test method
	public void testNumber(int index) {
		PlayerData editor = playerList.get(index);
		editor.finish("won");
		editor.finish("lost");
	}
	
	public void resetStats() {
		for (PlayerData toReset : playerList) {
			toReset.resetNumbers();
		}
	}
	
	public String[] displayPlayer(String userN) {
		int index = checkPosition(userN);
		if (index == -1) {
			return null;
		} else {
			PlayerData player = playerList.get(index);
			return(player.getData());
		}
	}
	
	public String[] displayPlayer(int index) {
		PlayerData player = playerList.get(index);
		return(player.getData());
	}
	
	public void exit() {
		
	}
	
	public void IO() {
		System.out.println("Welcome to Nim");
		System.out.println();
		
		while (true) {
			
		}
	}
	
}// end class

























