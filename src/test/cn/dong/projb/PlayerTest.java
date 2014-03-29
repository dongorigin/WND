package test.cn.dong.projb;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import cn.dong.projb.Player;

public class PlayerTest {

	private Player player1;
	private Player player2;

	@Before
	public void setUp() throws Exception {
		player1 = new Player("player1", "", "");
		player2 = new Player("player2", "", "");
	}

	/**
	 * 测试Player的胜率计算
	 */
	@Test
	public void testRate() {
		player1.played(false);
		assertEquals(0, player1.getRate());
		player1.played(true);
		assertEquals(50, player1.getRate());
		player1.played(true);
		player1.played(true);
		assertEquals(75, player1.getRate());
		player1.played(false);
		assertEquals(60, player1.getRate());
		player1.played(true);
		player1.played(true);
		assertEquals(71, player1.getRate());
	}

	/**
	 * 测试Player的CompareTo实现是否符合预期
	 */
	@Test
	public void testCompareTo1() {
		// player1.Rate = 100
		player1.played(true);
		// player2.Rate = 0
		player2.played(false);
		assertTrue(player1.compareTo(player2) > 0);
		assertTrue(player2.compareTo(player1) < 0);
	}

	/**
	 * 当Player rate相同时，比较username
	 */
	@Test
	public void testCompareTo2() {
		// player1.Rate == player2.Rate
		player1.setName("a", "", "");
		player2.setName("b", "", "");
		assertTrue(player1.getRate() == player2.getRate());
		assertEquals(player1.getUserName().compareTo(player2.getUserName()),
				player1.compareTo(player2));
		assertEquals(player2.getUserName().compareTo(player1.getUserName()),
				player2.compareTo(player1));

	}

	@Test
	public void testCompareTo3() {
		player1.setName("abcd", "", "");
		player2.setName("abcd", "", "");
		assertTrue(player1.getRate() == player2.getRate());
		assertEquals(player1.getUserName().compareTo(player2.getUserName()),
				player1.compareTo(player2));
	}
}
