import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        LibraryManagementSystem librarySystem = new LibraryManagementSystem();

        // Khởi tạo danh mục sách
        List<Book> catalog = new ArrayList<>();
        librarySystem.setCatalog(catalog);

        // Thêm sách vào danh mục
        Book book1 = new Book(1, "Introduction to Java", "John Doe", 2022, "Publisher A", "co san");
        Book book2 = new Book(2, "Data Structures in Python", "Jane Smith", 2021, "Publisher B", "co san");
        Book book3 = new Book( 3,"Neu nhu chi con 1 ngay de song","An",2020, "NXB tre", "da muon");
        catalog.add(book1);
        catalog.add(book2);
        catalog.add(book3);

        // Hiển thị danh sách sách
        System.out.println("Danh muc thu vien:");
        for (Book book : catalog) {
            System.out.println("De muc: " + book.getTitle() + ", Tinh trang: " + book.getStatus());
        }
        // hien thi danh sách sách có sẵn và sách ko có sẵn
        librarySystem.displayAvailableBooks();
        librarySystem.displayBorrowedBooks();

        // tạo một số nhân viên thư viện
        LibrarianAccount librarian1 = new LibrarianAccount (1,"L","Ngoc","2004","09123","dat@", "hcm", "active","2021-9-9 ","married");
        // Tạo một số thành viên thư viện
        MemberAccount member1 = new MemberAccount(101, "M", "An", "2000-01-01", "123456789", "nhi@email.com", "123 thu duc", "active", "2022-01-01", 2);
        MemberAccount member2 = new MemberAccount(102, "M", "Khang", "1995-05-15", "987654321", "trung@email.com", "456 quan 9", "active", "2022-02-15", 1);
        
        // librarian find book 
        librarian1.findBookByISBN(librarySystem, 3);
        
        // Hiển thị thông tin thành viên
        System.out.println("\nThanh vien thu vien:");
        System.out.println("Thanh vien 1: " + member1.getFullname() + ", thoi han thanh vien: " + member1.getMembershipDate());
        System.out.println("Thanh vien 2: " + member2.getFullname() + ", thoi han thanh vien: " + member2.getMembershipDate());
        
        // tim sach
        member1.findBookISBN(librarySystem, 2);
        // Thành viên 1 mượn sách
        member1.requestBook(librarySystem);

        librarian1.findBookRequests(librarySystem, 1);
        
    }
}
