package models;
import org.sql2o.Sql2o;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DB {
  //public static Sql2o sql2o=new Sql2o("jdbc:postgresql://localhost:5432/wildlife", "postgres","1870691bbn");

    public static Sql2o sql2o= new Sql2o("jdbc:postgresql://ec2-52-200-215-149.compute-1.amazonaws.com:5432/dd5v66dq2lk0ct", "fhznvrykbabvmk", "76f1f40e953174e489faa5da272c6e7dfee0171eeaaaa59820b663c688a5b973");

    public static void main(String[] args) {
        try(Connection con=DriverManager.getConnection("jdbc:postgresql://localhost:5432/wildlife", "postgres", "1870691bbn")){
            System.out.println("This is a trial to check if my database will connect");
            System.out.println("Congratulations...Database connected Successfully");

            Statement statement = con.createStatement();
        } catch (SQLException e) {
            System.out.println("Connection failure.");
            e.printStackTrace();
        }

    }

}
