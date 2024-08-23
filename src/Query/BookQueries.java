package Query;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import Execute.DatabaseConnector;
import Model.Book;

public class BookQueries {
    //Add new book
    public static boolean insertNewBook (int bookID, String title, int authorID, int categoryID ,int price, String stockStatus,
    int copiesLeft, int length, int publicationID, int wishedUsers, int ratings, int reviews) {

        String insertQuery = "INSERT INTO books VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
        try (Connection connection = DatabaseConnector.connect();
             PreparedStatement preparedStatement = connection.prepareStatement(insertQuery)) {
            
                preparedStatement.setInt(1,bookID);
                preparedStatement.setString(2, title);
                preparedStatement.setInt(3, authorID);
                preparedStatement.setInt(4, categoryID);
                preparedStatement.setInt(5, price);
                preparedStatement.setString(6, stockStatus);
                preparedStatement.setInt(7, copiesLeft);
                preparedStatement.setInt(8, length);
                preparedStatement.setInt(9, publicationID);
                preparedStatement.setInt(10, wishedUsers);
                preparedStatement.setInt(11, ratings);
                preparedStatement.setInt(12, reviews);

                int rowAffected = preparedStatement.executeUpdate();
                if (rowAffected > 0) {
                    System.out.println("Added new book successfully!");
                    return true;
                } else {
                    System.out.println("Failed add new book.");
                    return false;
                }

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    //Get all infor by book id
    public static ArrayList<Book> getBookByID (int bookID){
        ArrayList<Book> books = new ArrayList<>();
        String getQuery = "SELECT * FROM books WHERE book_id = ?";
        try (Connection connection = DatabaseConnector.connect();
             PreparedStatement preparedStatement = connection.prepareStatement(getQuery)) {
                preparedStatement.setInt(1, bookID);
                try(ResultSet resultSet = preparedStatement.executeQuery()){
                    while (resultSet.next()) {
                        Book book = new Book();
                        book.setBookID(resultSet.getInt("book_id"));
                        book.setTitle(resultSet.getString("title"));
                        book.setAuthorID(resultSet.getInt("author_id"));
                        book.setCategoryID(resultSet.getInt("category_id"));
                        book.setPrice(resultSet.getInt("price"));
                        book.setStockStatus(resultSet.getString("stock_status"));
                        book.setCopiesLeft(resultSet.getInt("copies_left"));
                        book.setLength(resultSet.getInt("length"));
                        book.setPublicationID(resultSet.getInt("publication_id"));
                        book.setWishedUsers(resultSet.getInt("wished_user"));
                        book.setRatings(resultSet.getInt("ratings"));
                        book.setReviews(resultSet.getInt("reviews"));

                        books.add(book);
                    }

                    for (Book book : books) {
                        System.out.println("Book ID: " + book.getBookID());
                        System.out.println("Title: " + book.getTitle());
                        System.out.println("Author ID: " + book.getAuthorID());
                        System.out.println("Category ID: " + book.getCategoryID());
                        System.out.println("Price: " + book.getPrice());
                        System.out.println("Stock Status: " + book.getStockStatus());
                        System.out.println("Copies Left: " + book.getCopiesLeft());
                        System.out.println("Length: " + book.getLength());
                        System.out.println("Publication ID: " + book.getPublicationID());
                        System.out.println("Wished Users: " + book.getWishedUsers());
                        System.out.println("Ratings: " + book.getRatings());
                        System.out.println("Reviews: " + book.getReviews());
                    }
                }
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return books;
    }
    //Update ratings & reviews by book id
    public static boolean updateBookByID (int bookID, int newRatings, int newReviews) {
        String updateQuery = "UPDATE books SET ratings = ?, reviews = ? WHERE book_id = ?;";
        try (Connection connection = DatabaseConnector.connect();
             PreparedStatement preparedStatement = connection.prepareStatement(updateQuery)) {

                preparedStatement.setInt(1, newRatings);
                preparedStatement.setInt(2, newReviews);
                preparedStatement.setInt(3, bookID);

                int rowAffected = preparedStatement.executeUpdate();

                if (rowAffected > 0) {
                    System.out.println("Updated ratings & reviews successfully!");
                    return true;
                } else {
                    System.out.println("Failed update ratings & reviews.");
                    return false;
                }
            
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    //Delete book by book id
    public static boolean deleteBookByID (int bookID) {
        String delQuery = "DELETE FROM books WHERE book_id = ?;";
        try (Connection connection = DatabaseConnector.connect();
             PreparedStatement preparedStatement = connection.prepareStatement(delQuery)) {

                preparedStatement.setInt(1, bookID);

                int rowAffected = preparedStatement.executeUpdate();

                if (rowAffected > 0) {
                    System.out.println("Deleted book successfully!");
                    return true;
                } else {
                    System.out.println("Failed delete book.");
                    return false;
                }
            
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
