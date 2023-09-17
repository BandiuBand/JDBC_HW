package com.gh.hw.storage;

import java.util.List;

/**
 * Every implementation of Storage should allow save, update, delete and retrieve entities {@link Entity}.
 */
public interface Storage {
    /**
     * Retrieves {@link Entity} from storage by its identifier.
     *
     * @param clazz type of object that should be retrieved from storage.
     * @param id    identifier of that object.
     * @param <T>   type of object that will be retrieved.
     * @return new instance of object T or null if it is not find by id.
     * @throws StorageException
     */
    <T extends Entity> T get(Class<T> clazz, Integer id) throws StorageException;

    /**
     * Retrieves all {@link Entity} from storage.
     *
     * @param clazz type of objects that needs to be retrieved.
     * @param <T>
     * @return list of objects of specified type or empty list if storage does not contains any object of that type.
     * @throws StorageException
     */
    <T extends Entity> List<T> list(Class<T> clazz) throws StorageException;

    /**
     * Deletes object in storage.
     *
     * @param entity that will be deleted
     * @param <T>
     * @return true if object was deleted successfully, false otherwise.
     * @throws StorageException
     */
    <T extends Entity> boolean delete(T entity) throws StorageException;

    /**
     * If {@link Entity} does not exists in storage yet it will be created, otherwise it will be updated.
     *
     * @param entity that will be stored in storage.
     * @param <T>
     * @throws StorageException
     */
    <T extends Entity> void save(T entity) throws StorageException;
}
