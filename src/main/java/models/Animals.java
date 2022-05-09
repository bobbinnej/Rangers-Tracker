package models;

import java.util.Objects;

public class Animals {
    private String name;
    private String category;
    private String health;
    private String age;
    private int id;

    //create our constant
    public static final String THREAT_TYPE="Non-endangered";
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

}
