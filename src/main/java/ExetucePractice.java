import java.sql.*;

public class ExetucePractice {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
    Class.forName("org.postgresql.Driver");
      Connection con= DriverManager.getConnection("jdbc:postgresql://localhost:5432/day07", "postgres", "gokhan3405");
      Statement st=con.createStatement();

        boolean myhtl1=st.execute("create table myhotel(room_num char(20),room_name char(30),stuff_name char(30));");
        System.out.println("myhtl1 = " + myhtl1);


       String myhtl2="ALTER TABLE myhotel add hotel_adress varchar(80);";
        boolean myhtl2b=st.execute(myhtl2);
        System.out.println("myhtl2b = " + myhtl2b);

        String myhtl3="drop table myhotel";
        boolean myhtl4=st.execute(myhtl3);
        System.out.println("myhtl4 = " + myhtl4);




    }
}
