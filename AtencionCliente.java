package HotelRelated;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AtencionCliente {

    public static void MandarComida(Room room)
    {
        room.setRoomStatus(RoomStatus.COMIDA);
    }

    public static void ServicioAlCuarto(Room room)
    {
        room.setRoomStatus(RoomStatus.MANTENIMIENTO);
    }

    public static void Limpiar(Room room)
    {
        room.setRoomStatus(RoomStatus.LIMPIEZA);
    }

    public static void Mantenimiento(Room room)
    {
        room.setRoomStatus(RoomStatus.MANTENIMIENTO);
    }

    public static void Terminar(Room room)
    {
        room.setRoomStatus(null);
    }

    public static void MandarServicio(Connection conn, int room, String servicio) {
        try {
            PreparedStatement preparedStatement = conn.prepareStatement("UPDATE rooms SET RoomStatus = ? WHERE idRooms = ?");
            preparedStatement.setString(1, servicio);
            preparedStatement.setInt(2, room);
            preparedStatement.executeUpdate();
            JOptionPane.showMessageDialog(null, "Se ha enviado el servicio de " + servicio + " al cuarto", "Success", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error", "Algo salio mal", JOptionPane.ERROR_MESSAGE);
        }
    }
}
