package daoexample;

import org.sqlite.JDBC;
import java.sql.*;

public class StatementFactory {

    public static Statement getStatement(boolean isPreparedStatement, String sql, Object object) throws SQLException {

        DriverManager.registerDriver(new JDBC());

        Connection connection = DriverManager.getConnection("jdbc:sqlite:dao_db.db");

        if (object instanceof User) {

            if (isPreparedStatement) {
                Statement tempStatement = connection.prepareStatement(sql);
                ((PreparedStatement) tempStatement).setInt(1, ((User)object).getId());

                if (!((User)object).getLogin().isEmpty() && !(((User)object).getLogin() == null)) {
                    ((PreparedStatement) tempStatement).setString(2, ((User)object).getLogin());
                }
                return tempStatement;
            } else {
                return connection.createStatement();
            }
        }
        else
        if (object instanceof Article) {
            if (isPreparedStatement) {
                Statement tempStatement = connection.prepareStatement(sql);
                ((PreparedStatement) tempStatement).setInt(1, ((Article)object).getArtcleId());

                if (!((Article)object).getTitle().isEmpty() && !(((Article)object).getTitle() == null)) {
                    ((PreparedStatement) tempStatement).setString(2, ((Article)object).getTitle());
                    ((PreparedStatement) tempStatement).setInt(3, ((Article)object).getIdUser());
                }
                return tempStatement;
            } else {
                return connection.createStatement();
            }
        }
        else {
            Statement tempStatement = connection.createStatement();
            return tempStatement;
        }
    }
}

