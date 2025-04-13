package employee;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import commons.GlobalContants;

import java.io.File;
import java.util.List;

public class EmployeeList {
    public void setEmployeeList(List<Employee> employeeList){
        this.employeeList = employeeList;
    }
    public List<Employee> getEmployee(){
        return employeeList;
    }
    @JsonProperty("employees")
    private List<Employee> employeeList;

    public static EmployeeList getEmployeeList(){
        try{
            ObjectMapper mapper =  new ObjectMapper();
            mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES,false);
            return mapper.readValue(new File(GlobalContants.DATA_TEST_PATH + "EmployeeList.json"), EmployeeList.class);
        }catch (Exception ex){
            ex.printStackTrace();
            return null;
        }
    }
    public static class Employee{
        private String name;

        @JsonProperty("email")
        private String emailAddress;
        @JsonProperty("age")
        private int ageNumber;

        public int getAgeNumber() {
            return ageNumber;
        }

        public String getName() {
            return name;
        }

        public String getEmailAddress() {
            return emailAddress;
        }
    }
}
