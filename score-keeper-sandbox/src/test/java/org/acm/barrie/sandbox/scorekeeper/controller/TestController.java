/**
 *
 */
package org.acm.barrie.sandbox.scorekeeper.controller;

import org.acm.barrie.sandbox.scorekeeper.model.Model;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author Fred
 */
public class TestController {

    @Test
    public void constructorNullModelTest() {
        try {
            new Controller(null);
            Assert.fail("controller should throw an assertion error for a null model.");
        } catch (final AssertionError e) {
            // ignore
        }
    }

    @Test
    public void constructorTest() {
        Assert.assertNotNull(new Controller(new Model()));
    }
}
