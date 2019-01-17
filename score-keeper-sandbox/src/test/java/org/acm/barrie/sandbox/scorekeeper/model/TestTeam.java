package org.acm.barrie.sandbox.scorekeeper.model;

import org.junit.Assert;
import org.junit.Test;

public class TestTeam {
	@Test
	public void testConstructor() {
		final Team team = new Team(1, "first team");
		Assert.assertEquals(1, team.getId());
		Assert.assertEquals("first team", team.getName());
	}

	public void testEquals() {
		final Team team1 = new Team(1, "first team");
		final Team team2 = new Team(2, "second team");

		Assert.assertEquals(team1, team1);
		Assert.assertNotEquals(team1, null);
		Assert.assertNotEquals(team1, team2);
		Assert.assertNotEquals(team1, new Object());
	}

	@Test
	public void testSetName() {
		final Team team = new Team(1, "first team");
		team.setName("new name");
		Assert.assertEquals("new name", team.getName());
	}

	@Test
	public void testToString() {
		final Team team = new Team(1, "first team");
		Assert.assertEquals("first team", team.toString());
	}

}
