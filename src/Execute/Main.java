package Execute;

import java.sql.Connection;

import Query.AuthorQueries;
import Query.PublicationQueries;

public class Main {
    public static void main(String[] args) {
        //Establish connection
        Connection connection = DatabaseConnector.connect();
        System.out.println();

        //Methods
            //Book Queries
                //.

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
                
                //Get infor by category id
                
                //Update author by category id
                
                //Delete author by category id
                

        //Close connection
        System.out.println();
        DatabaseConnector.disconnect(connection);
    }
}

