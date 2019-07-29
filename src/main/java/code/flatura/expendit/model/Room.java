package code.flatura.expendit.model;

import javax.persistence.*;
import java.util.Objects;

import static code.flatura.expendit.util.Util.START_SEQ;

@Entity
@Table(name = "room", uniqueConstraints = {@UniqueConstraint(columnNames = {"title", "facility_id"}, name = "unique_room_idx")})
public class Room extends AbstractNamedEntity {

    @Id
    @SequenceGenerator(name = "room_seq", sequenceName = "room_seq", allocationSize = 1, initialValue = START_SEQ)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "room_seq")
    private Integer id;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "facility_id", nullable = false)
    private long facilityId;

    @Column(name = "storage", nullable = false)
    private boolean storage;

    @Column(name = "user_id", nullable = false)
    private Integer userId;

    @Column(name = "comments", nullable = false)
    private String comments;

    public Room(String title, long facilityId, boolean storage, Integer userId, String comments) {
        this.title = title;
        this.facilityId = facilityId;
        this.storage = storage;
        this.userId = userId;
        this.comments = comments;
    }

    public Room() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public long getFacilityId() {
        return facilityId;
    }

    public void setFacilityId(long facilityId) {
        this.facilityId = facilityId;
    }

    public boolean isStorage() {
        return storage;
    }

    public void setStorage(boolean storage) {
        this.storage = storage;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
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
        return "Room{" +
                "title='" + title + '\'' +
                ", facilityId=" + facilityId +
                ", storage=" + storage +
                ", userId=" + userId +
                ", comments='" + comments + '\'' +
                "} " + super.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Room room = (Room) o;
        return facilityId == room.facilityId &&
                title.equals(room.title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), title, facilityId);
    }
}
