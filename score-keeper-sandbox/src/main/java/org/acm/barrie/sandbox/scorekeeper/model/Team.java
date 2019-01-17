package org.acm.barrie.sandbox.scorekeeper.model;

/**
 * Team contains players that compete against other teams in games.
 *
 * @author fred
 *
 */
public class Team extends NamedObject {

    /**
     * Creates a new team with the specified id and name.
     *
     * @param id   - unique ID of the team.
     * @param name - name of the team.
     */
    public Team(final long id, final String name) {
        super(id, name);
    }
}
