package models;
import org.sql2o.*;
import java.util.List;
import java.util.Objects;

public class Ranger {
    private String ranger_name;
    private String ranger_badge;
    private String ranger_number;
    private int id;

    public Ranger(String ranger_name, String ranger_badge, String ranger_number){
        this.ranger_name=ranger_name;
        this.ranger_badge=ranger_badge;
        this.ranger_number=ranger_number;

    }

    public String getRanger_name() {
        return ranger_name;
    }

    public String getRanger_badge() {
        return ranger_badge;
    }

    public String getRanger_number() {
        return ranger_number;
    }

    public int getId() {
        return id;
    }

    //override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ranger ranger = (Ranger) o;
        return id == ranger.id &&
                ranger_name.equals(ranger.ranger_name) &&
                ranger_badge.equals(ranger.ranger_badge) &&
                ranger_number.equals(ranger.ranger_number);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, ranger_name, ranger_badge, ranger_number);
    }

    //save all rangers
    public void save(){
        try(Connection con=DB.sql2o.open()){
             String sql= "INSERT INTO rangers(ranger_name, ranger_badge, ranger_number) VALUES (:ranger_name, :ranger_badge, :ranger_number)";
             this.id=(int) con.createQuery(sql,true)
                     .addParameter("ranger_name", this.ranger_name)
                     .addParameter("ranger_badge", this.ranger_badge)
                     .addParameter("ranger_number", this.ranger_number)
                     .executeUpdate()
                     .getKey();
        }
    }

    //get all rangers list
    public static List<Ranger>all(){
        String sql="SELECT *FROM rangers";
        try(Connection con=DB.sql2o.open()){
            return con.createQuery(sql)
                    .throwOnMappingFailure(false)
                    .executeAndFetch(Ranger.class);
        }
    }

    //ge ranger by id
    public static Ranger find (int id){
        try(Connection con=DB.sql2o.open()){
            String sql = "SELECT * FROM rangers where id=:id";
            Ranger ranger = con.createQuery(sql)
                    .addParameter("id", id)
                    .executeAndFetchFirst(Ranger.class);
            return ranger;
        }

    }

    //delete()
    public void delete() {
        try(Connection con = DB.sql2o.open()) {
            String sql = "DELETE FROM rangers WHERE id = :id;";
            con.createQuery(sql)
                    .addParameter("id", id)
                    .executeUpdate();
        }
    }

}
