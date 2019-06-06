package code.flatura.expendit.model;

public class Facility extends AbstractBaseEntity {

    private String title;
    private String address;
    private String comments;

    public Facility(String title, String address, String comments) {
        this.title = title;
        this.address = address;
        this.comments = comments;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    @Override
    public String toString() {
        return "Facility{" +
                "title='" + title + '\'' +
                ", address='" + address + '\'' +
                ", comments='" + comments + '\'' +
                "} " + super.toString();
    }
}
