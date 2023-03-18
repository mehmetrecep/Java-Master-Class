package com.javamasterclass.user;

import java.util.UUID;

public class UserDAO {
    private static final User[] users;

    static{
        users = new User[]{
                new User("Mohamed Ali",UUID.fromString("deda751f-af4f-40a3-a8fc-03c8e9812acf")),
                new User("Salah Eldin",UUID.fromString("0f163d56-adeb-4bd2-b63a-b1a730e32cb3")),
                new User("Omar", UUID.fromString("09ae5c8d-41ab-46ce-8d99-47bf50bb8db0"))
        };
    }

    public static User[] getUsers() {
        return users;
    }

}
