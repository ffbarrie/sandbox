/**
 *
 */
package org.acm.barrie.sandbox.scorekeeper.controller;

import org.acm.barrie.sandbox.scorekeeper.model.Model;

/**
 * @author Fred
 */
public class Controller
{

	private final Model model;

	/**
	 * @param model
	 */
	public Controller(final Model model)
	{
		this.model = model;
		if (this.model == null)
		{
			throw new NullPointerException("model argument cannot be null.");
		}
	}
}
