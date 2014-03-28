package cn.dong.projb;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class PlayerCenter {
	private static final String PLAYER_EXISTS = "The player already exists.";
	private static final String PLAYER_NOT_EXIST = "The player does not exist.";

	private ArrayList<Player> players;

	public PlayerCenter() {
		players = new ArrayList<Player>();
	}

	private int indexOf(String userName) {
		for (int i = 0; i < players.size(); i++) {
			if (players.get(i).getUserName().equals(userName)) {
				return i;
			}
		}
		return -1;
	}

	/**
	 * 添加Player
	 * 
	 * @param userName
	 * @param givenName
	 * @param familyName
	 * @return true 添加成功, false 用户已存在
	 */
	public boolean addPlayer(String userName, String givenName, String familyName) {
		int index = indexOf(userName);
		if (index == -1) {
			Player player = new Player(userName, givenName, familyName);
			players.add(player);
			return true;
		} else {
			System.out.println(PLAYER_EXISTS);
			return false;
		}
	}

	/**
	 * 删除Player
	 * 
	 * @param userName
	 * @return true 删除成功, false 用户不存在
	 */
	public boolean removePlayer(String userName) {
		int index = indexOf(userName);
		if (index >= 0) {
			players.remove(index);
			return true;
		} else {
			System.out.println(PLAYER_NOT_EXIST);
			return false;
		}
	}

	/**
	 * 删除全部Player
	 */
	public void removeAllPlayer() {
		players.clear();
	}

	/**
	 * 编辑Player
	 * 
	 * @param userName
	 * @param givenName
	 * @param familyName
	 * @return true 编辑成功, false 用户不存在
	 */
	public boolean editPlayer(String userName, String givenName, String familyName) {
		int index = indexOf(userName);
		if (index >= 0) {
			players.get(index).setName(userName, givenName, familyName);
			return true;
		} else {
			System.out.println(PLAYER_NOT_EXIST);
			return false;
		}
	}

	/**
	 * 重置统计数据
	 * 
	 * @param userName
	 * @return true 重置成功, false 用户不存在
	 */
	public boolean resetStats(String userName) {
		int index = indexOf(userName);
		if (index >= 0) {
			players.get(index).resetStats();
			return true;
		} else {
			System.out.println(PLAYER_NOT_EXIST);
			return false;
		}
	}

	/**
	 * 重置全部统计数据
	 */
	public void resetAllStats() {
		for (Player player : players) {
			player.resetStats();
		}
	}

	/**
	 * 展示Player
	 * 
	 * @param userName
	 * @return true 展示成功, false 用户不存在
	 */
	public boolean displayPlayer(String userName) {
		int index = indexOf(userName);
		if (index >= 0) {
			players.get(index).display();
			return true;
		} else {
			System.out.println(PLAYER_NOT_EXIST);
			return false;
		}
	}

	/**
	 * 展示全部Player
	 */
	public void displayAllPlayer() {
		for (Player player : players) {
			player.display();
		}
	}

	public void rankings() {
		Collections.sort(players);
		for (int i = 0; i < Math.min(players.size(), 10); i++) {
			Player player = players.get(i);
			System.out.printf("%d%% | %2d games | %s %s\n", player.getRate(),
					player.getPlayedNum(), player.getGivenName(), player.getFamilyName());
		}
	}

	/**
	 * 根据用户名获取Player
	 * 
	 * @param userName
	 * @return 用户名所对应的Player，不存在则返回null
	 */
	public Player getPlayer(String userName) {
		int index = indexOf(userName);
		if (index >= 0) {
			return players.get(index);
		} else {
			return null;
		}
	}
}
