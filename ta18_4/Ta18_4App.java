package project18;

import java.sql.Connection;

public class Ta18_4App {
public static void main(String[]args) {
		
		Connection conn;
		
		String nameDB = "peliculas_y_salas";
		String table1 = "peliculas";
		String table2 = "salas";		
				
		Ta18_4 ta18_4 = new Ta18_4();
					
		conn = ta18_4.conexio();
		
		ta18_4.createBD(conn, nameDB);
		ta18_4.createTable1(nameDB, table1);
		ta18_4.insertData(nameDB, table1);
		ta18_4.createTable2(nameDB, table2);						
		ta18_4.insertData2(nameDB, table2);		
		
		ta18_4.closeConnection(conn);
		
	}
}
