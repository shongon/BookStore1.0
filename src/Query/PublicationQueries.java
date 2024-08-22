package Query;

import Execute.DatabaseConnector;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


import Model.Publication;

public class PublicationQueries {
    // Insert new object
    public static boolean insertNewPublication (int publicationID, String publicationName){
        String insertQuery = "INSERT INTO publications (publication_id, publication_name) VALUES (?,?)";
        
        try (Connection connection = DatabaseConnector.connect();
             PreparedStatement preparedStatement = connection.prepareStatement(insertQuery)) {

                preparedStatement.setInt(1, publicationID);
                preparedStatement.setString(2, publicationName);

                int rowAffected = preparedStatement.executeUpdate();

                if (rowAffected > 0) {
                    System.out.println("Add new publication successfully!");
                    return true;
                } else {
                    System.out.println("Failed to add new publication.");
                    return false;
                }
            
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    //Get all info by publcation ID
    public static ArrayList<Publication> getAllByID(int publicationID) {
        ArrayList<Publication> publications = new ArrayList<>();
        String query = "SELECT * FROM publications WHERE publication_id = ?";

        try (Connection connection = DatabaseConnector.connect();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            
                preparedStatement.setInt(1,publicationID);
                try (ResultSet resultSet = preparedStatement.executeQuery()){

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
