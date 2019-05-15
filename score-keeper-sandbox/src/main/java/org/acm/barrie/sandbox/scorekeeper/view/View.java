/**
 *
 */
package org.acm.barrie.sandbox.scorekeeper.view;

import org.acm.barrie.sandbox.scorekeeper.controller.Controller;
import org.acm.barrie.sandbox.scorekeeper.model.ModelListener;

/**
 * @author Fred
 */
public class View implements ModelListener
{

	private final Controller controller;

	/**
	 * @param controller
	 *            the controller to update with user inputs.
	 */
	public View(final Controller controller)
	{
		this.controller = controller;
		if (this.controller == null)
		{
			throw new NullPointerException("controller cannot be null.");
		}
	}
}
