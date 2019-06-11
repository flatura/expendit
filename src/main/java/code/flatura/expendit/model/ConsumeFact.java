package code.flatura.expendit.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDate;

@Entity
@Table(name = "consume_fact")
public class ConsumeFact extends AbstractBaseEntity {

    @Column(name = "room_id", nullable = false)
    private Integer roomId;

    @Column(name = "consumable_id", nullable = false)
    private Integer consumableId;

    @Column(name = "consumable_model_id", nullable = false)
    private Integer consumableModelId;

    @Column(name = "date", nullable = false)
    private LocalDate date;

    public ConsumeFact(Integer roomId, Integer consumableId, Integer consumableModelId, LocalDate date) {
        this.roomId = roomId;
        this.consumableId = consumableId;
        this.consumableModelId = consumableModelId;
        this.date = date;
    }

    public Integer getRoomId() {
        return roomId;
    }

    public void setRoomId(Integer roomId) {
        this.roomId = roomId;
    }

    public Integer getConsumableId() {
        return consumableId;
    }

    public void setConsumableId(Integer consumableId) {
        this.consumableId = consumableId;
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

    public void setDate(LocalDate date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "ConsumeFact{" +
                "roomId=" + roomId +
                ", consumableId=" + consumableId +
                ", consumableModelId=" + consumableModelId +
                ", date=" + date +
                "} " + super.toString();
    }
}
