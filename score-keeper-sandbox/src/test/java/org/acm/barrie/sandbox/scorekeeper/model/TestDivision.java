package org.acm.barrie.sandbox.scorekeeper.model;

import org.junit.Assert;
import org.junit.Test;

public class TestDivision {

	@Test
	public void testConstructor() {
		final Division division = new Division(1, "first division");
		Assert.assertEquals(1, division.getId());
		Assert.assertEquals("first division", division.getName());
	}

	@Test
	public void testEquals() {
		final Division division1 = new Division(1, "first division");
		final Division division2 = new Division(2, "second division");
		final Division division3 = new Division(1, "copy division");

		Assert.assertEquals(division1, division1);
		Assert.assertNotEquals(division1, null);
		Assert.assertNotEquals(division1, division2);
		Assert.assertNotEquals(division1, new Object());
		Assert.assertEquals(division1, division3);
	}

	@Test
	public void testHashCode() {
		final Division division1 = new Division(1, "first division");
		final Division division2 = new Division(2, "second division");

		Assert.assertNotEquals(division1.hashCode(), division2.hashCode());
		Assert.assertEquals(division1.hashCode(), Integer.hashCode(1));
	}

	@Test
	public void testSetName() {
		final Division division = new Division(1, "first division");
		division.setName("new name");
		Assert.assertEquals("new name", division.getName());
	}

	@Test
	public void testToString() {
		final Division division = new Division(1, "first division");
		Assert.assertEquals("first division", division.toString());
	}
}
