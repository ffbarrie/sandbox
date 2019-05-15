/**
 *
 */
package org.acm.barrie.sandbox.scorekeeper.model.game;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.acm.barrie.sandbox.scorekeeper.model.team.Team;

/**
 * @author Fred
 */
public class Game implements Comparable<Game>
{

	// Sat, May 19 5:35PM
	private static final SimpleDateFormat GAME_CALENDAR_FORMAT = new SimpleDateFormat("EEE, MMM d h:mma");

	private Calendar endTime;
	private final Team homeTeam;
	private final List<Inning> innings;
	private final Calendar scheduledTime;
	private Calendar startTime;

	private final Team visitorsTeam;

	/**
	 * @param home
	 * @param visitors
	 * @param scheduledTime
	 */
	public Game(final Team home, final Team visitors, final Calendar scheduledTime)
	{
		this.homeTeam = home;
		this.visitorsTeam = visitors;
		this.scheduledTime = scheduledTime;
		this.innings = new ArrayList<>();
	}

	@Override
	public int compareTo(final Game o)
	{
		int result = this.homeTeam.compareTo(o.homeTeam);
		if (result == 0)
		{
			result = this.visitorsTeam.compareTo(o.visitorsTeam);
		}

		if (result == 0)
		{
			result = this.scheduledTime.compareTo(o.scheduledTime);
		}

		return result;
	}

	/**
	 * @return a new inning;
	 */
	public Inning createInning()
	{
		final Inning inning = new Inning(this.innings.size() + 1);
		this.innings.add(inning);
		return inning;
	}

	/**
	 * @return the endTime
	 */
	public Calendar getEndTime()
	{
		return this.endTime;
	}

	/**
	 * @return the homeTeam
	 */
	public Team getHomeTeam()
	{
		return this.homeTeam;
	}

	/**
	 * @return the scheduledTime
	 */
	public Calendar getScheduledTime()
	{
		return this.scheduledTime;
	}

	/**
	 * @return the startTime
	 */
	public Calendar getStartTime()
	{
		return this.startTime;
	}

	/**
	 * @return the visitorsTeam
	 */
	public Team getVisitorsTeam()
	{
		return this.visitorsTeam;
	}

	/**
	 * @param endTime
	 *            the endTime to set
	 */
	public void setEndTime(final Calendar endTime)
	{
		this.endTime = endTime;
	}

	/**
	 * @param startTime
	 *            the startTime to set
	 */
	public void setStartTime(final Calendar startTime)
	{
		this.startTime = startTime;
	}

	@Override
	public String toString()
	{
		return String.format("%s vs %s %s", this.visitorsTeam.getInitials(), this.homeTeam.getInitials(), Game.GAME_CALENDAR_FORMAT.format(this.scheduledTime.getTime()));
	}
}
