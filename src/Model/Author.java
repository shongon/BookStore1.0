package Model;
//Class Model of Author table.
public class Author {
    private int authorID;
    private String authorName;

    //Constructors
    // public Author(int authorID, String authorName){
    //     this.authorID = authorID;
    //     this.authorName = authorName;
    // }
    //Get & Set
    public int getAuthorID(){
        return authorID;
    }
    public void setAuthorID(int authorID){
        this.authorID = authorID;
    }

    public String getAuthorName(){
        return authorName;
    }
    public void setAuthorName(String authorName){
        this.authorName = authorName;
    }
}
