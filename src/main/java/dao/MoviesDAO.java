package dao;

import entity.Movies;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class MoviesDAO implements DAO {

    @Override
    public boolean addMovie(Statement statement, Movies movie) throws SQLException {
        String query = "INSERT INTO Movies (MOVIES, DIRECTORKEY, STUDIOKEY, RUNNINGTIME, BUDGET, BOXOFFICE, COUNTRYKEY, LANGUAGEKEY, YEAR) VALUES("
                +"'"+movie.getMovies()+"', "
                +movie.getDirectorKey()+", "
                +movie.getStudioKey()+", "
                +movie.getRunningTime()+", "
                +movie.getBudget()+", "
                +movie.getBoxOffice()+", "
                +movie.getCountryKey()+", "
                +movie.getLanguageKey()+", "
                +movie.getYear()+")";
        return statement.execute(query);
    }

    @Override
    public List<Movies> getMovieById(Statement statement, int id) throws SQLException {

        List<Movies> listOfMovies = new ArrayList<>();
        String query = "select * from Movies where MovieID = " + id;

        ResultSet result1 = null;
        try {
            result1 = statement.executeQuery(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        while(result1.next()){

                listOfMovies.add(new Movies(result1.getInt("MovieID"),
                        result1.getString("Movies"),
                        result1.getInt("DirectorKey"),
                        result1.getInt("StudioKey"),
                        result1.getInt("RunningTime"),
                        result1.getInt("Budget"),
                        result1.getInt("BoxOffice"),
                        result1.getInt("CountryKey"),
                        result1.getInt("LanguageKey"),
                        result1.getInt("Year")));

        }
        return listOfMovies;
    }

    @Override
    public boolean updateMovieByName(Statement statement, Movies movie, String name) throws SQLException {
        String query = "update Movies set Movies.Movies = '"
                +movie.getMovies()
                +"', DirectorKey="+movie.getDirectorKey()
                +", StudioKey="+movie.getStudioKey()
                +", RunningTime="+movie.getRunningTime()
                +", Budget="+movie.getBudget()
                +", BoxOffice="+movie.getBoxOffice()
                +", CountryKey="+movie.getCountryKey()
                +", LanguageKey="+movie.getLanguageKey()
                +", Year="+movie.getYear()
                +" where Movies.Movies = '"+name+"'";

        // update Movies set Movies.Movies = 'Matrix', DirectorKey = 27, StudioKey=2, RunningTime=136, Budget=63,
        // BoxOffice=465, CountryKey=150, LanguageKey=4, Year=1999 where Movies.Movies='Matrix';

        return statement.execute(query);
    }

    @Override
    public boolean deleteMovieByName(Statement statement, String name) throws SQLException {
        String query = "delete from Movies where Movies.Movies like '" + name + "'";
        return statement.execute(query);
    }
}

