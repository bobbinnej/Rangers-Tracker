//package models;
//
//import org.junit.rules.ExternalResource;
//import org.sql2o.*;
//import org.sql2o.Connection;
//
//
//public class DatabaseRule extends ExternalResource {
//    @Override
//    protected void before(){
//        DB.sql2o=new Sql2o("jdbc:postgresql://localhost:5432/wildlife", "jackie", "1870691bbn");
//    }
//    @Override
//    protected void after(){
//        String deleteAnimalsQuery="DELETE FROM  animals*;";
//        try(Connection con=DB.sql2o.open()){
//            con.createQuery(deleteAnimalsQuery).executeUpdate();
//        }
//    }
//
//}