import java.sql.*;

public class PreperiedStatement01 {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("org.postgresql.Driver");

        Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/day07", "postgres", "gokhan3405");
        Statement st = con.createStatement();
        /*
PreparedStatement interface, birden çok kez çalıştırılabilen önceden derlenmiş bir SQL kodunu temsil eder.
Paremetrelendirilmiş SQL sorguları(query) ile çalışır. Bur sorguyu 0 veya daha fazla parametre ile kullanabiliriz.
 *///1. Örnek: Prepared statement kullanarak company adı
        // IBM olan number_of_employees değerini 9999 olarak güncelleyin.
//prepare statement query olustur
        String sql1 = "update companies set number_of_employees= ? where company= ? ";
        //Prepare statement objesini olustur..
        PreparedStatement pst1 = con.prepareStatement(sql1);

        //3. adım setInt(), setString methodlarını kullanarak soru işaretleri yerlerine
        //değer atanır..
        pst1.setInt(1, 9999);
        pst1.setString(2, "IBM");
        //4. ADIM>> ExecuteQuerry i calıstır.
        int guncelSatirSaysi = pst1.executeUpdate();
        System.out.println("guncelSatirSaysi = " + guncelSatirSaysi);
        String sql2 = "select * from companies";
        ResultSet rs1 = st.executeQuery(sql2);
        while (rs1.next()) {
            System.out.println(rs1.getInt(1) + "...." + rs1.getString(2) + "...." + rs1.getInt(3));
        }
            //2. Örnek: Prepared statement kullanarak company adı GOOGLE olan
            // number_of_employees değerini 5555 olarak güncelleyin
            pst1.setInt(1, 5555);
            pst1.setString(2, "GOOGLE");

            int guncelSatirSaysi2 = pst1.executeUpdate();
            System.out.println("guncelSatirSaysi2 = " + guncelSatirSaysi2);

            ResultSet rs2 = st.executeQuery(sql2);
            while (rs2.next()) {
                System.out.println(rs2.getInt(1) + "...." + rs2.getString(2) + "...." + rs2.getInt(3));

                con.close();
                st.close();
                rs1.close();
                rs2.close();
                pst1.close();
            }

    }
}