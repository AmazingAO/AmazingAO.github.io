package JDBC.练习;

public class test1Student {
    private String name;
    private String email;
    private String birth;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getBirth() {
        return birth;
    }

    public void setBirth(String birth) {
        this.birth = birth;
    }

    @Override
    public String toString() {
        return "test1Student{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", birth='" + birth + '\'' +
                '}';
    }

    public test1Student(String name, String email, String birth) {
        this.name = name;
        this.email = email;
        this.birth = birth;
    }

    public test1Student() {
        super();
    }
}
