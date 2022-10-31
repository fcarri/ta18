package project18;

import java.sql.Connection;

public class Ta18_5App {
	public static void main(String[]args) {
		
		Connection conn;
		
		String nameDB = "peliculas_y_salas";
		String table1 = "peliculas";
		String table2 = "salas";		
				
		Ta18_5 ta18_5 = new Ta18_5();
					
		conn = ta18_5.conexio();
		
		ta18_5.createBD(conn, nameDB);
		ta18_5.createTable1(nameDB, table1);
		ta18_5.insertData(nameDB, table1);
		ta18_5.createTable2(nameDB, table2);						
		ta18_5.insertData2(nameDB, table2);		
		
		ta18_5.closeConnection(conn);
		
	}
}
