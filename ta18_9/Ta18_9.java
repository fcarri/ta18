package project18;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Ta18_9 {		
	
	public Connection conn = null;
	
	public Ta18_9(){
		
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
			
			String Query = "CREATE TABLE "+name+" (codigo int not null, nomapels varchar(255),"
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
			
			String Query = "CREATE TABLE "+name+" (dni varchar(8) not null, nomapels varchar(255),"
					+ "facultad int, primary key(dni),"
					+ "foreign key(facultad) references facultad(codigo)"
					+ "on delete cascade on update cascade"
					+ ")";
				
				
			Statement st=conn.createStatement();
			st.executeUpdate(Query);
			System.out.println("Tabla creada con exito");
			
		}catch(SQLException ex) {
			
			System.out.println(ex.getMessage());
			System.out.println("Error creando tabla");
			closeConnection(conn);
			
		}
	}			
	
	public void createTable3(String db,String name) {
		try {
			
			
			String Querydb = "USE "+db+";";
			Statement stdb = conn.createStatement();
			stdb.executeUpdate(Querydb);
			
			String Query = "CREATE TABLE "+name+" (numserie char(4), nombre varchar(4), facultad int,"
					+ "primary key(numserie),"
					+ "foreign key(facultad) references facultad(codigo)"
					+ "on delete cascade on update cascade"
					+ ")";
					
			Statement st=conn.createStatement();
			st.executeUpdate(Query);
			System.out.println("Tabla creada con exito");
			
		}catch(SQLException ex) {
			
			System.out.println(ex.getMessage());
			System.out.println("Error creando tabla");
			closeConnection(conn);
			
		}
	}
	
	public void createTable4(String db,String name) {
		try {
			
			
			String Querydb = "USE "+db+";";
			Statement stdb = conn.createStatement();
			stdb.executeUpdate(Querydb);
			
			String Query = "CREATE TABLE "+name+" (dni varchar(8) not null, numserie char(4) not null,"
					+ "comienzo datetime, fin datetime,"
					+ "primary key(dni,numserie),"
					+ "foreign key(dni) references investigadores(dni)"
					+ "on delete cascade on update cascade,"
					+ "foreign key(numserie) references equipos(numserie)"
					+ "on delete cascade on update cascade"
					+ ")";
					
			Statement st=conn.createStatement();
			st.executeUpdate(Query);
			System.out.println("Tabla creada con exito");
			
		}catch(SQLException ex) {
			
			System.out.println(ex.getMessage());
			System.out.println("Error creando tabla");
			closeConnection(conn);
			
		}
	}
	
	public void insertData1 (String db, String table_name) {
		
		try {
			String Querydb = "USE "+db+";";
			Statement stdb=conn.createStatement();
			stdb.executeUpdate(Querydb);
			
			String Query = "INSERT INTO "+ table_name + " values (1,'Fisica'),"
					+ "(2,'Informática'),"
					+ "(3,'Química'),"
					+ "(4,'Matemáticas'),"
					+ "(5,'Geologia')";
			
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
			
			String Query = "INSERT INTO "+ table_name + " values ('39712990','Joan Dalmau',1),"
					+ "('40111222','Pere Ferrer',2),"
					+ "('38000111','Alberto Ruiz',3),('38999222','Ramón Itziar',4),"
					+ "('40888222','Carme Forcadell',5)";
								
			Statement st=conn.createStatement();
			st.executeUpdate(Query);
			System.out.println("Datos insertados con exito");
			
		}catch(SQLException ex) {
			System.out.println(ex.getMessage());
			closeConnection(conn);
		}
	}
	
	public void insertData3 (String db, String table_name) {
		
		try {
			String Querydb = "USE "+db+";";
			Statement stdb=conn.createStatement();
			stdb.executeUpdate(Querydb);
			
			String Query = "INSERT INTO "+ table_name + " values ('0001','A',1),('0002','B',2),"
					+ "('0003','C',3),('0004','D',4),('0005','D',5)";
								
			Statement st=conn.createStatement();
			st.executeUpdate(Query);
			System.out.println("Datos insertados con exito");
			
		}catch(SQLException ex) {
			System.out.println(ex.getMessage());
			closeConnection(conn);
		}
	}

	public void insertData4 (String db, String table_name) {
	
	try {
		String Querydb = "USE "+db+";";
		Statement stdb=conn.createStatement();
		stdb.executeUpdate(Querydb);
		
		String Query = "INSERT INTO "+ table_name + " values "
				+ "('39712990','0001','2020-4-1','2020-8-2'),"
				+ "('40111222','0002','2020-4-2','2020-6-2'),"
				+ "('38000111','0003','2020-5-1','2020-6-1'),"
				+ "('38999222','0004','2020-6-1','2020-7-1'),"
				+ "('40888222','0005','2020-7-1','2020-8-1')";
							
		Statement st=conn.createStatement();
		st.executeUpdate(Query);
		System.out.println("Datos insertados con exito");
		
	}catch(SQLException ex) {
		System.out.println(ex.getMessage());
		closeConnection(conn);
	}
}
	
	
	
	
}



