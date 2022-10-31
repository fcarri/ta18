package project18;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Ta18_3 {		
	
	public Connection conn = null;
	
	public Ta18_3(){
		
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
			
			String Query = "CREATE TABLE "+name+" (codigo int not null, lugar varchar(100), "
					+ "capacidad int,"
					+ "primary key(codigo))";
					
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
			
			String Query = "CREATE TABLE "+name+" (numreferencia char(5) not null, contenido varchar(100), valor int,"
					+ "almacen int, primary key(numreferencia), foreign key(almacen) references almacenes(codigo)"
					+ "on delete cascade on update cascade)";
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
			
			String Query = "INSERT INTO "+ table_name + " values (1,'Barcelona',4),(2,'Munich',8),"
					+ "(3,'London',10),"
					+ "(4,'Paris',5),(5,'Prague',2)";
			
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
			
			String Query = "INSERT INTO "+ table_name + " values ('1','Camisa',20,1),"
					+"('2','Pantalon',40,2),('3','Zapatos',80,3),"
					+ "('4','Televisor',250,4),"
					+ "('5','Vajilla',120,5)";
								
			Statement st=conn.createStatement();
			st.executeUpdate(Query);
			System.out.println("Datos insertados con exito");
			
		}catch(SQLException ex) {
			System.out.println(ex.getMessage());
			closeConnection(conn);
		}
	}
	
	
}




