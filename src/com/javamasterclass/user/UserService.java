package com.javamasterclass.user;

import java.util.UUID;

public class UserService {
    private UserArrayDataAccessService userArrayDataAccessService ;

    public UserService(UserArrayDataAccessService userArrayDataAccessService) {
        this.userArrayDataAccessService =
                new UserArrayDataAccessService();
    }

    public User[] getAllUsers(User[] users){
        return userArrayDataAccessService.getUsers();
    }

    public User[] getUsers(){
        return userArrayDataAccessService.getUsers();
    }

    public User getUserById(UUID userId) {
        User[] users = getUsers();
        for(User user : users){
            if(user.getUuid().equals(userId)){
                return user;
            }
        }
        throw new IllegalStateException("User not found");
    }

}
