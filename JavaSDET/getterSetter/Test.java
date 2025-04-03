package getterSetter;

public class Test {
    public static void main(String[] args) {
        User user =  new User();
        System.out.println(user.getEmailAddress());
        System.out.println(user.getFirstName());
        System.out.println(user.getLastName());
        UserSetter userSetter = new UserSetter();
        userSetter.setFirstName("Automation");
        userSetter.setLastName("FC");
        userSetter.setEmailAddress("automationfc@gmail.com");
        User use = new User();
        use.setEmailAddress("automation@gmail.com");
        use.setFirstName("Automation");
        use.setLastName("FC");
        System.out.println(user.getEmailAddress());
        System.out.println(user.getFirstName());
        System.out.println(user.getLastName());

        UserLombok userLombok = new UserLombok();
        userLombok.setEmailAddress("automationtesting@gmail.com");
        userLombok.setFirstName("Manual");
        userLombok.setLastName("Testing 2025");

        System.out.println(userLombok.getEmailAddress());
        System.out.println(userLombok.getFirstName());
        System.out.println(userLombok.getLastName());

    }
}
