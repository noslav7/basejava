package ru.javawebinar.basejava.storage;

import java.sql.Connection;
import java.sql.SQLException;

public interface SqlTransaction<T> {
    T execute(Connection con) throws SQLException;
}
