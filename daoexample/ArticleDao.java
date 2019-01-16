package daoexample;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;

public class ArticleDao implements Dao {


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
    public LinkedList<?> getAll(String sql, Statement statement) {
        return null;
    }

    @Override
    public LinkedList<?> getById(String sql, Statement statement) {
        return null;
    }

    @Override
    public void update() {

    }

    @Override
    public void delete() {

    }
}

