package project18;

import java.sql.Connection;

public class Ta18_9App {
	public static void main(String[]args) {
		
		Connection conn;	
		
		String nameDB = "Investigadores";
				
		String table1 = "facultad";
		String table2 = "investigadores";
		String table3 = "equipos";
		String table4 = "reserva";
				
		Ta18_9 ta18_9 = new Ta18_9();
					
		conn = ta18_9.conexio();
		
		ta18_9.createBD(conn, nameDB);
		
		ta18_9.createTable1(nameDB, table1);		
		ta18_9.createTable2(nameDB, table2);						
		ta18_9.createTable3(nameDB, table3);								
		ta18_9.createTable4(nameDB, table4);
		
		ta18_9.insertData1(nameDB, table1);	
		ta18_9.insertData2(nameDB, table2);	
		ta18_9.insertData3(nameDB, table3);
		ta18_9.insertData4(nameDB, table4);	
		
		ta18_9.closeConnection(conn);
		
	}
}
