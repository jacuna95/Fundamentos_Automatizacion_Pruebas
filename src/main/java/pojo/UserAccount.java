package pojo;


public class UserAccount {
    private String email;
    private String password;
    private boolean validAccount;

    public UserAccount(String email, String password, boolean validAccount) {
        this.email = email;
        this.password = password;
        this.validAccount = validAccount;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean ValidAccount() {
        return validAccount;
    }

    public void setValidAccount(boolean validAccount) {
        this.validAccount = validAccount;
    }

}
