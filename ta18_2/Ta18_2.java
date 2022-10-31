package project18;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Ta18_2 {		
	
	public Connection conn = null;
	
	public Ta18_2(){
		
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
			
			String Query = "CREATE TABLE "+name+" (CodigoD int not null, nombreD varchar(100), "
					+ "Presupuesto int, primary key(CodigoD))";
					
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
			
			String Query = "CREATE TABLE "+name+" (DNI varchar(8) not null, nombreE varchar(100),"
					+ "Apellidos varchar(255), Departamento int, primary key(DNI),"
					+ "foreign key(Departamento) references departamentos(CodigoD) on delete cascade "
					+ "on update cascade)";
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
			
			String Query = "INSERT INTO "+ table_name + " values (1,'A',120000),(2,'B',80000),(3,'C',10000),"
					+ "(4,'D',50000),(5,'E',20000)";
			
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
			
			String Query = "INSERT INTO "+ table_name + " values ('39000111','Albert','Rull Sabaté',1),"
					+"('39111000','Joe','Moore Teo',2),('4000222','Juan','Ferrer Rojo',3),"
					+ "('38000444','Roberto','Miralles Oró',4),"
					+ "('39777222','Cristina','Robles Rau',5)";
								
			Statement st=conn.createStatement();
			st.executeUpdate(Query);
			System.out.println("Datos insertados con exito");
			
		}catch(SQLException ex) {
			System.out.println(ex.getMessage());
			closeConnection(conn);
		}
	}
	
	
}



