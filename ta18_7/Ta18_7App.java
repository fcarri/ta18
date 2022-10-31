package project18;

import java.sql.Connection;

public class Ta18_7App {
	public static void main(String[]args) {
		
		Connection conn;
		
		String nameDB = "Cientificos";
		String table1 = "cientificos";
		String table2 = "proyecto";
		String table3 = "asignado_a";
				
		Ta18_7 ta18_7 = new Ta18_7();
					
		conn = ta18_7.conexio();
		
		ta18_7.createBD(conn, nameDB);
		ta18_7.createTable1(nameDB, table1);
		ta18_7.insertData(nameDB, table1);
		ta18_7.createTable2(nameDB, table2);						
		ta18_7.insertData2(nameDB, table2);	
		ta18_7.createTable3(nameDB, table3);						
		ta18_7.insertData3(nameDB, table3);	
		
		ta18_7.closeConnection(conn);
		
	}
}
