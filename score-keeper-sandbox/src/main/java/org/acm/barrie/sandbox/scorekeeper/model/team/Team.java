/**
 *
 */
package org.acm.barrie.sandbox.scorekeeper.model.team;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

import org.acm.barrie.sandbox.scorekeeper.model.league.Division;
import org.acm.barrie.sandbox.scorekeeper.model.player.Player;

/**
 * @author Fred
 */
public class Team implements Comparable<Team>
{

	private Division division;
	private String initials;
	private String name;
	private final Map<Integer, Player> players;

	/**
	 * @param initials
	 * @param name
	 * @param division
	 */
	public Team(final String initials, final String name, final Division division)
	{
		this.initials = Objects.requireNonNull(initials);
		this.name = Objects.requireNonNull(name);
		this.division = Objects.requireNonNull(division);
		this.players = new HashMap<>();
	}

	/**
	 * @param player
	 */
	public void addPlayer(final Player player)
	{
		Objects.requireNonNull(player);

		if (!player.getTeam().equals(this))
		{
			throw new IllegalArgumentException("player team does not match this team");
		}

		this.players.put(Integer.valueOf(player.getNumber()), player);
	}

	@Override
	public int compareTo(final Team o)
	{
		if (Objects.isNull(o))
		{
			return 1;
		}
		return this.initials.compareTo(o.initials);
	}

	@Override
	public boolean equals(final Object obj)
	{
		if (this == obj)
		{
			return true;
		}
		if (obj == null)
		{
			return false;
		}
		if (this.getClass() != obj.getClass())
		{
			return false;
		}
		final Team other = (Team) obj;
		if (!this.initials.equals(other.initials))
		{
			return false;
		}
		return true;
	}

	/**
	 * @return the division
	 */
	public Division getDivision()
	{
		return this.division;
	}

	/**
	 * @return the initials
	 */
	public String getInitials()
	{
		return this.initials;
	}

	/**
	 * @return the name
	 */
	public String getName()
	{
		return this.name;
	}

	/**
	 * @param number
	 * @return an optional player or else empty
	 */
	public Optional<Player> getPlayerByNumber(final int number)
	{
		return Optional.ofNullable(this.players.get(Integer.valueOf(number)));
	}

	@Override
	public int hashCode()
	{
		final int prime = 31;
		int result = 1;
		result = prime * result + this.name.hashCode();
		return result;
	}

	/**
	 * @param division
	 *            the division to set
	 */
	public void setDivision(final Division division)
	{
		this.division = Objects.requireNonNull(division);
	}

	/**
	 * @param initials
	 *            the initials to set
	 */
	public void setInitials(final String initials)
	{
		this.initials = initials;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(final String name)
	{
		this.name = Objects.requireNonNull(name);
	}

	@Override
	public String toString()
	{
		return this.name;
	}

}
