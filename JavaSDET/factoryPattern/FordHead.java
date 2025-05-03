package factoryPattern;

public class FordHead extends CarFactory {
    @Override
    public void viewCar(){
        System.out.println("View Ford Car");
    }
    @Override
    public void driverCar(){
        System.out.println("Drive Ford Car");
    }
    @Override
    public void bookCar(){
        System.out.println("Book Ford Car");
    }
}
