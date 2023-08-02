package com.khoabug.coffeshop.common.repository.impl;

import com.khoabug.coffeshop.common.paging.Pageable;
import com.khoabug.coffeshop.common.repository.Repository;
import com.khoabug.coffeshop.common.mapper.RowMapper;
import com.khoabug.coffeshop.common.repository.exception.NotCreatException;
import com.khoabug.coffeshop.common.repository.exception.NotFoundException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author : DangKhoa
 * @since : 3/2/2023, Thu
 **/
public class CrudRepository<T> implements Repository<T> {

    private Connection connection = JdbcFactory.getConnection();
    private static final Logger LOGGER = LogManager.getLogger(CrudRepository.class);

    @Override
    public List<T> query(String sql, RowMapper<T> mapper, Object... parameters) {
        ArrayList<T> list = new ArrayList<>();
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            setParameter(statement, parameters);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                list.add(mapper.mapRow(resultSet));
            }
            return list;
        } catch (SQLException ex) {
            LOGGER.error(ex.getMessage());
            throw new NotFoundException();
        }
    }

    @Override
    public List<T> pagingQuery(Pageable pageable, RowMapper<T> mapper, String inputSql) {
        StringBuilder sql = new StringBuilder(inputSql);
        if (pageable != null && pageable.getSorter() == null) {
            sql.append("ORDER BY (SELECT NULL) OFFSET ? ROWS FETCH NEXT ? ROWS ONLY");
            return query(sql.toString(), mapper, pageable.getOffset(), pageable.getSize());
        } else if (pageable == null) {
            return query(sql.toString(), mapper);
        } else {
            sql.append("LIMIT ? OFFSET ? ");
            return query(sql.toString(), mapper, pageable.getSize(), pageable.getOffset());
        }
    }

    @Override
    public void update(String sql, Object... parameters) {
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            connection.setAutoCommit(false);
            statement.executeUpdate();
            connection.commit();
        } catch (SQLException ex) {
            try {
                connection.rollback();
            } catch (SQLException exception) {
                LOGGER.error(ex.getMessage());
                throw new NotCreatException();
            }
        }
    }

    @Override
    public Long insert(String sql, Object... parameters) {
        try (PreparedStatement statement
                     = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            connection.setAutoCommit(false);
            setParameter(statement, parameters);
            statement.executeUpdate();
            connection.commit();
            return statement.getGeneratedKeys().getLong(1);
        } catch (SQLException e) {
            try {
                connection.rollback();
            } catch (SQLException exception) {
                LOGGER.error(e.getMessage());
                throw new NotCreatException();
            }
        }
        return null;
    }

    @Override
    public int count(String sql, Object... parameters) {
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            setParameter(statement, parameters);
            ResultSet resultSet = statement.executeQuery();
            return resultSet.getInt(1);
        } catch (SQLException ex) {
            LOGGER.error(ex.getMessage());
            return -1;
        }
    }

    //TODO: change generic type
    private void setParameter(PreparedStatement statement, Object... parameters) {
        try {
            for (int i = 0; i < parameters.length; i++) {
                Object parameter = parameters[i];
                int index = i + 1;
                if (parameter instanceof Long) {
                    statement.setLong(index, (Long) parameter);
                } else if (parameter instanceof String) {
                    statement.setString(index, (String) parameter);
                } else if (parameter instanceof Double) {
                    statement.setDouble(index, (Double) parameter);
                } else if (parameter instanceof Integer) {
                    statement.setInt(index, (Integer) parameter);
                } else if (parameter instanceof Timestamp) {
                    statement.setTimestamp(index, (Timestamp) parameter);
                }
            }
        } catch (SQLException e) {
            LOGGER.error(e.getMessage());
        }
    }

    static class JdbcFactory {
        static Connection getConnection() {
            try {
                Class.forName(H2_DRIVER);
                return DriverManager.getConnection(H2_URL, H2_USER, H2_PASS);
            } catch (SQLException | ClassNotFoundException e) {
                LOGGER.error(e.getMessage());
            }
            return null;
        }
    }

}


