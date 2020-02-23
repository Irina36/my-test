package tests;

import org.testng.annotations.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnectionTest {

    @Test
    public void testDbConnection () {
        Connection conn = null;

        try {
            conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/rfd?user=user&password=123&serverTimezone=UTC");
            

            // Do something with the Connection


        } catch (SQLException ex) {
            // handle any errors
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }
    }
}
