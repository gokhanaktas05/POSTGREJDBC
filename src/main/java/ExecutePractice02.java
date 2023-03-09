import java.sql.*;

public class ExecutePractice02 {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("org.postgresql.Driver");
        Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/day07", "postgres", "gokhan3405");
        Statement st = con.createStatement();

        String myhtl5="select * from myhotel where stuff_name='Gokhan'";
        boolean myhtl5b=st.execute(myhtl5);
        System.out.println("myhtl5b = " + myhtl5b);
        ResultSet resultset1=st.executeQuery(myhtl5);

        while (resultset1.next()){
            System.out.println(resultset1.getString(3));
        }

        String myhtl6="select * from myhotel where room_name='Fatih';";
        boolean myhtl6b=st.execute(myhtl6);
        System.out.println("myhtl6b = " + myhtl6b);

        ResultSet resultSet2=st.executeQuery(myhtl6);
        while (resultSet2.next()){
            System.out.println(resultSet2.getString("room_name"));
        }

    }
}