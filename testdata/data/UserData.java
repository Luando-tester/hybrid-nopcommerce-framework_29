package data;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import commons.GlobalContants;

import java.io.File;

public class UserData {
    public static UserData getUser(){
        try{
            ObjectMapper mapper =  new ObjectMapper();
            mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES,false);
            return mapper.readValue(new File(GlobalContants.DATA_TEST_PATH + "User.json"),UserData.class);
        }catch (Exception ex){
            ex.printStackTrace();
            return null;
        }
    }
    @JsonProperty("firstname")
    private String firstName;
    @JsonProperty("lastName")
    private String lastName;
    @JsonProperty("email")
    private String emailAddress;
    @JsonProperty("company")
    private String companyName;
    @JsonProperty("password")
    private String password;

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public String getCompanyName() {
        return companyName;
    }

    public String getPassword() {
        return password;
    }
}
