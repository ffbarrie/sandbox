package org.acm.barrie.sandbox.scorekeeper.model;

import org.junit.Assert;
import org.junit.Test;

public class TestDivision {

	@Test
	public void testConstructor() {
		final Division Division = new Division(1, "first division");
		Assert.assertEquals(1, Division.getId());
		Assert.assertEquals("first division", Division.getName());
	}

	public void testEquals() {
		final Division Division1 = new Division(1, "first division");
		final Division Division2 = new Division(2, "second division");

		Assert.assertEquals(Division1, Division1);
		Assert.assertNotEquals(Division1, null);
		Assert.assertNotEquals(Division1, Division2);
		Assert.assertNotEquals(Division1, new Object());
	}

	@Test
	public void testSetName() {
		final Division Division = new Division(1, "first division");
		Division.setName("new name");
		Assert.assertEquals("new name", Division.getName());
	}

	@Test
	public void testToString() {
		final Division Division = new Division(1, "first division");
		Assert.assertEquals("first division", Division.toString());
	}
}
