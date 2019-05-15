/**
 *
 */
package org.acm.barrie.sandbox.scorekeeper.model.game;

/**
 * @author Fred
 */
public class Inning
{

	private final Frame homeFrame;
	private final int number;
	private final Frame visitorFrame;

	/**
	 * Create a new inning with the specified number.
	 *
	 * @param number
	 */
	public Inning(final int number)
	{
		this.number = number;
		this.homeFrame = new Frame();
		this.visitorFrame = new Frame();
	}

	/**
	 * @return the home frame
	 */
	public Frame getHomeFrame()
	{
		return this.homeFrame;
	}

	/**
	 * @return the number
	 */
	public int getNumber()
	{
		return this.number;
	}

	/**
	 * @return the visitor frame
	 */
	public Frame getVisitorFrame()
	{
		return this.visitorFrame;
	}

}
