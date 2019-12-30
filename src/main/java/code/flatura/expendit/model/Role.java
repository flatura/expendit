package code.flatura.expendit.model;

import java.util.Arrays;
import java.util.Optional;

public enum Role{
    /*
    USER("ROLE_USER"),
    ADMIN("ROLE_ADMIN"),
    VIEWER("ROLE_VIEWER");
*/
    USER("USER"),
    ADMIN("ADMIN"),
    VIEWER("VIEWER");

    private String text;

    Role(String text) {
        this.text = text;
    }

    public String getText() {
        return this.text;
    }

    public static Optional<Role> fromText(String text) {
        return  Arrays.stream(values())
                .filter(r -> r.text.equalsIgnoreCase(text))
                .findFirst();
    }
}

