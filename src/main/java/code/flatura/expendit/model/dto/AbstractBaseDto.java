package code.flatura.expendit.model.dto;

public abstract class AbstractBaseDto {
    protected Integer id;

    public AbstractBaseDto() {
    }

    public AbstractBaseDto(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
