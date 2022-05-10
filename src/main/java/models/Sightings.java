package models;
import org.sql2o.Connection;
import org.sql2o.Sql2oException;
import java.util.Date;
import java.sql.Timestamp;
import java.util.List;
import java.util.Objects;

public class Sightings {
    private int id;
    private String location;
    private String ranger;
    private String animal;
    private Date date= new Date();
    private Timestamp time;

    public Sightings(String location, String ranger, String animal){
        this.location=location;
        this.ranger=ranger;
        this.animal=animal;
        this.time=new Timestamp(date.getTime());

    }

    public int getId() {
        return id;
    }

    public String getLocation() {
        return location;
    }

    public String getRanger() {
        return ranger;
    }

    public String getAnimal() {
        return animal;
    }

    public Timestamp getTime() {
        return time;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Sightings sightings = (Sightings) o;
        return id == sightings.id &&
                location == sightings.location &&
                ranger== sightings.ranger &&
                animal== sightings.animal;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, location, ranger, animal);
    }


    // save all sightings to database

    public void save(){
        try(Connection con=DB.sql2o.open()){
            String sql= "INSERT INTO sightings(location,ranger,animal) VALUES(:location, :ranger, :animal)";
            this.id=(int) con.createQuery(sql,true)
                    .addParameter("location", this.location)
                    .addParameter("ranger", this.ranger)
                    .addParameter("animal", this.animal)
                    .executeUpdate()
                    .getKey();
        }
    }

    //get all sightings

    public static List<Sightings> all(){
        String sql="SELECT *FROM sightings";
        try(Connection con=DB.sql2o.open()){
            return con.createQuery(sql).executeAndFetch(models.Sightings.class);
        }
        catch (Sql2oException ex){
            System.out.println(ex);
            return null;
        }
    }

    //find sighting by id
    public static Sightings find (int id){
        try(Connection con=DB.sql2o.open()){
            String sql="SELECT *FROM sightings WHERE id=:id";
            return con.createQuery(sql)
                    .addParameter("id", id)
                    .executeAndFetchFirst(Sightings.class);

        }
    }
}
