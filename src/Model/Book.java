package Model;
public class Book {
    private int bookID;
    private String title;
    private int authorID;
    private int categoryID;
    private int price;
    private String stockStatus;
    private int copiesLeft;
    private int length;
    private int publicationID;
    private int wishedUsers;
    private int ratings;
    private int reviews;

    
    //Contructors
    // public Book(int bookID, String title, int authorID, int categoryID, int price, String stockStatus, int copiesLeft,
    //         int length, int publicationID, int wishedUsers, int ratings, int reviews) {
    //     this.bookID = bookID;
    //     this.title = title;
    //     this.authorID = authorID;
    //     this.categoryID = categoryID;
    //     this.price = price;
    //     this.stockStatus = stockStatus;
    //     this.copiesLeft = copiesLeft;
    //     this.length = length;
    //     this.publicationID = publicationID;
    //     this.wishedUsers = wishedUsers;
    //     this.ratings = ratings;
    //     this.reviews = reviews;
    // }

    //Get & Set
    public int getBookID() {
        return bookID;
    }
    public void setBookID(int bookID) {
        this.bookID = bookID;
    }

    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }

    public int getAuthorID() {
        return authorID;
    }
    public void setAuthorID(int authorID) {
        this.authorID = authorID;
    }

    public int getCategoryID() {
        return categoryID;
    }
    public void setCategoryID(int categoryID) {
        this.categoryID = categoryID;
    }

    public int getPrice() {
        return price;
    }
    public void setPrice(int price) {
        this.price = price;
    }

    public String getStockStatus() {
        return stockStatus;
    }
    public void setStockStatus(String stockStatus) {
        this.stockStatus = stockStatus;
    }

    public int getCopiesLeft() {
        return copiesLeft;
    }
    public void setCopiesLeft(int copiesLeft) {
        this.copiesLeft = copiesLeft;
    }

    public int getLength() {
        return length;
    }
    public void setLength(int length) {
        this.length = length;
    }

    public int getPublicationID() {
        return publicationID;
    }
    public void setPublicationID(int publicationID) {
        this.publicationID = publicationID;
    }

    public int getWishedUsers() {
        return wishedUsers;
    }
    public void setWishedUsers(int wishedUsers) {
        this.wishedUsers = wishedUsers;
    }

    public int getRatings() {
        return ratings;
    }
    public void setRatings(int ratings) {
        this.ratings = ratings;
    }

    public int getReviews() {
        return reviews;
    }
    public void setReviews(int reviews) {
        this.reviews = reviews;
    }

}
