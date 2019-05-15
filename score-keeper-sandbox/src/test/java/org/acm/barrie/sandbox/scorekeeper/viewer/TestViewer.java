/**
 *
 */
package org.acm.barrie.sandbox.scorekeeper.viewer;

import org.acm.barrie.sandbox.scorekeeper.controller.Controller;
import org.acm.barrie.sandbox.scorekeeper.model.Model;
import org.acm.barrie.sandbox.scorekeeper.view.View;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author Fred
 */
public class TestViewer
{

	@Test
	public void testConstructor()
	{
		final Model model = new Model();
		final Controller controller = new Controller(model);
		Assert.assertNotNull(new View(controller));
	}
}
