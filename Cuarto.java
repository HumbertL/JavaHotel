package HotelRelated;

public enum Cuarto {
    SINGLE("Single"), SUITE ("Suite"), DOUBLE("Double"), KING("King"),
    QUEEN("Queen"), QUAD("Quad");
    private final String RoomTypeName;
    Cuarto(String string)
    {
        RoomTypeName = string;
    }
    public String toString()
    {
        return RoomTypeName;
    }
}
