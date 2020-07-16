package code.flatura.expendit.model;

import javax.persistence.*;
import java.util.Objects;

import static code.flatura.expendit.util.Util.START_SEQ;

@Entity
@Table(name = "consumable")
public class Consumable {//extends AbstractNamedEntity {

    @Id
    @SequenceGenerator(name = "consumable_seq", sequenceName = "consumable_seq", allocationSize = 1, initialValue = START_SEQ)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "consumable_seq")
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "contract")
    private String contract;

    @Column(name = "price")
    private Integer price;

    @Column(name = "consumable_model_id")
    private Integer consumableModelId;

    @Column(name = "status")
    private ConsumableStatus status;

    @Column(name = "room_id")
    private Integer roomId;

    public Consumable(String name, String contract, Integer price, Integer consumableModelId, ConsumableStatus status, Integer roomId) {
        this.name = name;
        this.contract = contract;
        this.price = price;
        this.consumableModelId = consumableModelId;
        this.status = status;
        this.roomId = roomId;
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

    public Integer getConsumableModelId() {
        return consumableModelId;
    }

    public void setConsumableModelId(Integer consumableModelId) {
        this.consumableModelId = consumableModelId;
    }

    public ConsumableStatus getStatus() {
        return status;
    }

    public void setStatus(ConsumableStatus status) {
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
