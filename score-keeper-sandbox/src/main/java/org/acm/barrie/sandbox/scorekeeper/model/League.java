/**
 *
 */
package org.acm.barrie.sandbox.scorekeeper.model;

/**
 * Teams belong to a league.
 *
 * @author fred
 *
 */
public class League extends NamedObject {

    /**
     * Creates a league with the specified id and name.
     *
     * @param id   - unique ID of the league.
     * @param name - name of the league.
     */
    public League(final long id, final String name) {
        super(id, name);
    }
}
