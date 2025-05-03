package javaOOP;

public class Animals {
    private String animalName;
    protected String animalAge;

    protected String getAnimalName(){
        return animalName;
    }

    protected void setAnimalName(String animalName) {
        this.animalName = animalName;
    }
}
