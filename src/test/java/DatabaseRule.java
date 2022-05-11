//import models.DB;
//import org.junit.rules.ExternalResource;
//import org.sql2o.*;
//import org.sql2o.Connection;
//import spark.resource.ExternalResource;
//
//
//public class DatabaseRule extends ExternalResource {
//    @Override
//    public void before(){
//        DB.sql2o=new Sql2o("jdbc:postgresql://localhost:5432/wildlife", "postgres", "1870691bbn");
//    }
//    @Override
//    public void after(){
//        String deleteAnimalsQuery="DELETE FROM  animals*;";
//        try(Connection con=DB.sql2o.open()){
//            con.createQuery(deleteAnimalsQuery).executeUpdate();
//        }
//    }
//
//}
