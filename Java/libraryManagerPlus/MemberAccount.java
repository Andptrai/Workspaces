import java.util.List;
import java.util.Scanner;

public class MemberAccount extends Account {
    Scanner input = new Scanner(System.in);
    private String membershipDate;
    private int nBooks;

    public MemberAccount (int accountID, String accountType,String fullname, 
                        String dob, String phone, String email, String address, String status, String membershipDate, int nBooks) {
        super (accountID, accountType, fullname, dob, phone,email,address, status);
        this.nBooks = nBooks;
        this.membershipDate = membershipDate;
    }
    public String getMembershipDate() {
        return membershipDate;
    }

    public void setMembershipDate(String membershipDate) {
        this.membershipDate = membershipDate;
    }

    public int getnBooks() {
        return nBooks;
    }

    public void setnBooks(int nBooks) {
        this.nBooks = nBooks;
    }
    // find by id
    public void findBookISBN (LibraryManagementSystem manager, int id){
        List<Book> find = manager.findBook(id);
        if (find.isEmpty()){
            System.out.println("Khong tim thay sach dua theo ISBN .");
        }else{
            System.out.println("Da tim thay sach:");
            for (Book book : find){
                System.out.println(book.getTitle());
            }
            System.out.println("Thanh cong");
        }
    }
    // find by others
    public void findBook (LibraryManagementSystem manager, String keyword){
        List<Book> find = manager.searchBookKeword(keyword);
        if (find.isEmpty()){
            System.out.println("Khong tim thay sach dua theo tu khoa.");
        }else {
            System.out.println("Da tim thay sach:");
            for (Book book : find){
                System.out.println(book.getTitle());
            }
            System.out.println("Thanh cong");
        }
    }
    public void requestBook(LibraryManagementSystem manager){
        // Hiển thị danh sách sách trong catalog để thành viên chọn
        System.out.println("Sach co san trong danh muc:");
        manager.displayAvailableBooks();

        // Nhập ISBN của sách cần mượn từ thành viên
        System.out.print("Nhap ISBN cua cuon sach ban muon: ");
        int requestedISBN = input.nextInt();
        
        // Nhập thông tin cho BookRequest từ thành viên
        System.out.print("Nhap BLcode: ");
        int newBLcode = input.nextInt();
        input.nextLine(); // Consume the newline character
    
        System.out.print("Nhap ngay den han (yyyy-MM-dd): ");
        String newdueDate = input.nextLine();

    // Create a BookRequest object
    BookRequest request = new BookRequest(newBLcode, this.getAccountID(), requestedISBN, newdueDate,null);
    manager.createBookRequest(request);
    System.out.print("Muon thanh cong!! ");

    this.updateBookStatus(manager,requestedISBN,"da muon");
    }
    // Cập nhật số sách đã mượn
    public void updateNBooks(int increment) {
        this.nBooks += increment;
    }

    // Cập nhật trạng thái của sách
    public void updateBookStatus(LibraryManagementSystem manager, int ISBN, String newStatus) {
        manager.updateBookStatus(ISBN, newStatus);
    }

}
