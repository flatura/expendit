package code.flatura.expendit.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "facility")
public class Facility extends AbstractBaseEntity {

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "address", nullable = false, unique = true)
    private String address;

    @Column(name = "comments")
    private String comments;

    public Facility(String title, String address, String comments) {
        this.title = title;
        this.address = address;
        this.comments = comments;
    }

    public Facility() {
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
