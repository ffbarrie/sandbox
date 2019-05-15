/**
 *
 */
package org.acm.barrie.sandbox.scorekeeper.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.acm.barrie.sandbox.scorekeeper.model.player.Players;
import org.acm.barrie.sandbox.scorekeeper.model.team.Team;
import org.acm.barrie.sandbox.scorekeeper.model.team.Teams;

/**
 * The data model for the score keeper app.
 *
 * @author Fred
 */
public class Model
{

	private final List<ModelListener> listeners;
	private final Players players;
	private final Teams teams;

	/**
	 * Create a new empty model.
	 */
	public Model()
	{
		this.teams = new Teams(this);
		this.players = new Players();
		this.listeners = new ArrayList<>();
	}

	/**
	 * @param listener
	 *            the listener who is interested in changes to the data model.
	 */
	public void addListener(final ModelListener listener)
	{
		this.listeners.add(listener);
	}

	/**
	 * @return players list
	 */
	public Players getPlayers()
	{
		return this.players;
	}

	/**
	 * @param name
	 * @return the specified team
	 */
	public Optional<Team> getTeam(final String name)
	{
		if (name.length() <= 3)
		{
			return this.getTeams().getByInitials(name);
		}
		return this.getTeams().getTeam(name);
	}

	/**
	 * @return the teams
	 */
	public Teams getTeams()
	{
		return this.teams;
	}

	/**
	 *
	 */
	public void load()
	{
		this.teams.load();
	}

	/**
	 * @param listener
	 *            the listener who is no longer interested in changes to the data model.
	 */
	public void removeListener(final ModelListener listener)
	{
		this.listeners.remove(listener);
	}
}
