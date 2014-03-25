package au.edu.unimelb.benz;

public class PlayerDataTestDrive {

	public static void main(String[] args) {
		String[] playerDetail = new String[5];
		PlayerData playerA = new PlayerData();
		
		playerDetail = playerA.getData();
		for (int i = 0; i < 5; i++) {
			System.out.print(playerDetail[i] + " ");
		}
		
		int played = 12;
		int won = 5;
		playerA.setNames("benjamin", "Chibin", "Zhang");
		playerA.setGames(played, won);
		
		playerDetail = playerA.getData();
		for (int i = 0; i < 5; i++) {
			System.out.print(playerDetail[i] + " ");
		}
	}
}
