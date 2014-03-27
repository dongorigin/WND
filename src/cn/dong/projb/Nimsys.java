package cn.dong.projb;

import java.util.Scanner;

public class Nimsys {
	Scanner mScanner;
	PlayerCenter mCenter;

	public Nimsys() {
		mScanner = new Scanner(System.in);
		mCenter = new PlayerCenter();
	}

	public void start() {
		System.out.println("Welcome to Nim\n");
		System.out.print(">");

		while (true) {
			parseCommandLine(mScanner.nextLine());
			System.out.print(">");
		}
	}

	private void parseCommandLine(String line) {
		if (line.length() > 0) {
			String[] s = line.split(" ", 2);
			String command = s[0];
			String action = null;
			if (s.length > 1) {
				action = s[1].trim();
			}
			parseCommand(command, action);
		} else {
			return;
		}
	}

	private void parseCommand(String command, String action) {
		// System.out.println("command:" + command + ", action:" + action);
		if (command.equals("addplayer")) {
			addPlayer(action);
		} else if (command.equals("removeplayer")) {
			removePlayer(action);
		} else if (command.equals("editplayer")) {
			editPlayer(action);
		} else if (command.equals("resetstats")) {
			resetStats(action);
		} else if (command.equals("displayplayer")) {
			displayPlayer(action);
		} else if (command.equals("rankings")) {
			rankings();
		} else if (command.equals("startgame")) {
			startGame(action);
		} else if (command.equals("exit")) {
			exit();
		} else {
			System.out.println("command not found");
		}
		System.out.println();
	}

	private void addPlayer(String action) {
		if (action != null) {
			String[] names = action.split(",");
			mCenter.addPlayer(names[0], names[1], names[2]);
		}
	}

	private void removePlayer(String action) {
		if (action != null) {
			// 删除指定Player
			mCenter.removePlayer(action);
		} else {
			// 删除全部Player
			System.out.println("Are you sure you want to remoe all players? (y/n)");
			String input = mScanner.next();
			if (input.equals("y")) {
				mCenter.removeAllPlayer();
			}
		}
	}

	private void editPlayer(String action) {
		if (action != null) {
			String[] names = action.split(",");
			mCenter.editPlayer(names[0], names[1], names[2]);
		}
	}

	private void resetStats(String action) {
		if (action != null) {
			// 重置指定Player
			mCenter.resetStats(action);
		} else {
			// 重置全部Player
			System.out.println("Are you sure you want to reset all player statistics? (y/n)");
			String input = mScanner.next();
			if (input.equals("y")) {
				mCenter.resetAllStats();
			}
		}
	}

	private void displayPlayer(String action) {
		if (action != null) {
			// 展示指定Player
			mCenter.displayPlayer(action);
		} else {
			// 展示全部Player
			mCenter.displayAllPlayer();
		}
	}

	private void rankings() {
		mCenter.rankings();
	}

	private void startGame(String action) {
		if (action != null) {
			// assume valid and correct
			String[] actions = action.split(",");
			int stonesNum = Integer.parseInt(actions[0]);
			int upperBound = Integer.parseInt(actions[1]);
			String userNameA = actions[2];
			String userNameB = actions[3];

			Player playerA = mCenter.getPlayer(userNameA);
			Player playerB = mCenter.getPlayer(userNameB);
			if (playerA != null && playerB != null) {
				Nim nim = new Nim(mScanner, stonesNum, upperBound, playerA, playerB);
				nim.startGame();
			} else {
				System.out.println("One of the players does not exist.");
			}
		}
	}

	private void exit() {
		System.exit(0);
	}

	public static void main(String[] args) {
		Nimsys nimsys = new Nimsys();
		nimsys.start();
	}
}
