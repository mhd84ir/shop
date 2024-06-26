public class SignUp {
    private String userName;
    private String password;

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

    public boolean isValidUsername(String username) {
        // Username should be between 3 and 20 characters
        if (username.length() < 3 || username.length() > 20) {
            return false;
        }

        // Username should only contain alphanumeric characters and underscore
        if (!username.matches("^[a-zA-Z0-9_]*$")) {
            return false;
        }

        return true;
    }

    public boolean isValidPassword(String password) {
        // Password should be at least 8 characters long
        if (password.length() < 8) {
            return false;
        }

        // Password should contain at least one uppercase letter
        if (!password.matches(".*[A-Z].*")) {
            return false;
        }

        // Password should contain at least one lowercase letter
        if (!password.matches(".*[a-z].*")) {
            return false;
        }

        // Password should contain at least one digit
        if (!password.matches(".*\\d.*")) {
            return false;
        }

        return true;
    }




}
