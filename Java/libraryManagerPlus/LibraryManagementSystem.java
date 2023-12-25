import java.util.ArrayList;
import java.util.List;

public class LibraryManagementSystem {
    private List <Book> catalog;
    private List <MemberAccount> members;
    private List <BookRequest> requests;

    public LibraryManagementSystem() {
        this.catalog = new ArrayList<>();
        this.members = new ArrayList<>();
        this.requests = new ArrayList<>();
    }
    public List<Book> getCatalog() {
        return catalog;
    }
    public void setCatalog(List<Book> catalog) {
        this.catalog = catalog;
    }
    // method find book by id
    public List<Book> findBook (int bookId){
        List<Book> id = new ArrayList<>(); // id cua book
        // duyet 
        for (Book book : catalog){
            // neu tim thay
            if (book.getISBN()== bookId){
                // add book 
                id.add(book);
            }
        }
        // tra ve 
        return id;
    }

    public List<Book> searchBookKeword(String keyword){
        List<Book> searchbook = new ArrayList<>();
        for (Book book : catalog){
            if (book.getAuthors().equals(keyword) || book.getPublisher().equals(keyword)|| book.getTitle().equals(keyword)){
                searchbook.add(book);
            }
        }
        return searchbook;
    }

    // method find member name
    public List<MemberAccount> searchMemberName (String keyWord){
        List<MemberAccount> member = new ArrayList<>();
        for (MemberAccount m : members){
            if (m.getFullname().equals(keyWord)){
                member.add(m);
            }
                
        }
        return member;
    }

    // method find member id 
    public List<MemberAccount> searchMemberID (int id){
        List<MemberAccount> member = new ArrayList<>();
        for (MemberAccount m : members){
            if (m.getAccountID() == id){
                member.add(m);
            }
        }
        return member;
    }

    public void createBookRequest (BookRequest request){
        requests.add(request);
        System.out.println("Phieu muon sach da duoc tao");
    }
    // Hiển thị danh sách sách đã được mượn
    public void displayBorrowedBooks() {
        System.out.println("Cac sach da cho muon:");
        for (Book book : catalog) {
            if (book.getStatus().equals("da muon")) {
                System.out.println("ISBN: " + book.getISBN() + ", De muc: " + book.getTitle());
            }
        }
    }
    /// Hiển thị danh sách sách có sẵn
    public void displayAvailableBooks() {
        System.out.println("Sach co san:");
        for (Book book : catalog) {
            if (book.getStatus().equals("co san")) {
                System.out.println("ISBN: " + book.getISBN() + ", De muc: " + book.getTitle());
            }
        }
    }
    // cap nhat trang thai của sách
    public void updateBookStatus(int ISBN, String newStatus) {
        for (Book book : catalog) {
            if (book.getISBN() == ISBN) {
                book.setStatus(newStatus);
                break;
            }
        }
    }

    public List<BookRequest> searchBookRequests(int number) {
        List<BookRequest> searchRequests = new ArrayList<>();
    
        for (BookRequest request : requests) {
            // Tìm kiếm theo mã mượn
            if (number == request.getBLcode()) {
                searchRequests.add(request);
            }
        }
    
        return searchRequests;
    }
}
