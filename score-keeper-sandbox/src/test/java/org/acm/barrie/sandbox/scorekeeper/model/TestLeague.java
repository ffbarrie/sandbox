package org.acm.barrie.sandbox.scorekeeper.model;

import org.junit.Assert;
import org.junit.Test;

public class TestLeague {

	@Test
	public void testConstructor() {
		final League league = new League(1, "first league");
		Assert.assertEquals(1, league.getId());
		Assert.assertEquals("first league", league.getName());
	}

	public void testEquals() {
		final League league1 = new League(1, "first league");
		final League league2 = new League(2, "second league");

		Assert.assertEquals(league1, league1);
		Assert.assertNotEquals(league1, null);
		Assert.assertNotEquals(league1, league2);
		Assert.assertNotEquals(league1, new Object());
	}

	@Test
	public void testSetName() {
		final League league = new League(1, "first league");
		league.setName("new name");
		Assert.assertEquals("new name", league.getName());
	}

	@Test
	public void testToString() {
		final League league = new League(1, "first league");
		Assert.assertEquals("first league", league.toString());
	}
}
