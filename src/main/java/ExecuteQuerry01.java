import java.sql.*;

public class ExecuteQuerry01 {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {

        Class.forName("org.postgresql.Driver");

        Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/day07", "postgres", "gokhan3405");
        Statement st = con.createStatement();
        System.out.println();

        String sql1 = "SELECT country_name FROM countries WHERE region_id = 1";
        boolean r1 = st.execute(sql1);
        System.out.println("r1 = " + r1);
        //Recordları görmek için ExecuteQuery() methodunu kullanmalıyız.
        ResultSet resultSet1 = st.executeQuery(sql1);

        while (resultSet1.next()) {


            System.out.println(resultSet1.getString(1));

            //2.Örnek: "region_id"nin 2'den büyük olduğu "country_id" ve "country_name" değerlerini çağırın.
            String sql2 = "SELECT country_name, country_id FROM countries WHERE region_id>2";
            ResultSet resultSet2 = st.executeQuery(sql2);

            System.out.println("-----------------------");

            while (resultSet2.next()) {

                System.out.println(resultSet2.getString("country_name") + "--" + resultSet2.getString("country_id"));

            }

        }
     con.close();
        st.close();

    }

}