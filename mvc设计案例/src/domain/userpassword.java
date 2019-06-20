package domain;

public class userpassword {
    private String phone;
    private String  password;

    public userpassword(String phone, String password) {
        this.phone = phone;
        this.password = password;
    }

    public userpassword() {
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "userpassword{" +
                "phone=" + phone +
                ", password='" + password + '\'' +
                '}';
    }
}
