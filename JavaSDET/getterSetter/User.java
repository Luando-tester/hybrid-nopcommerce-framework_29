package getterSetter;

import java.util.regex.Pattern;

public class User {
    private String firstName;
    private String lastName;
    private String emailAddress;

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setEmailAddress(String emailAddress) {
        String emailRegex = "^[a-zA-Z0-9_+&*]+(?:\\.[a-zA-Z0-9_+&*-]+)*@" + "(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
        Pattern p = Pattern.compile(emailRegex);
        if(emailAddress != null && p.matcher(emailAddress).matches()) {
            this.emailAddress = emailAddress;
        }else {
            System.out.println("Email is not valid");
        }
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
}
