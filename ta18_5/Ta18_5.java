package project18;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Ta18_5 {		
	
	public Connection conn = null;
	
	public Ta18_5(){
		
	}
	
	public Connection conexio() {				
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn=DriverManager.getConnection("jdbc:mysql://192.168.1.77:"
					+ "3306?useTimezone=true&serverTimezoneUTC","remote","<FCSboot1972>");			
			System.out.print("Se ha conectado con la base de datos\n");   
			
		}catch(SQLException|ClassNotFoundException ex) {
			System.out.print("No se ha podido conectar con la base de datos\n");
			System.out.print(ex);
						
		}
		
		return conn;
	}
	
	public void closeConnection(Connection conn) {				
		
		try {
			conn.close();
			System.out.print("Conexion cerrada");
			
		}catch(SQLException ex){
			
			System.out.print("No se ha podido cerrar la conexion");
		}	
		
	}

	public void createBD(Connection conn, String nameDB) {
			
		try {
			
			String Query0 = "DROP DATABASE IF EXISTS "+nameDB+";";
			Statement st0=conn.createStatement();
			st0.executeUpdate(Query0);
			
			String Query = "CREATE DATABASE "+nameDB;
			Statement st = conn.createStatement();
			st.executeUpdate(Query);
			System.out.println("Base de datos creada.");
			
			
		}catch(SQLException ex) {
			Logger.getLogger(ta18_1App.class.getName()).log(Level.SEVERE,null,ex);
			System.out.println("No se ha podido crear la base de datos.");
			closeConnection(conn);
		}
		
	}
	
	public void createTable1(String db,String name) {
		try {
			
			
			String Querydb = "USE "+db+";";
			Statement stdb = conn.createStatement();
			stdb.executeUpdate(Querydb);
			
			String Query = "CREATE TABLE "+name+"(numero int not null, capacidad int, primary key(numero)) ";
				
			Statement st=conn.createStatement();
			st.executeUpdate(Query);
			System.out.println("Tabla creada con exito");
			
		}catch(SQLException ex) {
			
			System.out.println(ex.getMessage());
			System.out.println("Error creando tabla");
			closeConnection(conn);
			
		}
	}	
	
	public void createTable2(String db,String name) {
		try {
			
			
			String Querydb = "USE "+db+";";
			Statement stdb = conn.createStatement();
			stdb.executeUpdate(Querydb);
			
			String Query = "CREATE TABLE "+name+" (dni varchar(8) not null, nomapels varchar(255),"
					+ "key(dni), despacho int, primary key(dni),"
					+ "foreign key(dni) references directores(dni),foreign key(despacho) references despachos(numero)"
					+ "on delete cascade on update cascade"
					+ ") ";
			Statement st=conn.createStatement();
			st.executeUpdate(Query);
			System.out.println("Tabla creada con exito");
			
		}catch(SQLException ex) {
			
			System.out.println(ex.getMessage());
			System.out.println("Error creando tabla");
			closeConnection(conn);
			
		}
	}
	
	public void insertData (String db, String table_name) {
		
		try {
			String Querydb = "USE "+db+";";
			Statement stdb=conn.createStatement();
			stdb.executeUpdate(Querydb);
			
			String Query = "INSERT INTO "+ table_name + " values (1,18),"
					+ "(2,14),"
					+ "(3,16),"
					+ "(4,18),"
					+ "(5,10)";
			
			Statement st=conn.createStatement();
			st.executeUpdate(Query);
			System.out.println("Datos insertados con exito");
			
		}catch(SQLException ex) {
			System.out.println(ex.getMessage());
			closeConnection(conn);
		}
	}
	
	public void insertData2 (String db, String table_name) {
		
		try {
			String Querydb = "USE "+db+";";
			Statement stdb=conn.createStatement();
			stdb.executeUpdate(Querydb);
			
			String Query = "INSERT INTO "+ table_name + " values ('39888111','Clint Eastwood','39888111',1),"
					+"('40111222','Paul Newman',''40111222,2),('38000111','John Ford','38000111',3),"
					+ "('42000222','Robert Redford','42000222',4),"
					+ "('38444222','Morgan Freeman','38444222',5)";
								
			Statement st=conn.createStatement();
			st.executeUpdate(Query);
			System.out.println("Datos insertados con exito");
			
		}catch(SQLException ex) {
			System.out.println(ex.getMessage());
			closeConnection(conn);
		}
	}
	
	
}






