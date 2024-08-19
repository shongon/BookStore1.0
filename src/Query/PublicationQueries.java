package Query;

import Execute.DatabaseConnector;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


import Model.Publication;

public class PublicationQueries {

    //Get all info by publcation ID
    public static ArrayList<Publication> getAllByID(int publicationID) {
        ArrayList<Publication> publications = new ArrayList<>();
        String query = "SELECT * FROM publications WHERE publication_id = " + publicationID;

        try (Connection connection = DatabaseConnector.connect();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {
            
                while (resultSet.next()) {
                    Publication publication = new Publication();
                    publication.setPublicationID(resultSet.getInt("publication_id"));
                    publication.setPublicationName(resultSet.getString("publication_name"));

                    publications.add(publication);
                }

                for (Publication publication : publications) {
                    System.out.println("Publication ID: " + publication.getPublicationID());
                    System.out.println("Publication Name: " + publication.getPublicationName());
                    System.out.println("----------------------------");
                }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return publications;
    }

    //Update publication name by ID
    public static boolean updateNameByID(int publicationID, String newPublicationName){
        String updateQuery = "UPDATE publications SET publication_name = ? WHERE publication_id = ?";

        try (Connection connection = DatabaseConnector.connect();
             PreparedStatement preparedStatement = connection.prepareStatement(updateQuery)) {
            
                preparedStatement.setString(1, newPublicationName);
                preparedStatement.setInt(2, publicationID);
                
                int rowAffected = preparedStatement.executeUpdate();

                if (rowAffected > 0) {
                    System.out.println("Publication name updated successfully!");
                    return true;
                }else {
                    System.out.println("Failed to update publication name.");
                    return false;
                }
                
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    //Delete infor by ID
    public static boolean deleteAllByID (int publicationID){
        String queryDelete = "DELETE FROM publications WHERE publication_id = ?";

        try (Connection connection = DatabaseConnector.connect();
             PreparedStatement preparedStatement = connection.prepareStatement(queryDelete)) {
                preparedStatement.setInt(1, publicationID);

                int rowAffected = preparedStatement.executeUpdate();

                if (rowAffected > 1) {
                    System.out.println("Row deleted successfully!");
                    return true;
                }
                else{
                    System.out.println("Failed to delete row.");
                    return false;
                }

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
