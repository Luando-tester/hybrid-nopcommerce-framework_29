package fakeData;

import com.github.javafaker.Faker;

import java.util.Locale;

public class Topic_02_Faker {
    public static void main(String[] args){
        Faker fakeUS = new Faker();
        System.out.println(fakeUS.address().city());
        System.out.println(fakeUS.address().cityName());
        System.out.println(fakeUS.address().country());
        System.out.println(fakeUS.address().countryCode());
        System.out.println(fakeUS.address().firstName());
        System.out.println(fakeUS.address().lastName());
        System.out.println(fakeUS.address().streetName());
        System.out.println(fakeUS.address().fullAddress());
        System.out.println(fakeUS.address().state());
        System.out.println(fakeUS.address().zipCode());
        System.out.println(fakeUS.address().longitude());
        System.out.println(fakeUS.address().latitude());

        Faker fakeVN = new Faker(new Locale("vi"));
    }
}
