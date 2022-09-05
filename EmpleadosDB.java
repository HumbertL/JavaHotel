package Nonhotel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class EmpleadosDB {

	public static void AñadirEmpleado(Connection database,String nombre,String area,double salario)throws Exception {
		try {
			PreparedStatement preparedStatement = database.prepareStatement("INSERT INTO empleados (Nombre_empleado,Area_de_trabajo,salario,Estatus) values (?,?,?,?)");
			preparedStatement.setString(1, nombre);
            preparedStatement.setString(2, area);
            preparedStatement.setDouble(3, salario);
            preparedStatement.setString(4, "ACTIVO");
            preparedStatement.executeUpdate();
           JOptionPane.showMessageDialog(null,"Success", "Empleado añadido", JOptionPane.INFORMATION_MESSAGE);
		}
		catch(SQLException e){
			JOptionPane.showMessageDialog(null,"Error", "Algo salio mal, verifique sus datos", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	public static void ModificarArea(Connection database,int ID,String area)throws Exception{
		try {
			PreparedStatement preparedStatement = database.prepareStatement("UPDATE empleados SET Area_de_trabajo = ? WHERE empleadoID = ?");
			preparedStatement.setString(1, area);
			preparedStatement.setInt(2, ID);
			preparedStatement.executeUpdate();
			JOptionPane.showMessageDialog(null,"Success", "Cambio de area registrado", JOptionPane.INFORMATION_MESSAGE);
		}
		catch (SQLException e) {
			JOptionPane.showMessageDialog(null,"Error", "No existe dicho empleado", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	public static void DarDeBaja(Connection database,int ID)throws Exception{
		try {
			PreparedStatement preparedStatement = database.prepareStatement("DELETE FROM empleados WHERE empleadoID = ?");
			preparedStatement.setInt(1, ID);
			preparedStatement.executeUpdate();
			JOptionPane.showMessageDialog(null,"Success", "Empleado eliminado", JOptionPane.INFORMATION_MESSAGE);
		}
		catch (SQLException e) {
			JOptionPane.showMessageDialog(null,"Error", "No existe dicho empleado", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	public static void CambiarSalario(Connection database,int ID,double Salario)throws Exception {
		try {
			PreparedStatement preparedStatement = database.prepareStatement("UPDATE empleados SET salario = ? WHERE empleadoID = ?");
			preparedStatement.setDouble(1, Salario);
			preparedStatement.setInt(2, ID);
			preparedStatement.executeUpdate();
			JOptionPane.showMessageDialog(null,"Success", "Cambio de salario registrado", JOptionPane.INFORMATION_MESSAGE);
		}
		catch (SQLException e){
			JOptionPane.showMessageDialog(null,"Error", "Algo salio mal, revise sus datos", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	public static void Vacaciones(Connection database,int ID,String estatus) {
		try {
			PreparedStatement preparedStatement = database.prepareStatement("UPDATE empleados SET Estatus = ? WHERE empleadoID = ?");
			preparedStatement.setString(1, estatus);
			preparedStatement.setInt(2, ID);
			preparedStatement.executeUpdate();
			JOptionPane.showMessageDialog(null,"Success", "Cambio de estatus registrado", JOptionPane.INFORMATION_MESSAGE);
		}
		catch (SQLException e){
			JOptionPane.showMessageDialog(null,"Error", "No existe dicho empleado", JOptionPane.ERROR_MESSAGE);
		}
	}
}
