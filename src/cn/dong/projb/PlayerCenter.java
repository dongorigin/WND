package cn.dong.projb;

import java.util.ArrayList;

public class PlayerCenter {
	ArrayList<Player> players;

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
	 * @return true 展示成功, false 用户不存在, 提示错误
	 */
	public boolean displayPlayer(String userName) {
		int index = indexOf(userName);
		if (index >= 0) {
			players.get(index).display();
			return true;
		} else {
			System.out.println("The player does not exist.");
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

	}
}
