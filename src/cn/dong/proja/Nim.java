package cn.dong.proja;
import java.util.Scanner;

public class Nim {
	private Scanner scanner;
	private int number;

	public Nim() {
		scanner = new Scanner(System.in);
	}

	public void play() {
		System.out.println("Welcome to Nim");
		System.out.println("Please enter initial number of stones:");
		number = scanner.nextInt();
		display();
		while (number > 0) {
			if (move()) {
				display();
			} else {
				System.out.println("Game over");
			}
		}
	}

	public void display() {
		System.out.print(number + " stones left:");
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < number; i++) {
			sb.append(" *");
		}
		System.out.println(sb.toString());
	}

	public boolean move() {
		System.out.println("Remove how many?");
		int moveNum = scanner.nextInt();
		number -= moveNum;
		return number > 0;
	}

	public static void main(String[] args) {
		Nim nim = new Nim();
		nim.play();
	}
}
