/**
 *
 */
package org.acm.barrie.sandbox.scorekeeper.model.player;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.acm.barrie.sandbox.scorekeeper.model.team.Team;

/**
 * @author Fred
 */
public class Players
{

	private final Set<Player> players;

	/**
	 *
	 */
	public Players()
	{
		this.players = new HashSet<>();
	}

	/**
	 * @param team
	 */
	public void load(final Team team)
	{
		final List<Player> store = this.initialList(team);
		store.stream().filter(p -> p.getTeam().equals(team)).forEach(p ->
		{
			team.addPlayer(p);
			this.players.add(p);
		});
	}

	private List<Player> initialList(final Team team)
	{
		final List<Player> result = new ArrayList<>();
		for (int i = 1; i <= 25; i++)
		{
			result.add(new Player(team, i));
		}
		return result;
	}

}
