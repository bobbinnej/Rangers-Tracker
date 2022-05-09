package models;
import org.sql2o.Connection;
import java.util.Objects;

public class Animals {
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
        category=THREAT_TYPE;
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
    public boolean equals(Object secondAnimal){
        if(secondAnimal instanceof Animals){
            Animals newAnimals=(Animals) secondAnimal;
            return (this.getName().equals(newAnimals.getName()));
        }
        return false;
    }

    // Save a new animal by their id name category health age
    public void save(){

    }

}
