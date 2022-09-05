package HotelRelated;

public enum MemberType {
    VIP("VIP"), PLATINO("Platino"), GOLD("Gold");
    private final String MemberTypeName;
    MemberType(String string)
    {
        MemberTypeName = string;
    }
    public String toString()
    {
        return MemberTypeName;
    }

}
