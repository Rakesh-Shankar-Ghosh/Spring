package dev.rakesh.test.service;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public class AppService {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public AppService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public boolean isDatabaseConnected() {
        try {
            // Execute a simple query to check if the database is reachable
            jdbcTemplate.queryForObject("SELECT 1", Integer.class);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public String getConnectionStatusMessage() {
        try {
            if (isDatabaseConnected()) {
                return "Database is connected!";
            } else {
                return "Database is not connected.";
            }
        } catch (Exception e) {
            return "An error occurred while checking the database connection.";
        }
    }
}
