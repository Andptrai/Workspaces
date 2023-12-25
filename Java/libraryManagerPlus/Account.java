public class Account {
    private int accountID;
    private String accountType;
    private String fullname;
    private String dob;
    private String phone;
    private String email;
    private String address;
    private String status;

    public Account (int accountID, String accountType, String fullname, String dob, String phone, String email, String address, String status) {
        this.accountID = accountID;
        this.accountType = accountType;
        this.fullname = fullname;
        this.dob = dob;
        this.phone = phone;
        this.email = email;
        this.address = address;
        this.status = status;
    }

    public int getAccountID() {
        return accountID;
    }
    public void setAccountID(int accountID) {
        this.accountID = accountID;
    }
    public String getAccountType() {
        return accountType;
    }
    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }
    public String getFullname() {
        return fullname;
    }
    public void setFullname(String fullname) {
        this.fullname = fullname;
    }
    public String getDob() {
        return dob;
    }
    public void setDob(String dob) {
        this.dob = dob;
    }
    public String getPhone() {
        return phone;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
}
