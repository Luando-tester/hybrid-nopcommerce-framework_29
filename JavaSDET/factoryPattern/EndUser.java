package factoryPattern;

public class EndUser {
    public static CarFactory carFactory;
    public static void main(String [] args){
        carFactory = getCar("Honda");
        carFactory.viewCar();
        carFactory.bookCar();
        carFactory.driverCar();
    }
    public static CarFactory getCar(String carName) {
        CarFactory carFactory = null;
        CardList cardList = CardList.valueOf(carName.toUpperCase());
        switch(cardList){
            case HONDA:
                carFactory = new HondaHead();
            case HUYNDAI:
                carFactory = new HuyndaiHead();
            case FORD:
                carFactory = new FordHead();
        }
        return carFactory;
    }
}
