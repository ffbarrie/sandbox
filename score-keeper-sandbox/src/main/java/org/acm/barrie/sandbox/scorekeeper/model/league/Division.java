/**
 *
 */
package org.acm.barrie.sandbox.scorekeeper.model.league;

/**
 * @author Fred
 */
public enum Division
{
	/**
	 * American North
	 */
	PCL_AN(League.PCL, "American North"),

	/**
	 * American South
	 */
	PCL_AS(League.PCL, "American South"),

	/**
	 * Pacific North
	 */
	PCL_PN(League.PCL, "Pacific North"),

	/**
	 * Pacific South
	 */
	PCL_PS(League.PCL, "Pacific South");

	private final String divisionName;
	private final League league;

	private Division(final League league, final String divisionName)
	{
		this.league = league;
		this.divisionName = divisionName;
	}

	/**
	 * @return the division's initials
	 */
	public String getInitials()
	{
		return String.format("%s%s", this.league.getInitials() + this.name());
	}

	/**
	 * @return the league
	 */
	public League getLeague()
	{
		return this.league;
	}

	@Override
	public String toString()
	{
		return String.format("%s %s", this.league.toString(), this.divisionName);
	}
}
