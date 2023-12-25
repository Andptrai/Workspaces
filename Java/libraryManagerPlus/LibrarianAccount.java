import java.util.List;

public class LibrarianAccount extends Account{
    private String startingDate;
    private String married;

    public LibrarianAccount(int accountID, String accountType, String fullname, String dob, String phone,String email, String address ,String status,String startingDate, String married){
        super(accountID, accountType, fullname, dob, phone,email,address, status);
        this.startingDate = startingDate;
        this.married= married;
    }
    public String getStartingDate() {
        return startingDate;
    }

    public void setStartingDate(String startingDate) {
        this.startingDate = startingDate;
    }

    public String getMarried() {
        return married;
    }

    public void setMarried(String married) {
        this.married = married;
    }
    // libraian find book
    public void findBookByISBN (LibraryManagementSystem manager , int id){
        List<Book> find = manager.findBook(id);
        if (find.isEmpty()){
            System.out.println("Khon tim thay sach dua theo ISBN.");
        } else{
            System.out.println("Da tim thay sach:");
            for (Book book : find){
                System.out.println(book.getTitle());
            }
            System.out.println("Nhan vien tim thay");
        }
    }
    // librarian find book by name
    public void findMemberName(LibraryManagementSystem manager, String memberName){
        List<MemberAccount> members = manager.searchMemberName(memberName);
        if (members.isEmpty()){
            System.out.println("Khong thay thanh vien nao theo ten da cho.");
        }else {
            System.out.println("Tim thay thanh vien:");
            for (MemberAccount m : members ){
                System.out.println(m.getFullname());
            }
            System.out.println("Nhan vien tim thay ");
        }
    }
    // librarian find member by id account
    public void findMemberById(LibraryManagementSystem manager, int id){
        List<MemberAccount> members = manager.searchMemberID(id);
        if (members.isEmpty()){
            System.out.println("Khong thay thanh vien nao theo ID da cho.");
        }else {
            System.out.println ("Tim thay thanh vien: ");
            for (MemberAccount m : members){
                System.out.println(m.getFullname());
            }
            System.out.println("Nhan vien tim thay");
        }
    }
    public void findBookRequests(LibraryManagementSystem manager, int number) {
        List<BookRequest> bookRequests = manager.searchBookRequests(number);

        if (bookRequests.isEmpty()) {
            System.out.println("Khong thay phieu yeu cau theo tu khoa da cho");
        } else {
            System.out.println("Tim thay phieu yeu cau:");
            for (BookRequest request : bookRequests) {
                System.out.println("BLcode: " + request.getBLcode() +
                                   ", Member ID: " + request.getMemberID() +
                                   ", ISBN: " + request.getISBN() +
                                   ", Due Date: " + request.getDueDate());
            }
        }
    }
}
