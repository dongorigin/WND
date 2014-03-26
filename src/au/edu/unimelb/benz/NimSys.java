package au.edu.unimelb.benz;

import java.util.*;

public class NimSys {
	
	private ArrayList<PlayerData> playerList;

	public NimSys() {
		playerList = new ArrayList<PlayerData>();
	}

	// test method
	public void showPlayer(int index) {
		PlayerData testPlayer = playerList.get(index);
		String[] testData = testPlayer.getData();
		System.out.print("index");
		for (int i = 0; i < 5; i ++) {
			System.out.print(" " + testData[i]);
		}
		System.out.println();
	}
	
	public int checkPosition(String userN) {
		// test
		//System.out.println("checking now");
		
		int position = 0;
		for (PlayerData toCheck : playerList) {
			if (toCheck.getUsername() == userN) {
				return position;
			}
			position ++;
		}
		return -1;
	}
	
	public void addPlayer(String userN, String familyN, String givenN) {
		// test
		//System.out.println("adding player");
		PlayerData newPlayer = new PlayerData(userN, familyN, givenN);
		playerList.add(newPlayer);
	}

	public void removePlayer(int index) {
			playerList.remove(index);
	}

	public void removePlayer() {
		playerList.clear();
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
}// end class

