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
public class Division {
	private long id;
	private String name;

	/**
	 *
	 * @param id
	 * @param name
	 */
	public Division(final long id, final String name) {
		this.id = id;
		this.name = name;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
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
		final Division other = (Division) obj;
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

	/*
	 * (non-Javadoc)
	 *
	 * @see java.lang.Object#hashCode()
	 */
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
