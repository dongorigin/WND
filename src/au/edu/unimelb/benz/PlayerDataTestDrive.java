package au.edu.unimelb.benz;

import static java.lang.System.out;

import java.util.ArrayList;
import java.util.Collections;

public class PlayerDataTestDrive {

	public static void main(String[] args) {
		
		PlayerData testPlayerBond = new PlayerData("bond", "bond", "bond");
		PlayerData testPlayerBen = new PlayerData("ben", "ben", "ben");
		
		testPlayerBond.lose();
		testPlayerBond.lose();
		testPlayerBond.lose();
		
		testPlayerBen.lose();
		testPlayerBen.win();
		testPlayerBen.win();
		
		out.println("bond " + testPlayerBond.getRate());
		out.println("ben " + testPlayerBen.getRate());
		
		ArrayList<PlayerData> testPlayers = new ArrayList<PlayerData>();
		testPlayers.add(testPlayerBen);
		testPlayers.add(testPlayerBond);
		
		Collections.sort(testPlayers);
		
		out.println();
		
		
		
		/*String[] playerDetail = new String[5];
		PlayerData playerA = new PlayerData();
		
		playerDetail = playerA.getData();
		for (int i = 0; i < 5; i++) {
			System.out.print(playerDetail[i] + " ");
		}
		
		int played = 12;
		int won = 5;
		playerA.setNames("benjamin", "Zhang", "Chibin");
		//playerA.setGames(played, won);
		
		playerDetail = playerA.getData();
		for (int i = 0; i < 5; i++) {
			System.out.print(playerDetail[i] + " ");
		}*/
	}
}
