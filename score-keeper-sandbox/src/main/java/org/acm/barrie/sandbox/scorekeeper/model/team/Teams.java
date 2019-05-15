/**
 *
 */
package org.acm.barrie.sandbox.scorekeeper.model.team;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

import org.acm.barrie.sandbox.scorekeeper.model.Model;
import org.acm.barrie.sandbox.scorekeeper.model.league.Division;
import org.acm.barrie.sandbox.scorekeeper.model.player.Players;

/**
 * @author Fred
 */
public class Teams
{

	private final Model model;
	private final Map<String, Team> teams;

	/**
	 * @param model
	 */
	public Teams(final Model model)
	{
		this.model = Objects.requireNonNull(model);
		this.teams = new HashMap<>();
	}

	/**
	 * Find the team with the matching initials.
	 *
	 * @param initials
	 *            search criteria
	 * @return an optional or empty
	 */
	public Optional<Team> getByInitials(final String initials)
	{
		return Optional.ofNullable(this.teams.get(initials));
	}

	/**
	 * @return list of teams
	 */
	public List<Team> getList()
	{
		return new ArrayList<>(this.teams.values());
	}

	/**
	 * Find the team with the specified name
	 *
	 * @param name
	 *            search criteria
	 * @return an optional team or empty
	 */
	public Optional<Team> getTeam(final String name)
	{
		return this.teams.values().stream().filter(t -> t.getName().equals(name)).findAny();
	}

	/**
	 *
	 */
	public void load()
	{
		final Players players = this.model.getPlayers();
		this.initialList().stream().forEach(t ->
		{
			this.teams.put(t.getInitials(), t);
			players.load(t);
		});
	}

	private List<Team> initialList()
	{
		final List<Team> result = new ArrayList<>();
		result.add(new Team("OKC", "Oklahoma City Dodgers", Division.PCL_AN));
		result.add(new Team("COS", "Colorado Springs Sky Sox", Division.PCL_AN));
		result.add(new Team("OMA", "Omaha Storm Chasers", Division.PCL_AN));
		result.add(new Team("IOW", "Iowa Cubs", Division.PCL_AN));
		result.add(new Team("MEM", "Memphis Redbirds", Division.PCL_AS));
		result.add(new Team("NO", "New Orleans Baby Cakes", Division.PCL_AS));
		result.add(new Team("NAS", "Nashville Sounds", Division.PCL_AS));
		result.add(new Team("RR", "Round Rock Express", Division.PCL_AS));
		result.add(new Team("FRE", "Fresno Grizzlies", Division.PCL_PN));
		result.add(new Team("SAC", "Sacramento River Cats", Division.PCL_PN));
		result.add(new Team("TAC", "Tacoma Rainiers", Division.PCL_PN));
		result.add(new Team("RNO", "Reno Aces", Division.PCL_PN));
		result.add(new Team("SL", "Salt Lake Bees", Division.PCL_PS));
		result.add(new Team("ALQ", "Albuquerque Isotopes", Division.PCL_PS));
		result.add(new Team("ELP", "El Paso Chihuahuas", Division.PCL_PS));
		result.add(new Team("LV", "Las Vegas 51s", Division.PCL_PS));
		return result;
	}
}
