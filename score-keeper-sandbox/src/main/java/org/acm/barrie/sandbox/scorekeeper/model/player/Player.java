/**
 *
 */
package org.acm.barrie.sandbox.scorekeeper.model.player;

import org.acm.barrie.sandbox.scorekeeper.model.team.Team;

/**
 * @author Fred
 */
public class Player implements Comparable<Player> {

    private String firstName;
    private String lastName;
    private int number;
    private Team team;

    /**
     * @param team
     * @param number
     */
    public Player(final Team team, final int number) {
        this.team = team;
        this.number = number;
        firstName = "";
        lastName = "";
    }

    @Override
    public int compareTo(final Player o) {
        int result = lastName.compareTo(o.lastName);
        if (result == 0) {
            result = firstName.compareTo(o.firstName);
        }

        if (result == 0) {
            result = Integer.compare(number, o.number);
        }
        if (result == 0) {
            result = team.compareTo(o.team);
        }
        return result;
    }

    /**
     * @return the firstName
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * @return the lastName
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * @return the jersey number
     */
    public int getNumber() {
        return number;
    }

    /**
     * @return the team
     */
    public Team getTeam() {
        return team;
    }

    /**
     * @param firstName the firstName to set
     */
    public void setFirstName(final String firstName) {
        this.firstName = firstName;
    }

    /**
     * @param lastName the lastName to set
     */
    public void setLastName(final String lastName) {
        this.lastName = lastName;
    }

    /**
     * @param number the number to set
     */
    public void setNumber(final int number) {
        this.number = number;
    }

    /**
     * @param team the team to set
     */
    public void setTeam(final Team team) {
        this.team = team;
    }

    @Override
    public String toString() {
        if (lastName != null) {
            return lastName;
        }
        return Integer.toString(number);
    }

}
