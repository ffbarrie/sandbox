/**
 *
 */
package org.acm.barrie.sandbox.scorekeeper.model;

/**
 * A team belongs to a division.
 *
 * @author fred
 *
 */
public class Division extends NamedObject {

    /**
     * Create a division with the specified id and name.
     *
     * @param id   - unique ID for this division.
     * @param name - name of this division.
     */
    public Division(final long id, final String name) {
        super(id, name);
    }
}
