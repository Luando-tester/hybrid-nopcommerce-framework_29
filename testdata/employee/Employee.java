package employee;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import commons.GlobalContants;
import data.UserData;

import java.io.File;
import java.util.List;

public class Employee {
    @JsonProperty("name")
    private String name;
    @JsonProperty("position")
    private String position;
    @JsonProperty("skilltree")
    private List<String> skilltree;
    @JsonProperty("address")
    private Address address;
    public static Employee getEmployee(){
        try{
            ObjectMapper mapper =  new ObjectMapper();
            mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES,false);
            return mapper.readValue(new File(GlobalContants.DATA_TEST_PATH + "Employee.json"),Employee.class);
        }catch (Exception ex){
            ex.printStackTrace();
            return null;
        }
    }
    public String getPosition() {
        return position;
    }

    public List<String> getSkilltree() {
        return skilltree;
    }

    public String getName() {
        return name;
    }
    public Address getAddress(){
        return address;
    }
    public static class Address{
        @JsonProperty("street")
        private String streetName;
        @JsonProperty("streetNo")
        private String streetNumber;

        public String getStreetName() {
            return streetName;
        }
        public String getStreetNumber() {
            return streetNumber;
        }
    }

}
