package HotelRelated;

import Nonhotel.Host;

public class Room {
    private Host[] guests;
    private int RoomNumber;
    private int GuestCapacity;
    private int index = 0;
    private RoomStatus roomStatus;
    private String tier;

    public Room (int guestCapacity, int roomNumber, String tier)
    {
        setGuestCapacity(guestCapacity);
        setRoomNumber(roomNumber);
        setGuests(guestCapacity);
        setTier(tier);
    }

    public void setGuests(int guestCapacity) {
        this.guests = new Host[guestCapacity];
    }

    public void setGuestCapacity(int guestCapacity) {
        GuestCapacity = guestCapacity;
    }

    public void setRoomNumber(int roomNumber) {
        RoomNumber = roomNumber;
    }

    public void setTier(String tier) {
        this.tier = tier;
    }

    public String getTier() {
        return tier;
    }

    public int getGuestCapacity() {
        return GuestCapacity;
    }

    public void setRoomStatus(RoomStatus roomStatus) {
        this.roomStatus = roomStatus;
    }

    public void add_guest(Host host)
    {
        if(index != GuestCapacity)
        {
            guests[index] = host;
            index++;
        }
        else
            System.out.println("No se puede añadir más huespedes a esta habitación");
    }

    public int getRoomNumber() {
        return RoomNumber;
    }

    public String toString()
    {
        String roomstring =  "Room\t" + RoomNumber + "\nRoom Capacity\t" + GuestCapacity
                + "\nRoom type\t" + tier + "\nHuespedes dentro de este Cuarto\n";
        for( int i = 0; i < index; i++)
        {
            roomstring += "\n" + guests[i].toString() + "\n";
        }
        if(roomStatus == null)
            roomstring += "\nEstatus del Cuarto\tLIBRE";
        else
            roomstring += "\nEstatus del Cuarto\t" + roomStatus;
        return roomstring;
    }
}
