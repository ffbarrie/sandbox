/**
 *
 */
package org.acm.barrie.sandbox.scorekeeper.model.league;

/**
 * @author Fred
 */
public enum League
{
	/**
	 * Internation League
	 */
	IL("International League"),

	/**
	 * Mexican League
	 */
	ML("Mexican League"),

	/**
	 * Pacific Coast League
	 */
	PCL("Pacific Coast League");

	private final String leagueName;

	private League(final String leagueName)
	{
		this.leagueName = leagueName;
	}

	/**
	 * @return the league's initials
	 */
	public String getInitials()
	{
		return this.name();
	}

	@Override
	public String toString()
	{
		return this.leagueName;
	}

}
