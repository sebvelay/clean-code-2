package smells.primitiveobsession;

import java.time.LocalDate;
import java.util.Set;

public interface Reservations {

    Set<Reservation> findReservations(Salle salle, LocalDate date);

}