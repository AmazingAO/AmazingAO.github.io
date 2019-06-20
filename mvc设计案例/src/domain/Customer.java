package domain;

public class Customer {
    private Integer id;
    private String name;
    private String Location;
    private String QQ;
    private Integer number;

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public Customer(Integer id, String name, String location, String QQ, Integer number) {
        this.id = id;
        this.name = name;
        Location = location;
        this.QQ = QQ;
        this.number = number;
    }

    public Customer() {
    }

    public Customer(int id, String name, String lacation, String QQ) {
        this.id = id;
        this.name = name;
        Location = lacation;
        this.QQ = QQ;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", Lacation='" + Location + '\'' +
                ", QQ='" + QQ + '\'' +
                '}';
    }

    public Customer(String name, String location, String QQ,Integer number) {
        this.name = name;
        Location = location;
        this.QQ = QQ;
        this.number = number;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return Location;
    }

    public void setLocation(String lacation) {
        Location = lacation;
    }

    public String getQQ() {
        return QQ;
    }

    public void setQQ(String QQ) {
        this.QQ = QQ;
    }
}
