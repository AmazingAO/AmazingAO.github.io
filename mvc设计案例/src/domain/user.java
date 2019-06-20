package domain;

public class user {
    private String name;
    private String older;
    private String phone;
    private String password;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public user(String name, String older, String phone, String password) {
        this.name = name;
        this.older = older;
        this.phone = phone;
        this.password = password;
    }

    public user() {
    }

    public user(String name, String older, String phone) {
        this.name = name;
        this.older = older;
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOlder() {
        return older;
    }

    public void setOlder(String older) {
        this.older = older;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "user{" +
                "name='" + name + '\'' +
                ", older=" + older +
                ", phone=" + phone +
                '}';
    }
}
