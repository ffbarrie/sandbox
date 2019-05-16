/**
 *
 */
package org.acm.barrie.sandbox.scorekeeper.controller;

import org.acm.barrie.sandbox.scorekeeper.model.Model;

/**
 * @author Fred
 */
public class Controller {

    private final Model model;

    /**
     * @param model
     */
    public Controller(final Model model) {
        assert model != null;
        this.model = model;
        assert this.model != null; // removes warning for now
    }
}
