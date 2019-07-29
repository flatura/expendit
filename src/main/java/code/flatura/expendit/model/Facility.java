package code.flatura.expendit.model;

import javax.persistence.*;

import java.util.Objects;

import static code.flatura.expendit.util.Util.START_SEQ;

@Entity
@Table(name = "facility")
public class Facility extends AbstractNamedEntity {

    @Id
    @SequenceGenerator(name = "facility_seq", sequenceName = "facility_seq", allocationSize = 1, initialValue = START_SEQ)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "facility_seq")
    private Integer id;

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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Facility{" +
                "title='" + title + '\'' +
                ", address='" + address + '\'' +
                ", comments='" + comments + '\'' +
                "} " + super.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Facility facility = (Facility) o;
        return id.equals(facility.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), id);
    }
}
