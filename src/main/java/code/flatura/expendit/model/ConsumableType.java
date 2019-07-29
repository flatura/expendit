package code.flatura.expendit.model;

import javax.persistence.*;

import java.util.Objects;

import static code.flatura.expendit.util.Util.START_SEQ;

@Entity
@Table(name = "consumable_type")
public class ConsumableType extends AbstractNamedEntity {

    @Id
    @SequenceGenerator(name = "consumable_type_seq", sequenceName = "consumable_type_seq", allocationSize = 1, initialValue = START_SEQ)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "consumable_type_seq")
    private Integer id;

    @Column(name = "comments")
    private String comments;

    public ConsumableType(String comments) {
        this.comments = comments;
    }

    public ConsumableType() {
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
        return "ConsumableType{" +
                "comments='" + comments + '\'' +
                "} " + super.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ConsumableType that = (ConsumableType) o;
        return id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
