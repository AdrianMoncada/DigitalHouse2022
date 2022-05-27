import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/*UPDATE EMPLEADO
        SET COUNTRY = 'Brasil'
        WHERE COUNTRY='Argentina';*/

/*UPDATE EMPLEADO
        SET COUNTRY = 'Alemania'
        WHERE ID=1;*/
public class Main {
    private static final String SQL_CREATE_TABLE = "DROP TABLE IF EXISTS EMPLEADO; CREATE TABLE EMPLEADO "
            + "("
            + " ID INT PRIMARY KEY,"
            + " EMAIL VARCHAR(50) NOT NULL, "
            + " NAME VARCHAR(50) NOT NULL, "
            + " COUNTRY VARCHAR(50) NOT NULL, "
            + " LASTNAME VARCHAR(50) NOT NULL "
            + " );";

    private static final String SQL_INSERT = "INSERT INTO EMPLEADO (ID, EMAIL, NAME, COUNTRY, LASTNAME) VALUES (1,'federicodiaz@gmail.com','Federico','Argentina','Diaz')";
    private static final String SQL_INSERT2 = "INSERT INTO EMPLEADO (ID, EMAIL, NAME, COUNTRY, LASTNAME) VALUES (2,'agustinapodesta@gmail.com','Agustina','Brasil','Podesta')";
    private static final String SQL_INSERT3 = "INSERT INTO EMPLEADO (ID, EMAIL, NAME, COUNTRY, LASTNAME) VALUES (3,'pedroalonso@gmail.com','Pedro','Argentina','Alonso')";

    public static Connection getConnection() throws Exception {
        Class.forName("org.h2.Driver").newInstance();
        return DriverManager.getConnection("jdbc:h2:" +
                "~/test", "sa", "");
    }


    public static void main(String[] args) throws Exception {
        Connection connection = null;

        try{
            connection = getConnection();
            Statement statement = connection.createStatement();
            statement.execute(SQL_CREATE_TABLE);

            statement.execute(SQL_INSERT);
            statement.execute(SQL_INSERT2);
            statement.execute(SQL_INSERT3);

            String sql = "SELECT * FROM EMPLEADO\n" +
                    "WHERE COUNTRY = 'Argentina';";

            ResultSet rd = statement.executeQuery(sql);

            while (rd.next()) {
                System.out.println(rd.getInt(1) + rd.getString(2) + rd.getString(3));
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            connection.close();
        }

    }
}