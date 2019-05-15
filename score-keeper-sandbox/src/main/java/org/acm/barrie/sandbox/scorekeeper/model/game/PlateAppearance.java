/**
 *
 */
package org.acm.barrie.sandbox.scorekeeper.model.game;

import java.util.ArrayList;
import java.util.List;

import org.acm.barrie.sandbox.scorekeeper.model.player.Player;

/**
 * @author Fred
 */
public class PlateAppearance
{

	private int balls;
	private final List<Player> batters;
	private final List<Player> pictchers;
	private PlateAppearanceResult result;
	private String resultAsText;
	private int strikes;

	/**
	 * Create a new AtBat
	 *
	 * @param batter
	 * @param pitcher
	 */
	public PlateAppearance(final Player batter, final Player pitcher)
	{
		this.batters = new ArrayList<>();
		this.batters.add(batter);
		this.pictchers = new ArrayList<>();
		this.pictchers.add(pitcher);
		this.strikes = 0;
		this.balls = 0;
		this.result = PlateAppearanceResult.UNKNOWN;
		this.resultAsText = "";
	}

	/**
	 *
	 */
	public void ball()
	{
		this.balls++;
	}

	/**
	 * @return the result of the plate appearance
	 */
	public PlateAppearanceResult getResult()
	{
		return this.result;
	}

	/**
	 * @return the result as text
	 */
	public String getResultAsText()
	{
		return this.resultAsText;
	}

	/**
	 * The result of the plate appearance.
	 *
	 * @param newResult
	 * @param newResultAsText
	 */
	public void result(final PlateAppearanceResult newResult, final String newResultAsText)
	{
		this.result = newResult;
		this.resultAsText = newResultAsText;
	}

	/**
	 *
	 */
	public void strike()
	{
		this.strikes--;
	}

	@Override
	public String toString()
	{
		final String info = this.result == PlateAppearanceResult.UNKNOWN ? String.format("(%s-%s)", Integer.valueOf(this.balls), Integer.valueOf(this.strikes)) : this.resultAsText;
		return String.format("%s vs %s (%s)", this.batters.get(this.batters.size() - 1), this.pictchers.get(this.pictchers.size() - 1), info);
	}

	/**
	 * Result of a plate appearance.
	 *
	 * @author Fred
	 */
	public enum PlateAppearanceResult
	{
		/**
		 * Automatic double. For example, a fair ball that bounces into the stands.
		 */
		AUTOMATIC_DOUBLE,

		/**
		 * Batter reaches first base on four balls.
		 */
		BASE_ON_BALLS,

		/**
		 * Catcher interferes with the play.
		 */
		DEFENSIVE_INTERFERENCE,

		/**
		 * Defense obstructs the play.
		 */
		DEFENSIVE_OBSTRUCTION,

		/**
		 * Double hit.
		 */
		DOUBLE,

		/**
		 * Batter reaches on an error.
		 */
		ERROR,

		/**
		 * Batter reaches on a fielders choice.
		 */
		FIELDERS_CHOICE,

		/**
		 * Batter is out with a fly ball.
		 */
		FLY_OUT,

		/**
		 * Batter is out with a ground out.
		 */
		GROUND_OUT,

		/**
		 * Ground rule double. When an actual ground rule states a double.
		 */
		GROUND_RULE_DOUBLE,

		/**
		 * Batter is hit by a pitch and is awarded first base.
		 */
		HIT_BY_PITCH,

		/**
		 * Home run
		 */
		HOME_RUN,

		/**
		 * The offense interferes with the play.
		 */
		OFFENSIVE_INTERFERENCE,

		/**
		 * Batter hits a bunt ball to advance a base runner
		 */
		SACRIFICE_BUNT,

		/**
		 * Batter hits a sacrifice fly that scores a run from third.
		 */
		SACRIFICE_FLY,

		/**
		 * Single hit.
		 */
		SINGLE,

		/**
		 * Batter strikes out. Catcher catches pitch or runner on first with less than two outs.
		 */
		STRIKE_OUT,

		/**
		 * Batter strikes out. Catcher drops pitch and batter is tagged by catcher or batter walks away.
		 */
		STRIKE_OUT_CATCHER_PUT_OUT,

		/**
		 * Batter strikes out. Catcher drops pitch and catcher throws out the runner at first.
		 */
		STRIKE_OUT_CATCHER_TO_FIRST,

		/**
		 * Batter strikes out looking.
		 */
		STRIKE_OUT_LOOKING,

		/**
		 * Batter strikes out but reaches first base on a passed ball not being caught by the catcher.
		 */
		STRIKE_OUT_PASSED_BALL,

		/**
		 * Batter strikes out but reaches first base on a wild pitch not being caught by the catcher.
		 */
		STRIKE_OUT_WILD_PITCH,

		/**
		 * Triple hit.
		 */
		TRIPLE,

		/**
		 * Unknown result. Still in progress? etc.
		 */
		UNKNOWN

	}
}
