package DB;

import HotelRelated.Reservacion;
import Nonhotel.Host;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.*;
import java.time.LocalDate;
import java.time.ZoneId;

public class JavaDataBase {

    private static final String addgueststmt = "INSERT INTO hosts (HostName, MemberType, Room, Entrada, Salida, ID_Compra) values (?, ?, ?,  ?, ?, ?)";
    private static final String search_guest = "SELECT * from hoststesttable where testname = ?";
    private static final String reservation_add = "INSERT INTO Reservations (ReservationID, ReservationName, Invitados, RoomNumber,  EntryDate, ExitDate, ActiveStatus, capacityAvailable) VALUES (?, ?, ?, ?, ?, ?, true, ?)";
    private static final String getReservation = "SELECT ReservationID, ReservationName, Invitados, RoomNumber, EntryDate, ExitDate from Reservations where ReservationName = ? and ActiveStatus = true";
    private static final String UpdateToOccupied = "UPDATE rooms SET Status_USO = ? WHERE idRooms = ?";
    private static final String CheckOutReservation = "DELETE FROM Reservations WHERE ReservationID = ?";
    private static final String CheckOutGuests = "DELETE FROM hosts WHERE Id_Compra = ?";


    public static Connection getConnection() throws Exception {
        try {
            String driver = "com.mysql.jdbc.Driver";
            String url = "jdbc:mysql://localhost:3306/hoteldb";
            Class.forName(driver);
            String user = "root";
            String password = "SQLslayer666!";
            Connection conn = DriverManager.getConnection(url,user,password);
            System.out.println("Connection Successful!");
            return conn;
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
        return null;
    }

    public static void Add_Guest (Connection connection, Host host) throws SQLException {
        try {
            System.out.println("Inserting..."); //Insertar Huesped en la base de ddatos
            PreparedStatement preparedStatement = connection.prepareStatement(addgueststmt);
            preparedStatement.setString(1, host.getNombre()); //se pasan los parametros segun el orden de las columnas SQL
            preparedStatement.setString(2, host.getMembershiptype());
            preparedStatement.setInt(3, host.getROOM());
            preparedStatement.setDate(4, Date.valueOf(host.getEntrydate()) );
            preparedStatement.setDate(5, Date.valueOf(host.getExitdate()));
            preparedStatement.setInt(6, host.getreservationID());
            preparedStatement.executeUpdate();
        }
        catch (SQLException e) {
            System.out.println(e);
        }

    }

    public static void Add_Reservation (Connection connection, Reservacion reservacion)
    {
        try {
            System.out.println("Adding Reservation...");
            PreparedStatement preparedStatement = connection.prepareStatement(reservation_add);
            preparedStatement.setInt(1, reservacion.getReservationNumber());
            preparedStatement.setString(2, reservacion.getReservationName());
            preparedStatement.setInt(4, reservacion.getRoomNumber());
            preparedStatement.setInt(3, reservacion.getHostsNumber());
            preparedStatement.setDate(5,Date.valueOf(reservacion.getBegin()));
            preparedStatement.setDate(6, Date.valueOf(reservacion.getEnd()));
            preparedStatement.setInt(7,reservacion.getHostsNumber());
            preparedStatement.executeUpdate();
        }
        catch (SQLException e)
        {
            System.out.println(e);
        }
    }

    public static int getcapacityAvailable( int ReservationNumber)
    {
        Connection connection = null;
        try {
            connection = getConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
        int integer = -1;
        try
        {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT capacityAvailable from Reservations where ReservationID = ?");
            preparedStatement.setInt(1, ReservationNumber);
            preparedStatement.executeQuery();
            ResultSet rs = preparedStatement.executeQuery();
            if(rs.next())
                integer = rs.getInt(1);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return integer;
    }

    public static void reduceCapacity(Connection connection, int ReservationNumber, int integer)
    {
        try {
            PreparedStatement statement = connection.prepareStatement("  UPDATE Reservations SET capacityAvailable = ? WHERE ReservationID = ? ");
            statement.setInt(1, integer);
            statement.setInt(2, ReservationNumber);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }


    public static void ReservationChangeCheckOut(Connection connection, LocalDate NewCheckOut, int ReservationNumber)
    {
        try
        {
            PreparedStatement preparedStatement = connection.prepareStatement( "UPDATE reservations SET ExitDate = ? where ReservationID = ?");
            preparedStatement.setDate(1, Date.valueOf(NewCheckOut));
            preparedStatement.setInt(2, ReservationNumber);
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static void ChangeHostsDates(Connection connection,LocalDate NewCheckOut, int ReservationNumber)
    {
        try
        {
            PreparedStatement preparedStatement = connection.prepareStatement( "UPDATE hosts SET Salida = ? where ID_COMPRA = ?");
            preparedStatement.setDate(1, Date.valueOf(NewCheckOut));
            preparedStatement.setInt(2, ReservationNumber);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void ResetRoom(Connection connection, int roomnumber)
    {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(UpdateToOccupied);
            preparedStatement.setString(1, "VACIO");
            preparedStatement.setInt(2, roomnumber);
            System.out.println("Resetting...");
            preparedStatement.executeUpdate();
            PreparedStatement statement = connection.prepareStatement("  UPDATE rooms SET RoomStatus = null WHERE idRooms = ?");
            statement.setInt(1, roomnumber);
            statement.executeUpdate();
            PreparedStatement finalstatement = connection.prepareStatement("UPDATE rooms SET Huesped = NULL WHERE idRooms = ?");
            finalstatement.setInt(1, roomnumber);
            finalstatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void UpdateRoomOccupied(Connection connection, int roomnumber)
    {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(UpdateToOccupied);
            preparedStatement.setString(1, "OCUPADO");
            preparedStatement.setInt(2, roomnumber);
            System.out.println("Seting to OCCUPIED...");
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void SetRoomHost(Connection connection, int room,  String name)
    {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("UPDATE rooms SET Huesped = ? WHERE idRooms = ?");
            preparedStatement.setString(1,name);
            preparedStatement.setInt(2,room);
            System.out.println("Asignando host...");
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void CheckOutReservation(Connection connection, int ReservationID)
    {
        try {
            PreparedStatement statement = connection.prepareStatement(CheckOutReservation);
            statement.setInt(1,ReservationID);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
