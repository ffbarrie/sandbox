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
public class League {

	private long id;
	private String name;

	public League(final long id, final String name) {
		this.id = id;
		this.name = name;
	}

	@Override
	public boolean equals(final Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		final League other = (League) obj;
		return id == other.id;
	}

	/**
	 * @return the id
	 */
	public long getId() {
		return id;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	@Override
	public int hashCode() {
		return Long.hashCode(id);
	}

	/**
	 * @param id the id to set
	 */
	public void setId(final long id) {
		this.id = id;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(final String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return name;
	}
}
