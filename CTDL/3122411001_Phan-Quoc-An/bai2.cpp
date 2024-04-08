#include <iostream>
#include <fstream>
#include <string>

using namespace std;

// �?nh nghia c?u tr�c cho m?i cu?n s�ch
struct Book {
    string code;
    string title;
    string author;
    int year;
    int pages;
    Book* next;

    Book(string _code, string _title, string _author, int _year, int _pages) {
        code = _code;
        title = _title;
        author = _author;
        year = _year;
        pages = _pages;
        next = NULL;
    }
};

// Danh s�ch li�n k?t don ch?a c�c cu?n s�ch
class BookList {
private:
    Book* head;

public:
    BookList() : head(NULL) {}

    // Th�m m?t cu?n s�ch v�o cu?i danh s�ch
    void addBook(string code, string title, string author, int year, int pages) {
        Book* newBook = new Book(code, title, author, year, pages);
        if (!head) {
            head = newBook;
        } else {
            Book* temp = head;
            while (temp->next) {
                temp = temp->next;
            }
            temp->next = newBook;
        }
    }

    // In ra c�c cu?n s�ch c?a m?t t�c gi?
    void printBooksByAuthor(const string& author) {
        bool found = false;
        Book* temp = head;
        cout << "Cac cuon sach cua tac gia " << author << ":\n";
        while (temp) {
            if (temp->author == author) {
                found = true;
                cout << "Ma sach: " << temp->code << ", Ten sach: " << temp->title << ", Nam xuat ban: " << temp->year << ", So trang: " << temp->pages << endl;
            }
            temp = temp->next;
        }
        if (!found) {
            cout << "Khong tim thay cuon sach nao cua tac gia " << author << endl;
        }
    }

    // S?p x?p l?i c�c cu?n s�ch theo nam xu?t b?n v� s? trang
    void sortBooks() {
        if (!head || !head->next) return; // Danh s�ch r?ng ho?c ch? c� m?t ph?n t?, kh�ng c?n s?p x?p

        Book* current = head;
        while (current) {
            Book* minNode = current;
            Book* nextNode = current->next;
            while (nextNode) {
                if (nextNode->year < minNode->year || (nextNode->year == minNode->year && nextNode->pages < minNode->pages)) {
                    minNode = nextNode;
                }
                nextNode = nextNode->next;
            }
            swap(current->code, minNode->code);
            swap(current->title, minNode->title);
            swap(current->author, minNode->author);
            swap(current->year, minNode->year);
            swap(current->pages, minNode->pages);
            current = current->next;
        }
    }

    // X�a t?t c? s�ch c?a m?t t�c gi? kh?i danh s�ch
    void deleteBooksByAuthor(const string& author) {
        Book* current = head;
        Book* prev = NULL;
        while (current) {
            if (current->author == author) {
                if (current == head) {
                    head = current->next;
                    delete current;
                    current = head;
                } else {
                    prev->next = current->next;
                    delete current;
                    current = prev->next;
                }
            } else {
                prev = current;
                current = current->next;
            }
        }
    }

    // H?y danh s�ch li�n k?t, gi?i ph�ng b? nh?
    ~BookList() {
        Book* temp;
        while (head) {
            temp = head;
            head = head->next;
            delete temp;
        }
    }
};

// H�m d? d?c d? li?u t? file v� th�m c�c cu?n s�ch v�o danh s�ch
void readDataFromFile(BookList& books, const string& filename) {
    ifstream file(filename.c_str()); // Chuy?n t�n file th�nh m?t chu?i c.
    if (!file.is_open()) {
        cout << "Khong the mo file." << endl;
        return;
    }

    string code, title, author;
    int year, pages;
    while (file >> code >> ws && getline(file, title) && getline(file, author) && file >> year >> pages) {
        books.addBook(code, title, author, year, pages);
    }

    file.close();
}

int main() {
    BookList books;

    readDataFromFile(books, "book.txt");


    string author;
	cout << "Nhap ten tac gia de tim sach: ";
	getline(cin >> ws, author); // Lo?i b? d?u c�ch th?a tru?c khi nh?p v�o bi?n author


    books.printBooksByAuthor(author);

    books.sortBooks();

    cout << "Danh sach cuon sach sau khi sap xep:\n";
    books.printBooksByAuthor(author);

    string authorToDelete;
    cout << "Nhap ten tac gia de xoa sach: ";
    getline(cin, authorToDelete);

    books.deleteBooksByAuthor(authorToDelete);

    cout << "Danh sach cuon sach sau khi xoa sach cua tac gia " << authorToDelete << ":\n";
    books.printBooksByAuthor(author);

    return 0;
}

