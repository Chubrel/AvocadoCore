package com.github.chubrel.avocado_core.database;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.jetbrains.annotations.NotNull;
import org.sqlite.SQLiteDataSource;

import javax.sql.DataSource;
import java.io.*;
import java.nio.file.Files;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Locale;
import java.util.Properties;
import java.util.stream.Collectors;


public class DataBaseManager {

    private final @NotNull DataSource dataSource;

    public DataBaseManager(@NotNull DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public DataBaseManager(@NotNull String type, @NotNull String name,
                           @NotNull String user, @NotNull String password,
                           @NotNull String host, @NotNull String port,
                           @NotNull String additionalSettings) {
        dataSource = dataSource(type, name, user, password, host, port, additionalSettings);
    }

    protected @NotNull DataSource dataSource(@NotNull String type, @NotNull String name,
                                               @NotNull String user, @NotNull String password,
                                               @NotNull String host, @NotNull String port,
                                               @NotNull String additionalSettings) {
        switch (type.toUpperCase(Locale.ENGLISH)) {
            case "SQLITE":
                SQLiteDataSource sqLiteDataSource = new SQLiteDataSource();
                sqLiteDataSource.setUrl("jdbc:sqlite:" + name);
                return sqLiteDataSource;
            case "MYSQL":
                Properties properties = new Properties();
                properties.setProperty("dataSource.user", user);
                properties.setProperty("dataSource.password", password);
                properties.setProperty("jdbcUrl", String.format("jdbc:mysql://%s:%s/%s?%s", host, port, name, additionalSettings));
                return new HikariDataSource(new HikariConfig(properties));
        }
        throw new IllegalStateException("Provided no acceptable database type name");
    }

    public @NotNull DataSource getDataSource() {
        return dataSource;
    }

    private void testConnection() throws SQLException {
        try (Connection conn = dataSource.getConnection()) {
            if (!conn.isValid(5)) {
                throw new SQLException("Cannot establish database connection");
            }
        }
    }

    public void executeQueries(@NotNull String @NotNull ... queries) throws SQLException {
        for (String query : queries) {
            if (!query.isEmpty()) {
                try (Connection conn = dataSource.getConnection();
                     PreparedStatement stmt = conn.prepareStatement(query)) {
                    stmt.execute();
                } catch (SQLException e) {
                    throw new SQLException("Cannot execute queries", e);
                }
            }
        }
    }

    public void executeQueries(@NotNull String queries) throws SQLException {
        executeQueries(queries.split(";"));
    }

    public void executeQueries(@NotNull File file) throws SQLException, IOException {
        executeQueries(Files.newInputStream(file.toPath()));
    }

    public void executeQueries(@NotNull InputStream inputStream) throws SQLException {
        String setup = new BufferedReader(new InputStreamReader(inputStream)).lines().collect(Collectors.joining("\n"));
        executeQueries(setup);
    }
}
