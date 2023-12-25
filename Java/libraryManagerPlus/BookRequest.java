public class BookRequest {
    private int BLcode;
    private int memberID;
    private int ISBN;
    private String dueDate;
    private String returnedDate;

    public BookRequest(){};
    public BookRequest(int BLcode, int memberID, int ISBN, String dueDate, String returnedDate) {
        this.BLcode = BLcode;
        this.memberID = memberID;
        this.ISBN = ISBN;
        this.dueDate = dueDate;
        this.returnedDate = returnedDate;
    }
    
    public int getBLcode() {
        return BLcode;
    }

    public void setBLcode(int bLcode) {
        BLcode = bLcode;
    }
    public int getMemberID() {
        return memberID;
    }
    public void setMemberID(int memberID) {
        this.memberID = memberID;
    }
    public int getISBN() {
        return ISBN;
    }
    public void setISBN(int iSBN) {
        ISBN = iSBN;
    }
    public String getDueDate() {
        return dueDate;
    }
    public void setDueDate(String dueDate) {
        this.dueDate = dueDate;
    }
    public String getReturnedDate() {
        return returnedDate;
    }
    public void setReturnedDate(String returnedDate) {
        this.returnedDate = returnedDate;
    }

}
