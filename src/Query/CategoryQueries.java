package Query;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


import Execute.DatabaseConnector;
import Model.Category;

public class CategoryQueries {
    //Insert new category 
    public static boolean insertNewCategory (int categoryID, String categoryName){
        String insertQuery = "INSERT INTO categories VALUES (?, ?);";
        try (Connection connection = DatabaseConnector.connect();
             PreparedStatement preparedStatement = connection.prepareStatement(insertQuery)) {
            
                preparedStatement.setInt(1, categoryID);
                preparedStatement.setString(2, categoryName);

                int rowAffected = preparedStatement.executeUpdate();

                if (rowAffected > 0) {
                    System.out.println("Added new category successfully!");
                    return true;
                } else {
                    System.out.println("Failed add new category.");
                    return false;
                }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    //Get infor by category name
    public static ArrayList<Category> getCategoryByName (String categoryName) {
        ArrayList<Category> categories = new ArrayList<>();
        String query = "SELECT * FROM categories WHERE category_name = ?;";
        try (Connection connection = DatabaseConnector.connect();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            
                preparedStatement.setString(1, categoryName);

                try(ResultSet resultSet = preparedStatement.executeQuery()){
                    while (resultSet.next()) {
                        Category category = new Category();
                        category.setCategoryID(resultSet.getInt("category_id"));
                        category.setCategoryName(resultSet.getString("category_name"));

                        categories.add(category);
                    }

                    for (Category category : categories) {
                        System.out.println("Category ID: " + category.getCategoryID());
                        System.out.println("Category Name: " + category.getCategoryName());
                        System.out.println("--------------------------");
                    }
                }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return categories;
    }
    //Update category name by category name
    public static boolean updateCategoryByName (String categoryName, String newCategoryName){
        String updateQuery = "UPDATE categories SET category_name = ? WHERE category_name = ?";

        try (Connection connection = DatabaseConnector.connect();
             PreparedStatement preparedStatement = connection.prepareStatement(updateQuery)) {

                preparedStatement.setString(1, newCategoryName);
                preparedStatement.setString(2, categoryName);
                
                int rowAffected = preparedStatement.executeUpdate();
                if (rowAffected > 0) {
                    System.out.println("Updated category name successfully!");
                    return true;
                } else {
                    System.out.println("Failed update category name.");
                    return false;
                }
            
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    //Delete category by category name
    public static boolean deleteCategoryByName (String categoryName) {
        String deleteQuery = "DELETE FROM categories WHERE category_name = ?";

        try (Connection connection = DatabaseConnector.connect();
             PreparedStatement preparedStatement = connection.prepareStatement(deleteQuery)) {

                preparedStatement.setString(1, categoryName);
                
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
