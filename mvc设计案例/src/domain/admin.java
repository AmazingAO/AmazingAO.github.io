package domain;

public class admin {
    private String user;
    private String password;

    public admin() {
    }

    public admin(String user, String password) {
        this.user = user;
        this.password = password;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "admin{" +
                "user='" + user + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
