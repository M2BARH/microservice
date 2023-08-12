package za.co.protogen;

import za.co.protogen.core.UserService;
import za.co.protogen.core.impl.UserServiceImpl;
import za.co.protogen.core.utility.Constant;
import za.co.protogen.domain.User;

public class Application {

    // main thread for user class
    public static void main(String[] args) {

        UserService userService = new UserServiceImpl(Constant.users);

        System.out.println("All users");
        for (User user : userService.getAllUsers()) {
            System.out.println(user.toString());
        }

        String user = String.valueOf(userService.getUserById(2L));
        System.out.println("User : {" + user + " } was retrieved by Id");
    }
}
