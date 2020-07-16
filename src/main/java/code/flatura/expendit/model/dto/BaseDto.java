package code.flatura.expendit.model.dto;

import java.io.Serializable;

public class BaseDto extends AbstractBaseDto implements Serializable {
    private final Integer id;
    private final String name;

    public BaseDto(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
