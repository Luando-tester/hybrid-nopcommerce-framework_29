package javaBasic;

public class Dog extends Animal{
    String animalName;
    public Dog(String animalName){
        this.animalName = animalName;
    }
    @Override
    public void sleep() {
        System.out.println("Sleep....");
    }
}
