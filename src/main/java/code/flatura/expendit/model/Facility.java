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

    @Column(name = "address", nullable = false, unique = true)
    private String address;

    @Column(name = "comments")
    private String comments;

    public Facility(String name, String address, String comments) {
        this.name = name;
        this.address = address;
        this.comments = comments;
    }

    public Facility(int id, String name, String address, String comments) {
        this(name, address, comments);
        this.id = id;
    }

    public Facility() {
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
}
