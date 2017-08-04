package ua.ali_x.DAO;

import java.sql.Connection;

public abstract class AbstractDAO<T> implements GenericDAO <T> {

    protected final Connection connection;

    protected AbstractDAO(Connection connection) {
        this.connection = connection;
    }
}
