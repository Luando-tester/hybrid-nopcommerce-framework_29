package getterSetter;

import lombok.Getter;
import lombok.Setter;

public class UserLombok {
    @Getter
    @Setter
    private String firstName;
    @Getter
    @Setter
    private String lastName;
    @Getter
    @Setter
    private String emailAddress;
}
