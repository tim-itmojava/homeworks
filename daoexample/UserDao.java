package daoexample;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;

public class UserDao implements Dao {

    @Override
    public String toString() {
        return super.toString();
    }

    @Override
    public void add(String sql, Statement statement) {

        int rows = 0;

        if (statement instanceof PreparedStatement) {
            try {
                rows = ((PreparedStatement) statement).executeUpdate();
                System.out.println(rows); }
            catch (SQLException e) {
                e.printStackTrace();
            }
        } else {
            try {
                rows = statement.executeUpdate(sql);
            } catch (SQLException e) {
                e.printStackTrace();
            }
            System.out.println(rows);
        }
    }

    @Override
    public LinkedList<User> getAll(String sql, Statement statement) {

        LinkedList<User> usersList = new LinkedList<>();

        ResultSet resultSet;
        try {
            resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                int userId = resultSet.getInt("userId");
                String login = resultSet.getString("login");
                System.out.println("userId= " + userId + " || " + "login= " + login);
                usersList.add(new User(userId, login));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return usersList;
    }

    @Override
    public LinkedList<User> getById(String sql, Statement statement) {

        LinkedList<User> usersList = new LinkedList<>();

        ResultSet resultSet;
        try {
            resultSet = ((PreparedStatement) statement).executeQuery();

            while (resultSet.next()) {
                int userId = resultSet.getInt("userId");
                String login = resultSet.getString("login");
//                System.out.println("userId= " + userId + " || " + "login= " + login);
                usersList.add(new User(userId, login));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return usersList;
    }

    @Override
    public void update() {

    }

    @Override
    public void delete() {

    }

    public static void main(String[] args) throws SQLException {

        // 1. creating the User table
//        String sql = "CREATE TABLE IF NOT EXISTS User (" +
//                "id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL," +
//                "userId INTEGER NOT NULL," +
//                "login TEXT NOT NULL);";
//
//        int rc = StatementFactory.getStatement(false,sql, null).executeUpdate(sql);
//        System.out.println(rc);
// ==========
        // 2. inserting a record into the User table via Statement object
//        User user1 = new User(755, "foo_755");
//        String sql = "INSERT INTO User (userId, login)" + "VALUES (" + user1.getId() + "," +
//                                                        "\'" + user1.getLogin() + "\'" + ");";
//        new UserDao().add(sql, StatementFactory.getStatement(false,"",null));
// ==========
        // 3. inserting a set of records into the User table via Statement
//        ArrayList<User> users = new ArrayList<>();
//        for (int i = 0; i < 100; i++) {
//            users.add(new User(i, "login_".concat(Integer.toString(i))));
//        }

//        UserDao userDao = new UserDao();
//        SqlCommandSimple sqlExp = (u)-> {
//            String sqlExpession;
//            sqlExpession = "INSERT INTO User (userId, login)".concat("VALUES (")
//                    .concat(Integer.toString(u.getId()))
//                    .concat(",")
//                    .concat("\'").concat(u.getLogin()).concat("\'").concat(");");
//            return sqlExpession;
//        };
//
//        for(User u : users) {
//            userDao.add(sqlExp.getComposedSql(u),
//                    StatementFactory.getStatement(false,"",null));
//        }
// ==========
        // 4. inserting a set of records into the User table via PreparedStatement object
//        User user2 = new User(304, "foo_578");
//        String sql = "INSERT INTO User (userId, login)" + "VALUES (?, ?);";
//        new UserDao().add(sql, StatementFactory.getStatement(true,sql,user2));
// ==========
        // 5. retrieving ALL records from the User table
//        LinkedList<User> dataRetrieved = new UserDao().getAll("SELECT * FROM User;",
//                                StatementFactory
//                                .getStatement(false,"SELECT * FROM User;", null));
//
//        for (User u : dataRetrieved) {
//            System.out.println(u.toString());
//        }
// ==========
        // 6. retrieving records from User table by userId via PreparedStatement object
//        LinkedList<User> dataRetrieved = new UserDao().getById("SELECT * FROM User WHERE userId = ?;",
//                                StatementFactory
//                                .getStatement(true,"SELECT * FROM User WHERE userId = ?;",
//                                        new User(76,"")));
//
//        for (User u : dataRetrieved) {
//            System.out.println(u.toString());
//        }
// ==========
        // 7. creating Article table
        String sql = "CREATE TABLE IF NOT EXISTS My_Article (" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL," +
                "articleId INTEGER NOT NULL," +
                "idUser INTEGER NOT NULL," +
                "title TEXT NOT NULL);";

        int rc = StatementFactory.getStatement(false,sql, null).executeUpdate(sql);
        System.out.println(rc);
// ==========
        // 8. inserting a record into the Article table via Statement object
//        Article article1 = new Article(35, "art12", 77);
//        String sql = "INSERT INTO My_Article (articleId, title, idUser)" +
//                "VALUES (" + article1.getArtcleId() + "," +
//                "\'" + article1.getTitle() + "\'" + "," +
//                article1.getIdUser() + ");";
//        new ArticleDao().add(sql, StatementFactory.getStatement(false,"",null));
    }
}

