package Execute;

import java.sql.Connection;

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
                PublicationQueries.insertNewPublication(29,"Phu Nu");
                // Get all infor by publication id
                // PublicationQueries.getAllByID(1);
                

                // Update publication name by publication id
                // PublicationQueries.updateNameByID(1, "Hoa Hoc Tro");


                //Delete all infor by publication id
                // PublicationQueries.deleteAllByID(26);

            //Author Queries
                //.

            //Category Queries
                //.

        //Close connection
        System.out.println();
        DatabaseConnector.disconnect(connection);
    }
}

