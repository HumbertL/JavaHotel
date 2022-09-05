package HotelRelated;

import java.time.LocalDate;

public class Reservacion {
    private static int reservationID = 0;
    private int ReservationNumber;
    private int RoomNumber;
    private String ReservationName;
    private LocalDate begin;
    private LocalDate end;
    private int HostsNumber;
    private boolean Active;

    public Reservacion( String reservationName ,int roomNumber, int ReservationNumber, int guests, LocalDate begin, LocalDate end)
    {
        setReservationName(reservationName);
        setReservationNumber(ReservationNumber);
        setRoomNumber(roomNumber);
        setHostsNumber(guests);
        setBegin(begin);
        setEnd(end);
        this.Active = true;

    }

    public void setHostsNumber(int hostsNumber) {
        HostsNumber = hostsNumber;
    }

    public void setBegin(LocalDate begin) {
        this.begin = begin;
    }

    public void setRoomNumber(int roomNumber) {
        RoomNumber = roomNumber;
    }

    public void setEnd(LocalDate end) {
        this.end = end;
    }

    public void setActive(boolean active) {
        Active = active;
    }

    public void setReservationName(String reservationName) {
        ReservationName = reservationName;
    }

    public void setReservationNumber(int reservationNumber) {
        ReservationNumber = reservationNumber;
    }

    public static void setReservationID(int reservationID) {
        Reservacion.reservationID = reservationID;
    }

    public int getRoomNumber() {
        return RoomNumber;
    }

    public int getReservationNumber() {
        return ReservationNumber;
    }

    public LocalDate getBegin() {
        return begin;
    }

    public LocalDate getEnd() {
        return end;
    }

    public String getReservationName() {
        return ReservationName;
    }

    public int getHostsNumber() {
        return HostsNumber;
    }

    public String toString()
    {
        return "Reservation Name\t" + ReservationName + "\nRoom\t" + RoomNumber
                + "\nEntry Date\t" + begin + "\nExit Date\t" + end;
    }
}

