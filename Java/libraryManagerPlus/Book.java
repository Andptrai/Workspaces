public class Book{
    private int ISBN;
    private String title;
    private String authors;
    private int year;
    private String publisher;
    private String status;


    public Book(int ISBN, String title, String authors, int year, String publisher, String status){
        this.ISBN = ISBN;
        this.title = title;
        this.authors = authors;
        this.year= year;
        this.publisher = publisher;
        this.status = status;
    }
    public int getISBN() {
        return ISBN;
    }

    public void setISBN(int iSBN) {
        ISBN = iSBN;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthors() {
        return authors;
    }

    public void setAuthors(String authors) {
        this.authors = authors;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}