package Execute;

import java.sql.Connection;

import Query.AuthorQueries;
import Query.BookQueries;
import Query.CategoryQueries;
import Query.PublicationQueries;

public class Main {
    public static void main(String[] args) {
        //Establish connection
        Connection connection = DatabaseConnector.connect();
        System.out.println();

        //Methods
            //Book Queries
                // Add new book
                // BookQueries.insertNewBook(41, "Co tich Viet Name", 3, 4, 1000, "Out Stock", 0, 500, 1, 300, 150, 75);
                // Get book infor by id
                // BookQueries.getBookByID(41);
                // Update book (ratings, reviews) by id
                // BookQueries.updateBookByID(41, 175, 200);
                // Delete book by id
                // BookQueries.deleteBookByID(41);

            //Publication Queries
                //Add new publication
                // PublicationQueries.insertNewPublication(29,"Phu Nu");
                // Get all infor by publication id
                // PublicationQueries.getAllByID(1);
                

                // Update publication name by publication id
                // PublicationQueries.updateNameByID(1, "Hoa Hoc Tro");


                //Delete all infor by publication id
                // PublicationQueries.deleteAllByID(26);

            //Author Queries
                //Add new author
                // AuthorQueries.insertNewAuthor(38, "To Hoai");
                //Get infor by author id
                // AuthorQueries.getAuthorByID(38);
                //Update author by author id
                // AuthorQueries.updateAuthorByID(38, "Nguyen Nhat Anh");
                //Delete author by author id
                // AuthorQueries.deleteAuthorByID(38);

            //Category Queries
                //Add new category
                // CategoryQueries.insertNewCategory(14, "Comedy");
                //Get infor by category id
                // CategoryQueries.getCategoryByName("Comedy");
                //Update author by category id
                // CategoryQueries.updateCategoryByName("Comedy", "Horror");
                //Delete author by category id
                // CategoryQueries.deleteCategoryByName("Horror");

        //Close connection
        System.out.println();
        DatabaseConnector.disconnect(connection);
    }
}

