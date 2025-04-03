package utilities;

import com.github.javafaker.Faker;

public class FakeConfig {
    private Faker faker = new Faker();
    public static FakeConfig getFaker(){
        return new FakeConfig();
    }

    public String getEmailAddress(){
         return faker.internet().emailAddress();
    }
    public String getFirstName(){
        return faker.name().firstName();
    }
    public String getCity(){
        return faker.address().city();
    }
    public String gẹtLastName(){
        return faker.name().lastName();
    }
    public String getFullName(){
        return  faker.name().fullName();
    }
    public String getPassword(){
        return faker.internet().password(10,20);
    }
    public String getPhoneNumber(){
        return faker.phoneNumber().phoneNumber();
    }
    public String getZipCode(){
        return faker.address().zipCode();
    }
    public String getCompanyName(){
        return faker.company().name();
    }
}
