package Model;
public class Publication {
    private int publicationID;
    private String publicationName;

    //Constructors
    // public Publication(){
    //     this.publicationID = publicationID;
    //     this.publicationName = publicationName;
    // }

    //Get & Set
    public int getPublicationID(){
        return publicationID;
    }
    public void setPublicationID(int publicationID){
        this.publicationID = publicationID;
    }

    public String getPublicationName(){
        return publicationName;
    }
    public void setPublicationName(String publicationName){
        this.publicationName = publicationName;
    }
}
