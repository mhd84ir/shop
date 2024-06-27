public class User {
    private int ID;
    private String name ;
    private String address ;
    private String phoneNumber ;
    private String Email ;
    private String password ;
    private double credit ;
    private String userName ;
    //role: to know whether user is an admin or not
    private String role ;

    public void setID(int ID) {
        this.ID = ID;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setCredit(double credit) {
        this.credit = credit;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public int getID() {
        return ID;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getEmail() {
        return Email;
    }

    public String getPassword() {
        return password;
    }

    public double getCredit() {
        return credit;
    }

    public String getUserName() {
        return userName;
    }

    public String getRole() {
        return role;
    }

    public void addCredit(double creditAdded){
        double newCredit = getCredit() + creditAdded;
        setCredit(newCredit);
    }

    public void changePassword (String newPassword)
    {
        // در اینجا که در ادامه باید توسعه پیدا کنند بایید چک کند که آیا password صحیح است یا نه؟

        setPassword(newPassword);
    }


}
