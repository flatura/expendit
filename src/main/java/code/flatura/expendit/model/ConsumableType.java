package code.flatura.expendit.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "consumable_type")
public class ConsumableType extends AbstractNamedEntity {

    @Column(name = "comments")
    private String comments;

    public ConsumableType(String comments) {
        this.comments = comments;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    @Override
    public String toString() {
        return "ConsumableType{" +
                "comments='" + comments + '\'' +
                "} " + super.toString();
    }
}
