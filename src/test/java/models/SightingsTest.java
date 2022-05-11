package models;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import static org.junit.jupiter.api.Assertions.*;


class SightingsTest {
    @BeforeEach
    public void before(){
        DB.sql2o=new Sql2o("jdbc:postgresql://localhost:5432/wildlife", "postgres","1870691bbn");
    }
    @AfterEach
    public void after(){
        try(Connection con=DB.sql2o.open()){
            String deleteAnimalsQuery="DELETE FROM animals";
            con.createQuery(deleteAnimalsQuery).executeUpdate();
        }catch (Exception e){
            System.out.println(e);
        }
    }

    //check if new animal instance is created
    @Test
    public void checkIfNewInstanceIsCreated(){
        Sightings testSightings= new Sightings("Zone A", "Ephantus", "Pig", "Endangered");
        assertEquals(true, testSightings instanceof Sightings);
    }

}