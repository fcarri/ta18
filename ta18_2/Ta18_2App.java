package project18;

import java.sql.Connection;

public class Ta18_2App {
	public static void main(String[]args) {
		
		Connection conn;
		
		String nameDB = "Empleados";
		String table1 = "departamentos";
		String table2 = "empleados";
								
		Ta18_2 ta18_2 = new Ta18_2();
					
		conn = ta18_2.conexio();
		
		ta18_2.createBD(conn, nameDB);
		ta18_2.createTable1(nameDB, table1);
		ta18_2.insertData(nameDB, table1);
		ta18_2.createTable2(nameDB, table2);						
		ta18_2.insertData2(nameDB, table2);		
		
		ta18_2.closeConnection(conn);
		
	}
}
