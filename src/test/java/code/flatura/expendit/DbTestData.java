package code.flatura.expendit;

import code.flatura.expendit.model.*;

import java.time.Month;
import java.util.List;

import static java.time.LocalDate.of;
import static org.assertj.core.api.Assertions.assertThat;

public class DbTestData {
    //public static User USER1 = new User(0, "User1", "user1@yandex.ru", "1234", Role.ROLE_ADMIN);
    //public static User USER2 = new User(1, "User2", "user2@yandex.ru", "1234", Role.ROLE_USER);

    public static final Facility FACILITY1 = new Facility(0,"Facility1", "Address1", "Comments1");
    public static final Facility FACILITY2 = new Facility(1,"Facility2", "Address2", "Comments2");

    public static final Room ROOM1 = new Room(0, "Room1", 0, false, 0, "Comments1");
    public static final Room ROOM2 = new Room(1, "Room2", 0, true, 0, "Comments2");
    public static final Room ROOM3 = new Room(2, "Room2", 1, false, 1, "Comments3");
    public static final Room ROOM4 = new Room(3, "Room3", 2, true, 1, "Comments4");

    public static final ConsumableModel CONSUMABLE_MODEL1 = new ConsumableModel(0,"PN1", 0, 10000);
    public static final ConsumableModel CONSUMABLE_MODEL2 = new ConsumableModel(1,"PN2", 0, 14000);
    public static final ConsumableModel CONSUMABLE_MODEL3 = new ConsumableModel(2,"PN3", 1, 400);

    public static final Consumable CONSUMABLE1 = new Consumable(0,"Contract1", 700, 0, 0, 0,1);
    public static final Consumable CONSUMABLE2 = new Consumable(1,"Contract1", 700, 0, 0, 0,1);
    public static final Consumable CONSUMABLE3 = new Consumable(2,"Contract1", 700, 0, 0, 0,1);
    public static final Consumable CONSUMABLE4 = new Consumable(3,"Contract1", 700, 0, 0, 1,1);
    public static final Consumable CONSUMABLE5 = new Consumable(4,"Contract2", 400, 0, 1, 0,1);
    public static final Consumable CONSUMABLE6 = new Consumable(5,"Contract2", 400, 0, 1, 0,1);
    public static final Consumable CONSUMABLE7 = new Consumable(6,"Contract2", 600, 0, 0, 1,1);
    public static final Consumable CONSUMABLE8 = new Consumable(7,"Contract2", 600, 0, 1, 2,1);
    public static final Consumable CONSUMABLE9 = new Consumable(8,"Contract2", 500, 1, 2, 2,1);

    //public static final ConsumeFact FACT1 = new ConsumeFact(0, 3, 0, of(2019, Month.MAY, 30));
    //public static final ConsumeFact FACT2 = new ConsumeFact(0, 6, 0, of(2019, Month.MAY, 24));
    //public static final ConsumeFact FACT3 = new ConsumeFact(2, 7, 1, of(2019, Month.MAY, 30));


    //public static List<User> USERS = List.of(USER1, USER2);
    public static final List<Facility> FACILITIES = List.of(FACILITY1, FACILITY2);
    public static final List<Room> ROOMS = List.of(ROOM1, ROOM2, ROOM3, ROOM4);
    public static final List<ConsumableModel> CONSUMABLE_MODELS = List.of(CONSUMABLE_MODEL1, CONSUMABLE_MODEL2, CONSUMABLE_MODEL3);
    public static final List<Consumable> CONSUMABLES = List.of(CONSUMABLE1, CONSUMABLE2, CONSUMABLE3, CONSUMABLE4, CONSUMABLE5, CONSUMABLE6, CONSUMABLE7, CONSUMABLE8, CONSUMABLE9);
    //public static final List<ConsumeFact> FACTS = List.of(FACT1, FACT2, FACT3);

    public static <T> void assertMatch(T actual, T expected) {
        assertThat(actual).isEqualToIgnoringGivenFields(expected, "user");
    }

    public static <T> void assertMatch(Iterable<T> actual, T... expected) {
        assertMatch(actual, List.of(expected));
    }

    public static <T> void assertMatch(Iterable<T> actual, Iterable<T> expected) {
        assertThat(actual)
                .isInstanceOf(AbstractNamedEntity.class)
                .usingElementComparatorIgnoringFields("user")
                .isEqualTo(expected);
    }
}
