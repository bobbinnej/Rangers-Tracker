package models;
import java.util.List;
import org.sql2o.Connection;

import java.util.Objects;

public class Endangered extends Animals implements DatabaseManagement {
  private String name;
  private String category;
  private String health;
  private String age;
  private int id;

  //create our constant for animals as non-endangered
  public static final String THREAT_TYPE="Endangered";

  public Endangered(String name, String category, String health, String age){

    super(name,category,age,health);
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

  //Overriding the Animals
  @Override
  public boolean equals(Object secondEndangeredAnimal){
    if(secondEndangeredAnimal instanceof Animals){
      Endangered endangered=(Endangered) secondEndangeredAnimal;
      return (this.getName().equals(endangered.getName()));
    }
    return false;
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, id);
  }

  // Save a new animal by their id name category health age
  public void save() {
    try (Connection con = DB.sql2o.open()) {
      String sql = "INSERT INTO animals (name,category,health,age) VALUES (:name, :category,:health,:age )";
      this.id = (int) con.createQuery(sql, true)
              .addParameter("name", this.name)
              .addParameter("category", this.category)
              .addParameter("health", this.health)
              .addParameter("age", this.age)
              .executeUpdate()
              .getKey();
    }
  }

  //get all animals
  public static List<Endangered> allEndangered() {
    String sql = "SELECT * FROM animals where threattype='Endangeredous'";
    try(Connection con = DB.sql2o.open()) {
      return con.createQuery(sql)
              .throwOnMappingFailure(false)
              .executeAndFetch(Endangered.class);
    }
  }
  //find animal by id
  public static Endangered find(int id) {
    try(Connection con = DB.sql2o.open()) {
      String sql = "SELECT * FROM animals where id=:id";
      Endangered endangered = con.createQuery(sql)
              .addParameter("id", id)
              .executeAndFetchFirst(Endangered.class);
      return endangered;
    }
  }

}
