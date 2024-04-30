package nonFactoryPattern;

public class EndUser {
    public static void main(String [] args){
        HondaHead honda = new HondaHead();
        honda.viewCar();
        honda.bookCar();
        honda.driverCar();

        FordHead ford = new FordHead();
        ford.viewCar();
        ford.bookCar();
        ford.driverCar();

        HuyndaiHead huyndai = new HuyndaiHead();
        huyndai.viewCar();
        huyndai.bookCar();
        huyndai.driverCar();
    }
}
