package project18;

import java.sql.Connection;

public class Ta18_8App {
	public static void main(String[]args) {
		
		Connection conn;
		
		String nameDB = "Grandes_Almacenes";
		
		String table1 = "productos";
		String table2 = "cajeros";
		String table3 = "maquinas_regristadoras";
		String table4 = "venta";
				
		Ta18_8 ta18_8 = new Ta18_8();
					
		conn = ta18_8.conexio();
		
		ta18_8.createBD(conn, nameDB);
		ta18_8.createTable1(nameDB, table1);
		ta18_8.insertData(nameDB, table1);
		ta18_8.createTable2(nameDB, table2);						
		ta18_8.insertData2(nameDB, table2);	
		ta18_8.createTable3(nameDB, table3);						
		ta18_8.insertData3(nameDB, table3);	
		ta18_8.createTable4(nameDB, table4);						
		ta18_8.insertData4(nameDB, table4);	
		
		ta18_8.closeConnection(conn);
		
	}
}
