package models;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AnimalsTest {
    @Test
    public void checkIfNewInstanceIsSaved(){
        Animals animals=new Animals("cow", "Endangered", "Healthy","Newborn");
        animals.save();
        assertTrue(Animals.all().get(0).equals(animals));
    }

}