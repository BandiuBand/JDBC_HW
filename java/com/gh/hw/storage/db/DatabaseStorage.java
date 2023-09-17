package com.gh.hw.storage.db;

import com.gh.hw.storage.Entity;
import com.gh.hw.storage.Storage;
import com.gh.hw.storage.StorageException;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;
import java.util.Map;

public class DatabaseStorage implements Storage {

    private final DataSource dataSource;

    public DatabaseStorage(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public <T extends Entity> T get(Class<T> clazz, Integer id) throws StorageException {
        //this method is fully implemented, no need to do anything, it's just an example
        String sql = "SELECT * FROM \"" + clazz.getSimpleName().toLowerCase() + "\" WHERE id = " + id;
        try (Connection connection = dataSource.getConnection()) {
            Statement statement = connection.createStatement();
            List<T> result = extractResult(clazz, statement.executeQuery(sql));
            return result.isEmpty() ? null : result.get(0);
        } catch (StorageException e) {
            throw e;
        } catch (Exception e) {
            throw new StorageException(e);
        }
    }

    @Override
    public <T extends Entity> List<T> list(Class<T> clazz) throws StorageException {
        //TODO: Implement me
        return null;
    }

    @Override
    public <T extends Entity> boolean delete(T entity) throws StorageException {
        //TODO: Implement me
        return false;
    }

    @Override
    public <T extends Entity> void save(T entity) throws StorageException {
        //TODO: Implement me
        /*
        Use StringJoiner if you need to concat a string of ?
         */
    }

    //creates list of new instances of clazz by using data from the result set
    private <T extends Entity> List<T> extractResult(Class<T> clazz, ResultSet resultSet) throws Exception {
        /*
        This method must a create a resulting list of entities. Fill objects with data from the results set.
        Use reflection to create an instance of given class. Extract data from result set by class' field name.
         */
        return null;
    }

    //converts object to map, could be helpful in save method
    private <T extends Entity> Map<String, Object> prepareEntity(T entity) throws StorageException {
        //TODO: Implement me and use in the save method
        return null;
    }
}
