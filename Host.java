package Nonhotel;

import java.time.LocalDate;

public class Host {
    private int reservationID;
    private String nombre;
    private String membershiptype;
    private int ROOM;
    private LocalDate entrydate;
    private LocalDate exitdate;

    private boolean ISPRESENT;

    public Host()
    {

    }

    public Host(String nombre, String membershiptype, int ROOM, int reservationID, LocalDate entry, LocalDate exit)
    {
        setNombre(nombre);
        setreservationID(reservationID);
        setMembershiptype(membershiptype);
        setROOM(ROOM);
        setISPRESENT(true);
        setExitdate(exit);
        setEntrydate(entry);
    }

    private void checkin(int ROOM)
    {
        setROOM(ROOM);
    }

    public void setISPRESENT(boolean ISPRESENT) {
        this.ISPRESENT = ISPRESENT;
    }

    public void setEntrydate(LocalDate entrydate) {
        this.entrydate = entrydate;
    }

    public void setExitdate(LocalDate exitdate) {
        this.exitdate = exitdate;
    }

    public void setreservationID(int reservationID) {
        this.reservationID = reservationID;
    }

    public void setMembershiptype(String membershiptype) {
        this.membershiptype = membershiptype;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setROOM(int ROOM) {
        this.ROOM = ROOM;
    }

    public int getreservationID() {
        return reservationID;
    }

    public LocalDate getEntrydate() {
        return entrydate;
    }

    public LocalDate getExitdate() {
        return exitdate;
    }

    public int getROOM() {
        return ROOM;
    }

    public String getMembershiptype() {
        return membershiptype;
    }

    public String getNombre() {
        return nombre;
    }

    public boolean getisISPRESENT() {
        return ISPRESENT;
    }

    public String toString()
    {
        return "HOSTNAME: " + nombre + "\nMembership Type\t " + membershiptype + "\nMembership number\t" + reservationID + "\nRoom: " +ROOM
                + "\nIs present\t" + ISPRESENT
                +"\nEntry Date\t" + entrydate.toString()
                + "\nExit Date\t" + exitdate.toString();
    }
}
