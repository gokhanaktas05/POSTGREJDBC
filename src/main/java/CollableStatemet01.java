import java.sql.*;

public class CollableStatemet01 {
/*
Java'da method'lar return type sahibi olsa da olmasa da method olarak adlandırılır.
SQL'de ise data return ediyorsa "function" denir. Return yapmiyorsa "procedure" olarak adlandırilir
 */

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("org.postgresql.Driver");

        Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/day07", "postgres", "gokhan3405");
        Statement st = con.createStatement();
    //Collable statement ile function cagırmayı parametreize edeceğiz.

        //1. adım>> Function codu nu yaz..
    String sql1="create or replace function toplamaF(x NUMERIC ,y NUMERIC )\n" +
            "RETURNS NUMERIC\n" +
            "LANGUAGE plpgsql\n" +
            "as\n" +
            "$$\n" +
            "begin\n" +
            "\n" +
            "return x+y;\n" +
            "\n" +
            "end\n" +
            "\n" +
            "$$";

    //2. adım>> function u calstır...
        st.execute(sql1);
   //3. adım>>function u cagır...
     CallableStatement cst1 = con.prepareCall("{?=call toplamaF(?,?)}");
    //4. adım>>Return için
        cst1.registerOutParameter(1, Types.NUMERIC);
        cst1.setInt(2,6);
        cst1.setInt(3,4);

        //5. adım>> execute komutu ile Callable ı calıstır..
        cst1.execute();
        //6. adım>>
        System.out.println(cst1.getBigDecimal(1));

        //Koninin hacmini bulan bir function yazın..
        String sql2="create or replace function konininHacmi(r NUMERIC ,h NUMERIC )\n" +
                "RETURNS NUMERIC\n" +
                "LANGUAGE plpgsql\n" +
                "as\n" +
                "$$\n" +
                "begin\n" +
                "\n" +
                "return 3.14*r*r*h/3;\n" +
                "\n" +
                "end\n" +
                "\n" +
                "$$";
        st.execute(sql2);

        CallableStatement cst2 = con.prepareCall("{?=call konininHacmi(?,?)}");

        cst2.registerOutParameter(1, Types.NUMERIC);
        cst2.setInt(2,1);
        cst2.setInt(3,6);

        cst2.execute();

        System.out.printf("%.2f",cst2.getBigDecimal(1));




    }
}
