package javaBasic;

public abstract class Animal {

    public Animal(){
        System.out.println("Animal running....");
    }
    public abstract void sleep();

    public void eat(){
        System.out.println("Eating.....");
    }
}
