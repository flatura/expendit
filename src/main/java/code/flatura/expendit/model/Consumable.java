package code.flatura.expendit.model;

import javax.persistence.*;
import java.util.Objects;

import static code.flatura.expendit.util.Util.START_SEQ;

@Entity
@Table(name = "consumable")
public class Consumable extends AbstractNamedEntity {

    @Id
    @SequenceGenerator(name = "consumable_seq", sequenceName = "consumable_seq", allocationSize = 1, initialValue = START_SEQ)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "consumable_seq")
    private Integer id;

    @Column(name = "contract")
    private String contract;

    @Column(name = "price")
    private Integer price;

    @Column(name = "consumable_model_id")
    private Integer consumableTypeId;

    @Column(name = "consumable_type_id")
    private Integer consumableModelId;

    @Column(name = "status")
    private Integer status;

    @Column(name = "room_id")
    private Integer roomId;

    public Consumable(String contract, Integer price, Integer consumableTypeId, Integer consumableModelId, Integer status, Integer roomId) {
        this.contract = contract;
        this.price = price;
        this.consumableTypeId = consumableTypeId;
        this.consumableModelId = consumableModelId;
        this.status = status;
        this.roomId = roomId;
    }

    public Consumable(int id, String contract, Integer price, Integer consumableTypeId, Integer consumableModelId, Integer status, Integer roomId) {
        this(contract, price, consumableTypeId, consumableModelId, status, roomId);
        this.id = id;
    }

    public Consumable() {
    }

    public String getContract() {
        return contract;
    }

    public void setContract(String contract) {
        this.contract = contract;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getConsumableTypeId() {
        return consumableTypeId;
    }

    public void setConsumableTypeId(Integer consumableTypeId) {
        this.consumableTypeId = consumableTypeId;
    }

    public Integer getConsumableModelId() {
        return consumableModelId;
    }

    public void setConsumableModelId(Integer consumableModelId) {
        this.consumableModelId = consumableModelId;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getRoomId() {
        return roomId;
    }

    public void setRoomId(Integer roomId) {
        this.roomId = roomId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Consumable that = (Consumable) o;
        return id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
