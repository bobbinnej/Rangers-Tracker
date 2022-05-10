package models;
import org.sql2o.Connection;

import java.util.List;
import java.util.Objects;

public class Location {
    private int id;
    private String name;

public Location(String name){
    this.name=name;
}

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Location location = (Location) o;
        return id == location.id &&
                Objects.equals(name, location.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, id);
    }

    //saving our location
    public void save(){
    try(Connection con=DB.sql2o.open()){
        String sql= "INSERT INTO locations (name) VALUES (:name)";
        this.id= (int)con.createQuery(sql,true)
                .addParameter("name", this.name)
                .throwOnMappingFailure(false)
                .executeUpdate()
                .getKey();
    }
    }


    //list all locations

    public static List<Location>all(){
        String sql= "SELECT *FROM locations";
        try(Connection con=DB.sql2o.open()){
            return con.createQuery(sql).executeAndFetch(Location.class);
        }
    }

    //find location by id

    public static Location find(int id){
        try(Connection con=DB.sql2o.open()){
            String sql="SELECT *FROM locations WHERE id=:id";
            Location location=con.createQuery(sql)
                    .addParameter("id", id)
                    .executeAndFetchFirst(Location.class);
            return location;
        }
    }

}
