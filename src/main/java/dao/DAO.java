package dao;

import entity.Movies;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public interface DAO {

    boolean addMovie (Statement statement, Movies movie) throws SQLException;                           // create
    List<Movies> getMovieById(Statement statement, int id) throws SQLException;                         // read
    boolean updateMovieByName (Statement statement, Movies movie, String name) throws SQLException;     // update
    boolean deleteMovieByName (Statement statement, String name) throws SQLException;                   // delete

}
