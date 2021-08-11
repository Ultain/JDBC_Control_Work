import dao.MoviesDAO;
import entity.Movies;

import java.sql.*;

import static data.ConnectionInfo.*;

public class Application {

    public static void main(String[] args) {

        try(Connection connection = DriverManager.getConnection(DB, USER, PASSWORD);
            Statement statement = connection.createStatement()){

            MoviesDAO moviesDAOobj = new MoviesDAO();

            // Добавление фильма "Матрица" в таблицу Movies
            Movies movieMatrix = new Movies("Matrix", 27, 2, 136, 63, 465, 150, 4, 1999);
            moviesDAOobj.addMovie(statement, movieMatrix);

            // Чтение полей фильма из таблицы Movies по MovieID
            System.out.println(moviesDAOobj.getMovieById(statement, 15));

            // Обновление полей фильма по названию фильма (в данном случае поле RunningTime меняется с 136 на 180)
            Movies updateMatrix = new Movies("Matrix", 27, 2, 180, 63, 465, 150, 4, 1999);
            moviesDAOobj.updateMovieByName(statement, updateMatrix, "Matrix");

            // Удаление фильма по названию фильма
            moviesDAOobj.deleteMovieByName(statement, "Matrix");

        }catch (SQLException ex){
            ex.printStackTrace();
        }

    }
}
