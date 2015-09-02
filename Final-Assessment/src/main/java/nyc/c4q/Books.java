package nyc.c4q;

/**
 * Created by sufeizhao on 8/30/15.
 */
public class Books {

    private int id, publishyear, checkedoutby, checkedoutdateyear, checkedoutdatemonth, checkedoutdateday,
    duedateyear, duedatemonth, duedateday;
    private String title, author, isbn, isbn13, publisher;
    private boolean checkedout;

    public Books(int id, String title, String author, String isbn, String isbn13, String publisher, int publishyear, boolean checkedout) {
        this.author = author;
        this.id = id;
        this.isbn13 = isbn13;
        this.isbn = isbn;
        this.publisher = publisher;
        this.publishyear = publishyear;
        this.title = title;
        this.checkedout = checkedout;
    }

    public Books(int id, String title, String author, String isbn, String isbn13, String publisher, int publishyear, boolean checkedout, int checkedoutby, int checkedoutdateyear, int checkedoutdatemonth, int checkedoutdateday, int duedateyear, int duedatemonth, int duedateday) {
        this.author = author;
        this.checkedout = checkedout;
        this.checkedoutby = checkedoutby;
        this.checkedoutdateday = checkedoutdateday;
        this.checkedoutdatemonth = checkedoutdatemonth;
        this.checkedoutdateyear = checkedoutdateyear;
        this.duedateday = duedateday;
        this.duedatemonth = duedatemonth;
        this.duedateyear = duedateyear;
        this.id = id;
        this.isbn13 = isbn13;
        this.isbn = isbn;
        this.publisher = publisher;
        this.publishyear = publishyear;
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIsbn13() {
        return isbn13;
    }

    public void setIsbn13(String isbn13) {
        this.isbn13 = isbn13;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public int getPublishyear() {
        return publishyear;
    }

    public void setPublishyear(int publishyear) {
        this.publishyear = publishyear;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getCheckedoutby() {
        return checkedoutby;
    }

    public void setCheckedoutby(int checkedoutby) {
        this.checkedoutby = checkedoutby;
    }

    public int getCheckedoutdateday() {
        return checkedoutdateday;
    }

    public void setCheckedoutdateday(int checkedoutdateday) {
        this.checkedoutdateday = checkedoutdateday;
    }

    public int getCheckedoutdatemonth() {
        return checkedoutdatemonth;
    }

    public void setCheckedoutdatemonth(int checkedoutdatemonth) {
        this.checkedoutdatemonth = checkedoutdatemonth;
    }

    public int getCheckedoutdateyear() {
        return checkedoutdateyear;
    }

    public void setCheckedoutdateyear(int checkedoutdateyear) {
        this.checkedoutdateyear = checkedoutdateyear;
    }

    public int getDuedateday() {
        return duedateday;
    }

    public void setDuedateday(int duedateday) {
        this.duedateday = duedateday;
    }

    public int getDuedatemonth() {
        return duedatemonth;
    }

    public void setDuedatemonth(int duedatemonth) {
        this.duedatemonth = duedatemonth;
    }

    public int getDuedateyear() {
        return duedateyear;
    }

    public void setDuedateyear(int duedateyear) {
        this.duedateyear = duedateyear;
    }

    public boolean isCheckedout() {

        return checkedout;
    }

    public void setCheckedout(boolean checkedout) {
        this.checkedout = checkedout;
    }
}
