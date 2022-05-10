package models;
import org.sql2o.Sql2o;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DB {
    //public static Sql2o sql2o=new Sql2o("jdbc:postgresql://localhost:5432/wildlife", "postgres","1870691bbn");
     public static Sql2o sql2o= new Sql2o("jdbc:postgresql://ec2-44-195-169-163.compute-1.amazonaws.com:5432/d8ducgke7pn0h7", "jspamliwjntrut", "198311fc1649fe91835cd6188e7f0c2af27f85763a1f5b9206b7f41421248247");

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
