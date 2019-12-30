package code.flatura.expendit.model;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Objects;

import static code.flatura.expendit.util.Util.START_SEQ;

@Entity
@Table(name = "consume_fact")
public class ConsumeFact {

    @Id
    @SequenceGenerator(name = "consume_fact_seq", sequenceName = "consume_fact_seq", allocationSize = 1, initialValue = START_SEQ)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "consume_fact_seq")
    private Integer id;

    @Column(name = "room_id", nullable = false)
    private Integer roomId;

    @Column(name = "storage_id", nullable = false)
    private Integer storage_id;

    @Column(name = "consumable_id", nullable = false)
    private Integer consumableId;

    @Column(name = "consumable_model_id", nullable = false)
    private Integer consumableModelId;

    @Column(name = "date", nullable = false)
    private LocalDate date;

    public ConsumeFact(Integer roomId, Integer storage_id, Integer consumableId, Integer consumableModelId, LocalDate date) {
        this.roomId = roomId;
        this.storage_id = storage_id;
        this.consumableId = consumableId;
        this.consumableModelId = consumableModelId;
        this.date = date == null ? LocalDate.now() : date;
    }

    public ConsumeFact() {
    }

    public Integer getRoomId() {
        return roomId;
    }

    public Integer getConsumableId() {
        return consumableId;
    }

    public Integer getStorage_id() {
        return storage_id;
    }

    public Integer getConsumableModelId() {
        return consumableModelId;
    }

    public void setConsumableModelId(Integer consumableModelId) {
        this.consumableModelId = consumableModelId;
    }

    public LocalDate getDate() {
        return date;
    }

    public Integer getId() {
        return id;
    }

    @Override
    public String toString() {
        return "ConsumeFact{" +
                "roomId=" + roomId +
                ", storage_id=" + storage_id +
                ", consumableId=" + consumableId +
                ", consumableModelId=" + consumableModelId +
                ", date=" + date +
                "} " + super.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        ConsumeFact that = (ConsumeFact) o;
        return id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), id);
    }
}
