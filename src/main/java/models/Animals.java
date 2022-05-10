package models;
import org.sql2o.Connection;

import java.util.List;
import java.util.Objects;

import java.sql.ResultSet;

public class Animals implements DatabaseManagement {
    private String name;
    private String category;
    private String health;
    private String age;
    private int id;

    //create our constant for animals as non-endangered
    public static final String THREAT_TYPE="Non-endangered";

    //lets throw an exception if name eld is left bank
    public Animals(String name){
        if(name.equals("")){
            throw new IllegalArgumentException("Please input an animal name");
        }
        this.name=name;

    }
public Animals(String name, String category, String health, String age){
  this.name=name;
  this.category=category;
  this.age=age;
  this.health=health;
}

//get method

    public String getName() {
        return name;
    }

    public String getCategory() {
        return category;
    }

    public String getHealth() {
        return health;
    }

    public String getAge() {
        return age;
    }

    public int getId() {
        return id;
    }

    //Overriding the Animals

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Animals animal = (Animals) o;
        return id == animal.id &&
                Objects.equals(name, animal.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, id);
    }

    // Save a new animal by their id name category health age
    public void save() {
        try (Connection con = DB.sql2o.open()) {
            String sql = "INSERT INTO animals (name,category,health,age) VALUES (:name, :category,:health, :age)";
            this.id = (int) con.createQuery(sql, true)
                    .addParameter("name", this.name)
                    .addParameter("category", this.category)
                    .addParameter("health", this.health)
                    .addParameter("age", this.age)
                    .throwOnMappingFailure(false)
                    .executeUpdate()
                    .getKey();
        }
    }
// get all animals
        public static List<Animals> all(){
            String sql="SELECT *FROM animals";
            try(Connection con =DB.sql2o.open()){
                return con.createQuery(sql)
                        .throwOnMappingFailure(false)
                        .executeAndFetch(Animals.class);
            }
        }
 //find animal by id
    public static Animals find(int id) {
        try(Connection con = DB.sql2o.open()) {
            String sql = "SELECT * FROM animals where id=:id";
            Animals animals = con.createQuery(sql)
                    .addParameter("id", id)
                    .executeAndFetchFirst(Animals.class);
            return animals;
        }
    }


}
