package org.acm.barrie.sandbox.scorekeeper.model;

/**
 * A named object.
 *
 * @author fred
 *
 */
abstract class NamedObject {

    private final long _id;
    private String _name;

    /**
     * Creates named object.
     *
     * @param id   - unique id of this named object
     * @param name - name of the object
     */
    protected NamedObject(final long id, final String name) {
        _id = id;
        _name = name;
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
        final NamedObject other = (NamedObject) obj;
        return _id == other.getId();
    }

    /**
     * @return the id
     */
    public long getId() {
        return _id;
    }

    /**
     * @return the name
     */
    public String getName() {
        return _name;
    }

    @Override
    public int hashCode() {
        return Long.hashCode(getId());
    }

    /**
     * @param name the name to set
     */
    public void setName(final String name) {
        this._name = name;
    }

    @Override
    public String toString() {
        return _name;
    }
}
