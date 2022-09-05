package DB;

import java.sql.Connection;
import java.time.LocalDate;

public interface DatabaseUpdates {
    void ChangeDates(Connection connection, LocalDate NewCheckOut, int ReservationNumber);

}
