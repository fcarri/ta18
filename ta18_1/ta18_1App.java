package project18;
import java.sql.Connection;

public class ta18_1App {
	public static void main(String[]args) {
		
		Connection conn;
		
		String nameDB = "Tienda_Informatica";
		String table1 = "Fabricantes";
		String table2 = "Articulos";		
				
		Ta18_1 ta18_1 = new Ta18_1();
					
		conn = ta18_1.conexio();
		
		ta18_1.createBD(conn, nameDB);
		ta18_1.createTable1(nameDB, table1);
		ta18_1.insertData(nameDB, table1);
		ta18_1.createTable2(nameDB, table2);						
		ta18_1.insertData2(nameDB, table2);		
		
		ta18_1.closeConnection(conn);
		
	}
}
