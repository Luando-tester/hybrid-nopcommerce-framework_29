package data;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import commons.GlobalContants;

import java.io.File;

public class UserLevelData {
    public static UserLevelData getUserLevelData(){
        try{
            ObjectMapper mapper =  new ObjectMapper();
            mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES,false);
            return mapper.readValue(new File(GlobalContants.DATA_TEST_PATH + "UserLevel.json"), UserLevelData.class);
        }catch (Exception ex){
            ex.printStackTrace();
            return null;
        }
    }
    @JsonProperty("Register")
    Register register;
    static class Register{
        @JsonProperty("Register")
        private String fullName;
    };
    @JsonProperty("login")
    Login login;
    static class Login{
        @JsonProperty("username")
        private String username;
        @JsonProperty("lastname")
        private String lastname;
        @JsonProperty("password")
        private String password;
    }
    @JsonProperty("firstname")
    private String firstname;
    @JsonProperty("lastname")
    private String lastname;

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }
    public String getFullName(){
        return register.fullName;
    }
    public String getUserName(){
        return login.username;
    }

    public String getPassword(){
        return login.password;
    }
}