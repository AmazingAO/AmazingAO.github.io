package JDBC.DBUtilsTest;

public class tushan {
    private int id;
    private String name;
    private int ord;

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

    public int getOrd() {
        return ord;
    }

    public void setOrd(int ord) {
        this.ord = ord;
    }

    public tushan(int id, String name, int ord) {
        this.id = id;
        this.name = name;
        this.ord = ord;
    }

    public tushan() {
        super();
    }

    @Override
    public String toString() {
        return "tushan{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", ord=" + ord +
                '}';
    }
}
