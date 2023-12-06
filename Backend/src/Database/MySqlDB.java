package Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MySqlDB {
    public Statement Connection_method() {
        Connection connection = null;
        Statement statement = null;
        try {
            connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/testing", "muruga", "mask@2004");
            statement = connection.createStatement();
//            ResultSet rs=statement.executeQuery("select * from student");
//            while(rs.next())
//                System.out.println(rs.getString(1)+" "+rs.getInt(2));
        } catch (SQLException e) {
            System.out.println(e);
        }
        return statement;
    }
}
