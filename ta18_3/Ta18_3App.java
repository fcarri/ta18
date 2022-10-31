package project18;

import java.sql.Connection;

public class Ta18_3App {
	public static void main(String[]args) {
		
		Connection conn;
		
		String nameDB = "almacenes";
		String table1 = "almacenes";
		String table2 = "cajas";		
				
		Ta18_3 ta18_3 = new Ta18_3();
					
		conn = ta18_3.conexio();
		
		ta18_3.createBD(conn, nameDB);
		ta18_3.createTable1(nameDB, table1);
		ta18_3.insertData(nameDB, table1);
		ta18_3.createTable2(nameDB, table2);						
		ta18_3.insertData2(nameDB, table2);		
		
		ta18_3.closeConnection(conn);
		
	}
}
