package daoexample;

import java.sql.Statement;
import java.util.LinkedList;

public interface Dao {

    void add(String sql, Statement statement);
    LinkedList<?> getAll(String sql, Statement statement);
    LinkedList<?> getById(String sql, Statement statement);
    void update();
    void delete();

}
