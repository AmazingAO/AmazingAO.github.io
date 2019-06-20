package domain;

public class borr {
    private int id;
    private String book;
    private String bookid;
    private String phone;
    private String img;
    private String action;

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public borr() {
    }

    public borr(int id, String book, String bookid, String phone, String img, String action) {
        this.id = id;
        this.book = book;
        this.bookid = bookid;
        this.phone = phone;
        this.img = img;
        this.action = action;
    }

    public borr(int id, String book, String bookid, String phone, String img) {
        this.id = id;
        this.book = book;
        this.bookid = bookid;
        this.phone = phone;
        this.img = img;
    }

    public borr(int id, String book, String bookid, String phone) {
        this.id = id;
        this.book = book;
        this.bookid = bookid;
        this.phone = phone;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBook() {
        return book;
    }

    public void setBook(String book) {
        this.book = book;
    }

    public String getBookid() {
        return bookid;
    }

    public void setBookid(String bookid) {
        this.bookid = bookid;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
