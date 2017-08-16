package ua.ali_x.dao;

import java.sql.Connection;

public abstract class AbstractDAO<T> implements GenericDAO<T> {

    protected final Connection connection;

    protected AbstractDAO(Connection connection) {
        this.connection = connection;
    }

}
