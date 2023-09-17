package com.gh.hw.storage;

public abstract class Entity {
    /**
     * Identifier of the entity. Should be updated only by {@link Storage} implementation.
     */
    private Integer id;

    /**
     * Determines is object new or not based on its id.
     *
     * @return true if object not yet saved, false otherwise.
     */
    public boolean isNew() {
        return getId() == null;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
