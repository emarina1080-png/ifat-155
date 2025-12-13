package user;

import utils.PropertyReader;

public class UserFactory {
    public static User withAdminPermission() {
        return new User(
                PropertyReader.getProperty("saucedemo.user"),
                PropertyReader.getProperty("saucedemo.password"));
    }

    public static User withLockedUserPermission() {
        return new User(PropertyReader.getProperty("saucedemo.locked_user"),
                PropertyReader.getProperty("saucedemo.password"));
    }

    public static User withUsernameOnly(String username) {
        return new User(
                username,
                PropertyReader.getProperty("saucedemo.password")
        );
    }

    public static User withPasswordOnly(String password) {
        return new User(
                PropertyReader.getProperty("saucedemo.user"),
                password
        );
    }

    public static User emptyUser() {
        return new User("", "");
    }
}
