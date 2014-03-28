package cn.dong.projb;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Nim {
	private Scanner mScanner;
	private int stonesNum;
	private int upperBound;
	private Player[] players = new Player[2];

	public Nim(Scanner scanner, int stonesNum, int upperBound, Player playerA, Player playerB) {
		this.mScanner = scanner;
		this.stonesNum = stonesNum;
		this.upperBound = upperBound;
		this.players[0] = playerA;
		this.players[1] = playerB;
	}

	public void startGame() {
		welcome();
		int turnNum = 0;
		while (true) {
			try {
				display(turnNum);
				int num = mScanner.nextInt();
				int upper = Math.min(upperBound, stonesNum);
				if (num <= 0 || num > upper) {
					System.out.printf("\nInvalid move. You must remove between 1 and %d stones.\n",
							upper);
					continue;
				} else {
					stonesNum -= num;
					if (stonesNum == 0) {
						System.out.println("\nGame Over");
						System.out.printf("%s %s wins!\n\n",
								players[(turnNum + 1) % 2].getGivenName(),
								players[(turnNum + 1) % 2].getFamilyName());
						players[(turnNum + 1) % 2].played(true);
						players[turnNum % 2].played(false);
						break;
					}
				}
				turnNum++;
			} catch (InputMismatchException e) {
				System.out.println("\nOnly can enter the Numbers\n");
			}
		}
	}

	private void welcome() {
		System.out.println("Initial stone count: " + stonesNum);
		System.out.println("Maxinum stone removal: " + upperBound);
		System.out.printf("Player 1: %s %s\n", players[0].getGivenName(),
				players[0].getFamilyName());
		System.out.printf("Player 2: %s %s\n", players[1].getGivenName(),
				players[1].getFamilyName());
	}

	private void display(int turnNum) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < stonesNum; i++) {
			sb.append(" *");
		}
		System.out.println();
		System.out.printf("%d stones left:%s\n", stonesNum, sb.toString());
		System.out.printf("%s's turn - remove how many?\n", players[turnNum % 2].getGivenName());
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		Player playerA = new Player("a", "a", "a");
		Player playerB = new Player("b", "b", "b");
		Nim nim = new Nim(scanner, 10, 3, playerA, playerB);
		nim.startGame();
	}
}
