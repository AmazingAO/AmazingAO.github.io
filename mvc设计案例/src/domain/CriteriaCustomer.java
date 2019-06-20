package domain;

public class CriteriaCustomer {
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

    public CriteriaCustomer(String name, String location, String QQ, Integer number) {
        this.name = name;
        Location = location;
        this.QQ = QQ;
        this.number = number;
    }

    public CriteriaCustomer(String name, String location, String QQ) {
        this.name = name;
        Location = location;
        this.QQ = QQ;
    }

    public String getName() {
        if (name ==null){
            name="%%";
        }else {
            name="%"+name+"%";
        }
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        if (Location ==null){
            Location="%%";
        }else {
            Location="%"+Location+"%";
        }
        return Location;
    }

    public void setLocation(String location) {
        Location = location;
    }

    public String getQQ() {
        if (QQ ==null){
            QQ="%%";
        }else {
            QQ="%"+QQ+"%";
        }
        return QQ;
    }

    public void setQQ(String QQ) {
        this.QQ = QQ;
    }
}
