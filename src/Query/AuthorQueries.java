package Query;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Execute.DatabaseConnector;
import Model.Author;

public class AuthorQueries {
    //Insert new author 
    public static boolean insertNewAuthor (int authorID, String authorName){
        String insertQuery = "INSERT INTO authors(author_id, author_name) VALUES (?, ?);";
        try (Connection connection = DatabaseConnector.connect();
            PreparedStatement preparedStatement = connection.prepareStatement(insertQuery)) {
            
                preparedStatement.setInt(1, authorID);
                preparedStatement.setString(2, authorName);

                int rowAffected = preparedStatement.executeUpdate();

                if (rowAffected > 0) {
                    System.out.println("Add new author successfully!");
                    return true;
                } else {
                    System.out.println("Failed add new author.");
                    return false;
                }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    //Get infor by author ID
    public static ArrayList<Author> getAuthorByID (int authorID){
        ArrayList<Author> authors = new ArrayList<>();
        String getQuery = "SELECT * FROM authors WHERE author_id = ?";

        try (Connection connection = DatabaseConnector.connect();
             PreparedStatement preparedStatement = connection.prepareStatement(getQuery)) {

                preparedStatement.setInt(1, authorID);

                try(ResultSet resultSet = preparedStatement.executeQuery()){
                    while (resultSet.next()) {
                        Author author = new Author();
                        author.setAuthorID(resultSet.getInt("author_id"));
                        author.setAuthorName(resultSet.getString("author_name"));

                        authors.add(author);
                    }

                    for (Author author : authors) {
                        System.out.println("Author ID:" + author.getAuthorID());
                        System.out.println("Author name: " + author.getAuthorName());
                        System.out.println("-------------------");
                    }
                }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return authors;
    }
    //Update author name by authorID
    public static boolean updateAuthorByID (int authorID, String newAuthorName){
        String updateQuery = "UPDATE authors SET author_name = ? WHERE author_id = ?";

        try (Connection connection = DatabaseConnector.connect();
             PreparedStatement preparedStatement = connection.prepareStatement(updateQuery)) {

                preparedStatement.setString(1, newAuthorName);
                preparedStatement.setInt(2, authorID);
                
                int rowAffected = preparedStatement.executeUpdate();
                if (rowAffected > 0) {
                    System.out.println("Updated author name successfully!");
                    return true;
                } else {
                    System.out.println("Failed update author name.");
                    return false;
                }
            
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    //Delete author by author ID
    public static boolean deleteAuthorByID (int authorID) {
        String deleteQuery = "DELETE FROM authors WHERE author_id = ?";

        try (Connection connection = DatabaseConnector.connect();
             PreparedStatement preparedStatement = connection.prepareStatement(deleteQuery)) {

                preparedStatement.setInt(1, authorID);
                
                int rowAffected = preparedStatement.executeUpdate();
                if (rowAffected > 0) {
                    System.out.println("Deleted author successfully!");
                    return true;
                } else {
                    System.out.println("Failed delete author.");
                    return false;
                }
            
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
