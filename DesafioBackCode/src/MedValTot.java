import java.io.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class MedValTot {
	private static Connection conn;
	
	private static ArrayList<String> lerArquivoSQL() {
        File file = new File("inserts.sql");
        ArrayList<String> inserts = new ArrayList<>();
        try {
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line = "";
            while ((line = bufferedReader.readLine()) != null) {
                inserts.add(line);
            }
            fileReader.close();
            bufferedReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return inserts;
    }
	
	public static ArrayList<Customer> getCustomersR(){
        String sqlSelect = 	"SELECT * "
        					+"FROM tb_customer_account WHERE vl_total > 560 AND "
        					+"id_customer BETWEEN 1500 AND 2700 ORDER BY vl_total DESC";
        ArrayList<Customer> list = new ArrayList<>();
        try (PreparedStatement stm = conn.prepareStatement(sqlSelect);
                ResultSet rs = stm.executeQuery();) {
            while(rs.next()) {
            	Customer customer = new Customer(rs.getInt("id_customer"), rs.getString("cpf_cnpj"),
            			rs.getString("nm_customer"), rs.getString("is_active"),  rs.getLong("vl_total"));
                list.add(customer);
            }
        }
        catch(Exception e) {
            e.printStackTrace();
        }
        return list; 
    }
	
	private static Long calcMedTotalVal(ArrayList<Customer> list) {
		Long finalValue = 0l;
		for(int i = 0; i < list.size(); ++i) {
			finalValue += list.get(i).getVl_total();
		}
		return finalValue/list.size();
	}
	
	private static void printCustomers(ArrayList<Customer> list) {
		for(int i = 0; i < list.size(); ++i) {
			System.out.println(list.get(i));
		}
	}
	
	private static void runBatch() {
        Statement stmt = null;
        ArrayList<String> arqSql = lerArquivoSQL();
        try {
            stmt = conn.createStatement();
            for (int i = 0; i < arqSql.size(); ++i) {
                stmt.addBatch(arqSql.get(i));
            }
            stmt.executeBatch();
            stmt.clearBatch();
            ArrayList<Customer> listCustomers = getCustomersR();
            if(listCustomers.size() < 1) {
            	System.out.println("NÃO HÁ REGISTROS COM AS RESTRIÇÕES PROGRAMADAS");
            }else {
            	System.out.println("MÉDIA FINAL DOS VALORES TOTAIS: "+calcMedTotalVal(listCustomers)+"\n");
                printCustomers(listCustomers);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
        	ConexaoBD.desconectar(conn, stmt, null);
        }

    }

	public static void main(String[] args) {
		try {
			conn = ConexaoBD.conectar();
			runBatch();
		   }
		catch (Exception e) {
			e.printStackTrace();
		}	

	}

}
