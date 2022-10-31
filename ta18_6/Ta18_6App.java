package project18;

import java.sql.Connection;

public class Ta18_6App {
	public static void main(String[]args) {
		
		Connection conn;
		
		String nameDB = "piezas_y_proveedores";
		String table1 = "piezas";
		String table2 = "proveedores";
		String table3 = "suministra";
				
		Ta18_6 ta18_6 = new Ta18_6();
					
		conn = ta18_6.conexio();
		
		ta18_6.createBD(conn, nameDB);
		ta18_6.createTable1(nameDB, table1);
		ta18_6.insertData(nameDB, table1);
		ta18_6.createTable2(nameDB, table2);						
		ta18_6.insertData2(nameDB, table2);	
		ta18_6.createTable3(nameDB, table3);						
		ta18_6.insertData3(nameDB, table3);	
		
		ta18_6.closeConnection(conn);
		
	}
}
