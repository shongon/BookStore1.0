package Model;
public class Category {
    private int categoryID;
    private String categoryName;

    //Constructors
    // public Category(int categoryID, String categoryName){
    //     this.categoryID = categoryID;
    //     this.categoryName = categoryName;
    // }

    //Get & Set
    public int getCategoryID(){
        return categoryID;
    }
    public void setCategoryID(int categoryID){
        this.categoryID = categoryID;
    }

    public String getCategoryName(){
        return categoryName;
    }
    public void setCategoryName(String categoryName){
        this.categoryName = categoryName;
    }
}   
